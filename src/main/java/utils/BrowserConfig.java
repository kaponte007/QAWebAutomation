package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class BrowserConfig {
	private static WebDriver driver;
	private static final String path = "./src/main/resources/drivers/";

	public static WebDriver getChromerDriver() {

		if (System.getProperty("os.name").contains("Windows")) {
			System.setProperty("webdriver.chrome.driver", path + "Windows/chromedriver.exe");
		} else {
			System.setProperty("webdriver.chrome.driver", path + "Mac/chromedriver");
		}

		System.out.println("Opening Google CHROME...");
		ChromeOptions opt = new ChromeOptions();
		opt.setAcceptInsecureCerts(true);
		driver = new ChromeDriver(opt);
		return driver;
	}

	public static WebDriver getEdgeDriver() {
		
		if (System.getProperty("os.name").contains("Windows")) {
			System.setProperty("webdriver.edge.driver", path + "Windows/msedgedriver.exe");
		} else {
			System.setProperty("webdriver.edge.driver", path + "Mac/msedgedriver");
		}
		
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
