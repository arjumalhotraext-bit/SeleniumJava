package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class S2Dropdown {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement dropdown = driver.findElement(By.id("dropdown-class-example"));

        Select select = new Select(dropdown);
        select.selectByIndex(1);
        select.selectByValue("option2");
        select.selectByVisibleText("Option3");

    }
}
