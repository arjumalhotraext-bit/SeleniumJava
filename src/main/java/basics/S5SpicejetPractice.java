package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class S5SpicejetPractice {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        try {
            driver.get("http://spicejet.com");
            driver.findElement(By.xpath("//*[@data-testid='to-testID-origin']//input")).click();
            driver.findElement(By.xpath("//*[@data-testid='to-testID-origin']//input")).sendKeys("cha");
            driver.findElement(By.xpath("//div[normalize-space(text())='IXC']")).click();

            driver.findElement(By.xpath("//*[@data-testid='to-testID-destination']//input")).click();
            driver.findElement(By.xpath("//*[@data-testid='to-testID-destination']//input")).sendKeys("del");

            List<WebElement> months = driver.findElements(By.xpath("//div[@data-testid and contains(@data-testid,'undefined-month-')]"));
            for (WebElement month : months) {
                String monthText = month.getText();

                if (monthText.contains("August 2025")) {
                    List<WebElement> days = month.findElements(By.xpath(".//div[@data-testid and contains(@data-testid,'calendar-day')]"));

                    for (WebElement day : days) {
                        if (day.getText().equals("17")) {
                            day.click();
                            break;
                        }
                    }
                }
            }

            Thread.sleep(3000);
            driver.findElement(By.xpath("//div[normalize-space(text())='Students']")).click();
            System.out.println(driver.findElement(By.xpath("//div[normalize-space(text())='Students']")).isEnabled());
        } catch (Exception e) {
            System.out.println(e);
        } finally {
//            driver.close();
        }
    }
}
