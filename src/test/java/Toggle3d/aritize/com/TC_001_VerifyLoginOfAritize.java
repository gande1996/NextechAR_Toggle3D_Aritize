package Toggle3d.aritize.com;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_001_VerifyLoginOfAritize {
	WebDriver driver;

	@BeforeMethod
	public void LaunchBroswer() {
		ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

	}

	@Test
	public void verify_with_valid_login_details() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://portal-test.threedy.ai/");
		WebElement email = driver.findElement(By.id("index_email"));
		email.sendKeys("akhil.gande@nextechar.com");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("Akhil@123");
		WebElement loginbutton = driver.findElement(By.id("btn-login"));
		loginbutton.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}
	@Test
	public void verify_with_invalid_login_details() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://portal-test.threedy.ai/");
		String expected = "Login";
		String actual = "Login";
		Assert.assertEquals(actual,expected,"Strings");
		WebElement email=driver.findElement(By.id("index_email"));
		email.sendKeys("akhil.test251@myyahoo.com");
		WebElement password=driver.findElement(By.id("password"));
		password.sendKeys("Akhil@123148");
		WebElement loginbutton=driver.findElement(By.id("btn-login"));
		loginbutton.click();
		WebElement errorMessage = driver.findElement(By.cssSelector("#error-message"));
        String expectedText = "Wrong email or password.";
        String actualText = driver.findElement(By.cssSelector("#error-message")).getText();
        Assert.assertEquals(actualText, expectedText, "Error message does not match.");
	}

	@AfterMethod
	public void closures() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		driver.close();
//		test1
	}

}
