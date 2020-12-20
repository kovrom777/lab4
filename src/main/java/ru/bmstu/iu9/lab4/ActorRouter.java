package ru.bmstu.iu9.lab4;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;

public class ActorRouter extends AbstractActor {

    public static int TIMEOUT_CONSTANT = 10000;


    Props propsJSTestExecProp = Props.create(JSTestExecuterActor.class);
    Props propsResultProp = Props.create(ResultSupplyActor.class);

    ActorRef storeActor = getContext().actorOf(propsResultProp, "Store");
    ActorRef testActor = getContext().actorOf(new Roun)
}
