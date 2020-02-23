package test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ContactusPage;

public class runTest {

	WebDriver driver;
	HomePage homepage;
	ContactusPage contactPage;
	String url = "https://www.bighand.com";
	String error = "Please correct the errors below:";
	
	@BeforeTest
	public void launchBrowser()
	{		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sony\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);		
	}	
	
	@AfterTest
	public void closeBrowser()
	{
		driver.quit();
		System.out.println("Browser closed");
	}
	
	@Test
	public void triggerTest() throws Throwable {
		homepage = new HomePage(driver);
		homepage.click_contactus();
		
		contactPage = new ContactusPage(driver);
		contactPage.enter_firstName("Testing");
		contactPage.validateError(error);	
	}

}
