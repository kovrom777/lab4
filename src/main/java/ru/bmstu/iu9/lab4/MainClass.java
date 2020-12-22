package ru.bmstu.iu9.lab4;

import akka.actor.*;
import akka.http.javadsl.Http;

import java.io.IOException;


public class MainClass {

    public static void main(String[] args) throws IOException {

        final ActorSystem system = ActorSystem.create("Test");
        ActorRef router = system.actorOf(Props.create(ActorRouter.class));
        final Http http = Http.get(system);
        final AkkaMainApplication application = new AkkaMainApplication();

    }

}
