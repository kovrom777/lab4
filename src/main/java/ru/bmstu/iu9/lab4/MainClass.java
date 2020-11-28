package ru.bmstu.iu9.lab4;

import akka.actor.*;

import java.io.IOException;


public class MainClass {

    public static void main(String[] args) throws IOException {

        final ActorSystem system = new ActorSystem.create("Test");
        ActorRef router = system.actorOf(Props.create())

    }

}
