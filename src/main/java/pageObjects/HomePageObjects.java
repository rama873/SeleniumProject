package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.base;

public class HomePageObjects extends base {
	

	
	public static HomePageObjects HomePage = new HomePageObjects(driver);
	
	By Createbutton = By.xpath("//a[@id='showCreateDialogBtn']");
	By ERcreatebutton = By.xpath("//a[@id='myDocumentsForm:newERBtn_']");
	By PRcreatebutton = By.xpath("//a[@id='myDocumentsForm:newPRBtn_']");
	By TPcreatebutton = By.xpath("//a[@id='myDocumentsForm:newTPBtn_']");
	By TScreatebutton = By.xpath("//a[@id='myDocumentsForm:newTSBtn_']");
	By Signout = By.xpath("//span[@id='myDocumentsForm:logoutLink']");
	
	public HomePageObjects(WebDriver driver) {
		this.driver=driver;
	}
	


	public WebElement Createbutton() {
		return driver.findElement(Createbutton);
	}
	
	public WebElement ERcreatebutton() {
		return driver.findElement(ERcreatebutton);
	}
	
	public WebElement PRcreatebutton() {
		return driver.findElement(PRcreatebutton);
	}
	public WebElement TPcreatebutton() {
		return driver.findElement(TPcreatebutton);
	}
	public WebElement TScreatebutton() {
		return driver.findElement(TScreatebutton);
	}
	public WebElement Signout() {
		return driver.findElement(Signout);
	}
	

}
