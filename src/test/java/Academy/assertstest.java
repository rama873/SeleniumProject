package Academy;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LoginPageObject;
import resources.base;

public class assertstest extends base {
    @BeforeTest
    public void startup() throws IOException {
    	//driver = initialiazeDriver();
		driver.get(prop.getProperty("CSFM1C07_TST"));
		
    }
	
	@Test
	public void basis2() throws IOException {
		LoginPageObject lpo = new LoginPageObject(driver);
		driver.manage().window().maximize();
		Assert.assertEquals(lpo.title().getText(), "Infor Expense Management");
		System.out.println(lpo.title().getText());
}
	@AfterClass
	public void teardoen() {
		driver.close();
		driver=null;
	}
}
