package base;

import org.openqa.selenium.WebDriver;

import pageObjects.VehicleBasidcInfoPO;
import pageObjects.VehicleHomePO;
import utils.ExcelUtils;
import utils.GeneralUtils;

public class VehicleBase {
	private WebDriver driver;

	public VehicleBase(WebDriver driver) {
		this.driver = driver;
	}

	public void openVehiclePage() throws Exception {
		ExcelUtils.loadTestingData("credentials.xlsx", "URL");
		final String url = ExcelUtils.getPropertyFromTestDataFile("url.vehicle.qa");
		driver.get(url);
	}
	
	public void clickAddNewVehicle() {
		VehicleHomePO obj = new VehicleHomePO(driver);
		obj.getAddNewVehicleBtn().click();
	}
	
	public void populateVehicleInfo() {
		VehicleBasidcInfoPO obj = new VehicleBasidcInfoPO(driver);
		obj.getLicenseTxtBox().clear();
		obj.getLicenseTxtBox().sendKeys("AAA-123");
		obj.getMakeDropdown().sendKeys("Dodge");
		obj.getModelDropdown().sendKeys("Caravan");
		obj.getLicenseTxtBox().click();
		GeneralUtils.forceWait(1);
		obj.getSaveCloseBtn().click();
	}
	
}
