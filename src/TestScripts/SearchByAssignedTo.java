package TestScripts;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Generic.Base;
import POM.CampaignPage;
import POM.HomePage;

public class SearchByAssignedTo extends Base {
	
	@Test
	public void searchByAssignedTo() throws IOException {

		HomePage hp = new HomePage(driver);
		WebElement more = hp.getMorelink();
		wdu.movetoelement(driver, more);
		
		hp.getCampaignlink().click();
		
		String assignedTo= eu.readDatafromExcel("Sheet1", 4, 0);
		String assigned= eu.readDatafromExcel("Sheet1", 4, 1);
		
		CampaignPage cp = new CampaignPage(driver);
		
		cp.getSearchbox().sendKeys(assigned);
		
		wdu.selectdropdown(cp.getInDD(), assignedTo);
		
		cp.getSearhBtn().click();
		
		 
	}

}
