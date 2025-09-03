package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class S2Frames {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        driver.switchTo().frame("courses-iframe");

        WebElement loginLink = driver.findElement(By.xpath("//a[text()='Login']"));
        loginLink.click();

        System.out.println("Clicked Login inside iframe");

        driver.switchTo().defaultContent();

        String heading = driver.findElement(By.xpath("//h1[text()='Practice Page']")).getText();
        System.out.println("Main page heading: " + heading);

        driver.quit();
    }
}
