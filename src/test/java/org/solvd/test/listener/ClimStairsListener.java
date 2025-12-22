package org.solvd.test.listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ClimStairsListener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        System.out.println("test start");
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("test started" + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("test executed successfully" + result.getStatus());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("test Failed");

    }
}
