package ru.bmstu.iu9.lab4;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class JSFuncStore {

    final String PACKAGEID = "packageId";
    final String FUNCTION = "jsScript";
    final String FUNCTION_Name = "functionName";
    final String FUNCTTION_PARAMETRS = "tests";


    @JsonProperty(PACKAGEID)
    public String packageId;
    @JsonProperty(FUNCTION)
    public String funcBody;
    @JsonProperty(FUNCTION_Name)
    public String funcName;
    @JsonProperty(FUNCTTION_PARAMETRS)
    public ArrayList<Test> funcParams;

    @JsonCreator
    public JSFuncStore(@JsonProperty(PACKAGEID) String packageId, @JsonProperty(FUNCTION) String funcBody,
                       @JsonProperty(FUNCTION_Name) String funcName, @JsonProperty(FUNCTTION_PARAMETRS) ArrayList<Test> funcParams) {
        this.packageId = packageId;
        this.funcBody = funcBody;
        this.funcName = funcName;
        this.funcParams = funcParams;
    }

    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    public String getFuncBody() {
        return funcBody;
    }

    public void setFuncBody(String funcBody) {
        this.funcBody = funcBody;
    }

    public String getFuncName() {
        return funcName;
    }

    public void setFuncName(String funcName) {
        this.funcName = funcName;
    }

    public ArrayList<Test> getFuncParams() {
        return funcParams;
    }

    public void setFuncParams(ArrayList<Test> funcParams) {
        this.funcParams = funcParams;
    }
}
