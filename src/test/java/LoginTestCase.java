import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginTestCase {
    private WebDriver webDriver;
    private static final Logger logger = LogManager.getLogger(LoginTestCase.class);

    @BeforeMethod
    public void setup() {
        logger.info("Setting up WebDriver and navigating to base URL...");
        webDriver = new ChromeDriver();
        String baseUrl = PropertiesUtil.get("base.url");
        webDriver.get(baseUrl);
        webDriver.manage().window().maximize();
        logger.debug("Navigated to: {}", baseUrl);
    }

    @Test
    public void login() {
        logger.info("Starting login test case...");

        String username = PropertiesUtil.get("login.username");
        String password = PropertiesUtil.get("login.password");
        boolean expected = PropertiesUtil.getBoolean("login.success.expected");

        logger.debug("Loaded credentials from properties: username='{}', expected='{}'", username, expected);

        LoginPage loginPage = new LoginPage(webDriver, username, password);
        loginPage.LoginToTheSystem(expected);

        logger.info("Completed login test for user '{}'", username);
    }

    @AfterMethod
    public void tearDown() {
        logger.info("Tearing down WebDriver...");
        if (webDriver != null) {
            webDriver.quit();
            logger.debug("WebDriver quit successfully.");
        }
    }
}