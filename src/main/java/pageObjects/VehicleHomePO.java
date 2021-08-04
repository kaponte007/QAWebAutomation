package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VehicleHomePO {
	private WebDriverWait wait;
	private WebDriver driver;
	
	public VehicleHomePO(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 15);
	}
	
	public WebElement getAddNewVehicleBtn() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Add New Vehicle']")));
	}

}
