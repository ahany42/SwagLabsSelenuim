import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        Object testClass = result.getInstance();

        WebDriver driver = ((BaseTest) testClass).getDriver();

        if (driver != null) {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                File screenshotsDir = new File("screenshots");
                if (!screenshotsDir.exists()) {
                    screenshotsDir.mkdirs();
                }

                File destFile = new File(screenshotsDir, result.getName() + ".png");

                Files.copy(screenshot.toPath(), destFile.toPath());

                System.out.println("Saved failed test screenshot: " + destFile.getAbsolutePath());

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
