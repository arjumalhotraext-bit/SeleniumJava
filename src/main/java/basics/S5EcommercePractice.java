package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;

public class S5EcommercePractice {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        String[] itemsNeeded = {"Cucumber", "Brocolli", "Beetroot"};
        try {
            driver.get("https://rahulshettyacademy.com/seleniumPractise/");
            Thread.sleep(3000);

            List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

            int j = 0;

            for (int i = 0; i < products.size(); i++) {
                String[] name=products.get(i).getText().split("-");
                String formattedName=name[0].trim();

                List itemsNeededList = Arrays.asList(itemsNeeded);

                if (itemsNeededList.contains(formattedName)) {
                    j++;
                    driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

                    if (j == itemsNeeded.length) {
                        break;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            driver.quit();
        }
    }
}
