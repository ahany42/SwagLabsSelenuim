import org.testng.annotations.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.By;

public class LoginTestCase extends BaseTest {
    private static final Logger logger = LogManager.getLogger(LoginTestCase.class);

    @BeforeMethod
    public void navigateToLoginPage() {
        // Navigate to login page before each test to reset state
        webDriver.get(PropertiesUtil.get("base.url"));  // <-- Change to your login URL
        logger.info("Navigated to login page.");
    }

    @AfterMethod
    public void clearLoginFields() {
        try {
            webDriver.findElement(By.id("user-name")).clear();
            webDriver.findElement(By.id("password")).clear();
            logger.info("Cleared login input fields after test method.");
        } catch (Exception e) {
            logger.warn("Could not clear login fields (maybe not on login page): " + e.getMessage());
        }
    }

    @Test(priority = 1)
    public void InvalidUserNameLogin() {
        logger.debug("Starting invalid user name login test case...");

        String username = "WrongUserName";
        String password = PropertiesUtil.get("login.password");
        boolean isAuthenticated = false;

        logger.debug("Loaded credentials from properties: username='{}', expected='{}'", username, isAuthenticated);

        LoginPage loginPage = new LoginPage(webDriver, username, password);
        loginPage.LoginToTheSystem(isAuthenticated);

        logger.info("Completed login test for user '{}'", username);
    }
    @Test(priority = 3)
    public void InValidPasswordLogin(){
        logger.debug("Starting invalid password login test case...");

        String username = PropertiesUtil.get("login.username");
        String password = "WrongPassword";
        boolean isAuthenticated = false;

        logger.debug("Loaded credentials from properties: username='{}', expected='{}'", username, isAuthenticated);

        LoginPage loginPage = new LoginPage(webDriver, username, password);
        loginPage.LoginToTheSystem(isAuthenticated);

        logger.info("Completed login test for user '{}'", username);
    }
    @Test(priority = 4)
    public void InValidUserNameAndPasswordLogin(){
        logger.debug("Starting invalid password and User Name login test case...");

        String username = "WrongUserName";
        String password = "WrongPassword";
        boolean isAuthenticated = false;

        logger.debug("Loaded credentials from properties: username='{}', expected='{}'", username, isAuthenticated);

        LoginPage loginPage = new LoginPage(webDriver, username, password);
        loginPage.LoginToTheSystem(isAuthenticated);

        logger.info("Completed login test for user '{}'", username);
    }    @Test(priority = 5)
    public void LockedOutUserLogin(){
        logger.debug("Starting invalid password and User Name login test case...");

        String username = PropertiesUtil.get("login.lockedaccount");
        String password = PropertiesUtil.get("login.password");
        boolean isAuthenticated = false;

        logger.debug("Loaded credentials from properties: username='{}', expected='{}'", username, isAuthenticated);

        LoginPage loginPage = new LoginPage(webDriver, username, password);
        loginPage.LoginToTheSystem(isAuthenticated);

        logger.info("Completed login test for user '{}'", username);
    }
    @Test(priority = 6)
    public void ValidLogin() {
        logger.info("Starting valid login test case...");

        String username = PropertiesUtil.get("login.username");
        String password = PropertiesUtil.get("login.password");
        boolean isAuthenticated = true;

        logger.debug("Loaded credentials from properties: username='{}', expected='{}'", username, isAuthenticated);

        LoginPage loginPage = new LoginPage(webDriver, username, password);
        loginPage.LoginToTheSystem(isAuthenticated);

        logger.info("Completed login test for user '{}'", username);
        isLoggedIn = true;
    }
}
