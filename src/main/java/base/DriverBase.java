package base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import pageObjects.DriverBasidcInfoPO;
import pageObjects.DriverDetailsPO;
import pageObjects.DriverHomePO;
import pageObjects.DriverReviewPO;
import pageObjects.LogInPO;
import pojo.DriverPojo;
import utils.ExcelUtils;
import utils.GeneralUtils;

public class DriverBase {
	private WebDriver driver;

	public DriverBase(WebDriver driver) {
		this.driver = driver;
	}

	public void openDriverPage() throws Exception {
		ExcelUtils.loadTestingData("credentials.xlsx", "URL");
		final String url = ExcelUtils.getPropertyFromTestDataFile("url.driver.qa");
		driver.get(url);
	}
	
	public void logIn() throws Exception {
		ExcelUtils.loadTestingData("credentials.xlsx", "CREDENTIALS");
		final String username = ExcelUtils.getPropertyFromTestDataFile("username");
		final String password = ExcelUtils.getPropertyFromTestDataFile("password");
		LogInPO obj = new LogInPO(driver);
		
		obj.getUsernameTxtBox().clear();
		obj.getUsernameTxtBox().sendKeys(username);
		obj.getPasswordTxtBox().clear();
		obj.getPasswordTxtBox().sendKeys(password);
		obj.getSignInBtn().click();
	}
	
	public void clickAddNewDriver() {
		DriverHomePO obj = new DriverHomePO(driver);
		obj.getAddNewDriverBtn().click();
	}
	
	public void populateDriverInfo() throws IOException {
		DriverBasidcInfoPO obj = new DriverBasidcInfoPO(driver);
		DriverReviewPO obj2 = new DriverReviewPO(driver);
		final String name = ExcelUtils.getPropertyFromTestDataFile("driver.name");
		final String lastName = ExcelUtils.getPropertyFromTestDataFile("driver.lastName");
		final String email = "automation_"+System.currentTimeMillis()+"@mailinator.com";
		final String phone = ExcelUtils.getPropertyFromTestDataFile("driver.phone");
		
		obj.getDriverFirstNameTxtBox().sendKeys(name);
		obj.getDriverLastNameTxtBox().sendKeys(lastName);
		obj.getDriverEmailTxtBox().sendKeys(email);
		obj.getDriverPhoneTxtBox().sendKeys(phone);
		GeneralUtils.forceWait(2);
		obj.getContinueBtn().click();
		obj2.getSaveBtn().click();
		System.out.println("Using email generated: "+email);
		
		//Saving the driver info in memory
		DriverPojo.setEmail(email);
		DriverPojo.setLastName(lastName);
		DriverPojo.setName(name);
	}
	
	public void validateDriverCreated() {
		DriverDetailsPO obj = new DriverDetailsPO(driver);
		Assert.assertNotNull(obj.getDriverIdLabel());
		//@TODO: Add more validations 
	}
}
