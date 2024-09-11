package Toggle3d.aritize.com;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_Internal_Selfserve_Login {
	WebDriver driver;
	
	@BeforeMethod
	public void Launchbroswer () {
		ChromeOptions co=new ChromeOptions();
		co.addArguments("--remote-allow-orginis=*");
		driver=new ChromeDriver(co);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

	}
	@Test
	public void Checkhomepage() {
		driver.get("https://portal-test.threedy.ai/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement email = driver.findElement(By.id("index_email"));
		email.sendKeys("suresh28@mailinator.com");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("Akhil@123");
		WebElement loginbutton = driver.findElement(By.id("btn-login"));
		loginbutton.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		WebElement hometextvalid=driver.findElement(By.className("jss91"));
		Assert.assertTrue(hometextvalid.isDisplayed(),"Home Page Header Not Found");
		
	}
	@AfterMethod
	public void browserclosure() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}
}
