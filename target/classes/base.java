package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {
	
 	public static WebDriver driver;
    public Properties prop;
	public WebDriver initialiazeDriver() throws IOException {
		
		 prop = new Properties();
		
		FileInputStream fip =new FileInputStream("C:\\Users\\rchimmiri\\RealTimeProject\\src\\main\\java\\resources\\data.properties");
		prop.load(fip);
		
		System.out.println(prop.getProperty("browser"));
		if(prop.getProperty("browser") != null && prop.getProperty("browser").equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "C:\\jars selenium\\chrome driver4\\chromedriver.exe");
                 driver=new ChromeDriver();
		}
		else if(prop.getProperty("browser") != null && prop.getProperty("browser").equals("firefox")) {
			System.setProperty("webdriver.firefox.marionette","C:\\\\jars selenium\\firefox driver\\geckodriver.exe");
			     driver = new FirefoxDriver();
		}
		else if(prop.getProperty("browser") != null && prop.getProperty("browser").equals("IE")) {
			
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	public void getScreenShot(String result) throws IOException {
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\rchimmiri\\RealTimeProject\\Screenshots\\"+result+"screenshot.png"));
	}

}
