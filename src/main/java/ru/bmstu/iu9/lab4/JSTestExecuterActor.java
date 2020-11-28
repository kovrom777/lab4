package ru.bmstu.iu9.lab4;

import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.ArrayList;

public class JSTestExecuterActor extends AbstractActor {


    public final String JS_COMPILER = "nashorn";

    public JSFunctionRes jsExecutor(String jsFunc, String funcName, ArrayList<Integer> jsParams, String packageId) throws ScriptException,
            NoSuchMethodException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName(JS_COMPILER);
        engine.eval(jsFunc);
        Invocable invocable = (Invocable) engine;

        return new JSFunctionRes(packageId,
                invocable.invokeFunction(funcName, jsParams.toArray()).toString());
    }


    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match()
    }
}
