package firstMavenProject.firstMavenProject;

import org.openqa.selenium.By;

public class Repository 
{
	public By usernamefield=By.id("username");
	public By passwordfield=By.name("pwd");
	public By checkboxfield=By.id("keepLoggedInCheckBox");
	public By loginbutton=By.id("loginButton");
	public By errormsg=By.xpath(".//*[@id='ErrorsTable']/tbody/tr/td[2]/table/tbody/tr/td/span");
	public By logoutbutton=By.id("logoutLink");
	
}
