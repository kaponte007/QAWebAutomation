package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VehicleHomePO {
	private WebDriverWait wait;
	private WebDriver driver;

	public VehicleHomePO(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 15);
	}

	public WebElement getAddNewVehicleBtn() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Add New Vehicle']")));
	}

	private WebElement getElementInFirstRow(int index) {
		return wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("//tbody/tr[1]/td[" + index + "]"))));
	}

	public WebElement getPlateInFirstRow() {
		final int index = 1;
		return getElementInFirstRow(index);
	}

	public WebElement getMakeInFirstRow() {
		final int index = 4;
		return getElementInFirstRow(index);
	}

	public WebElement getModelInFirstRow() {
		final int index = 5;
		return getElementInFirstRow(index);
	}

	public WebElement getSearchTxtBox() {
		return driver.findElement(By.tagName("input"));
	}

	public WebElement getVehiclesTitle() {
		return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[text()='Vehicles']")));
	}

}
