package pageobjects;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageobjects.pageobjs.*;

import java.io.IOException;
import java.util.List;

public class StepDefinitions extends BaseTest {
    // Cucumber
    // Gherkin Language (Given, When, Then)

    // Regex Anchors
    // ^ - start of the line
    // $ - end of the line

    // ^Logged in with username (.+) and password (.+)$
    // Logged in with username test@gmail.com and password Test@123

    // Regex Capture Group
    // () - capture a value from the step
    // .+ - one or more of any character
    // so (.+) means grab whatever text is there

    // {string}, {int}, {float} → Cucumber Expressions
    // {string} → matches a quoted string (e.g. "THANKYOU FOR THE ORDER.")

    // Older way of doing regex
    // "^\"([^\"]*)\"
    // \" → match a double quote
    //([^\"]*) → capture everything until the next double quote
    //\" → match closing quote


    public LandingPage landingPage;
    public ProductCatalogue productCatalogue;
    public ConfirmationPage confirmationPage;

    @Given("I landed on Ecommerce Page")
    public void I_landed_on_Ecommerce_Page() throws IOException {
        landingPage = launchApplication();
    }

    @Given("^Logged in with username (.+) and password (.+)$")
    public void logged_in_username_and_password(String username, String password) {
        productCatalogue = landingPage.loginApplication(username,password);
    }

    @When("^I add product (.+) to Cart$")
    public void i_add_product_to_cart(String productName) throws InterruptedException {
        List<WebElement> products = productCatalogue.getProductList();
        productCatalogue.addProductToCart(productName);
    }

    @When("^Checkout (.+) and submit the order$")
    public void checkout_submit_order(String productName) {
        CartPage cartPage = productCatalogue.goToCartPage();

        Boolean match = cartPage.VerifyProductDisplay(productName);
        Assert.assertTrue(match);

        CheckoutPage checkoutPage = cartPage.goToCheckout();
        checkoutPage.selectCountry("india");
        confirmationPage = checkoutPage.submitOrder();
    }

    @Then("{string} message is displayed on ConfirmationPage")
    public void message_displayed_confirmationPage(String string) {
        String confirmMessage = confirmationPage.getConfirmationMessage();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
        driver.close();
    }

    @Then("^\"([^\"]*)\" message is displayed$")
    public void something_message_is_displayed(String strArg1) throws Throwable {
        Assert.assertEquals(strArg1, landingPage.getErrorMessage());
        driver.close();
    }
}
