package base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import pageObjects.DriverAppHomePO;
import pageObjects.DriverAppLogInPO;
import pageObjects.DriverAppSignUpPO;
import pageObjects.LogInPO;
import pojo.DriverPojo;
import utils.ExcelUtils;

public class DriverAppBase {
	private WebDriver driver;

	public DriverAppBase(WebDriver driver) {
		this.driver = driver;
	}

	public void openDriverApp() throws Exception {
		ExcelUtils.loadTestingData("credentials.xlsx", "URL");
		final String url = ExcelUtils.getPropertyFromTestDataFile("url.driverapp.qa");
		driver.get(url);
	}

	public void signUp() throws Exception {
		final String email = DriverPojo.getEmail();
		ExcelUtils.loadTestingData("credentials.xlsx", "URL");
		final String url = ExcelUtils.getPropertyFromTestDataFile("url.driverapp.qa") + "/signup?email=" + email;
		Assert.assertNotNull(email, "There is no email in POJO class");
		System.out.println(url);
		driver.get(url);

		DriverAppSignUpPO obj = new DriverAppSignUpPO(driver);
		obj.getPasswordTxtbox().sendKeys("ChangeMe@.");
		obj.getSignUpBtn().click();
	}

	public void validateVehicleInList(String plate) {
		DriverAppHomePO obj = new DriverAppHomePO(driver);
		Assert.assertNotNull(obj.getPlateLabel(plate));
		System.out.println("Vehicle with plate "+plate+ " is listed");
	}

	public void validateDriverName() {
		DriverAppHomePO obj = new DriverAppHomePO(driver);
		String name = DriverPojo.getName()+" "+DriverPojo.getLastName();
		Assert.assertNotNull(obj.getNameLabel(name), "Unable to validate driver's name");
		System.out.println(name+" // Name validated!");
	}

	public void openDriverAppPage() throws IOException {
		ExcelUtils.loadTestingData("credentials.xlsx", "URL");
		final String url = ExcelUtils.getPropertyFromTestDataFile("url.driverapp.qa");
		driver.get(url);	
	}

	public void logIn() throws IOException {
		ExcelUtils.loadTestingData("testingDataExcel.xlsx", "Data2");
		final String username = ExcelUtils.getPropertyFromTestDataFile("email");
		final String password = ExcelUtils.getPropertyFromTestDataFile("password");
		DriverAppLogInPO obj = new DriverAppLogInPO(driver);
		
		obj.getUsernameTxtBox().clear();
		obj.getUsernameTxtBox().sendKeys(username);
		obj.getPasswordTxtBox().clear();
		obj.getPasswordTxtBox().sendKeys(password);
		obj.getLogInBtn().click();		
	}

	public void validateLogIn() {
		DriverAppHomePO obj = new DriverAppHomePO(driver);
		Assert.assertNotNull(obj.getSelectVehicleLabel(), "Unable to validate log in process");
		System.out.println(" Log in process validated!");	
	}

	public void selectAnAvailableVehicle() {
		DriverAppHomePO obj = new DriverAppHomePO(driver);
		int vehicles = obj.getAvailableVehicles().size();
		System.out.println("Vehicles available: "+vehicles);
		Assert.assertTrue(vehicles>0, "No vehicles available");
		obj.getAvailableVehicles().get(0).click();
		System.out.print("asas");
	}

}
