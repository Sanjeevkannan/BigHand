package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	By element_contactus = By.cssSelector(".getInTouchButton");
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void click_contactus() throws Throwable
	{
		driver.findElement(element_contactus).click();
		Thread.sleep(1000);
//		System.out.println(driver.getCurrentUrl());
	}
	
}
