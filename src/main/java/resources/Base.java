package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {


	public WebDriver driver;
	public Properties prop ;
	public WebDriver initializeDriver() throws Exception {
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\a\\Desktop\\Selenium Practice\\com.selenium.practise\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browserName =prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\a\\Downloads\\ChromeDriver\\chromedriver.exe");
			 driver = new ChromeDriver();
			
			
			
		}else if(browserName.equals("firefox")) {
			
			//firefox code
			
		}else if(browserName.equals("safari")){
			//safari ccode
		}
		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
	}
	

	public void getScreenShotPath(String testCaseName,WebDriver driver) throws Exception {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File Source=ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(Source, new File(destination));
		
	}
	
	
	
}
