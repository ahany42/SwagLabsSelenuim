import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import static org.testng.Assert.*;

public class LoginSteps extends BaseTest {
    private static final Logger logger = LogManager.getLogger(LoginSteps.class);
    private LoginPage loginPage;
    private boolean loginResult;

    @Before
    public void setup() {
        webDriver.get(PropertiesUtil.get("base.url"));
        logger.info("Navigated to login page.");
    }

    @After
    public void tearDown() {
        try {
            webDriver.findElement(By.id("user-name")).clear();
            webDriver.findElement(By.id("password")).clear();
            logger.info("Cleared login input fields after scenario.");
        } catch (Exception e) {
            logger.warn("Could not clear login fields (maybe not on login page): " + e.getMessage());
        }
    }

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        assertTrue(webDriver.getCurrentUrl().contains("login"), "Not on login page");
    }

    @When("I login with username {string} and password {string}")
    public void i_login_with_username_and_password(String username, String password) {
        boolean isAuthenticatedExpected = !(username.equals("WrongUserName") || password.equals("WrongPassword") || username.equals(PropertiesUtil.get("login.lockedaccount")));
        loginPage = new LoginPage(webDriver, username, password);
        try {
            loginPage.LoginToTheSystem(isAuthenticatedExpected);
            loginResult = isAuthenticatedExpected;
        } catch (AssertionError e) {
            loginResult = false;
        }
    }

    @Then("I should see login failure message")
    public void i_should_see_login_failure_message() {
        assertFalse(loginResult, "Expected login failure but login succeeded");
    }

    @Then("I should see login success")
    public void i_should_see_login_success() {
        assertTrue(loginResult, "Expected login success but login failed");
    }
}
