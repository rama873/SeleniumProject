package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageObject {
	
	public WebDriver driver;
	
	By uname = By.xpath("//input[@id='userid']");
	By password = By.xpath("//input[@id='password']");
	By submit = By.xpath("//input[@name='j_security_check']");
	By title = By.xpath("//span[@id='companyNameTag']");
	
	public LoginPageObject(WebDriver driver) {
		this.driver=driver;
	}
	


	public WebElement username() {
		return driver.findElement(uname);
	}
	
	public WebElement password() {
		return driver.findElement(password);
	}
	
	public WebElement submit() {
		return driver.findElement(submit);
	}
	public WebElement title() {
		return driver.findElement(title);
	}

}
