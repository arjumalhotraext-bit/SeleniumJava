package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class S4Waits {
    public static void main(String[] args) {
        // Implicit, Explicit, Thread.sleep, Fluent Wait

        WebDriver driver = new ChromeDriver();

        // Implicit Wait
        // Implicit: Hey wait for 3 seconds before you throw element not found error
        // It wont wait for entire duration like 3 seconds if result is visible after 1 second
        // then it will continue but 3 seconds is the max duration
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


        // Explicit: explicitly waiting for a test case
        // like if we know only this test case will take 10 seconds
        // so its a bad thing that we are making implicit to 10 seconds
        // rather we take explicit and go on

        // Fluent Wait
        // Polling frequency – How often to check for the condition.
        // Timeout – Maximum time to wait.
        // It is a type of explicit wait only

        // in Explicit time is fixed 500ms and we cant change
        // but in fluent wait we can change it so polling happens after specified time

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.pollingEvery(Duration.ofSeconds(2)); // check every 2 seconds
        wait.ignoring(NoSuchElementException.class);

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("foo")));
    }
}
