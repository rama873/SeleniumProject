package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.base;

public class LoginPageObject extends base {
	
	
	
	public static LoginPageObject lp = new LoginPageObject(driver);
	
	By uname = By.xpath("//input[@id='userid']");
	By password = By.xpath("//input[@id='password']");
	By submit = By.xpath("//input[@name='j_security_check']");
	By title = By.xpath("//span[@id='companyNameTag']");
	
	public LoginPageObject(WebDriver driver) {
		this.driver=driver;
	}
	
	public void login(UserDetails ud) {
		driver.findElement(uname).sendKeys(ud.login);
		driver.findElement(password).sendKeys(ud.password);
		driver.findElement(submit).click();
		
		
	}
	

}
