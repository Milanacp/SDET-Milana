package Generic;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import POM.HomePage;
import POM.LoginPage;

public class Base {
	public WebDriver	driver;
	public	JavaUtility jv = new JavaUtility();
	public FileUtility fu=  new FileUtility();
	public ExcelUtility eu= new ExcelUtility();
	public WebDriverUtility wdu= new WebDriverUtility();


/**
 * Create DB Connection
 * And  Extent Report
 */
	@BeforeSuite
	public void beforesuite() 
	{
		System.out.println("==DB connection==");
		System.out.println("==Extent report==");
	}

	@AfterSuite
	public void afterSuite() 
	{
		System.out.println("==Close DB connection==");
		System.out.println("== Close Extent report==");
	}

	/**
	 * Launch Browser and get the URL
	 * @throws IOException
	 */
	@BeforeClass
	public void launchBrowser() throws IOException {

		String BROWSER=fu.readDataFromPropFile(IConstants.propfilepath, "browser");
		

		if(BROWSER.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
			driver= new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.firefox.driver", "./driver/geckodriver.exe");
			driver= new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase("ie")) {
			driver= new InternetExplorerDriver();
		}
		wdu.maximizewindow(driver);
		wdu.implicitwait(driver);
		driver.get(fu.readDataFromPropFile(IConstants.propfilepath, "url"));
	}

	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
	
	
	@BeforeMethod
	public void logintoapp() throws IOException {
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(fu.readDataFromPropFile(IConstants.propfilepath, "username"), fu.readDataFromPropFile(IConstants.propfilepath, "password"));

	} 
	  
	
	@AfterMethod
	public void logoutfromApp() {
		HomePage hp = new HomePage(driver);
		hp.logout();
	}
	
	

}
