package com.auto.testng;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class AllureITestListener implements ITestListener {
    private static final Logger logger = LoggerFactory.getLogger(AllureITestListener.class);

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Override
    public void onTestStart(ITestResult result) {
        logger.info("Test started: {}", result.getName());
    }
}
