package Academy;

import java.io.IOException;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.*;

import pageObjects.DocumentsToReviewobject;
import pageObjects.ErCreationPageObjects;
import pageObjects.HomePageObjects;
import pageObjects.LoginPageObject;
import pageObjects.UserDetails;
import pageObjects.erline;
import resources.base;

public class test_01<Er_TrackingNumber> extends base{
	
	private static Logger log =LogManager.getLogger(base.class.getClass());
	
	
	
	@BeforeTest()
	public void startup() throws IOException {
    	driver = initialiazeDriver();
    	log.info("driver is intilized");
		//driver.get(prop.getProperty("CSFM1C07_TST"))
		//log.info("navigated to home page");
    	driver.get(prop.getProperty("CSFM1C07_TST"));	
    	}
	
	@Test
	public void test() throws InterruptedException {
		String Er_TrackingNumber= null;
		driver.manage().window().maximize();
		LoginPageObject.lp.login(UserDetails.jsmith);
		log.info("Logged in Successfully");
		String Homepagewindow = driver.getWindowHandle();
		HomePageObjects.HomePage.Createbutton().click();
		HomePageObjects.HomePage.ERcreatebutton().click();
		

		Set<String> winhandles = driver.getWindowHandles();
		for(String handles : winhandles ) {
			if(!handles.equals(Homepagewindow)) {
				driver.switchTo().window(handles);
				driver.manage().window().maximize();
				
				try {
					ErCreationPageObjects.ExpenseReportCreation.erlinecreate(erline.Gas);
					Er_TrackingNumber =  ErCreationPageObjects.ExpenseReportCreation.getTrackingNumber();
					ErCreationPageObjects.ExpenseReportCreation.ErSubmitwithEsig();
					driver.switchTo().window(Homepagewindow);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			HomePageObjects.HomePage.Signout().click(); 
			
			////////////////////////////////////////////////////////
			LoginPageObject.lp.login(UserDetails.jjones);
			DocumentsToReviewobject.documentToReview.documentstoreviewtab().click();
			DocumentsToReviewobject.documentToReview.OpenDocumenttoreview(Er_TrackingNumber);
			DocumentsToReviewobject.documentToReview.MydocumentsTab().click();
			HomePageObjects.HomePage.Signout().click(); 
			
			////////////////////////////////////////////////////////
			LoginPageObject.lp.login(UserDetails.ryoung);
			DocumentsToReviewobject.documentToReview.documentstoreviewtab().click();
			DocumentsToReviewobject.documentToReview.OpenDocumenttoreview(Er_TrackingNumber);
			DocumentsToReviewobject.documentToReview.MydocumentsTab().click();
			HomePageObjects.HomePage.Signout().click();
			
			////////////////////////////////////////////////////////
			LoginPageObject.lp.login(UserDetails.admin);
			
				
				
		
	}
			
	
		}
	}
	
	@AfterTest()
	public void After_test() {
		driver.quit();
	}
	

}
