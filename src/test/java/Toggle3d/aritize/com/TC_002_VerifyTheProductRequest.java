package Toggle3d.aritize.com;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
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
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		driver.findElement(By.xpath("(//span[normalize-space()='Product Request'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement productTitle = driver.findElement(By.id("title"));
		productTitle.sendKeys("pumaShoes");
		WebElement productURL = driver.findElement(By.id("url"));
		productURL.sendKeys("https://in.puma.com/in/en/pd/tour-mens-sneakers/386918?swatch=01");
//		WebElement sku = driver.findElement(By.id("sku"));
//		sku.sendKeys("puma070");
		
		String randomsku = generateRandomAlphanumeric(10);
		System.out.println("Generated SKU:" +randomsku);
		WebElement entersku = driver.findElement(By.id("sku"));
		entersku.sendKeys(randomsku);
		WebElement productcategory = driver.findElement(By.id("client_category"));
		productcategory.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement categoryInput = driver.findElement(By.id("client_category"));
		categoryInput.sendKeys("Cricket Products");
		List<WebElement> dropdownOptions = driver
				.findElements(By.xpath("//li[contains(@class, 'MuiAutocomplete-option')]"));

		for (WebElement option : dropdownOptions) {
			if (option.getText().equals("Cricket Products")) {
				option.click();
				break;
			}
		}
		WebElement height = driver.findElement(By.id("heightValue"));
		height.sendKeys("8");
		WebElement width = driver.findElement(By.id("widthValue"));
		width.sendKeys("5");
		WebElement depth = driver.findElement(By.id("depthValue"));
		depth.sendKeys("4");
		WebElement note=driver.findElement(By.id("note"));
		note.sendKeys("newmodel");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[3]/div/div/div[9]/div/div[1]/div/div/div/button[2]/span[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.findElement(By.id("url-0")).sendKeys("https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_750,h_750/global/107341/03/sv01/fnd/IND/fmt/png/Varion-II-Unisex-Indoor-Sports-Shoes");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement sendRequest = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[4]/button[2]"));
		boolean flag=sendRequest.isEnabled();
		sendRequest.click();
		
		
	
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
	public void closures() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		driver.quit();
	}
}
