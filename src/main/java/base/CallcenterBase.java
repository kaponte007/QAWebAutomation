package base;

import org.openqa.selenium.WebDriver;

import pageObjects.CallcenterHomePO;
import utils.ExcelUtils;

public class CallcenterBase {
	private WebDriver driver;

	public CallcenterBase(WebDriver driver) {
		this.driver = driver;
	}

	public void openCallcenterPage() throws Exception {
		ExcelUtils.loadTestingData("credentials.xlsx", "URL");
		final String url = ExcelUtils.getPropertyFromTestDataFile("url.callcenter.qa");
		driver.get(url);
	}
	
	public void findRider() {
		final String rider = "Test"; //@TODO: get from Excel
		CallcenterHomePO obj = new CallcenterHomePO(driver);
		obj.getSearchTxtbox().sendKeys(rider);
		obj.getFindBtn().click();
	}
	
	
}
