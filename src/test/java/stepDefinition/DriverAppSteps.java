package stepDefinition;

import java.io.IOException;

import base.DriverAppBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utils.BrowserConfig;

public class DriverAppSteps {
    
	@Then("I sign up in the driver app")
	public void sign_up() throws Exception {
		DriverAppBase base = new DriverAppBase(BrowserConfig.getDriver());
		base.signUp();
	}
	
	@And("I validate the driver name")
	public void validate_driver_name() {
		DriverAppBase base = new DriverAppBase(BrowserConfig.getDriver());
		base.validateDriverName();
	}

	@Then("I open the driver app")
	public void open_driver_app() throws IOException {
		DriverAppBase base = new DriverAppBase(BrowserConfig.getDriver());
		base.openDriverAppPage();
	}
	
	@And("I log in driverapp")
	public void log_in_driverapp() throws IOException {
		DriverAppBase base = new DriverAppBase(BrowserConfig.getDriver());
		base.logIn();
	}

	@And("I validate the log in")
	public void validate_log_in() {
		DriverAppBase base = new DriverAppBase(BrowserConfig.getDriver());
		base.validateLogIn();
	}
	
	@Given("I select an available vehicle")
	public void select_available_vehicle() {
		DriverAppBase base = new DriverAppBase(BrowserConfig.getDriver());
		base.selectAnAvailableVehicle();
	}
	
	@Then("I select shift hours")
	public void select_shift_hours() {
		DriverAppBase base = new DriverAppBase(BrowserConfig.getDriver());
		base.selectShiftHours();
	}
	
	@And("I click start")
	public void click_start_btn() {
		DriverAppBase base = new DriverAppBase(BrowserConfig.getDriver());
		base.clickStartBtn();
	}
}
