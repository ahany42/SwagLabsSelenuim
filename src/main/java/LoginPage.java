import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginPage {
    private WebDriver driver;
    private String userName;
    private String password;
    private static final Logger logger = LoggerFactory.getLogger(LoginPage.class);

    public LoginPage(WebDriver driver, String userName, String password){
        this.driver = driver;
        this.userName = userName;
        this.password = password;
    }

    public void LoginToTheSystem(boolean isAuthenticated){
        logger.info("Logging in with username: {}", userName);

        driver.findElement(By.id("user-name")).sendKeys(userName);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();

        try {
            WebElement logo = driver.findElement(By.className("app_logo"));
            boolean isDisplayed = logo.isDisplayed();
            if (isAuthenticated) {
                Assert.assertTrue(isDisplayed, "Login was expected to succeed, but logo is not displayed.");
            } else {
                Assert.assertFalse(isDisplayed, "Login was expected to fail, but logo is displayed.");
            }
        } catch (Exception e) {
            if (isAuthenticated) {
                Assert.fail("Login was expected to succeed, but failed: " + e.getMessage());
            } else {
                Assert.assertTrue(true, "Login failed as expected.");
            }
        }
    }
}
