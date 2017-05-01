package firstMavenProject.firstMavenProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	WebDriver driver;
	ReusableMethods obj;
	Repository lib;

	public LoginPage(WebDriver driver)
	{
		
		this.driver=driver;
		obj=new ReusableMethods(driver);
		lib = PageFactory.initElements(driver, Repository.class);
	}

	private void setUsername(String username)
	{
		obj.typeData(lib.usernamefield, username);
	}

	private void setPassword(String pwd)
	{
		obj.typeData(lib.passwordfield, pwd);
	}

	private void clickCheckbox()
	{
		if(!obj.isElementSelected(lib.checkboxfield))
		{
			obj.clickElement(lib.checkboxfield);
		}
	}

	private void loginbutton()
	{
		obj.clickElement(lib.loginbutton);
	}
	
	public String validLogin(String username, String password)
	{
		setUsername(username);
		setPassword(password);
		clickCheckbox();
		loginbutton();
		obj.ExplicitWait2(lib.logoutbutton);
		return obj.getPageTitle();
	}
	
	public String validInLogin(String username, String password)
	{
		setUsername(username);
		setPassword(password);
		clickCheckbox();
		loginbutton();
		obj.ExplicitWait2(lib.errormsg);
		return obj.getElementText(lib.errormsg);
	}
	
	public void forgotpwd()
	{
		
	}
}
