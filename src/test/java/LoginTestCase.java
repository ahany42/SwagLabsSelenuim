import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginTestCase extends BaseTest {
    private static final Logger logger = LogManager.getLogger(LoginTestCase.class);
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

}