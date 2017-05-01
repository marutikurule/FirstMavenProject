package firstMavenProject.firstMavenProject;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestScenarios 
{
	WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
		
		BaseTest basetest = new BaseTest();
		driver=basetest.selectBrowser(ConstantVariable.browserName);
		driver.get(ConstantVariable.baseUrl);
		driver.manage().window().maximize();
	}
	
	@Test(description="validate login with valid credentials",enabled=true)
	public void test1()
	{
		
		LoginPage loginpage = new LoginPage(driver);
		String val= loginpage.validLogin(ConstantVariable.username, ConstantVariable.password);
		Assert.assertTrue(val.contains(ConstantVariable.expectedTitle),"fail to login");
	}
	
	@Test(description="validate login with Invalid credentials")
	public void test2()
	{
		LoginPage loginpage = new LoginPage(driver);
		String val= loginpage.validInLogin(ConstantVariable.username, ConstantVariable.password+"1");
		Assert.assertTrue(val.contains(ConstantVariable.errormsg),"error on the page");
	}
	
	
	@AfterMethod
	public void teardown()
	{
		driver.manage().deleteAllCookies();
		driver.quit();
	}
}
