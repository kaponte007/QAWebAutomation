package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverReviewPO {
	private WebDriverWait wait;
	private WebDriver driver;
	
	public DriverReviewPO(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 15);
	}
	
	
	public WebElement getSaveBtn() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='SAVE AND CLOSE']")));
	}

}
