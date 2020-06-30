package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import resources.base;

public class ErCreationPageObjects extends base {
	
	
	
	public static ErCreationPageObjects ExpenseReportCreation = new ErCreationPageObjects(driver);
	
	By DocumentTitle = By.xpath("//input[@id='mainForm:title-PFAField']");
	By pdropdown = By.xpath("//span[@class='ui-button-icon ui-icon ui-icon-triangle-1-s']");
	By purpose = By.xpath("//a[contains(text(),'Client Costs')]");
	By hsavebtn = By.xpath("//input[@id='mainForm:saveBtn']");
	By outofpocket = By.xpath("//a[text()='Out of Pocket']");
	By TypeExpense =By.xpath("//div[text()='Type expense name to filter.']");
	By LineItemAmount = By.xpath("//input[@id='editItemForm:amountVal-PFAField']");
	By PaymentType = By.id("editItemForm:ADC_3048901");
	By ReceiptIncluded = By.xpath("//label[@id='editItemForm:receipt-PFALabel']");
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
	By AttachNext = By.xpath("//input[@id='attachReciptsPromptForm:NoBtn']");
	
	
	public ErCreationPageObjects(WebDriver driver) {
		this.driver=driver;
	}
	
	
	public void erlinecreate(erline Erline) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,9000);
		driver.findElement(DocumentTitle).sendKeys(Erline.Document_title);
		driver.findElement(pdropdown).click();
		driver.findElement(purpose).click();
		driver.findElement(hsavebtn).click();
		WebElement iframeElement = driver.findElement(By.xpath("//frame[@name='content']"));
		driver.switchTo().frame(iframeElement);
		wait.until(ExpectedConditions.elementToBeClickable(outofpocket));
		driver.findElement(outofpocket).click();
		new Actions(driver).sendKeys(Erline.Expense_type).perform();
		new Actions(driver).sendKeys(Keys.ENTER).perform();
		driver.findElement(LineItemdate).sendKeys(Erline.DATE);
		driver.findElement(LineItemAmount).sendKeys(Erline.AMOUNT);
		Select fruits = new Select(driver.findElement(PaymentType));
		fruits.selectByVisibleText(Erline.PAYMENT_TYPE);
		//driver.findElement(PaymentType).sendKeys(Erline.PAYMENT_TYPE);
		if(Erline.RECEIPT_INCLUDED) {driver.findElement(ReceiptIncluded).click();}
		driver.findElement(Lineitemsave).click();		
	}
	
	public String getTrackingNumber() {
		driver.findElement(Summarytab).click();
		return driver.findElement(Trackingid).getText();		
	}
	
	public void ErSubmitwithEsig() {
		driver.findElement(ExpenseSubmit).click();
		driver.findElement(ViolationNext).click();
		driver.findElement(EsignUser).sendKeys("jsmith");
		driver.findElement(EsignPassword).sendKeys("p");
		driver.findElement(EsignNext).click();
		driver.findElement(AttachNext).click();
	}


}
