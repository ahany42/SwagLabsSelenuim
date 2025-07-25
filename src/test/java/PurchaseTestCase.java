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
    @Test (priority = 3)
    public void ContinueToPurchase(){
    PurchasePage purchasePage = new PurchasePage(webDriver);
    purchasePage.ClickOnCart();
    }
    @Test (priority = 4)
    public void CheckOut(){
        PurchasePage purchasePage = new PurchasePage(webDriver);
        purchasePage.CheckOut();
    }
    @Test (priority = 6)
    public void FillCheckOutForm(){
        PurchasePage purchasePage = new PurchasePage(webDriver);
        String filePath = "D:\\Testing projects\\SwagLabs\\src\\test\\resources\\ProfileData.xlsx";
        String sheetName = "Sheet1";
        ExcelReader reader = new ExcelReader(filePath, sheetName);
        String firstName = reader.getCellData(1, 0);
        String lastName = reader.getCellData(1, 1);
        String postalCode = reader.getCellData(1, 2);
        purchasePage.CheckOutForm(firstName, lastName, postalCode);
    }
    @Test (priority = 7)
    public void FinishPurchase(){
        PurchasePage purchasePage = new PurchasePage(webDriver);
        purchasePage.FinishPurchase();
    }
}
