package tests;

import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.baseTest;
import pages.LoginPage;

public class verifyTheValidLoginPage extends baseTest {

	@Test
	public void Verify_With_Valid_Login_Details() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmail("rahul28@mailinator.com");
		loginPage.enterPassword("Akhil@123");
		loginPage.clickOnLoginButton();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement h3title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
				"#app > div > div > div.jss9 > div > div > div.MuiGrid-root.MuiGrid-container.MuiGrid-spacing-xs-2 > div:nth-child(1) > h3")));

		// Get the actual title text
		String actualtitle = h3title.getText();
		String expectedtitle = "ARitize 3D Dashboard";

		// Output the actual title for debugging
		System.out.println("Actual H3 Title: " + actualtitle);

		// Assertion to validate the title
		Assert.assertEquals(actualtitle, expectedtitle, "Title does not match!");
	}

}
