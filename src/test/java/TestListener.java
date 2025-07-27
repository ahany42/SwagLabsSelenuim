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
        // Get the test class instance to access WebDriver
        Object testClass = result.getInstance();

        // Cast it to your BaseTest to access getDriver()
        WebDriver driver = ((BaseTest) testClass).getDriver();

        if (driver != null) {
            // Take screenshot
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                // Ensure the folder exists
                File screenshotsDir = new File("screenshots");
                if (!screenshotsDir.exists()) {
                    screenshotsDir.mkdirs();
                }

                // Create destination file with test name
                File destFile = new File(screenshotsDir, result.getName() + ".png");

                // Copy the screenshot to destination
                Files.copy(screenshot.toPath(), destFile.toPath());

                System.out.println("Saved failed test screenshot: " + destFile.getAbsolutePath());

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
