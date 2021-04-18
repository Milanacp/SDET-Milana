package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic.WebDriverUtility;

public class HomePage {
	
	WebDriver driver;
	public WebDriverUtility wdu = new WebDriverUtility();

	@FindBy(xpath="//img[@src='themes/softed/images/menuDnArrow.gif']")
	private WebElement morelink;

	@FindBy(xpath="//a[@name='Campaigns']")
	private WebElement campaignlink;

	public WebElement getMorelink() {
		return morelink;
	}

	public WebElement getCampaignlink() {
		return campaignlink;
	}
	  
	@FindBy(xpath = "//img[contains(@src,'user.PNG')]")
	private WebElement administrationImg;

	@FindBy(linkText = "Sign Out")
	private WebElement signOutLink;

	
	public HomePage(WebDriver driver) 
	{
		this.driver = driver;	
		PageFactory.initElements(driver, this);
	}
	

	public void logout() {
		wdu.movetoelement(driver, administrationImg);
		signOutLink.click();
	}




}
