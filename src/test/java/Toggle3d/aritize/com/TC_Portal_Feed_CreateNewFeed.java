package Toggle3d.aritize.com;

import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_Portal_Feed_CreateNewFeed {

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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

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
		WebElement feedmenu = driver
				.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[1]/header/div/div/div[7]/div/a"));
		feedmenu.click();
		System.out.println("Enter the main Menu button name:"+feedmenu.getText());
		WebElement Newfeedbtn=driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[3]/div/div/div[2]/button[1]"));
		Assert.assertTrue(Newfeedbtn.isDisplayed());
		Assert.assertTrue(Newfeedbtn.isEnabled());
		Newfeedbtn.click();
		System.out.println("Enter the button name:"+Newfeedbtn.getText());
		WebElement titlefieldname=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[2]/table/tbody/tr[1]/td[1]"));
		Assert.assertTrue(titlefieldname.isDisplayed());
		System.out.println("Enter the Title Field Name:" +titlefieldname.getText());
		
		WebElement CreateFeedbtn=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[3]/button[2]/span[1]"));
		CreateFeedbtn.click();
		Assert.assertTrue(CreateFeedbtn.isDisplayed());
		Assert.assertTrue(CreateFeedbtn.isEnabled());
		System.out.println("Enter the Button Name:" +CreateFeedbtn.getText());
		
		WebElement entertitle=driver.findElement(By.id("title"));
		entertitle.sendKeys("Tour Men's Sneakers");
		System.out.println("Enter the Title:" +entertitle.getAttribute("value"));
		WebElement enterurl=driver.findElement(By.id("url"));
		enterurl.sendKeys("https://in.puma.com/in/en/pd/tour-mens-sneakers/386918?swatch=01");
		System.out.println("Enter the URL:" +enterurl.getAttribute("value"));
		
		String randomsku = generateRandomAlphanumeric(10);
		System.out.println("Generated SKU:" +randomsku);
		WebElement entersku = driver.findElement(By.id("sku"));
		entersku.sendKeys(randomsku);
		
		WebElement selectclientname=driver.findElement(By.id("client_id"));
		selectclientname.sendKeys("TeamSG");
		List<WebElement> dropdownOptions = driver.findElements(By.xpath("//*[@id=\"client_id\"]"));
		for (WebElement option: dropdownOptions) {
			if(option.getText().equals("TeamSG")) {
				option.click();
				break;
			}
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		
		WebElement selectclientcategory = driver.findElement(By.id("client_category"));
		selectclientcategory.sendKeys("Cricket Products");
			
			

	}

	private String generateRandomAlphanumeric(int Length) {
		String chars= "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		StringBuilder sb=new StringBuilder();
		Random random=new Random();
		for(int i =0; i<Length;i++) {
			int index=random.nextInt(chars.length());
			sb.append(chars.charAt(index));
		}
		return sb.toString();
	}

	@AfterMethod
	public void close() {
//		driver.close();
	}
}
