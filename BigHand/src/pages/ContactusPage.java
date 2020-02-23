package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class ContactusPage {
	
	WebDriver driver;
	By element_firstname = By.cssSelector(".first_name input");
	By element_submit = By.cssSelector(".submit input");
	By element_error = By.cssSelector("form[method='post'] p");
	By cookie = By.cssSelector(".h4.mb-0");
	By frame = By.id("iframe-pardot-form");
	
	public ContactusPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void enter_firstName(String name) throws Throwable
	{
		driver.findElement(cookie).click();
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500)");
		WebElement element = driver.findElement(frame);
		driver.switchTo().frame(element);
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element_firstname));
		driver.findElement(element_firstname).click();
		driver.findElement(element_firstname).sendKeys(name);
		driver.findElement(element_submit).click();
		
	}
	
	public void validateError(String errorMessage) throws Throwable
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element_error));
		String error = driver.findElement(element_error).getText();
		Assert.assertEquals(error, errorMessage);
	}
}
