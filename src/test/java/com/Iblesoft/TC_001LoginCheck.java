package com.Iblesoft;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Durations;

public class TC_001LoginCheck {
	WebDriver driver;
	@BeforeMethod
	public void launchbroswer() {
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(co);
		driver.get("https://manage.smarteweb.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	@Test
	public void ValidLoginTest() {
		
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtusername")).sendKeys("iblesoft");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtpassword")).sendKeys("Boxon@123");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnlogin")).click();
		
	}
	@Test
	public void InvalidLoginTest() {
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtusername")).sendKeys("iblesoftTT");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtpassword")).sendKeys("Boxon@123156");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnlogin")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement errormessage=driver.findElement(By.cssSelector("#ctl00_ContentPlaceHolder1_lblMsg"));
		String expectedText = "Invalid Username Or Password";
		String actualText =driver.findElement(By.cssSelector("#ctl00_ContentPlaceHolder1_lblMsg")).getText();
		Assert.assertEquals(actualText, expectedText, "Error message does not match.");
	}
	@AfterMethod
	public void closebrowser() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		driver.quit();
	}
}
