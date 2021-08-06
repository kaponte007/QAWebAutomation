package base;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import pageObjects.VehicleBasidcInfoPO;
import pageObjects.VehicleDetailsPO;
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
		obj.getLicenseTxtBox().sendKeys("2342366");
		obj.getMakeDropdown().sendKeys("Dodge");
		obj.getModelDropdown().sendKeys("Caravan");
		obj.getCabNumberTxtBox().sendKeys("1234");
		obj.getSaveCloseBtn().click();
	}

	public void validateVehicule() {
		VehicleHomePO obj = new VehicleHomePO(driver);
		VehicleDetailsPO obj2 = new VehicleDetailsPO(driver);
		Assert.assertNotNull(obj.getVehiclesTitle());
		obj.getSearchTxtBox().sendKeys("2342366");
		Assert.assertNotNull(obj2.getPlateLabel());
	}

}
