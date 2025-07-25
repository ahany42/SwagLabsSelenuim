import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

public class PurchaseSteps {
    private WebDriver webDriver = Hooks.webDriver;
    private PurchasePage purchasePage;
    private ExcelReader reader;
    private String firstName, lastName, postalCode;

    @Given("I am on the purchase page")
    public void i_am_on_the_purchase_page() {
        purchasePage = new PurchasePage(webDriver);
    }

    @When("I add an item to the cart")
    public void i_add_item_to_cart() {
        purchasePage.AddToCart();
    }

    @Then("the item should be added successfully")
    public void item_should_be_added() {
        // Optional assertion
    }

    @Given("I have added an item to the cart")
    public void item_is_added() {
        purchasePage = new PurchasePage(webDriver);
        purchasePage.AddToCart();
    }

    @When("I view the cart")
    public void i_view_cart() {
        purchasePage.NumberOfItemsInCart();
    }

    @Then("I should see the correct number of items")
    public void check_cart_items() {
        // Optional assertion
    }

    @When("I click on the cart")
    public void click_cart() {
        purchasePage.ClickOnCart();
    }

    @Then("I should proceed to checkout")
    public void proceed_to_checkout() {
        // Optional: validate current page
    }

    @When("I click on the checkout button")
    public void click_checkout_button() {
        purchasePage.CheckOut();
    }

    @Then("I should be on the checkout form")
    public void on_checkout_form() {
        // Optional: validate form visibility
    }

    @Given("I have profile data from Excel")
    public void read_excel_data() {
        reader = new ExcelReader("D:\\Testing projects\\SwagLabs\\src\\test\\resources\\ProfileData.xlsx", "Sheet1");
        firstName = reader.getCellData(1, 0);
        lastName = reader.getCellData(1, 1);
        postalCode = reader.getCellData(1, 2);
    }

    @When("I fill the checkout form")
    public void fill_checkout_form() {
        purchasePage.CheckOutForm(firstName, lastName, postalCode);
    }

    @Then("the form should be completed successfully")
    public void form_completed() {
        // Optional: verify form data or next step
    }

    @When("I finish the purchase")
    public void finish_purchase() {
        purchasePage.FinishPurchase();
    }

    @Then("I should see a confirmation")
    public void confirmation_message() {
        // Optional: assert success message
    }
}
