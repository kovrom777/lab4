package ru.bmstu.iu9.lab4;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.japi.pf.ReceiveBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ResultSupplyActor extends AbstractActor {

    private Map<String, ArrayList<String>> store = new HashMap<>();

    private void saveResult(JSFunctionRes res){
        ArrayList<String> dop;
        if (store.containsKey(res.getPackageID())){
            dop = store.get(res.getPackageID());
        }else{
            dop = new ArrayList<>();
        }
        dop.add(res.getFunctionRes());
        store.put(res.getPackageID(), dop);
    }

    private JSFunctionRes printPackageId(String packageId){
        if (store.containsKey(packageId)){
            ArrayList<String> dop = store.get(packageId);
            for (int i = 0; i< dop.size(); i++){
                return new JSFunctionRes(packageId, dop.get(i));
            }
        }
        return new JSFunctionRes(packageId, "Oups, There are no tests yet");
    }

    public Receive createReceive(){
        return ReceiveBuilder()
                .match(
                        JSFunctionRes.class,
                        this::saveResult
                )
                .match(
                        String.class,
                        id -> {
                            getSender().tell(printPackageId(id), ActorRef.noSender());
                        }
                )
                .build();
    }

}
