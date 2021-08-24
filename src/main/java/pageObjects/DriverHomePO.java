package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.GeneralUtils;

public class DriverHomePO {
	private WebDriverWait wait;
	
	public DriverHomePO(WebDriver driver) {
		wait = new WebDriverWait(driver, 15);
	}
	
	
	public WebElement getAddNewDriverBtn() {
		WebElement temp = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='ADD NEW DRIVER']")));
		GeneralUtils.scrollToElement(temp);
		return temp;
	}

}
