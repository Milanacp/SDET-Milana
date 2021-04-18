package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPage {

	WebDriver driver;
	
	public CampaignPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@class='txtBox']")
	private WebElement searchBox;

	public WebElement getSearchbox() {
		return searchBox;
	}
	
	@FindBy(xpath="//div[@id='basicsearchcolumns_real']/select[@class='txtBox']")
	private WebElement inDD;

	public WebElement getInDD() {
		return inDD;
	}
	
	@FindBy(xpath="//input[@name='submit']")
	private WebElement searchBtn;

	public WebElement getSearhBtn() {
		return searchBtn;
		
	}  
	
}
