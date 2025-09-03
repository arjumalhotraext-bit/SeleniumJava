package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class S2MouseHover {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        WebElement hoverButton = driver.findElement(By.id("mousehover"));

        Actions actions = new Actions(driver);
        actions.moveToElement(hoverButton).perform();
        Thread.sleep(2000);

        WebElement topOption = driver.findElement(By.xpath("//a[text()='Top']"));
        topOption.click();
    }
}
