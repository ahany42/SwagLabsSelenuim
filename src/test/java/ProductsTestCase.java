import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class ProductsTestCase extends BaseTest {
    SoftAssert softAssert = new SoftAssert();
    private PurchasePage purchasePage;
    public int buttonCounter;
    public int PriceLabelCounter;

    @BeforeMethod
    public void setUpTest() {
        purchasePage = new PurchasePage(webDriver);
    }

    @Test
    public void PurchaseButtonsCount() {
        List<WebElement> buttons = webDriver.findElements(By.className("btn_inventory"));
        buttonCounter = buttons.size();
        logger.info("Fetching products ");
        int expectedCount = purchasePage.productCounter;
        if (buttonCounter == expectedCount) {
            logger.info("✅ Product count matches expected value.");
        } else {
            logger.error("❌ Product count mismatch! Expected: {}, Actual: {}", expectedCount, buttonCounter);
        }
        softAssert.assertEquals(buttonCounter, expectedCount, "Product count mismatch!");
        softAssert.assertAll();
    }

    @Test
    public void PriceLabelCount() {
        logger.info("Fetching products ");
        List<WebElement> priceLabels = webDriver.findElements(By.className("inventory_item_price"));
        PriceLabelCounter = priceLabels.size();
        int expectedCount = purchasePage.productCounter;
        if (PriceLabelCounter == expectedCount) {
            logger.info("✅ Product count matches expected value.");
        } else {
            logger.error("❌ Product count mismatch! Expected: {}, Actual: {}", expectedCount, PriceLabelCounter);
        }
        softAssert.assertEquals(PriceLabelCounter, expectedCount, "Product count mismatch!");
        softAssert.assertAll();
    }
}
