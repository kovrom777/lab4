package ru.bmstu.iu9.lab4;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.pattern.Patterns;
import akka.routing.RoundRobinPool;
import scala.concurrent.Future;

public class ActorRouter extends AbstractActor {

    public static int TIMEOUT_CONSTANT = 10000;


    Props propsJSTestExecProp = Props.create(JSTestExecuterActor.class);
    Props propsResultProp = Props.create(ResultSupplyActor.class);

    ActorRef storeActor = getContext().actorOf(propsResultProp, "Store");
    ActorRef testActor = getContext().actorOf(new RoundRobinPool(5).props(propsJSTestExecProp));

    @Override
    public Receive createReceive(){
        return receiveBuilder()
                .match(
                        JSFuncStore.class,
                        JSFunc ->{
                            for (int i = 0; i< JSFunc.funcParams.size(); i++){
                                testActor.tell(
                                        new Test(
                                                JSFunc.funcName,
                                                JSFunc.funcParams.get(i).testName,
                                                JSFunc.funcParams.get(i).expectedResult,
                                                JSFunc.funcParams.get(i).funcParams,
                                                JSFunc.funcBody,
                                                JSFunc.packageId),
                                                getSelf()

                                );
                            }
                        }
                )
                .match(JSFunctionRes.class,
                        output->{
                            storeActor.tell(output, self());
                        })
                .match(String.class,
                        id->{
                            Future<Object> res = Patterns.ask(storeActor, id, TIMEOUT_CONSTANT);
                            getSender().tell(res, self());
                        })
                .build();
    }
}
