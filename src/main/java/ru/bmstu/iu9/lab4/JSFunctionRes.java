package ru.bmstu.iu9.lab4;

public class JSFunctionRes {

    private String packageID, functionRes;

    public JSFunctionRes(String packageID, String functionRes) {
        this.packageID = packageID;
        this.functionRes = functionRes;
    }

    public String getPackageID() {
        return packageID;
    }

    public String getFunctionRes() {
        return functionRes;
    }

    public void setPackageID(String packageID) {
        this.packageID = packageID;
    }

    public void setFunctionRes(String functionRes) {
        this.functionRes = functionRes;
    }

    @Override
    public String toString(){
        return "JSFunctionRec{" + "packageId = " + packageID + "\'" + ", FunctionRes=" + functionRes + "\'" + "}";
    }
}
