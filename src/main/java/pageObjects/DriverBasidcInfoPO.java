package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.GeneralUtils;

public class DriverBasidcInfoPO {
	private WebDriverWait wait;
	private WebDriver driver;
	
	public DriverBasidcInfoPO(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
	}
	
	public WebElement getDriverFirstNameTxtBox() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.name("firstName")));
	}
	
	public WebElement getDriverLastNameTxtBox() {
		return driver.findElement(By.name("lastName"));
	}
	
	public WebElement getDriverEmailTxtBox() {
		return driver.findElement(By.name("email"));
	}
	
	public WebElement getDriverPhoneTxtBox() {
		return driver.findElement(By.name("phone"));
	}
	
	public WebElement getContinueBtn() {
		WebElement temp = driver.findElement(By.xpath("//a[text()='CONTINUE']"));
		GeneralUtils.scrollToElement(temp);
		return temp;
	}

}
