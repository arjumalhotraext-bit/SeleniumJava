package basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class S11SSL {
    public static void main(String[] args) {
        // DesiredCapabilities ch = DesiredCapabilities.chrome();

        // Accept insecure and SSL certificates
        // ch.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        // ch.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

        // Belongs to your local browser
        ChromeOptions c = new ChromeOptions();
        // c.merge(ch);

        // Set path to ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\path\\to\\chromedriver.exe");

        // Launch Chrome with capabilities
        WebDriver driver = new ChromeDriver(c);
    }
}
