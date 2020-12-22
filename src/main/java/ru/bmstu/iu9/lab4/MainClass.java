package ru.bmstu.iu9.lab4;

import akka.actor.*;
import akka.http.javadsl.Http;
import akka.http.javadsl.server.Route;
import akka.stream.ActorMaterializer;
import akka.stream.Materializer;

import java.io.IOException;


public class MainClass {

    public static void main(String[] args) throws IOException {

        final ActorSystem system = ActorSystem.create("Test");
        ActorRef router = system.actorOf(Props.create(ActorRouter.class));
        final Http http = Http.get(system);
        final MainClass application = new MainClass();
        final Materializer materializer = new ActorMaterializer.create(system);
//        final Flow<HttpRequest, HttpResponse, NotUsed> routeFlow = application.

    }


    private Route createRoute(ActorSystem actorSystem, ActorRef actorRef){
        return 
    }

}
