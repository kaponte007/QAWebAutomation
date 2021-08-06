package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VehicleDetailsPO {

	private WebDriverWait wait;
	private WebDriver driver;
	
	public VehicleDetailsPO(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 15);
	}
	
	public WebElement getPlateLabel() {
		return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='License plate number']")));
	}
}
