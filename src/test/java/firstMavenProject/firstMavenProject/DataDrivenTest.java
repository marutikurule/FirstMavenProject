package firstMavenProject.firstMavenProject;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DataDrivenTest 
{
	WebDriver driver;
	ExceLib lib;
	SoftAssert soft;
	@BeforeMethod
	public void setup()
	{

		BaseTest basetest = new BaseTest();
		driver=basetest.selectBrowser(ConstantVariable.browserName);
		driver.get(ConstantVariable.baseUrl);
		driver.manage().window().maximize();
		soft = new SoftAssert();
	}

	@Test(description="validate login with Invalid credentials")
	public void test1()
	{
		LoginPage loginpage = new LoginPage(driver);
		
		lib= new ExceLib();
		int rc=lib.getRowcount(ConstantVariable.filepath, ConstantVariable.sheet);
		for(int i=1; i<=rc;i++)
		{
			String username=lib.readexceldata(ConstantVariable.filepath, ConstantVariable.sheet, i, 0);
			String password=lib.readexceldata(ConstantVariable.filepath, ConstantVariable.sheet, i, 1);
			String val= loginpage.validInLogin(username, password);
			lib.writeExcelData(ConstantVariable.filepath, ConstantVariable.sheet, i, 2, val);
			soft.assertTrue(val.contains(ConstantVariable.errormsg),"error on the page");
			soft.assertAll();
		}
		
	}


	@AfterMethod
	public void teardown()
	{
		driver.manage().deleteAllCookies();
		driver.quit();
	}
}
