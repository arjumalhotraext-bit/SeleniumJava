package pageobjects;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobjects.pageobjs.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class SubmitOrder extends BaseTest {
    // https://deloittedevelopment.udemy.com/course/selenium-real-time-examplesinterview-questions/learn/lecture/33480350#overview
    // DO INTERVIEW QUESTIONS

    String productName = "ZARA COAT 3";

    @Test(dataProvider="getData", groups= {"Purchase"})
    public void submitOrder(HashMap<String,String> input) throws IOException, InterruptedException {
        ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"), input.get("password"));
        List<WebElement> products = productCatalogue.getProductList();

        productCatalogue.addProductToCart(input.get("product"));
        CartPage cartPage = productCatalogue.goToCartPage();

        Boolean match = cartPage.VerifyProductDisplay(input.get("product"));
        Assert.assertTrue(match);

        CheckoutPage checkoutPage = cartPage.goToCheckout();
        checkoutPage.selectCountry("india");

        ConfirmationPage confirmationPage = checkoutPage.submitOrder();
        String confirmMessage = confirmationPage.getConfirmationMessage();

        Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
    }

    @Test(dependsOnMethods= {"submitOrder"})
    public void OrderHistoryTest() {
        ProductCatalogue productCatalogue = landingPage.loginApplication("arjunmal@gmail.com", "Eagle@eye1");
        OrderPage ordersPage = productCatalogue.goToOrdersPage();
        Assert.assertTrue(ordersPage.VerifyOrderDisplay(productName));
    }

    @DataProvider
    public Object[][] getData() throws IOException {
        List<HashMap<String, String>> data = getJsonDataToMap(
                System.getProperty("user.dir") + "//src//main//java//pageobjects//data//data.json");
        return new Object[][] { { data.get(0) }, { data.get(1) } };
    }

}
