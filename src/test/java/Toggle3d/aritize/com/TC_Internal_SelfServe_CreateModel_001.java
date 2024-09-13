package Toggle3d.aritize.com;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_Internal_SelfServe_CreateModel_001 {

	WebDriver driver;

	@BeforeMethod
	public void Launchbroswer() {
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-orginis=*");
		driver = new ChromeDriver(co);
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
		WebElement hometextvalid = driver.findElement(By.className("jss91"));
		Assert.assertTrue(hometextvalid.isDisplayed(), "Home Page Header Not Found");
		WebElement createModelBtn = driver.findElement(By.className("MuiButton-label"));
		createModelBtn.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement letsGetStartedBtn = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("/html/body/div/div/div/div/div/div/div[2]/div/div/button")));
		letsGetStartedBtn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement categorymodel=driver.findElement(By.className("css-1hwfws3"));
		categorymodel.click();
		
		List<WebElement> dropdownoptionscategory = driver.findElements(By.xpath("//*[@id=\"app\"]/div/div/div/div/div/div[2]/div/div/div/div[1]/div/div[1]/div[1]"));
		for(WebElement category:dropdownoptionscategory) {
			if(category.getText().equals("Chairs")) {
				category.click();
				break;
			}
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebElement btncontinue=driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[2]/div/div/div/div[2]/button[2]"));
		Assert.assertTrue(btncontinue.isDisplayed());
		Assert.assertTrue(btncontinue.isEnabled());
		btncontinue.click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
//		WebElement popupbtnYesiamsure=driver.findElement(By.className("MuiTouchRipple-root"));
//		popupbtnYesiamsure.click();
				
		
				
		
	}

	@AfterMethod
	public void browserclosure() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.quit();
	}
}
