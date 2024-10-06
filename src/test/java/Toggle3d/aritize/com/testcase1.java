package Toggle3d.aritize.com;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testcase1 {
	WebDriver driver;

	@BeforeMethod
	public void launchbroswer() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		driver.get("https://portal-test.threedy.ai/");
//		driver.get("https://portal.threedy.ai/");
		WebElement email = driver.findElement(By.id("index_email"));
		email.sendKeys("akhil.gande@nextechar.com");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("Akhil@123");
		WebElement loginbutton = driver.findElement(By.id("btn-login"));
		loginbutton.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@Test
	public void testcase() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement h3title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
				"#app > div > div > div.jss9 > div > div > div.MuiGrid-root.MuiGrid-container.MuiGrid-spacing-xs-2 > div:nth-child(1) > h3")));
		String actualtitle = h3title.getText();
		String expectedtitle = "ARitize 3D Dashboard";
		System.out.println("Actual H3 Title: " + actualtitle);
		assert actualtitle.equals(expectedtitle) : "Title does not match!";
		WebElement toolsmenu = driver
				.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[1]/header/div/div/div[7]/div/a"));
		toolsmenu.click();
		WebElement complexityCheckersubmenu = driver
				.findElement(By.xpath("/html/body/div[2]/div[3]/ul/a[2]/li/div/span"));
		complexityCheckersubmenu.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		WebElement primaryimg=driver.findElement(By.id("primary-image"));
		primaryimg.sendKeys("C://Users//Toggle3D//Desktop//61MFwxMjk9L._AC_UL320_.jpg");
		WebElement secondaryimg=driver.findElement(By.id("secondary-image"));
		secondaryimg.sendKeys("C://Users//Toggle3D//Desktop//81ejz3uOYRL._AC_UL320_.jpg");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		WebElement category = driver.findElement(By.id("category"));
		category.click();
		List<WebElement> dropdownoptions= driver.findElements(By.xpath("//*[@id=\"menu-\"]/div[3]/ul/li[1]"));
		for(WebElement options: dropdownoptions) {
			if(options.getText().equals("Other")) {
				options.click();
				break;
			}
		}
		WebElement title=driver.findElement(By.id("title"));
		title.sendKeys("watches");
		WebElement depth=driver.findElement(By.id("depth"));
		depth.sendKeys("3");
		WebElement width=driver.findElement(By.id("width"));
		width.sendKeys("2");
		WebElement height=driver.findElement(By.id("height"));
		height.sendKeys("3");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebElement checkcomplexity=driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[3]/div/div/div/form/div/button/span[1]"));
		Assert.assertTrue(checkcomplexity.isDisplayed());
		Assert.assertTrue(checkcomplexity.isEnabled());
		checkcomplexity.click();
		System.out.println("Enter the button name:"+ checkcomplexity.getText());
		WebElement complexitycheck =driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[3]/div/div/div/div/table/tbody/tr/td[2]"));
		Assert.assertTrue(complexitycheck.isDisplayed());
		System.out.println("Enter the complexity:" +complexitycheck.getText());
		WebElement pricerange=driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[3]/div/div/div/div/table/tbody/tr/td[3]"));
		Assert.assertTrue(pricerange.isDisplayed());
		System.out.println("Enter the Price Range:"+pricerange.getText());
		
	}

	@AfterMethod
	public void close() {
//		driver.close();
	}

}
