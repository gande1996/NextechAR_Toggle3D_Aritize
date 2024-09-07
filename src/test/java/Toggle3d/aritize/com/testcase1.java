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
				.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[1]/header/div/div/div[37]/div/span"));
		toolsmenu.click();
		WebElement complexityCheckersubmenu = driver
				.findElement(By.xpath("/html/body/div[2]/div[3]/ul/a[2]/li/div/span"));
		complexityCheckersubmenu.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		WebElement category = driver.findElement(By.id("category"));
		category.sendKeys("Other");
		List<WebElement> dropdownoptions= driver.findElements(By.xpath("//ul[contains(@class, 'MuiMenuItem-root')]"));
		for(WebElement options: dropdownoptions) {
			if(options.getText().equals("Other")) {
				options.click();
				break;
			}
		}
		WebElement primaryImageLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),'Primary Image')]")));
	    primaryImageLabel.click();
	    WebElement fileInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='file'][@name='primary_image']")));
	    fileInput.sendKeys("C:\\Users\\Toggle3D\\Desktop\\81ejz3uOYRL._AC_UL320_.jpg");
		
//		driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div/form/div/div[1]/div/div/span/label")).click();
//		driver.findElement(By.xpath("//input[@type='file'][@name='primary_image']"))
//				.sendKeys("C:\\Users\\Toggle3D\\Desktop\\81ejz3uOYRL._AC_UL320_.jpg");
		
	}

	@AfterMethod
	public void close() {
//		driver.close();
	}

}
