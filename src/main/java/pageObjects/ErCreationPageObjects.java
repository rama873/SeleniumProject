package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ErCreationPageObjects {
	
	public WebDriver driver;
	
	By DocumentTitle = By.xpath("//input[@id='mainForm:title-PFAField']");
	By pdropdown = By.xpath("//span[@class='ui-button-icon ui-icon ui-icon-triangle-1-s']");
	By purpose = By.xpath("//a[contains(text(),'Client Costs')]");
	By hsavebtn = By.xpath("//input[@id='mainForm:saveBtn']");
	By outofpocket = By.xpath("//a[text()='Out of Pocket']");
	By GasLineItem = By.xpath("//span[contains(text(),'Gas')]");
	By LineItemAmount = By.xpath("//input[@id='editItemForm:amountVal-PFAField']");
	//By PaymentType = By.xpath("//select[@id='editItemForm:ADC_3048901']]");
	By Lineitemsave = By.xpath("//input[@id='editItemForm:saveBtn']");
	By LineItemdate = By.xpath("//input[@id='editItemForm:date-PFAField']");
	By Summarytab = By.xpath("//a[@id='mainForm:_id10TabBtn']");
	By ExpenseSubmit = By.xpath("//a[@id='generalForm:_id2DefaultButton0']");
	By ViolationNext= By.xpath("//input[@id='docViolationForm:nextBtn']");
	By Trackingid= By.xpath("//span[@id='generalForm:trackingVal']");
	By ManagerName= By.xpath("//span[@id='generalForm:approverIdVal']");
	By EsignUser = By.xpath("//input[@id='signForm:userIdVal']");
	By EsignPassword = By.xpath("//input[@id='signForm:passwordVal']");
	By EsignNext = By.xpath("//input[@id='signForm:nextBtn']");
	
	
	public ErCreationPageObjects(WebDriver driver) {
		this.driver=driver;
	}
	


	public WebElement DocumentTitle() {
		return driver.findElement(DocumentTitle);
	}
	
	public WebElement pdropdown() {
		return driver.findElement(pdropdown);
	}
	
	public WebElement purpose() {
		return driver.findElement(purpose);
	}
	public WebElement hsavebtn() {
		return driver.findElement(hsavebtn);
	}
	public WebElement outofpocket() {
		return driver.findElement(outofpocket);
	}
	
	public WebElement GasLineItem() {
		return driver.findElement(GasLineItem);
	}
	public WebElement LineItemAmount() {
		return driver.findElement(LineItemAmount);
	}
	public WebElement LineItemdate() {
		return driver.findElement(LineItemdate);
	}
	public WebElement Lineitemsave() {
		return driver.findElement(Lineitemsave);
	}
	public WebElement Summarytab() {
		return driver.findElement(Summarytab);
	}
	public WebElement Trackingid() {
		return driver.findElement(Trackingid);
	}
	public WebElement ManagerName() {
		return driver.findElement(ManagerName);
	}
	public WebElement ExpenseSubmit() {
		return driver.findElement(ExpenseSubmit);
	}
	public WebElement ViolationNext() {
		return driver.findElement(ViolationNext);
	}
	public WebElement EsignUser() {
		return driver.findElement(EsignUser);
	}
	public WebElement EsignPassword() {
		return driver.findElement(EsignPassword);
	}
	public WebElement EsignNext() {
		return driver.findElement(EsignNext);
	}
	


}
