package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class S9Streams {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
            driver.findElement(By.xpath("//tr/th[1]")).click();

            List<WebElement> elementsList = driver.findElements(By.xpath("//tr/td[1]"));
            List<String> originalList = elementsList.stream()
                    .map(s -> s.getText())
                    .collect(Collectors.toList());

            List<String> sortedList = originalList.stream()
                    .sorted()
                    .collect(Collectors.toList());

            System.out.println(sortedList);

            Assert.assertTrue(originalList.equals(sortedList));

            List<String> price;

            do {
                List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));

                price = rows.stream()
                        .filter(s -> s.getText().contains("Rice"))
                        .map(s -> getPriceVeggie(s))
                        .collect(Collectors.toList());

                price.forEach(a -> System.out.println(a));

                if (price.size() < 1) {
                    driver.findElement(By.cssSelector("[aria-label='Next']")).click();
                }
            } while (price.size() < 1);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            driver.close();
        }
    }

    private static String getPriceVeggie(WebElement s) {
        String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
        return priceValue;
    }

    // Java Streams
    // It makes filtering, mapping, and transforming data shorter and cleaner compared to loops
    // A Stream is a pipeline of operations on a collection (like List, Set, Map).
    // Streams do not store data → they process data from collections

    // .stream() → converts the List of WebElements into a Stream.
    // .map(s -> s.getText()) → transforms each element (WebElement → String).
    // .collect(Collectors.toList()) → collects results back into a List.


    // .stream() → converts the List of WebElements into a Stream.
    // .sorted() → Sorts the data
    // .collect(Collectors.toList()) → collects results back into a List.

    // Important Functions
    // .stream() // First step
    // .sorted(), .map(), .filter(), .distinct() etc // Intermediate Functions
    // .colelct(Collectors.toList()) // final step back into a List
}
