package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Prac1 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("https://x.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        WebElement signIn = driver.findElement(By.xpath("//*[text()='Sign in']"));
        signIn.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));


        WebElement inputUsername = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@autocomplete='username']")));
        inputUsername.sendKeys("fyredev");

//        driver.close();
    }
}
