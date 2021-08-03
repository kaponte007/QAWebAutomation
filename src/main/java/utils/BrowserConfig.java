package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class BrowserConfig {
    private static WebDriver driver;

    public static WebDriver getChromerDriver() {

        System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver.exe");
        System.out.println("Opening Google CHROME...");
		ChromeOptions opt = new ChromeOptions();
		opt.setAcceptInsecureCerts(true);
		driver = new ChromeDriver(opt);
        return driver;
    }

    public static WebDriver getEdgeDriver() {
        System.setProperty("webdriver.edge.driver", "./src/main/resources/drivers/msedgedriver.exe");
        System.out.println("Opening Microsoft EDGE...");
        EdgeOptions opt = new EdgeOptions();
        opt.setCapability("acceptSslCerts", true);
        driver = new EdgeDriver(opt);
        return driver;
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = getEdgeDriver();
            System.out.println("Driver is NULL. Using EDGE as default option");
        }
        return driver;
    }

    public static void closeDriver() {
        System.out.println("Closing driver...");
        driver.quit();
    }

}
