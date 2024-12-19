package testng;

import com.codeborne.selenide.Screenshots;
import io.qameta.allure.Attachment;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.nio.file.Files;
import java.nio.file.Path;

public class AllureTestListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println(">>> Test Started: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("+++ Test Passed: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("--- Test Failed: " + result.getMethod().getMethodName());
        saveScreenshot();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("??? Test Skipped: " + result.getMethod().getMethodName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("=== All Tests Finished ===");
    }

    @Attachment(value = "Screenshot on Failure", type = "image/png")
    public byte[] saveScreenshot() {
        try {
            Path screenshot = Screenshots.takeScreenShotAsFile().toPath();
            return Files.readAllBytes(screenshot);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
