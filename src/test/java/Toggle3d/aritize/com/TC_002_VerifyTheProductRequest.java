package Toggle3d.aritize.com;





import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_002_VerifyTheProductRequest {
	WebDriver driver;

	@BeforeMethod
	public void LaunchBroswer() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		driver.get("https://portal-test.threedy.ai/");
		WebElement email = driver.findElement(By.id("index_email"));
		email.sendKeys("rahul28@mailinator.com");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("Akhil@123");
		WebElement loginbutton = driver.findElement(By.id("btn-login"));
		loginbutton.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

	}

	@Test
	public void verify_with_valid_login_details() {
		driver.findElement(By.linkText("Products")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.xpath("(//span[normalize-space()='Product Request'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		String text = driver.findElement(By.cssSelector("h2")).getText();
//        assertEquals(text, "Product Request");
		WebElement productTitle = driver.findElement(By.id("title"));
		productTitle.sendKeys("pumaShoes");
		WebElement productURL = driver.findElement(By.id("url"));
		productURL.sendKeys("https://in.puma.com/in/en/pd/tour-mens-sneakers/386918?swatch=01");
		WebElement sku=driver.findElement(By.id("sku"));
		sku.sendKeys("puma001");
		WebElement productcategory = driver.findElement(By.id("client_category"));
		productcategory.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Select productcategory2 = new Select(driver.findElement(By.id("client_category")));
		productcategory2.selectByVisibleText("Cricket Products");
		
		
	}

	@AfterMethod
	public void closures() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		driver.quit();Test2
	}
}
