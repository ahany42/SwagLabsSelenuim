import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.asserts.SoftAssert;

import java.io.InputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
public class PurchasePage {
    private WebDriver webDriver;
    private static final Logger logger = LoggerFactory.getLogger(PurchasePage.class);
    private List<WebElement> buttons;
    int productCounter;
    private int item_number_to_be_tested = 0;

    private int initialCartCount = 0;
    private int cartCount = 0;

    private SoftAssert softAssert = new SoftAssert();

    public PurchasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.buttons = webDriver.findElements(By.className("btn_inventory"));
        this.productCounter = buttons.size();
    }

    public void AddToCart(String productToPurchase) {
        logger.info("About to add item {} to cart", item_number_to_be_tested);
        try {
            WebElement productTitle = webDriver.findElement(
                    By.xpath("//div[@class='inventory_item_name' and contains(text(), '" + productToPurchase + "')]")
            );
            productTitle.click();

            WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));

// Wait until product name is visible and has non-empty text
            WebElement productName = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.className("inventory_details_name")
            ));
            wait.until(driver -> !productName.getText().trim().isEmpty());

// Wait until product price is visible and has non-empty text
            WebElement productPrice = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.className("inventory_details_price")
            ));
            wait.until(driver -> !productPrice.getText().trim().isEmpty());

// Now it's safe to click the button
            WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.className("btn_inventory")
            ));
            addToCartButton.click();
            logger.info("Item added to cart successfully");

        } catch (Exception e) {
            logger.error("Failed to click on item {}", productToPurchase, e);
            softAssert.fail("Exception while clicking add to cart button: " + e.getMessage());
        }

        try {
            WebElement cartNumberLabel = webDriver.findElement(By.className("shopping_cart_badge"));
            String cartText = cartNumberLabel.getText().trim();
            initialCartCount = Integer.parseInt(cartText);
        } catch (Exception e) {
            logger.info("No items in cart initially. Assuming initialCartCount = 0");
            initialCartCount = 0;
        }

        softAssert.assertAll();
    }

    public void NumberOfItemsInCart() {
        try {
            WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
            WebElement updatedCartLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.className("shopping_cart_badge")));

            String updatedCartText = updatedCartLabel.getText().trim();
            cartCount = Integer.parseInt(updatedCartText);
        } catch (Exception e) {
            logger.warn("Could not locate updated cart number. Assuming cartCount = 0");
            cartCount = 0;
        }
        logger.info("Initial cart count: {}", initialCartCount);
        logger.info("Cart count after adding: {}", cartCount);
        logger.info("Expected cart count: {}", initialCartCount + 1);

        softAssert.assertEquals(cartCount, initialCartCount + 1, "Cart count mismatch after adding item");
        softAssert.assertAll();
        logger.info("Cart count validation completed");
    }
    public void ClickOnCart(){
     try{
         WebElement cartIcon = webDriver.findElement(By.className("shopping_cart_link"));
         cartIcon.click();
         logger.info("Cart Clicked Successfully");
     }catch(Exception e){
         logger.error("Couldn't Continue to Purchase {}",e);
         softAssert.fail("Failed to click on the cart icon: " + e.getMessage());
     }
        softAssert.assertAll();
    }
    public void CheckOut(){
        WebElement checkOutButton;
        try{
            checkOutButton = webDriver.findElement(By.className("checkout_button"));
            checkOutButton.click();
            logger.info("Check Out Completed");
        }
        catch(Exception e){
            logger.error("Error On Checkour {}",e);
        }
    }
    public void CheckOutForm(String firstName,String lastName,String postalCode){
        try{
            WebElement firstNameField = webDriver.findElement(By.id("first-name"));
            WebElement lastNameField = webDriver.findElement(By.id("last-name"));
            WebElement postalCodeField = webDriver.findElement(By.id("postal-code"));
            firstNameField.sendKeys(firstName);
            lastNameField.sendKeys(lastName);
            postalCodeField.sendKeys(postalCode);
            logger.info("Check Out Form Filled Successfully");
            WebElement continueButton = webDriver.findElement(By.className("cart_button"));
            continueButton.click();
        }
        catch(Exception e){
            logger.error("Error On Checkout {}",e.getMessage());
        }
        softAssert.assertAll();
    }
    public void FinishPurchase(){
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));

        WebElement finishButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("cart_button")));
        finishButton.click();
        logger.info("Finish Button Clicked");
        try{
        WebElement checkOutCompleteContainer = webDriver.findElement(By.className("checkout_complete_container"));
        logger.info("Purchase Success");
        }catch(Exception e){
        logger.error("Purchase Not Complete {}",e.getMessage());
        }
    }

}
