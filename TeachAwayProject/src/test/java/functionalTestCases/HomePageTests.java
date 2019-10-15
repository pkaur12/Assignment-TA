package functionalTestCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import resources.TestData;

public class HomePageTests extends BaseTest{
	
	@Test
	public void checkHeaderTabCount() {
		Assert.assertEquals(homepage.headerTabCount(), 5);
	}
	
	@Test (dataProvider="tabs", dataProviderClass = TestData.class)
	public void testHeader(String tabName) {
		homepage.checkHeaderTabs(tabName);
	}
	

	@Test
	public void testLogoURL() {
		Assert.assertEquals(homepage.logoURL(), "https://www.teachaway.com/themes/contrib/tams/logo.svg");
	}
	
	@Test (dataProvider="tabs", dataProviderClass = TestData.class)
	public void testContentForJobs(String tab) {
		homepage.mouseHover(tab);
		homepage.checkInnerContent(tab);
		
		//Assertion function for 200 ok status is remaining
	}

}
