package ru.bmstu.iu9.lab4;

import akka.actor.AbstractActor;
import akka.actor.Props;

public class ActorRouter extends AbstractActor {

    public static int timeout = 3000;

    Props propsJSTestExecProp = Props.create(JSTestExecuterActor.class);

}
