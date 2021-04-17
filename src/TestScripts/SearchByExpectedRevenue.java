package TestScripts;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Generic.Base;
import POM.CampaignPage;
import POM.HomePage;

public class SearchByExpectedRevenue extends Base{
	
	@Test
	public void searchByExpectedRevenue() throws IOException {

		HomePage hp = new HomePage(driver);
		WebElement more = hp.getMorelink();
		wdu.movetoelement(driver, more);
		
		hp.getCampaignlink().click();
		
		String expectedRevenue= eu.readDatafromExcel("Sheet1", 2, 0);
		CampaignPage cp = new CampaignPage(driver);
		
		cp.getSearchbox().sendKeys("25000");
		
		wdu.selectdropdown(cp.getInDD(), expectedRevenue);
		
		cp.getSearhBtn().click();
		
		 
	}

}
