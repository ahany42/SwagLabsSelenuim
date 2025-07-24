import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;  // Soft assert import
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginPage {
    private WebDriver webDriver;
    private String userName;
    private String password;
    private static final Logger logger = LoggerFactory.getLogger(new Object() {}.getClass().getEnclosingClass());

    public LoginPage(WebDriver webDriver, String userName, String password){
        this.webDriver = webDriver;
        this.userName = userName;
        this.password = password;
    }

    public void LoginToTheSystem(boolean isAuthenticated){
        logger.info("Logging in with username: {}", userName);
        SoftAssert softAssert = new SoftAssert();

        try {
            webDriver.findElement(By.id("user-name")).sendKeys(userName);
            webDriver.findElement(By.id("password")).sendKeys(password);
            webDriver.findElement(By.id("login-button")).click();
            WebElement logo = webDriver.findElement(By.className("app_logo"));
            boolean isDisplayed = logo.isDisplayed();
            if (isAuthenticated) {
                softAssert.assertTrue(isDisplayed, "Login was expected to succeed, but logo is not displayed.");
            } else {
                softAssert.assertFalse(isDisplayed, "Login was expected to fail, but logo is displayed.");
            }
        } catch (Exception e) {
            if (isAuthenticated) {
                softAssert.fail("Login was expected to succeed, but failed: " + e.getMessage());
            } else {
                // Expected failure, no assertion needed or just log info
                logger.info("Login failed as expected.");
            }
        }

        // Collect all assertion results
        softAssert.assertAll();
    }
}
