package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;



public class HomePageObjects{
	
	WebDriver driver;
	Actions act;
	
	public HomePageObjects(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='container container-fluid-md']/a/img")
	public WebElement logo;
	
	@FindBy(xpath="//ul[@class='tb-megamenu-nav nav level-0 items-5']/li/span")
	public List<WebElement> firstThreeTabs;
	
	@FindBy(xpath="//ul[@class='tb-megamenu-nav nav level-0 items-5']/li/a")
	public List<WebElement> lastTwoTabs;
	
	@FindBy(xpath="//ul[@class='tb-megamenu-nav nav level-0 items-5']/li[1]/span")
	public WebElement firstTab;
	
	@FindBy(xpath="//ul[@class='tb-megamenu-nav nav level-0 items-5']/li[2]/span")
	public WebElement secondTab;
	
	@FindBy(xpath="//ul[@class='tb-megamenu-nav nav level-0 items-5']/li[3]/span")
	public WebElement thirdTab;
	
	@FindBy(xpath="//ul[@class='tb-megamenu-nav nav level-0 items-5']/li[4]/a")
	public WebElement fourthTab;
	
	@FindBy(xpath="//ul[@class='tb-megamenu-nav nav level-0 items-5']/li[5]/a")
	public WebElement fifthTab;
	
	
	
	
	@FindBy(xpath="//ul[@class='tb-megamenu-subnav mega-nav level-1 items-6']/li/a")
	public WebElement jobInnerContentFirstTab;
	
	@FindBy(xpath="//ul[@class='tb-megamenu-subnav mega-nav level-1 items-3']/li/a")
	public List<WebElement> TEFLInnerContent;
	
	@FindBy(xpath="//ul[@class='tb-megamenu-subnav mega-nav level-1 items-2']/li/a")
	public List<WebElement> TeacherCertificationInnerContent;
	
	
	public int headerTabCount() {
		System.out.println(firstThreeTabs.size()+lastTwoTabs.size());
		return firstThreeTabs.size()+lastTwoTabs.size();
	}
	
	public void checkHeaderTabs(String tab) {
		if(tab.equalsIgnoreCase("JOBS")) {
			//System.out.println(firstTab.getText() +  "======"+tab);
			Assert.assertEquals(firstTab.getText(), tab);
			
		} else if (tab.equalsIgnoreCase("TEFL")) {
			//System.out.println(secondTab.getText() +  "======"+tab);
			Assert.assertEquals(secondTab.getText(), tab);
			
		} else if (tab.equalsIgnoreCase("TEACHER CERTIFICATION")) {
			//System.out.println(thirdTab.getText() +  "======"+tab);
			Assert.assertEquals(thirdTab.getText(), tab);
			
		} else if (tab.equalsIgnoreCase("COURSES")) {
			//System.out.println(fourthTab.getText() +  "======"+tab);
			Assert.assertEquals(fourthTab.getText(), tab);
			
		} else if (tab.equalsIgnoreCase("HIRE TEACHERS")) {
			//System.out.println(fifthTab.getText() +  "======"+tab);
			Assert.assertEquals(fifthTab.getText(), tab);
			
		} 
	}

	public String logoURL() {
		System.out.println(logo.getAttribute("src"));
		return logo.getAttribute("src");
	}
	
	public void mouseHover(String tab) {
		
		act = new Actions(driver);
		
		if(tab.equalsIgnoreCase("JOBS")) {
			act.moveToElement(firstTab).build().perform();
			
		} else if (tab.equalsIgnoreCase("TEFL")) {
			act.moveToElement(secondTab).build().perform();
			
		} else if (tab.equalsIgnoreCase("TEACHER CERTIFICATION")) {
			act.moveToElement(thirdTab).build().perform();
			
		} 
		
	}
	
	
		
		
		
	
	public void checkInnerContent(String tab) {
		
		if(tab.equalsIgnoreCase("JOBS")) {
			
			for(int i=0;i<6;i++) {
				if(i==0)
					Assert.assertEquals(jobInnerContentFirstTab.getAttribute("href"), "https://www.teachaway.com/teaching-jobs-abroad");
				//else if (i==1)
					//Assert.assertEquals(jobInnerContentFirstTab.getAttribute("href"), expected);
				//remaining tabs of Jobs are remaining to build
				
			}
			
			
		}
		
		
		
		if(tab.equalsIgnoreCase("TEFL")) {
			
			for(int i=0;i<TEFLInnerContent.size();i++) {
				if(i==0)
					Assert.assertEquals(TEFLInnerContent.get(i).getAttribute("href"), "https://www.teachaway.com/courses/online-tefl-certification");
				else if (i==1)
					Assert.assertEquals(TEFLInnerContent.get(i).getAttribute("href"), "https://www.teachaway.com/tefl-certification");
			}
			
			
		}
		
		if(tab.equalsIgnoreCase("TEACHER CERTIFICATION")) {
			for(int i=0;i<TeacherCertificationInnerContent.size();i++) {
				if(i==0)
					Assert.assertEquals(TeacherCertificationInnerContent.get(i).getAttribute("href"), "https://www.teachaway.com/courses/teacher-certification-program");
				else if (i==1)
					Assert.assertEquals(TeacherCertificationInnerContent.get(i).getAttribute("href"), "https://www.teachaway.com/alternative-teacher-certification");
			}
		}
		
		if(tab.equalsIgnoreCase("COURSES")) {
			Assert.assertEquals(fourthTab.getAttribute("href"), "https://www.teachaway.com/courses-and-certifications");
		
		}
		
		if(tab.equalsIgnoreCase("HIRE TEACHERS")) {
			Assert.assertEquals(fifthTab.getAttribute("href"), "https://www.teachaway.com/recruitment");
		
		}
	}
	
}
