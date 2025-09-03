package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class S2Suggestions {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement rb1 = driver.findElement(By.xpath("//input[@id='autocomplete']"));
        rb1.click();
        rb1.sendKeys("ind");

        List<WebElement> suggestions = driver.findElements(By.cssSelector(".ui-menu-item div"));
        for (WebElement option : suggestions) {
            if (option.getText().equalsIgnoreCase("India")) {
                option.click();
                break;
            }
        }

//        driver.quit();
    }
}
