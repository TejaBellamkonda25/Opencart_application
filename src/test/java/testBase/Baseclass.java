package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


public class Baseclass {
	
		
		public static WebDriver driver;
		public Logger logger;
		public Properties p;
		@BeforeClass(groups = {"Sanity","Regration","Master"})
		@Parameters({"os","browser"})
		public void setup( String os, String br) throws IOException, InterruptedException {
			//Loading config.properties file..
			FileReader file = new FileReader("./src/test/resources//config.properties");
			p = new Properties();
			p.load(file);
			logger = LogManager.getLogger(this.getClass());
			
			if (p.getProperty("execution_env").equalsIgnoreCase("remote")) {
				 
		        String hubURL = "http://localhost:4444/wd/hub";
	 
		        if (br.equalsIgnoreCase("chrome")) {
		            ChromeOptions options = new ChromeOptions();
		          /*  options.addArguments("--headless=new");
		            options.addArguments("--disable-gpu");
		            options.addArguments("--window-size=1920,1080");       
		            options.addArguments("--no-sandbox");
		            options.addArguments("--disable-dev-shm-usage");*/
	 
		            options.setPlatformName(os.equalsIgnoreCase("windows") ? "WIN11" : os.toLowerCase());
		            driver = new RemoteWebDriver(new URL(hubURL), options);
	 
		        } else if (br.equalsIgnoreCase("firefox")) {
		        	FirefoxOptions options = new FirefoxOptions();
		        	/* options.addArguments("--headless");
		            options.addArguments("--width=1920");
		            options.addArguments("--height=1080");*/
	 
		            options.setPlatformName(os.equalsIgnoreCase("windows") ? "WIN11" : os.toLowerCase());
		            driver = new RemoteWebDriver(new URL(hubURL), options);
	 
	 
		        } else if (br.equalsIgnoreCase("edge")) {
		            EdgeOptions options = new EdgeOptions();
		           /* options.addArguments("--headless=new");
		            options.addArguments("--disable-gpu");
		            options.addArguments("--window-size=1920,1080");
		            options.addArguments("--no-sandbox");
		            options.addArguments("--disable-dev-shm-usage");*/
		            
		            options.setPlatformName(os.equalsIgnoreCase("windows") ? "WIN11" : os.toLowerCase());
		            driver = new RemoteWebDriver(new URL(hubURL), options);
	 
		        } else {
		            System.out.println("No matching browser found.");
		            return;
		        }
	 
		    }
	 
			
			// for remote
	 
			/*if(p.getProperty("execution_env").equalsIgnoreCase("remote")) {
				DesiredCapabilities cap = new DesiredCapabilities();
				//os
				if(os.equalsIgnoreCase("Windows"))
				{
					cap.setPlatform(Platform.WIN11);
				}
				else if(os.equalsIgnoreCase("mac")) {
					cap.setPlatform(Platform.MAC);
					}
				else if(os.equalsIgnoreCase("linux")){
					cap.setPlatform(Platform.LINUX);	 				
				}
				else {
					System.out.println("no matching browser");
					return;
				}
				
				//browser
				switch(br.toLowerCase()){
				case "chrome":cap.setBrowserName("chrome");break;
				case "edge":cap.setBrowserName("microsoftEdge");break;
				case "firefox":cap.setBrowserName("firefox");break;
				default:System.out.println("no matching browser");
				return;
				}
				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
			}
			*/
			 //for local 
			if(p.getProperty("execution_env").equalsIgnoreCase("local")) {
			 switch(br.toLowerCase())	
			 {
			 case "chrome":driver = new ChromeDriver();break;
			 case "edge":driver = new EdgeDriver();break;
			 case "firefox":driver = new FirefoxDriver();break;
			 default:System.out.println("invalid browser......");return;  
			 }
			 
			 
			  driver.manage().deleteAllCookies();
			  //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			  
			  
			  driver.get(p.getProperty("appurl"));
			  driver.manage().window().maximize();
		}  
		}	
		@AfterClass(groups = {"Sanity","Regration","Master"})
		public void teardown() {
			driver.quit();
		}
	
		//methods to create random String,number
	
				
		public String randomeString()
		{
			String generatedString = RandomStringUtils.randomAlphabetic(6);
			return generatedString;
			}
		public String randomnumber() {
			String generatednumber = RandomStringUtils.randomNumeric(10);
			return generatednumber;
		}
		public String randomalphanumeric()
		{
			String generatedString = RandomStringUtils.randomAlphabetic(3);
			String generatednumber = RandomStringUtils.randomNumeric(3);
			return(generatedString+"@"+generatednumber);
 
		}
		
		public String captureScreen(String tname) {
			String timestamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			TakesScreenshot takesscreenshot = (TakesScreenshot)driver;
			File scorcefile = takesscreenshot.getScreenshotAs(OutputType.FILE);
			
			String targetFilePath = System.getProperty("user.dir")+"\\screenshot\\"+ tname +"_"+ timestamp+ ".png";
			File targetFILE = new File(targetFilePath);
			
			scorcefile.renameTo(targetFILE);
			return targetFilePath;
			
		}

}

