package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class S11BrokenURL {
    public static void main(String[] args) throws MalformedURLException, IOException {
        // TODO Auto-generated method stub

        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // Broken URL check
        // Step 1 - Get all URLs tied to the links using Selenium
        // Java methods will call URLs and get the status code
        // If status code > 400, then that URL is not working (broken link)

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
        SoftAssert a = new SoftAssert();

        for (WebElement link : links) {
            String url = link.getAttribute("href");

            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("HEAD");
            conn.connect();

            int respCode = conn.getResponseCode();
            System.out.println(respCode);

            a.assertTrue(
                    respCode < 400,
                    "The link with text \"" + link.getText() + "\" is broken with code " + respCode
            );
        }

        a.assertAll();
    }
}
