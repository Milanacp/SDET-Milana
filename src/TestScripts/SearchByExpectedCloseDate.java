package TestScripts;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Generic.Base;
import POM.CampaignPage;
import POM.HomePage;

public class SearchByExpectedCloseDate extends Base {
	
	@Test
	public void searchByExpectedCloseDate() throws IOException {

		HomePage hp = new HomePage(driver);
		WebElement more = hp.getMorelink();
		wdu.movetoelement(driver, more);
		
		hp.getCampaignlink().click();
		
		String expectedCloseDate= eu.readDatafromExcel("Sheet1", 3, 0);
		CampaignPage cp = new CampaignPage(driver);
		
		cp.getSearchbox().sendKeys("2021-05-17");
		
		wdu.selectdropdown(cp.getInDD(), expectedCloseDate);
		
		cp.getSearhBtn().click();
		
		 
	}

}
