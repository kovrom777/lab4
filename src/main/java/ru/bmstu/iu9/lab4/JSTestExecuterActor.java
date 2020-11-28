package ru.bmstu.iu9.lab4;

import akka.actor.AbstractActor;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.ArrayList;

public class JSTestExecuterActor extends AbstractActor {


    public final String JS_COMPILER = "nashorn";

    public JSFunctionRes jsExecutor(String jsFunc, String FuncName, ArrayList<Integer> jsParams, String packageId) throws ScriptException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName(JS_COMPILER);
        engine.eval(jsFunc);
        
    }
}
