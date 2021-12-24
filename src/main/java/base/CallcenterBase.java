package base;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import pageObjects.CallcenterBookRidePO;
import pageObjects.CallcenterHomePO;
import entities.DriverEntity;
import entities.RideEntity;
import utils.ExcelUtils;
import utils.GeneralUtils;

public class CallcenterBase {
	private WebDriver driver;

	public CallcenterBase(WebDriver driver) {
		this.driver = driver;
	}

	public void openCallcenterPage() throws Exception {
		ExcelUtils.loadTestingData("credentials.xlsx", "URL");
		final String url = ExcelUtils.getPropertyFromTestDataFile("url.uat.rides");
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
		GeneralUtils.forceWait(2);
		obj.getPickUpLocationTxtBox().sendKeys(Keys.DOWN);
		obj.getPickUpLocationTxtBox().sendKeys(Keys.ENTER);
		obj.getDropoffLocationTxtBox().sendKeys("Queens Hospital Center");
		GeneralUtils.forceWait(2);
		obj.getDropoffLocationTxtBox().sendKeys(Keys.DOWN);
		obj.getDropoffLocationTxtBox().sendKeys(Keys.ENTER);
		GeneralUtils.forceWait(1);
	}
	
	public void populateRideInfoFromExcel(String fileName, String sheetName) throws IOException {
		
		RideEntity data = getRideEntityFromExcel(fileName, sheetName);
		CallcenterBookRidePO obj = new CallcenterBookRidePO(driver);
		obj.getAccountSearchBox().sendKeys("Test");
		obj.getFirstOptionListAccount().click();
		obj.getRiderFirstNameTxtBox().sendKeys("Nombre");
		obj.getRiderLastNameTxtBox().sendKeys("Last");
//		obj.getRiderPhoneTxtBox().click();
//		obj.getRiderPhoneTxtBox().sendKeys("8888888888");
//		obj.getRiderEmailTxtBox().sendKeys("testing@test.com");
//		
		obj.getPickUpLocationTxtBox().sendKeys(data.pickupLocation);
		GeneralUtils.forceWait(2);
		obj.getPickUpLocationTxtBox().sendKeys(Keys.DOWN);
		obj.getPickUpLocationTxtBox().sendKeys(Keys.ENTER);
		obj.getDropoffLocationTxtBox().sendKeys(data.dropOffLocation);
		GeneralUtils.forceWait(2);
		obj.getDropoffLocationTxtBox().sendKeys(Keys.DOWN);
		obj.getDropoffLocationTxtBox().sendKeys(Keys.ENTER);
		GeneralUtils.forceWait(1);
	}

	private RideEntity getRideEntityFromExcel(String fileName, String sheetName) throws IOException {
		ExcelUtils.loadTestingData(fileName, sheetName);
		RideEntity ride = new RideEntity();
		ride.serviceName = ExcelUtils.getPropertyFromTestDataFile("ServiceName");
		ride.dropOffLocation = ExcelUtils.getPropertyFromTestDataFile("DropOffLocation");
		ride.pickupLocation = ExcelUtils.getPropertyFromTestDataFile("PickupLocation");
		ride.fare = ExcelUtils.getPropertyFromTestDataFile("Fare");
		ride.timing = ExcelUtils.getPropertyFromTestDataFile("Timing");
		return ride;
	}

	public void clickNextAvailableBtn() {
		CallcenterBookRidePO obj = new CallcenterBookRidePO(driver);
		obj.getTimingNextAvailableBtn().click();
		GeneralUtils.forceWait(1);
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
		System.out.println("Clicking first row");
	}

	public void assignDriver() {
		CallcenterBookRidePO obj = new CallcenterBookRidePO(driver);
		String name = DriverEntity.getName()+" "+DriverEntity.getLastName();
		obj.getAssignDriverTxtbox().sendKeys(name);
		obj.getAssignDriverTxtbox().sendKeys(Keys.DOWN);
		obj.getAssignDriverTxtbox().sendKeys(Keys.ENTER);
		System.out.println("Assigning to: "+name);
	}

	public void clickSaveChanges() {
		CallcenterBookRidePO obj = new CallcenterBookRidePO(driver);
		obj.getSaveChangesBtn().click();
		System.out.println("Clicking save changes...");		
	}
	
	

	
	
}
