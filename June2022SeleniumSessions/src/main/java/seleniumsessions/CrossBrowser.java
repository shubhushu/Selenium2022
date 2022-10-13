package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class CrossBrowser {

	static WebDriver driver;

	public static void main(String[] args) {

//		System.setProperty("webdriver.chrome.driver", "/Users/naveenautomationlabs/Downloads/chromedriver");
//		WebDriver driver = new ChromeDriver();// launch chrome browser

//		System.setProperty("webdriver.gecko.driver", "/Users/naveenautomationlabs/Downloads/geckodriver");
//		WebDriver driver = new FirefoxDriver();

		// WebDriver driver = new SafariDriver();

		// cross browser logic:

		String browser = "chrome";
		
		switch (browser.toLowerCase())// to LowerCase to handle input Chrome/chrome/CHROME or any case
		{
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium driverexefiles\\chromedriver.exe");
			driver = new ChromeDriver();
			break;

		case "firefox":
			System.setProperty("webdriver.gecko.driver", "C:\\Selenium driverexefiles\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;

		case "safari":
			driver = new SafariDriver();
			break;
			
		default:
			System.out.println("plz pass ghe right browser.....");
			break;
		}
		
		

		driver.get("https://www.google.com");
		String title = driver.getTitle();// get the title
		System.out.println("page title : " + title);

		String url = driver.getCurrentUrl();
		System.out.println(url);

		// close the browser:
		driver.quit();

	}

}