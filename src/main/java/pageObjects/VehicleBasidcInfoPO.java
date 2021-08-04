package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VehicleBasidcInfoPO {
	private WebDriverWait wait;
	private WebDriver driver;
	
	public VehicleBasidcInfoPO(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
	}
	
	public WebElement getLicenseTxtBox() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.name("license_plate_number")));
	}
	
	public WebElement getMakeDropdown() {
		return driver.findElement(By.name("make_id"));
	}
	
	public WebElement getModelDropdown() {
		return driver.findElement(By.name("model_id"));
	}
	
	public WebElement getSaveCloseBtn() {
		return driver.findElement(By.xpath("//button[text()='Save and Close']"));
	}
	

}
