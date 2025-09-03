package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class S2SwitchTabs {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        String parentTab = driver.getWindowHandle();
        driver.findElement(By.id("opentab")).click();
        Set<String> tabs = driver.getWindowHandles();

        for (String tab : tabs) {
            if (!tab.equals(parentTab)) {
                driver.switchTo().window(tab);
                System.out.println("Switched to new tab: " + driver.getTitle());
                driver.close();
            }
        }

        driver.switchTo().window(parentTab);
        System.out.println("Back to parent tab: " + driver.getTitle());
    }
}
