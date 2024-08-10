package Toggle3d.aritize.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testcase1 {
	WebDriver driver;

	@BeforeMethod
	public void launchbroswer() {
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(co);
		driver.manage().window().maximize();
		driver.get("https://iblesoft.smarteweb.com/");
	

	}
	@Test
	public void testcase() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"theme_nav\"]/div[1]/ul/li[3]/a")).click();
		
	}
	@AfterMethod
	public void close() {
		driver.close();
	}

}
