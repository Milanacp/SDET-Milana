package TestScripts;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Generic.Base;
import POM.CampaignPage;
import POM.HomePage;

public class SearchByCampaignStatus extends Base {
	
	@Test
	public void searchByCampaignStatus() throws IOException {

		HomePage hp = new HomePage(driver);
		WebElement more = hp.getMorelink();
		wdu.movetoelement(driver, more);
		
		hp.getCampaignlink().click();
		
		String campaignStatus= eu.readDatafromExcel("Sheet1", 0, 0);
		String status= eu.readDatafromExcel("Sheet1", 0, 1);
		CampaignPage cp = new CampaignPage(driver);
		
		cp.getSearchbox().sendKeys(status);
		
		wdu.selectdropdown(cp.getInDD(), campaignStatus);
		
		cp.getSearhBtn().click();
		
		    
	}

}
