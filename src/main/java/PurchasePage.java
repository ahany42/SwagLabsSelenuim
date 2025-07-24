import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.Random;

public class PurchasePage {
    private WebDriver webDriver;
    private static final Logger logger = LoggerFactory.getLogger(new Object() {}.getClass().getEnclosingClass());
    public int productCounter;
    public int item_number_to_be_tested;
    public PurchasePage(WebDriver webDriver) {
        logger.info("Construct");
        this.webDriver = webDriver;
    }
    public void PurchaseItem(){
        logger.info("Called");
        List<WebElement> buttons = webDriver.findElements(By.className("inventory_item"));
        productCounter = buttons.size();
        Random random = new Random();
        item_number_to_be_tested = random.nextInt(productCounter);
        logger.info("About to Add Item {} to Cart",item_number_to_be_tested);
        buttons.get(item_number_to_be_tested).click();
        logger.info("Item Purchased Successfully");
    }
}
