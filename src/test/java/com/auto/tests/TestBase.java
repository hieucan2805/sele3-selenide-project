package com.auto.tests;

import com.auto.testng.AllureITestListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;

import static com.codeborne.selenide.Selenide.closeWebDriver;


public class TestBase {
//    private final TestConfig testConfig = TestConfig.getInstance();
private static final Logger logger = LoggerFactory.getLogger(AllureITestListener.class);

    @BeforeSuite(alwaysRun = true)
    public void beforeTestSuite() {
        logger.info("Max retry time: {}", System.getProperty("maxRetryCount"));
        logger.info("Grid: {}", System.getProperty("remote"));
        logger.info("Browser: {}", System.getProperty("selenide.browser"));
        logger.info("Thread count: {}", System.getProperty("threadCount"));

//        if (System.getProperty("remote").equals("true")) {
//            Configuration.remote = testConfig.remote();
//        }
//        Configuration.browser = testConfig.getBrowser();
//        Configuration.startMaximized = testConfig.isStartMaximized();
//        Configuration.reportsFolder = testConfig.getReportFolder();
//        Configuration.timeout = testConfig.getTimeout();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        closeWebDriver();
    }
}
