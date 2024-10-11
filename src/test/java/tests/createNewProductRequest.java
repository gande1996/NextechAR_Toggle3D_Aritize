package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.baseTest;
import pages.LoginPage;
import pages.newProductRequest;

public class createNewProductRequest extends baseTest {

	@Test
	public void Verify_Create_new_product_Request() {
		LoginPage loginPage = new LoginPage(driver);
		newProductRequest productPage = new newProductRequest(driver);
//		driver.manage().deleteAllCookies();
		loginPage.enterEmail("rahul28@mailinator.com");
		loginPage.enterPassword("Akhil@123");
		loginPage.clickOnLoginButton();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(35));
		WebElement h3title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
				"#app > div > div > div.jss9 > div > div > div.MuiGrid-root.MuiGrid-container.MuiGrid-spacing-xs-2 > div:nth-child(1) > h3")));
		String actualtitle = h3title.getText();
		String expectedtitle = "ARitize 3D Dashboard";
		System.out.println("Actual H3 Title: " + actualtitle);
		assert actualtitle.equals(expectedtitle) : "Title does not match!";
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.linkText("Products")).click();

		productPage.clickOnProductRequest();

		productPage.enterTitleField("Puma Shoes");
		productPage.enterURLfield("https://in.puma.com/in/en/pd/tour-mens-sneakers/386918?swatch=01");

		String randomSKU = productPage.generateRandomSKU(8);
		productPage.enterSKU(randomSKU);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		productPage.checkboxpublishtomodeltoamazon();

		String randomAsin = productPage.generateRandomASIN(10);
		productPage.enterAsin(randomAsin);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		productPage.selectmarketplaceid("India");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		productPage.enterCategory("Cricket Products");

		productPage.enterDimensions("8", "5", "4");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		productPage.enterNote("This is a test product");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		productPage.clickOnUrlProduct();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		productPage.enterProductUrl("https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_500,h_500/global/193753/02/sv01/fnd/IND/fmt/png/UltraRide-ProFoam-Men's-Running-Shoes");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		productPage.clickSendRequestButton();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
//		WebElement successmessage = wait.until(ExpectedConditions
//				.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div/div/div/div")));
//		String actualMessage = successmessage.getText();
//		String expectedMessage = "Product request submitted successfully!"; // Change to actual message
//		Assert.assertEquals(actualMessage, expectedMessage, "Success message did not match the expected message.");
//
//		System.out.println("Success Message: " + actualMessage);
		// (Optional) Add assertions here to validate submission success
		// Example: Assert success message, page redirection, etc.
		// Assert.assertTrue(driver.findElement(By.id("successMessage")).isDisplayed(),
		// "Request submission failed");
	}

//    }    
}
