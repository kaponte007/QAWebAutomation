package stepDefinition;


import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import utils.BrowserConfig;
import utils.ExcelUtils;


public class CommonSteps {
    private WebDriver driver;


    @Given("I open EDGE")
    public void open_edge() {
        driver = BrowserConfig.getEdgeDriver();
    }

    @Given("I open CHROME")
    public void open_chrome() {
        driver = BrowserConfig.getChromerDriver();
    }

    @Given("I upload testing data from {string} sheet {string}")
    public void upload_testing_data(String fileName, String sheetName) throws IOException {
        ExcelUtils.loadTestingData(fileName, sheetName);
    }

 

    @Before
    public void preSetup() throws Exception {
        ExcelUtils.isExcelFileOpened();
    }

    @After
    public void tearDown(Scenario scenario) {

        if(driver!=null){
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            // embed it in the report.
            scenario.attach(screenshot, "image/png", scenario.getName());

            BrowserConfig.closeDriver();
        }

    }
}
