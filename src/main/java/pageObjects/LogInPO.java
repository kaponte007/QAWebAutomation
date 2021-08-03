package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogInPO {
	private WebDriverWait wait;
	private WebDriver driver;
	
	public LogInPO(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
	}
	
	public WebElement getUsernameTxtBox() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.name("emailAddress")));
	}
	
	public WebElement getPasswordTxtBox() {
		return driver.findElement(By.name("password"));
	}
	
	public WebElement getSignInBtn() {
		return driver.findElement(By.xpath("//button[text()='Sign In']"));
	}
	
	
}
