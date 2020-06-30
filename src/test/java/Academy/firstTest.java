package Academy;

import java.io.IOException;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import resources.base;
import pageObjects.ErCreationPageObjects;
import pageObjects.HomePageObjects;
import pageObjects.LoginPageObject;

public class firstTest extends base {
	private static Logger log =LogManager.getLogger(base.class.getClass());
	 @BeforeTest()
	    public void startup() throws IOException {
	    	driver = initialiazeDriver();
	    	log.info("driver is intilized");
			driver.get(prop.getProperty("CSFM1C07_TST"));
			log.info("navigated to home page");
			System.out.println("navigated to home page");
	 }
	
	@Test
	public void ExpenseReport() throws IOException, InterruptedException {
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
				//Thread.sleep(20000);
		ErCreationPageObjects ExpenseReportCreation = new ErCreationPageObjects(driver);
	    System.out.println(driver.getTitle());
	    WebDriverWait wait = new WebDriverWait(driver,1000);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(ExpenseReportCreation.DocumentTitle()));
		ExpenseReportCreation.DocumentTitle().sendKeys("Createdby--");
	    ExpenseReportCreation.pdropdown().click();
	    wait.until(ExpectedConditions.elementToBeClickable(ExpenseReportCreation.purpose()));
	    ExpenseReportCreation.purpose().click();
		ExpenseReportCreation.hsavebtn().click();
		System.out.println("report is saved");
				//wait.until(ExpectedConditions. visibilityOfElementLocated(By.xpath("//a[@id='mainForm:headerSelectLineItemTypeBtn']")));
				
				//Thread.sleep(9000);
				 WebElement iframeElement = driver.findElement(By.xpath("//frame[@name='content']"));
				driver.switchTo().frame(iframeElement);
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Out of Pocket']")));
				ExpenseReportCreation.outofpocket().click();
				 System.out.println("success");
				ExpenseReportCreation.GasLineItem().click();
				
//				WebElement iframeElement1 = driver.findElement(By.xpath("//frame[@name='content']"));
//				driver.switchTo().frame(iframeElement1);
				wait.until(ExpectedConditions.elementToBeClickable(ExpenseReportCreation.LineItemdate()));
				ExpenseReportCreation.LineItemdate().sendKeys("03/02/2019");
				//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//input[@id='editItemForm:amountVal-PFAField']")));
				ExpenseReportCreation.LineItemAmount().sendKeys("18");
				ExpenseReportCreation.Lineitemsave().click();
				
				Thread.sleep(3000);
				wait.until(ExpectedConditions.elementToBeClickable(ExpenseReportCreation.Summarytab()));
         		ExpenseReportCreation.Summarytab().click();
//				String TrackingID = ExpenseReportCreation.Trackingid().getText();
//				String ManagerName = ExpenseReportCreation.ManagerName().getText();
//				System.out.println("Your Expense Report was Successfully Created with ID:"+TrackingID+"and pending with"+ManagerName);
				ExpenseReportCreation.ExpenseSubmit().click();
				ExpenseReportCreation.ViolationNext().click();
				ExpenseReportCreation.EsignUser().sendKeys("jsmith");
				ExpenseReportCreation.EsignPassword().sendKeys("p");
				ExpenseReportCreation.EsignNext().click();
				
				//System.out.println("Your Expense Report was Successfully submitted with ID:"+TrackingID+"and pending with"+ManagerName);
			}
			driver.switchTo().window(Homepagewindow);
			}
		}
			
		
		
		

		
		
	}

//	@DataProvider
//	public Object[][] getData() {
//		Object[][] oj = new Object[2][2];
//		
//		oj[0][0]="jsmith";
//		oj[0][1]="p";
//		oj[1][0]="jjones";
//		oj[1][1]="p";
//				
//
//
//		
//		return oj;
//}
//	
	/*@AfterClass
	public void teardown() {
		driver.close();
		driver=null;
	
	}*/
	


