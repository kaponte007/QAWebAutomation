package stepDefinition;

import base.VehicleBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import utils.BrowserConfig;

public class VehicleSteps {

	@Then("I open the vehicle web page")
	public void open_vehicle_page() throws Exception {
		VehicleBase base = new VehicleBase(BrowserConfig.getDriver());
		base.openVehiclePage();
	}

	@Then("I click add new vehicle")
	public void add_new_driver() {
		VehicleBase base = new VehicleBase(BrowserConfig.getDriver());
		base.clickAddNewVehicle();
	}
	
	@And("populate new vehicle info")
	public void populate_driver_info() {
		VehicleBase base = new VehicleBase(BrowserConfig.getDriver());
		base.populateVehicleInfo();
	}
	
	@Then("I validate the vehicule created")
	public void validate_vehicule() {
		VehicleBase base = new VehicleBase(BrowserConfig.getDriver());
		base.validateVehicule();
	}

}
