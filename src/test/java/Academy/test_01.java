package Academy;

import java.io.IOException;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;

import pageObjects.ErCreationPageObjects;
import pageObjects.HomePageObjects;
import pageObjects.LoginPageObject;
import pageObjects.erline;
import resources.base;

public class test_01 extends base{
	
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
	public void test() {
		driver.manage().window().maximize();
		LoginPageObject.lp.login();
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
					@SuppressWarnings("unused")
					String Er_TrackingNumber = ErCreationPageObjects.ExpenseReportCreation.getTrackingNumber();
					ErCreationPageObjects.ExpenseReportCreation.ErSubmitwithEsig();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
		
	}
			driver.switchTo().window(Homepagewindow);
	
		}
	}
	
	@AfterTest()
	public void After_test() {
		driver.quit();
	}
	

}
