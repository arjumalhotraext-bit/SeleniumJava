package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class S2SwitchTabsWindows {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        String parentWindow = driver.getWindowHandle();
        driver.findElement(By.id("openwindow")).click();
        Set<String> handles = driver.getWindowHandles();

        for (String handle : handles) {
            if (!handle.equals(parentWindow)) {
                driver.switchTo().window(handle);
                System.out.println("Switched to child window: " + driver.getTitle());
                driver.close();
            }
        }

        driver.switchTo().window(parentWindow);
        System.out.println("Back to parent: " + driver.getTitle());
    }
}
