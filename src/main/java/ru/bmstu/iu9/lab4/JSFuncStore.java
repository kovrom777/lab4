package ru.bmstu.iu9.lab4;

import com.fasterxml.jackson.annotation.JsonProperty;

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
    public String funcParams;

    public JSFuncStore(@JsonProperty(PACKAGEID) String packageId, @JsonProperty(FUNCTION) String funcBody,
                       @JsonProperty(FUNCTION_Name) String funcName, @JsonProperty(FUNCTTION_PARAMETRS) String funcParams) {
        this.packageId = packageId;
        this.funcBody = funcBody;
        this.funcName = funcName;
        this.funcParams = funcParams;
    }
}
