package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class S2Tables {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        WebElement table = driver.findElement(By.id("product"));

        List<WebElement> rows = table.findElements(By.tagName("tr"));
        System.out.println("Total rows: " + rows.size());

        for (WebElement row : rows) {
            List<WebElement> cols = row.findElements(By.tagName("td"));
            for (WebElement col : cols) {
                System.out.print(col.getText() + " | ");
            }
            System.out.println();
        }

        // if (courseNames.get(i).getText().equalsIgnoreCase("Learn SQL in Practical + Database Testing from Scratch")) {

        driver.quit();
    }
}
