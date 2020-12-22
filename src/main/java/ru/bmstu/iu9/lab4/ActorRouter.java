package ru.bmstu.iu9.lab4;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.japi.pf.ReceiveBuilder;
import akka.routing.RoundRobinPool;
import jdk.nashorn.internal.runtime.JSONFunctions;

public class ActorRouter extends AbstractActor {

    public static int TIMEOUT_CONSTANT = 10000;


    Props propsJSTestExecProp = Props.create(JSTestExecuterActor.class);
    Props propsResultProp = Props.create(ResultSupplyActor.class);

    ActorRef storeActor = getContext().actorOf(propsResultProp, "Store");
    ActorRef testActor = getContext().actorOf(new RoundRobinPool(5).props(propsJSTestExecProp));

    @Override
    public Receive createReceive(){
        return ReceiveBuilder()
                .match(
                        JSFuncStore.class,
                        JSFunc ->{
                            for (int i = 0; i< JSFunc.)
                        }
                )
    }
}
