package pages;

import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	private WebDriver driver;
	
	//locators
	private By emailField = By.id("index_email");
	private By passwordField = By.id("password");
	private By loginButton = By.id("btn-login");
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterEmail(String email) {
		driver.findElement(emailField).sendKeys(email);
	}
	
	public void enterPassword(String password) {
		driver.findElement(passwordField).sendKeys(password);
	}
	
	public void clickOnLoginButton() {
		driver.findElement(loginButton).click();
	}
	public String getPageTitle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        WebElement h3title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
                "#app > div > div > div.jss9 > div > div > div.MuiGrid-root.MuiGrid-container.MuiGrid-spacing-xs-2 > div:nth-child(1) > h3")));
        return h3title.getText();
	
	}
	
}
