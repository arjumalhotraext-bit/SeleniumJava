package demoqa.utlities;

import demoqa.base.BasePage;
import org.openqa.selenium.WebDriver;

public class Utility {
    public static WebDriver driver;


    public static void setUtilityDriver() {
        driver = demoqa.base.BasePage.driver;
    }
}
