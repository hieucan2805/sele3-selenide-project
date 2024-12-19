package com.auto.testng;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Allure;
import io.qameta.allure.listener.TestLifecycleListener;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.TestResult;
import org.openqa.selenium.OutputType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.util.UUID;


public class AllureTestLifecycleListener implements TestLifecycleListener {

    private static final Logger logger = LoggerFactory.getLogger(AllureTestLifecycleListener.class);

    @Override
    public void beforeTestStart(TestResult result) {

    }

    @Override
    public void beforeTestStop(TestResult result) {
        if (result.getStatus() != null &&
                (result.getStatus().equals(Status.BROKEN) || result.getStatus().equals(Status.FAILED))) {
            logger.info("Test case \"{}\" has been \"{}\". Take a screenshot", result.getFullName(),
                    result.getStatus().value());
            try {
                byte[] screenshot = Selenide.screenshot(OutputType.BYTES);
                if (screenshot != null) {
                    ByteArrayInputStream input = new ByteArrayInputStream(screenshot);
                    Allure.attachment(UUID.randomUUID().toString(), input);
                }
            } catch (Exception e) {
                logger.error("An error occurs when adding screenshot to report: \n{}", e.getMessage());
            }

        }
    }
}