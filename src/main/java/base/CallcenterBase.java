package base;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import pageObjects.CallcenterBookRidePO;
import pageObjects.CallcenterHomePO;
import utils.ExcelUtils;
import utils.GeneralUtils;

public class CallcenterBase {
	private WebDriver driver;

	public CallcenterBase(WebDriver driver) {
		this.driver = driver;
	}

	public void openCallcenterPage() throws Exception {
		ExcelUtils.loadTestingData("credentials.xlsx", "URL");
		final String url = ExcelUtils.getPropertyFromTestDataFile("url.callcenter.qa");
		driver.get(url);
	}
	
	public void findRider() {
		final String rider = "Test"; //@TODO: get from Excel
		CallcenterHomePO obj = new CallcenterHomePO(driver);
		obj.getSearchTxtbox().sendKeys(rider);
		obj.getFindBtn().click();
	}

	public void clickBookRide() {
		CallcenterHomePO obj = new CallcenterHomePO(driver);
		obj.getBookARideBtn().click();
	}

	public void populateRideInfo() {
		CallcenterBookRidePO obj = new CallcenterBookRidePO(driver);
		obj.getAccountSearchBox().sendKeys("Test");
		obj.getFirstOptionListAccount().click();
		obj.getRiderFirstNameTxtBox().sendKeys("Nombre");
		obj.getRiderLastNameTxtBox().sendKeys("Last");
		obj.getRiderPhoneTxtBox().click();
		obj.getRiderPhoneTxtBox().sendKeys("8888888888");
		obj.getRiderEmailTxtBox().sendKeys("testing@test.com");
		
		obj.getPickUpLocationTxtBox().sendKeys("JFK Airport (JFK), Queens, NY, USA");
		GeneralUtils.forceWait(1);
		obj.getPickUpLocationTxtBox().sendKeys(Keys.DOWN);
		obj.getPickUpLocationTxtBox().sendKeys(Keys.ENTER);
		obj.getDropoffLocationTxtBox().sendKeys("Queens Hospital Center");
		GeneralUtils.forceWait(1);
		obj.getDropoffLocationTxtBox().sendKeys(Keys.DOWN);
		obj.getDropoffLocationTxtBox().sendKeys(Keys.ENTER);
		GeneralUtils.forceWait(1);
	}

	public void clickNextAvailableBtn() {
		CallcenterBookRidePO obj = new CallcenterBookRidePO(driver);
		obj.getTimingNextAvailableBtn().click();
		
		System.out.println("ESTIMATE FARE: "+obj.getEstimatedFareLabel().getText());
	}

	public void clickScheduleRideBtn() {
		CallcenterBookRidePO obj = new CallcenterBookRidePO(driver);
		obj.getScheduleRideBtn().click();	
	}

	public void makeCopy() {
		CallcenterHomePO obj = new CallcenterHomePO(driver);
		obj.getMakeCopyBtn().click();		
	}

	public void goHome() throws IOException {
		ExcelUtils.loadTestingData("credentials.xlsx", "URL");
		final String url = ExcelUtils.getPropertyFromTestDataFile("url.callcenter.qa")+"/rides/list";
		driver.get(url);
	}

	public void clickFirstRow() {
		CallcenterHomePO obj = new CallcenterHomePO(driver);
		obj.getFirstRideRow().click();
		System.out.println("");
	}
	
	
}
