package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class S1Locators {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        // Opening the URL
        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        // Finding element By ID
        driver.findElement(By.id("inputUsername")).sendKeys("rahul");

        // Finding element By Name
        driver.findElement(By.name("inputPassword")).sendKeys("hello123");

        // Finding element by ClassName
        driver.findElement(By.className("signInBtn")).click();

        // CSS Selector
        // <p class="error" .... ></p>
        System.out.println(driver.findElement(By.cssSelector("p.error")).getText());

        // Locate anchor (<a>) elements based on their visible text
        driver.findElement(By.linkText("Forgot your password?")).click();

        // XPath
        // tag[attribute='value']
        // <input type='text' placeholder='Name'>...</input>

        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("John");
        driver.findElement(By.xpath("//input[@type='text'][2]")).clear();

        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("John");
        driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("john@gmail.com");

        // <input type="text" name="email" />
        //| CSS | input[name='email'] |
        //| XPath | //input[@name='email'] |

        // <div>
        //    <input type="text" />
        // </div>
        // | CSS | div > input |
        // | XPath | //div/input |

        // <p>Hello World</p>
        // | CSS | Not supported |
        // | XPath | //p[text()='Hello World'] |

        driver.findElement(By.xpath("//form/input[3]")).sendKeys("9864353253");
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        System.out.println(driver.findElement(By.cssSelector("form p")).getText());

        driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();

        driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");
        driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
        driver.findElement(By.id("chkboxOne")).click();
        driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();

        driver.quit();
    }

    // DRIVER
    // driver.get("https://www.github.com/");
    // driver.getTitle()
    // driver.getCurrentUrl()
    // driver.close(); // closes the current browser window
    // driver.quit(); // will quit all

    // BASICS
    // if we want to send input we use --> [sendKeys("")]
    // if we want to click we use --> [click()]
    // if we want to get text we use --> [getText()]
    // if we want to clear the field --> [clear()]
    // if we want to check if the element is there -> [isDisplayed()]


    // Set<String> abc = driver.getWindowHandles();
    // Iterator<String> it = abc.iterator();
    // driver.switchTo().window(it.next());

    // SELECTORS [id, name, className, cssSelector, xpath, linkText]

    // Selectors [id, name, className, linkText, tagName]
    // driver.findElement(By.id("inputUsername")).sendKeys("rahul");
    // driver.findElement(By.name("inputPassword")).sendKeys("hello123");
    // driver.findElement(By.className("signInBtn")).click();
    // driver.findElement(By.linkText("Forgot your password?")).click();
    // driver.findElements(By.tagName("iframe")).size();

    // Selectors [cssSelector]    ([] this square brackets is to add a condition)
    // System.out.println(driver.findElement(By.cssSelector("p.error")).getText());                         [tag.className]
    // driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("John");                   [tag[attribute=value]]
    // driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("john@gmail.com");    [tag[attribute=value]]:nth-child(3)
    // driver.findElement(By.cssSelector(".reset-pwd-btn")).click();                                        [.className]
    // driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");                              [#id]
    // driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");            [tag[attribute*=partialValue]]
    // driver.findElement(By.cssSelector("[routerlink*='cart']")


    // Selectors [xpath] [starts from //]
    // driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("John");                       [//tag[@attribute=value]]
    // driver.findElement(By.xpath("//form/input[3]")).sendKeys("9864353253");                              [parent -> child, form -> input:nth-of-type(3)]
    // driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-container']/button[1]")).click();
    // driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();                         [finds button with class submit]
    // driver.findElement(By.xpath("//*[text()='Log Out']"))
    // driver.findElement(By.xpath("//div[normalize-space(text())='Students']")).click();                   [normalize-space removes all leading, trailing and extra spaces between the words]


    // ------------------------------------------------------------------------------------
    // Xpath vs cssSelector
    // Xpath supports text search
    // //p[text()='Hello World']
    // //button[contains(text(),'Login')]


    // in Xpath we can move up and down the DOM
    // //input[@id='username']/parent::div
    // cssSelector can only move downward (parent -> child)

    // cssSelector is usually faster, xpath can be slower due to text search like things
    // ------------------------------------------------------------------------------------

    // ------------------------------------------------------------------------------------
    // Absolute vs Relative XPath
    // Absolute: Starts from the root node (/html) and goes step-by-step to the element.
    // /html/body/div[1]/form/input[1]

    // Relative: begins with //
    // //tagname[@attribute='value']
    // ------------------------------------------------------------------------------------

    // ------------------------------------------------------------------------------------
    // Asserts
    // Assert.assertEquals(one, two);
    // ------------------------------------------------------------------------------------
}
