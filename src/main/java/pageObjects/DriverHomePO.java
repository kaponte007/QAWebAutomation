package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverHomePO {
	private WebDriverWait wait;
	private WebDriver driver;
	
	public DriverHomePO(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 15);
	}
	
	
	public WebElement getAddNewDriverBtn() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='ADD NEW DRIVER']")));
	}

}
