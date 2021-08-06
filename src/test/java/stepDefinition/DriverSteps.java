package stepDefinition;

import java.io.IOException;

import base.DriverBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import utils.BrowserConfig;

public class DriverSteps {

	@Then("I open the driver web page")
	public void open_driver_page() throws Exception {
		DriverBase base = new DriverBase(BrowserConfig.getDriver());
		base.openDriverPage();
	}

	@And("I log in")
	public void log_in() throws Exception {
		DriverBase base = new DriverBase(BrowserConfig.getDriver());
		base.logIn();
	}

	@Then("I click add new driver")
	public void add_new_driver() {
		DriverBase base = new DriverBase(BrowserConfig.getDriver());
		base.clickAddNewDriver();
	}
	
	@And("populate new driver info")
	public void populate_driver_info() throws IOException {
		DriverBase base = new DriverBase(BrowserConfig.getDriver());
		base.populateDriverInfo();
	}
	
	@Then("I validate the driver created")
	public void validate_driver() {
		DriverBase base = new DriverBase(BrowserConfig.getDriver());
		base.validateDriverCreated();
	}

}
