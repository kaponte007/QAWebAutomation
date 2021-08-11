package stepDefinition;

import base.CallcenterBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import utils.BrowserConfig;

public class CallcenterSteps {

	@Then("I open the call center web page")
	public void open_vehicle_page() throws Exception {
		CallcenterBase base = new CallcenterBase(BrowserConfig.getDriver());
		base.openCallcenterPage();
	}
	
	@Then("I click the BOOK A RIDE btn")
	public void click_book_ride() {
		CallcenterBase base = new CallcenterBase(BrowserConfig.getDriver());
		base.clickBookRide();
	}
	
	@And("I populate the ride information")
	public void populate_ride_info() {
		CallcenterBase base = new CallcenterBase(BrowserConfig.getDriver());
		base.populateRideInfo();
	}
	
	@Then("I click SCHEDULE RIDE btn")
	public void click_schedule_ride() {
		CallcenterBase base = new CallcenterBase(BrowserConfig.getDriver());
		base.clickScheduleRideBtn();
	}
	
	@And("I click timing: NEXT AVAILABLE")
	public void click_next_available_btn() {
		CallcenterBase base = new CallcenterBase(BrowserConfig.getDriver());
		base.clickNextAvailableBtn();
	}
	



}
