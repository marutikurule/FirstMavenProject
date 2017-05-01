package firstMavenProject.firstMavenProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReusableMethods 
{
	WebDriver driver;
	
	public ReusableMethods(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	public void clickElement(By locator)
	{
		driver.findElement(locator).click();
	}
	
	public void typeData(By locator, String val)
	{
		driver.findElement(locator).sendKeys(val);
	}
	
	public String getElementText(By locator)
	{
		return driver.findElement(locator).getText();
	}
	
	public boolean isElementVisible(By locator)
	{
		return driver.findElement(locator).isDisplayed();
	}
	
	public boolean isElementEnable(By locator)
	{
		return driver.findElement(locator).isEnabled();
	}
	
	public boolean isElementSelected(By locator)
	{
		return driver.findElement(locator).isSelected();
	}
	
	public String getPageTitle()
	{
		return driver.getTitle();
	}
	
	public String getPagUrl()
	{
		return driver.getCurrentUrl();
	}
	
	public void ExplicitWait1(String title)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.titleContains(title));
	}
	
	public void ExplicitWait2(By locator)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
}
