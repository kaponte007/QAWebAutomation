package base;

import org.openqa.selenium.WebDriver;

import pageObjects.DriverBasidcInfoPO;
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
		obj.getDriverFirstNameTxtBox().sendKeys("NOMBRE");
		obj.getDriverLastNameTxtBox().sendKeys("LAST");
		obj.getDriverEmailTxtBox().sendKeys("testingNow@mailinator.com");
		obj.getDriverPhoneTxtBox().sendKeys("9999999999");		
		obj.getContinueBtn().click();
		GeneralUtils.forceWait(2);
		obj2.getSaveBtn().click();
	}
}
