package base;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Locale;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import pageObjects.CallcenterBookRidePO;
import pageObjects.CallcenterHomePO;
import entities.DriverEntity;
import entities.RideEntity;
import utils.ExcelUtils;
import utils.GeneralUtils;

public class CallcenterBase {
	private WebDriver driver;
	private static RideEntity ride;

	public CallcenterBase(WebDriver driver) {
		this.driver = driver;
	}

	public void openCallcenterPage() throws Exception {
		ExcelUtils.loadTestingData("credentials.xlsx", "URL");
		final String url = ExcelUtils.getPropertyFromTestDataFile("url.uat.rides");
		driver.get(url);
	}

	public void findRider() {
		final String rider = "Test"; // @TODO: get from Excel
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

	public void populateRideInfoFromExcel() throws IOException {

		ride = getRideEntityFromExcel();
		CallcenterBookRidePO obj = new CallcenterBookRidePO(driver);
		// obj.getAccountSearchBox().sendKeys("Test");
		// obj.getFirstOptionListAccount().click();
		obj.getRiderFirstNameTxtBox().sendKeys(ride.riderFirstName);
		obj.getRiderLastNameTxtBox().sendKeys(ride.riderLastName);
		obj.getRiderPhoneTxtBox().click();
		obj.getRiderPhoneTxtBox().sendKeys(ride.riderPhone);
		obj.getRiderEmailTxtBox().sendKeys(ride.riderEmail);
	}

	private RideEntity getRideEntityFromExcel() throws IOException {
		RideEntity ride = new RideEntity();
		ride.serviceName = ExcelUtils.getPropertyFromTestDataFile("ServiceName");
		ride.dropOffLocation = ExcelUtils.getPropertyFromTestDataFile("DropOffLocation");
		ride.pickupLocation = ExcelUtils.getPropertyFromTestDataFile("PickupLocation");
		ride.fare = ExcelUtils.getPropertyFromTestDataFile("BaseFare");
		ride.timing = ExcelUtils.getPropertyFromTestDataFile("Timing");
		ride.riderFirstName = ExcelUtils.getPropertyFromTestDataFile("RiderFirstName");
		ride.riderLastName = ExcelUtils.getPropertyFromTestDataFile("RiderLastName");
		ride.riderPhone = ExcelUtils.getPropertyFromTestDataFile("RiderPhone");
		ride.riderEmail = ExcelUtils.getPropertyFromTestDataFile("RiderEmail");
		ride.mileageIncluded = ExcelUtils.getPropertyFromTestDataFile("MileageIncluded");
		ride.mileageExtraRate = ExcelUtils.getPropertyFromTestDataFile("MileageExtraRate");
		ride.distance = ExcelUtils.getPropertyFromTestDataFile("Distance");
		return ride;
	}

	public void clickNextAvailableBtn() {
		CallcenterBookRidePO obj = new CallcenterBookRidePO(driver);
		obj.getTimingNextAvailableBtn().click();
		GeneralUtils.forceWait(1);
	}

	public void clickScheduledBtn() {
		CallcenterBookRidePO obj = new CallcenterBookRidePO(driver);
		obj.getTimingScheduledBtn().click();
		GeneralUtils.forceWait(1);
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
		final String url = ExcelUtils.getPropertyFromTestDataFile("url.callcenter.qa") + "/rides/list";
		driver.get(url);
	}

	public void clickFirstRow() {
		CallcenterHomePO obj = new CallcenterHomePO(driver);
		obj.getFirstRideRow().click();
		System.out.println("Clicking first row");
	}

	public void assignDriver() {
		CallcenterBookRidePO obj = new CallcenterBookRidePO(driver);
		String name = DriverEntity.getName() + " " + DriverEntity.getLastName();
		obj.getAssignDriverTxtbox().sendKeys(name);
		obj.getAssignDriverTxtbox().sendKeys(Keys.DOWN);
		obj.getAssignDriverTxtbox().sendKeys(Keys.ENTER);
		System.out.println("Assigning to: " + name);
	}

	public void clickSaveChanges() {
		CallcenterBookRidePO obj = new CallcenterBookRidePO(driver);
		obj.getSaveChangesBtn().click();
		System.out.println("Clicking save changes...");
	}

	public void selectStartDate() {
		CallcenterBookRidePO obj = new CallcenterBookRidePO(driver);
		obj.getStartDatePicker().click();
		obj.getNextMonthPicker().click();
		obj.getTimePicker("6:00 PM").click();
		System.out.println("Selecting a scheduled ride for the next month");
	}

	public void populateTripInfoFromExcel() {
		CallcenterBookRidePO obj = new CallcenterBookRidePO(driver);
		obj.getPickUpLocationTxtBox().sendKeys(ride.pickupLocation);
		GeneralUtils.forceWait(2);
		obj.getPickUpLocationTxtBox().sendKeys(Keys.DOWN);
		obj.getPickUpLocationTxtBox().sendKeys(Keys.ENTER);
		obj.getDropoffLocationTxtBox().sendKeys(ride.dropOffLocation);
		GeneralUtils.forceWait(2);
		obj.getDropoffLocationTxtBox().sendKeys(Keys.DOWN);
		obj.getDropoffLocationTxtBox().sendKeys(Keys.ENTER);
		GeneralUtils.forceWait(1);
	}

	public void populateTimingInfoFromExcel() {
		if (ride.timing.equalsIgnoreCase("SCHEDULED")) {
			System.out.println("Selecting Scheduled ride");
			clickScheduledBtn();
			selectStartDate();
		} else {
			System.out.println("Selecting Next Available ride");
			clickNextAvailableBtn();
		}
	}

	public void selectServiceFromExcel() {
		CallcenterBookRidePO obj = new CallcenterBookRidePO(driver);
		String service = ride.serviceName.toLowerCase();

		switch (service) {
		case "ambulatory":
			obj.getServiceAmbulatory().click();
			System.out.println("Service: ambulatory");
			break;

		case "stretcher":
			obj.getServiceStretcher().click();
			System.out.println("Service: stretcher");
			break;

		case "hospital":
			obj.getServiceHospital().click();
			System.out.println("Service: hospital");
			break;

		case "holiday":
			obj.getServiceHoliday().click();
			System.out.println("Service: Sunday/holiday");
			break;

		default:
			obj.getServiceWheelchair().click();
			System.out.println("Service: wheelchair");
			break;
		}
		
		GeneralUtils.forceWait(2);
	}

	public void validateFareFromExcel() {
		CallcenterBookRidePO obj = new CallcenterBookRidePO(driver);
		String actual = obj.getEstimatedFareLabel().getText();
		double baseFare = Double.parseDouble(ride.fare);
		double extraMileageRate = Double.parseDouble(ride.mileageExtraRate);
		double distance = Double.parseDouble(ride.distance);
		double includedMileage = Double.parseDouble(ride.mileageIncluded);
		double extraMileage = distance - includedMileage;
		double expectedFare;
		String expectedFareStr;

		if (extraMileage<=0) {
			expectedFare = baseFare;
		} else {
			expectedFare = baseFare + extraMileage * extraMileageRate;
		}
		
		expectedFareStr = String.format(Locale.US, "%.2f",expectedFare);
		System.out.println("Expected Rate is " + expectedFareStr);
		System.out.println("Actual Rate is " + actual);
		Assert.assertTrue(actual.contains(expectedFareStr.substring(0, expectedFareStr.length()-1)), "Mismatch in in rate"); //Removing last decimal digit (pending to check difference)
	}

}
