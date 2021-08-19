package stepDefinition;

import base.DriverAppBase;
import base.DriverBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import utils.BrowserConfig;

public class DriverAppSteps {

	//      Then I sign up in the driver app
    //And I validate the vehicle is listed
    
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



}
