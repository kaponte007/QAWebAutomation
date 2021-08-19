package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverAppSignUpPO {
	private WebDriverWait wait;
	private WebDriver driver;
	
	public DriverAppSignUpPO(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 15);
	}
	
	
	public WebElement getPasswordTxtbox() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signUpPassword")));
	}
	
	public WebElement getSignUpBtn() {
		return driver.findElement(By.tagName("button"));
	}

	
	

}
