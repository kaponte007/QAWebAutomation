package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CallcenterHomePO {
	private WebDriverWait wait;
	private WebDriver driver;
	
	public CallcenterHomePO(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 15);
	}
	
	public WebElement getSearchTxtbox() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Look up a rider']")));
	}
	
	public WebElement getFindBtn() {
		return driver.findElement(By.xpath("//button[text()='FIND']"));
	}

}
