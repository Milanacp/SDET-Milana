package TestScripts;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Generic.Base;
import POM.CampaignPage;
import POM.HomePage;

public class SearchByCampaignType extends Base {
	
	@Test
	public void searchByCampaignType() throws IOException {

		HomePage hp = new HomePage(driver);
		WebElement more = hp.getMorelink();
		wdu.movetoelement(driver, more);
		
		hp.getCampaignlink().click();
		
		String campaignType= eu.readDatafromExcel("Sheet1", 1, 0);
		String type= eu.readDatafromExcel("Sheet1", 1, 1);
		CampaignPage cp = new CampaignPage(driver);
		
		cp.getSearchbox().sendKeys(type);
		
		wdu.selectdropdown(cp.getInDD(), campaignType);
		
		cp.getSearhBtn().click();
		
		 
	}

}
