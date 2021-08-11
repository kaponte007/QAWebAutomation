package runners;




import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import utils.ExtentReportConfig;


@CucumberOptions(plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
							features= "src/test/java/features",
							glue="stepDefinition",
							tags = "@Callcenter")
public class CallcenterRunner extends AbstractTestNGCucumberTests {
	static { ExtentReportConfig.setReportName("Call_Center");}
}
