package base;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import pageObjects.DriverBasidcInfoPO;
import pageObjects.DriverDetailsPO;
import pageObjects.DriverHomePO;
import pageObjects.DriverReviewPO;
import pageObjects.LogInPO;
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
	
	public void populateDriverInfo() {
		DriverBasidcInfoPO obj = new DriverBasidcInfoPO(driver);
		DriverReviewPO obj2 = new DriverReviewPO(driver);
		obj.getDriverFirstNameTxtBox().sendKeys("NOMBRE DOS");
		obj.getDriverLastNameTxtBox().sendKeys("LAST");
		obj.getDriverEmailTxtBox().sendKeys("testingNow3@mailinator.com");
		obj.getDriverPhoneTxtBox().sendKeys("9999999998");
		GeneralUtils.forceWait(2);
		obj.getContinueBtn().click();
		obj2.getSaveBtn().click();
		System.out.println("test");
	}
	
	public void validateDriverCreated() {
		DriverDetailsPO obj = new DriverDetailsPO(driver);
		Assert.assertNotNull(obj.getDriverIdLabel());
		//@TODO: Add more validations 
	}
}
