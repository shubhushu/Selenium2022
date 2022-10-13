package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ElementUtilv6 {

	private WebDriver driver;
	private Select select;

	public ElementUtilv6 (WebDriver driver) {
		this.driver = driver;
	}

	public void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}

	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public void doClick(By locator) {
		getElement(locator).click();
	}

	public String doGetText(By locator) {
		return getElement(locator).getText();
	}

	public String doGetAttribute(By locator, String attrName) {
		return getElement(locator).getAttribute(attrName);
	}

	public boolean doEleIsDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}

	public int getElementsCount(By locator) {
		return getElements(locator).size();
	}

	public ArrayList<String> getElementsTextList(By locator) {
		List<WebElement> eleList = getElements(locator);
		ArrayList<String> eleTextList = new ArrayList<String>();

		for (WebElement e : eleList) {
			String text = e.getText();
			if (text.length() != 0) {
				eleTextList.add(text);
			}
		}
		return eleTextList;
	}

	// ******************Drop Down utils*****************//
	// only when html tag = <select>
	public void doSelectDropDownByIndex(By locator, int index) {
		select = new Select(getElement(locator));
		select.selectByIndex(index);
	}

	public void doSelectDropDownByVisibleText(By locator, String text) {
		select = new Select(getElement(locator));
		select.selectByVisibleText(text);
	}

	public void doSelectDropDownByValue(By locator, String value) {
		select = new Select(getElement(locator));
		select.selectByValue(value);
	}

	public List<WebElement> getDropDownOptions(By locator) {
		select = new Select(getElement(locator));
		return select.getOptions();
	}

	public int getDropDownOptionsCount(By locator) {
		return getDropDownOptions(locator).size();
	}

	public void doSelectValueFromDropDown(By locator, String value) {
		List<WebElement> optionsList = getElements(locator);

		System.out.println(optionsList.size());

		for (WebElement e : optionsList) {
			String text = e.getText();
			System.out.println(text);
			if (text.equals(value)) {
				e.click();
				break;
			}

		}
	}

	public void search(By searchLocator, String searchKey, By suggLocator, String value) throws InterruptedException {
		getElement(searchLocator).sendKeys(searchKey);
		Thread.sleep(3000);

		List<WebElement> suggList = getElements(suggLocator);

		System.out.println(suggList.size() - 1);

		for (WebElement e : suggList) {
			String text = e.getText();
			System.out.println(text);
			if (text.equals(value)) {
				e.click();
				break;
			}
		}
	}

}