package stepDefinition;

import java.io.IOException;

import base.CallcenterBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
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

	@Then("I click make a copy from first row")
	public void make_copy() {
		CallcenterBase base = new CallcenterBase(BrowserConfig.getDriver());
		base.makeCopy();
	}

	@Given("I go to call center home page")
	public void go_callcenter_home() throws IOException {
		CallcenterBase base = new CallcenterBase(BrowserConfig.getDriver());
		base.goHome();
	}

	@Then("I click on the first row")
	public void click_first_row() {
		CallcenterBase base = new CallcenterBase(BrowserConfig.getDriver());
		base.clickFirstRow();
	}

	@And("I assign a driver")
	public void assign_driver() {
		CallcenterBase base = new CallcenterBase(BrowserConfig.getDriver());
		base.assignDriver();
	}
	
	@Then("I click SAVE CHANGES btn")
	public void click_save_changes() {
		CallcenterBase base = new CallcenterBase(BrowserConfig.getDriver());
		base.clickSaveChanges();
	}

}
