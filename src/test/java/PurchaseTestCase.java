import org.testng.annotations.*;
public class PurchaseTestCase extends BaseTest {
    @Test
    public void PurchaseItem(){
    PurchasePage purchasePage = new PurchasePage(webDriver);
    logger.info("About to Purchase Item");
    purchasePage.PurchaseItem();
    }
}
