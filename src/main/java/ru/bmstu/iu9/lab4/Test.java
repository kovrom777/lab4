package ru.bmstu.iu9.lab4;

import scala.Int;

import java.util.ArrayList;

public class Test {

    public String name;
    public String testName;
    public String expectedResult;
    public ArrayList<Integer> funcParams;
    public String func;
    public String packageId;

    public Test(String name, String testName, String expectedResult, ArrayList<Integer> funcParams, String func, String packageId) {
        this.name = name;
        this.testName = testName;
        this.expectedResult = expectedResult;
        this.funcParams = funcParams;
        this.func = func;
        this.packageId = packageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getExpectedResult() {
        return expectedResult;
    }

    public void setExpectedResult(String expectedResult) {
        this.expectedResult = expectedResult;
    }

    public ArrayList<Integer> getFuncParams() {
        return funcParams;
    }

    public void setFuncParams(ArrayList<Integer> funcParams) {
        this.funcParams = funcParams;
    }

    public String getFunc() {
        return func;
    }

    public void setFunc(String func) {
        this.func = func;
    }

    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }
}
