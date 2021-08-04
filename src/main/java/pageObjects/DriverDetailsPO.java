package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverDetailsPO {

	private WebDriverWait wait;
	private WebDriver driver;
	
	public DriverDetailsPO(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 15);
	}
	
	public WebElement getDriverIdLabel() {
		return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='DRIVER ID']")));
	}
}
