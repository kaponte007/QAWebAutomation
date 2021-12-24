package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.GeneralUtils;

public class CallcenterBookRidePO {
	private WebDriverWait wait;
	private WebDriver driver;
	
	public CallcenterBookRidePO(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 15);
	}
	
	public WebElement getAccountSearchBox() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder= 'Account']")));
	}
	
	public WebElement getRiderFirstNameTxtBox() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.name("riderFirstName")));
	}
	
	public WebElement getRiderLastNameTxtBox() {
		return driver.findElement(By.name("riderLastName"));
	}
	
	public WebElement getRiderPhoneTxtBox() {
		return driver.findElement(By.name("riderPhone"));
	}
	
	public WebElement getRiderEmailTxtBox() {
		return driver.findElement(By.name("riderEmail"));
	}
	
	public WebElement getPickUpLocationTxtBox() {
		return driver.findElement(By.name("pickupLocation"));
	}
	
	public WebElement getDropoffLocationTxtBox() {
		return driver.findElement(By.name("dropoffLocation"));
	}
	
	public WebElement getTimingNextAvailableBtn() {
		return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Next Available']")));
	}
	
	public WebElement getTimingScheduledBtn() {
		return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Scheduled']")));
	}
	
	public WebElement getEstimatedFareLabel() {
		WebElement temp = driver.findElement(By.xpath("//strong[text()='Estimated Fare']/../following-sibling::div"));
		GeneralUtils.scrollToElement(temp);
		return temp;
	}
	
	public WebElement getScheduleRideBtn() {
		return driver.findElement(By.xpath("//button[text()='Schedule Ride']"));
	}
	
	public WebElement getFirstOptionListAccount() {
		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='inner-list']/a"))).get(0);
	}

	public WebElement getAssignDriverTxtbox() {
		return wait.until(ExpectedConditions.presenceOfElementLocated(By.name("driverInput")));
	}
	
	public WebElement getSaveChangesBtn() {
		return driver.findElement(By.xpath("//button[text()='Save Changes']"));
	}
	
	public WebElement getNextMonthPicker() {
		return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Next Month']")));
	}
	
	public WebElement getTimePicker(String time) {
		WebElement temp = driver.findElement(By.xpath("//li[contains(text(), '"+time+"')]"));
		GeneralUtils.scrollToElement(temp);
		return temp;
	}
	
	public WebElement getStartDatePicker() {
		return driver.findElement(By.xpath("//input[@name='start-date']"));
	}
	
	private WebElement getRideService(String str) {
		return driver.findElement(By.xpath("//*[text()='"+str+"']/.."));
	}
	
	public WebElement getServiceWheelchair() {
		return getRideService("WHEELCHAIR SHARED");
	}
	
	public WebElement getServiceAmbulatory() {
		return getRideService("AMBULATORY SHARED");
	}
	
	public WebElement getServiceStretcher() {
		return getRideService("STRETCHER SHARED");
	}
	
	public WebElement getServiceHospital() {
		return getRideService("HOSP DISCHARGE SHARED");
	}
	
	public WebElement getServiceHoliday() {
		return getRideService("SUNDAY/HOLIDAY SHARED");
	}

}
