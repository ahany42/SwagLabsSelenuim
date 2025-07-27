import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.FileWriter;
import org.testng.TestNG;
import java.io.IOException;
import org.openqa.selenium.chrome.ChromeOptions;
public class BaseTest {
    public static final Logger logger = LogManager.getLogger(LoginTestCase.class);
    public static WebDriver webDriver;
    private void clearLogFile() {
        try (FileWriter fw = new FileWriter("logs/test-log.log", false)) {
        } catch (IOException e) {
            System.err.println("Could not clear log file: " + e.getMessage());
        }
    }
    public WebDriver getDriver() {
        return webDriver;
    }
    @BeforeSuite
    public void setup() {
        clearLogFile();
        logger.info("Setting up WebDriver and navigating to base URL...");ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        webDriver = new ChromeDriver();
        String baseUrl = PropertiesUtil.get("base.url");
        webDriver.get(baseUrl);
        webDriver.manage().window().maximize();
        logger.debug("Navigated to: {}", baseUrl);
    }
    @AfterTest

    @AfterSuite
    public void tearDown() throws InterruptedException {
        logger.info("Tearing down WebDriver...");
        Thread.sleep(5000);
        if (webDriver != null) {
            webDriver.quit();
            logger.debug("WebDriver quit successfully.");
        }
    }
}
