package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverAppHomePO {
	private WebDriverWait wait;
	private WebDriver driver;
	
	public DriverAppHomePO(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 15);
	}
	
	
	public WebElement getPlateLabel(String plate) {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/p[text()='"+plate+"']")));
	}
	
	public WebElement getNameLabel(String name) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='"+name+"']")));
	}
	
	public WebElement getHourRadioBtn() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='hour']/..")));
	}
	
	public WebElement getStartBtn() {
		return driver.findElement(By.xpath("//button[text()='START']"));
	}
	
	public List<WebElement> getAvailableVehicles() {
		return driver.findElements(By.xpath("//div[@class='wrap-vehicle']/following-sibling::div[not(@class='empty_content')]"));
	}
	
	public WebElement getSelectVehicleLabel() {
		return getNameLabel("SELECT YOUR VEHICLE");
	}
	
	public WebElement getShiftHourTxtbox() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'item-qty')]/div/input")));
		
	}

}
