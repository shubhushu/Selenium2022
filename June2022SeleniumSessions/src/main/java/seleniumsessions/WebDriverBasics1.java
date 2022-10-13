package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverBasics1 {

	public static void main(String[] args) {
		
        //Open Chrome Browser
		//launch :URL google.com
		//get the title of page
		//verify the title:act vs exp
		//close the browser
		
		// concept of interface and classes we have to use
		// Webdriver is interface- and we have methods in webdriver interface get()url()gettitle()close()switch()
		//SearchContext is a parent of webdriver interface (top and last interface) FindElement() and FindElements()
		
		//CLASS Is RemoteWebDriver() is a class in which we will write business logic method etc
		//class->interface use implement keyword
		//class->class use extends keyword

		//WebDriver driver =new ChromeDriver();//-->chromedriver is class RHS is object/grand child class
		
		System.setProperty("WebDriver.chrome.driver","C:\\Selenium driverexefiles\\chromedriver.exe");
		//System.setProperty("WebDriver.Firefox.driver","C:\\Selenium driverexefiles\\geckodriver.exe");
		WebDriver driver = new ChromeDriver();//launch chrome browser
		driver.get("https://www.google.com");//enter the URL
		
		String title=driver.getTitle(); // Get the title , driver.getTitle on mouse over you can see returing String so we are storing in String title  
		System.out.println("Page Title :" + title);// to print page title and title means Tab name
	
		//Verification point : act vs exp result// checkpoint
		if (title.equals("google")) {
			System.out.println("Pass");
		} else
		{
			System.out.println("Fail");
		}
		 String url =  driver.getCurrentUrl();
		 
		 System.out.println(url);
		 
		 String source = driver.getPageSource();
		 
		 System.out.println(source);
		 
		 if (source.contains("copyright the closeure libary authors"))
		 {
			 System.out.println("Pass");
		 }
		 
			//close the browser:
		 driver.quit();
		 //driver.close();
		
	}

}
