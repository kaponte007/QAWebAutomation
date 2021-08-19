package pageObjects;

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
		return driver.findElement(By.id("hour"));
	}
	
	public WebElement getStartBtn() {
		return driver.findElement(By.xpath("//button[text()='START']"));
	}
	
	

}
