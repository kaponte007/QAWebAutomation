package base;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import pageObjects.DriverAppHomePO;
import pageObjects.DriverAppSignUpPO;
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

}
