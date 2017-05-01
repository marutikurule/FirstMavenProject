package firstMavenProject.firstMavenProject;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenTest1 
{

	WebDriver driver;
	
	@BeforeTest
	public void setup()
	{
		
		BaseTest basetest = new BaseTest();
		driver=basetest.selectBrowser(ConstantVariable.browserName);
		driver.get(ConstantVariable.baseUrl);
		driver.manage().window().maximize();
	}	
	
	@Test(dataProvider="testData",description="validate login with Invalid credentials")
	public void test1(String username, String password)
	{
		LoginPage loginpage = new LoginPage(driver);
		String val= loginpage.validInLogin(username, password);
		Assert.assertTrue(val.contains(ConstantVariable.errormsg),"error on the page");
	}
	
	@DataProvider(name="testData")
	public Object[][] readDataText()
	{
		return new Object[][] 
				{ {"first","sdfdsf"},{"second","sdfdsf"},{"third","sdfdsf"}};
	}
	
	
	
	
	@AfterTest
	public void teardown()
	{
		driver.manage().deleteAllCookies();
		driver.quit();
	}
}
