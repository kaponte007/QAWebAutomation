package stepDefinition;

import base.CallcenterBase;
import io.cucumber.java.en.Then;
import utils.BrowserConfig;

public class CallcenterSteps {

	@Then("I open the call center web page")
	public void open_vehicle_page() throws Exception {
		CallcenterBase base = new CallcenterBase(BrowserConfig.getDriver());
		base.openCallcenterPage();
	}



}
