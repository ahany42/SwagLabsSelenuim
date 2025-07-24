import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
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
        this.webDriver = webDriver;
        List<WebElement> buttons = webDriver.findElements(By.className("inventory_item"));
        productCounter = buttons.size();
        Random random = new Random();
        item_number_to_be_tested = random.nextInt(productCounter);
        buttons.get(item_number_to_be_tested).click();
    }
}
