package ru.bmstu.iu9.lab4;

import akka.NotUsed;
import akka.actor.*;
import akka.http.javadsl.ConnectHttp;
import akka.http.javadsl.Http;
import akka.http.javadsl.ServerBinding;
import akka.http.javadsl.marshallers.jackson.Jackson;
import akka.http.javadsl.model.HttpRequest;
import akka.http.javadsl.model.HttpResponse;
import akka.http.javadsl.server.Route;
import akka.pattern.Patterns;
import akka.stream.ActorMaterializer;
import akka.stream.Materializer;
import akka.stream.javadsl.Flow;
import scala.concurrent.Future;

import java.io.IOException;
import java.util.concurrent.CompletionStage;

import static akka.http.javadsl.server.Directives.*;


public class MainClass {

    public static final int TIMEOUT_MILLIS = 5000;

    public static void main(String[] args) throws IOException {

        final ActorSystem system = ActorSystem.create("Test");
        ActorRef router = system.actorOf(Props.create(ActorRouter.class));
        final Http http = Http.get(system);
        final MainClass application = new MainClass();
        final Materializer materializer = ActorMaterializer.create(system);
        final Flow<HttpRequest, HttpResponse, NotUsed> routeFlow = application.createRoute(system, router).flow(system, materializer);
        final CompletionStage<ServerBinding> serverBinding = http.bindAndHandle(
                routeFlow,
                ConnectHttp.toHost("localhost", 8080),
                materializer
        );
        System.out.println("Server Started on port 8080");
        System.in.read();
        serverBinding.thenCompose(ServerBinding::unbind)
                .thenAccept(unbond -> system.terminate());

    }


    private Route createRoute(ActorSystem actorSystem, ActorRef actorRef){
        return get(() -> parameter("packageId", key ->{
            Future<Object> res = Patterns.ask(actorRef, key, TIMEOUT_MILLIS);
            return completeOKWithFuture(res, Jackson.marshaller());
        }))
                .orElse(post(() -> entity(Jackson.unmarshaller(JSFuncStore.class), msg ->{
                    actorRef.tell(msg, ActorRef.noSender());
                    return complete("Started");
                })));
    }

}
