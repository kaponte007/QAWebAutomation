package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverAppLogInPO {
	private WebDriverWait wait;
	private WebDriver driver;
	
	public DriverAppLogInPO(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
	}
	
	public WebElement getUsernameTxtBox() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.name("username")));
	}
	
	public WebElement getPasswordTxtBox() {
		return driver.findElement(By.name("password"));
	}
	
	public WebElement getLogInBtn() {
		return driver.findElement(By.xpath("//button[text()='LOG IN']"));
	}
	
	
}
