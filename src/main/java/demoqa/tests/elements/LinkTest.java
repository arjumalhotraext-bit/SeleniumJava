package demoqa.tests.elements;

import demoqa.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LinkTest extends BaseTest {
    @Test
    public void testLinks() {
        var linksPage = homePage.goToElements().clickLinks();
        linksPage.clickBadRequestLink();
        String actualResponse = linksPage.getResponse();
        Assert.assertTrue(actualResponse.contains("400")
                        && actualResponse.contains("Bad Request"),
                "\n Actual Response (" + actualResponse +
                        ")\n Does Not Contain '400' and 'Bad Request' \n");
    }
}
