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
		System.out.println("Home Page Title:" +hometextvalid.getText());
		WebElement createModelBtn = driver.findElement(By.className("MuiButton-label"));
		createModelBtn.click();
		WebElement new3Dmodel = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div/div[1]/div/h1"));
		Assert.assertTrue(new3Dmodel.isDisplayed());
		System.out.println("Lets get Start Title:"+new3Dmodel.getText());
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement letsGetStartedBtn = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("/html/body/div/div/div/div/div/div/div[2]/div/div/button")));
		letsGetStartedBtn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement categorypagetitle=driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div/div[1]/div/h1"));
		Assert.assertTrue(categorypagetitle.isDisplayed());
		System.out.println("Step 1 Title:" +categorypagetitle.getText());
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
		WebElement btncontinue1=driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[2]/div/div/div/div[2]/button[2]"));
		Assert.assertTrue(btncontinue1.isDisplayed());
		Assert.assertTrue(btncontinue1.isEnabled());
		btncontinue1.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebElement basicdetails=driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div/div[1]/div/h1"));
		Assert.assertTrue(basicdetails.isDisplayed());
		System.out.println("Step 2 Title:" + basicdetails.getText());
		WebElement modeltitle=driver.findElement(By.id("title"));
		modeltitle.sendKeys("pumashoes");
		WebElement sku=driver.findElement(By.id("sku"));
		sku.sendKeys("puma082");
		WebElement url=driver.findElement(By.id("url"));
		url.sendKeys("https://in.puma.com/in/en/pd/tour-mens-sneakers/386918?swatch=01");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement btncontinue2=driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[2]/div/div/div/div[2]/button[2]"));
		btncontinue2.click();
		WebElement modeldimensionpagetitle=driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div/div[1]/div/h1"));
		Assert.assertTrue(modeldimensionpagetitle.isDisplayed());
		System.out.println("Step 3 Title:" +modeldimensionpagetitle.getText());
		WebElement height=driver.findElement(By.id("height"));
		height.sendKeys("8");
		WebElement width=driver.findElement(By.id("width"));
		width.sendKeys("5");
		WebElement depth=driver.findElement(By.id("depth"));
		depth.sendKeys("2");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebElement btncontinue3=driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[2]/div/div/div/div[2]/button[2]"));
		Assert.assertTrue(btncontinue3.isDisplayed());
		Assert.assertTrue(btncontinue3.isEnabled());
		btncontinue3.click();
		WebElement uploadedimages=driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div/div[1]/div/h1"));
		Assert.assertTrue(uploadedimages.isDisplayed());
		System.out.println("Step 4 Title:" + uploadedimages.getText());
		WebElement linkimage=driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[2]/div/div/div/div[1]/div[2]/div"));
		linkimage.click();
		WebElement producturl= driver.findElement(By.id("imageUrl"));
		producturl.sendKeys("https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_750,h_750/global/386918/01/fnd/IND/fmt/png/Tour-Men's-Sneakers");
		WebElement Addimagebtn=driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div/div[2]/div/div/div/div[1]/div[1]/button/span[1]"));
		Addimagebtn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebElement reviewyourmodel = driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[2]/div/div/div/div[2]/button[2]"));
		reviewyourmodel.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebElement createmodel = driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[2]/div/div/div/div[2]/button[2]/span[1]"));
		createmodel.click();
				
		
				
		
	}

	@AfterMethod
	public void browserclosure() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.quit();
	}
}
