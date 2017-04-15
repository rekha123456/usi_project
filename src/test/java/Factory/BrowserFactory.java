package Factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import DataProvider.configdataProvider;

public class BrowserFactory {

	static WebDriver driver;
	
	static configdataProvider config=new configdataProvider();
	
	public static WebDriver getbrowser(String browser)
	
	{
		if(browser.equalsIgnoreCase("firefox"))
			
		{
			System.setProperty("webdriver.gecko.driver",config.getchromepath());
			
			driver=new FirefoxDriver();
				
		}
		
		else if(browser.equalsIgnoreCase("chrome"))
			
		{
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			
			System.setProperty("webdriver.chrome.driver",config.getchromepath());
			driver=new ChromeDriver(options);
			
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
		
	}
	
	public static void closebrowser()
	{
		
      driver.quit();
	}
	
	
	
	
	
	
}
