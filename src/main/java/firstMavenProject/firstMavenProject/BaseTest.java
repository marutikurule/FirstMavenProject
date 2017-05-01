package firstMavenProject.firstMavenProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class BaseTest 
{
	public WebDriver driver;

	public WebDriver selectBrowser(String browsername)
	{
		switch(browsername)
		{
		case "firefox":
		
			System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
			driver= new FirefoxDriver();
			break;
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
			driver=new ChromeDriver();
			break;
		case "ie":
			System.setProperty("webdriver.chrome.driver", "drivers/IEDriverServer.exe");
			driver=new InternetExplorerDriver();
			break;
		default:System.out.println("invalid choice"); System.exit(0);
		}
		return driver;
	}
}
