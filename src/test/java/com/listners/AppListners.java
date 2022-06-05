package com.listners;

import com.fileutils.FileUtils;
import com.genericmethods.GenricMethods;
import org.testng.*;

public class AppListners implements ITestListener, IInvokedMethodListener {
    GenricMethods genricMethods=new GenricMethods();
    FileUtils fileUtils=new FileUtils();
    public void onStart(ITestContext context) {
        System.out.println("onStart method started");
        fileUtils.loadApplicationProperties();
        genricMethods.launchBrowser(fileUtils.getApplicationProperties("Browser_Execute"),fileUtils.getApplicationProperties("QA_APP_URL"));
    }

    public void onFinish(ITestContext context) {
        System.out.println("onFinish method started");
        genricMethods.closeBrowser();
    }

    public void onTestStart(ITestResult result) {
        System.out.println("New Test Started" +result.getName());
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("onTestSuccess Method" +result.getName());
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("onTestFailure Method" +result.getName());
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("onTestSkipped Method" +result.getName());
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("onTestFailedButWithinSuccessPercentage" +result.getName());
    }
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        System.out.println("Before method......"+method.getTestMethod().getMethodName());
    }

    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        System.out.println("After method......"+method.getTestMethod().getMethodName());
    }

}
