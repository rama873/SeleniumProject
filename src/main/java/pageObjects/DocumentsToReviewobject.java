package pageObjects;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import resources.base;

public class DocumentsToReviewobject extends base {
	
	public static DocumentsToReviewobject documentToReview = new DocumentsToReviewobject(driver);
	WebDriverWait wait = new WebDriverWait(driver,10);

	public DocumentsToReviewobject(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	
	public WebElement MydocumentsTab() {
		return driver.findElement(By.xpath("//table[@class='tabbar']//td[2]"));
	}
	
	public WebElement documentstoreviewtab() {
		return driver.findElement(By.xpath("//table[@class='tabbar']//td[3]"));
	}
	
	public void OpenDocumenttoreview(String tracking_number) {	
		List<WebElement> listofids = driver.findElements(By.xpath("//span[contains(@id,'col3144116Val')]"));
		for(int i=0;i<=listofids.size();i++) {
			if((tracking_number!=null)&&((listofids.get(i).getText().toString()).equals(tracking_number))) { 
				
				 listofids.get(i).click();
				 break;
	}}}
	public void ManagerApprove() {
		WebElement iframeElement = driver.findElement(By.xpath("//iframe[@id='printFrame']"));
		driver.switchTo().frame(iframeElement);
		
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body[@class='er-emailApproval']//tr[@class='sectiontext']//tr[@class='sectiontext']//td//td[1]"))).click();
		driver.findElement(By.xpath("//input[@id='closeDocPrintBtn']")).click();
		driver.switchTo().defaultContent();
	 }
	public void auditorapprove() {
		String auditpagewindow = driver.getWindowHandle();
		Set<String> winhandles = driver.getWindowHandles();
		for(String handles : winhandles ) {
			if(handles.equals(auditpagewindow)) {
			 driver.switchTo().window(handles);
			 WebElement iframeElement = driver.findElement(By.xpath("//frame[@name='content']"));
			 driver.switchTo().frame(iframeElement);		 
			 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='mainForm:_id2DefaultButton0']"))).click();	
			 driver.switchTo().defaultContent();
	 }}}
	
	
	
	
	
}
