package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class baseTest {
	
	protected WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		ChromeOptions co=new ChromeOptions();
		co.addArguments("--remote-allow-origin*");
		driver = new ChromeDriver(co);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://portal-test.threedy.ai/");
	}
	
	@AfterMethod
	public void tearDown() {
		if(driver !=null) {
			driver.quit();
		}
	}
}
