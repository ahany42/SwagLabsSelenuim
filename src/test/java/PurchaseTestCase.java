import org.testng.annotations.*;
public class PurchaseTestCase extends BaseTest {
    @Test (priority=1)
    public void AddToCart(){
    PurchasePage purchasePage = new PurchasePage(webDriver);
        logger.info("About to Add Item to Cart");
        purchasePage.AddToCart();
    }
    @Test (priority = 2)
    public void NumberOfItemsInCart(){
    PurchasePage purchasePage = new PurchasePage(webDriver);
    logger.info("About to Test Number of Items in Cart");
    purchasePage.NumberOfItemsInCart();
    }
}
