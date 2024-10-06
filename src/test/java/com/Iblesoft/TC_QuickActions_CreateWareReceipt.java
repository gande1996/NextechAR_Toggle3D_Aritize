package com.Iblesoft;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_QuickActions_CreateWareReceipt {
	
	WebDriver driver;
	@BeforeMethod
	public void launchbrowser() {
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(co);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://manage.smarteweb.com/");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtusername")).sendKeys("iblesoft");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtpassword")).sendKeys("Boxon@123");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnlogin")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement errormessage = driver.findElement(By.cssSelector("#ctl00_lblDesc"));
		Assert.assertTrue(errormessage.isDisplayed(),"Message Not Found");
		System.out.println("Enter the Name:" +errormessage.getText());
	}
	@Test
	public void createWarehouseReceipt() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		WebElement quickactionbtn=driver.findElement(By.id("ctl00_lnkQuickActions"));
		Assert.assertTrue(quickactionbtn.isDisplayed());
		Assert.assertTrue(quickactionbtn.isEnabled());
		System.out.println("Enter button Name:"+quickactionbtn.getText());
		quickactionbtn.click();
		WebElement Warehousereceiptbtn=driver.findElement(By.id("ctl00_lnkBILL"));
		Assert.assertTrue(Warehousereceiptbtn.isDisplayed());
		Assert.assertTrue(Warehousereceiptbtn.isEnabled());
		System.out.println("Enter the button text:" +Warehousereceiptbtn.getText());
		Warehousereceiptbtn.click();
		driver.switchTo().frame("ctl00_ASPxPopupControl1_CIF-1");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement AddWarehouseReceipt=driver.findElement(By.cssSelector("#pnlcustomerInner > div:nth-child(2) > div > div > div > div > div > div.col-md-12.col-sm-12.no-padding > div.row > h4:nth-child(1)"));
		Assert.assertTrue(AddWarehouseReceipt.isDisplayed());
		Assert.assertTrue(AddWarehouseReceipt.isDisplayed());
		System.out.println("Enter the Title Name:" +AddWarehouseReceipt.getText());
		String randomAlphanumeric = generateRandomAlphanumeric(10); // Length 10
		System.out.println("Generated random alphanumeric: " + randomAlphanumeric);
		// Enter random alphanumeric string into the Track No. field
		WebElement trackNoField = driver.findElement(By.id("txtTrackNo"));
		trackNoField.sendKeys(randomAlphanumeric);
		WebElement custname = driver.findElement(By.id("txtCustomerID"));
		custname.sendKeys("IBLEC1011");
		System.out.println("Enter the Customer ID:" +custname.getAttribute("value"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		List<WebElement> dropdownOptions = driver
				.findElements(By.xpath("//ul[@id='ui-id-1']/li"));
		for (WebElement option : dropdownOptions) {
			if (option.getText().equals("Pavan kumar")) {
				option.click();
				break;
			}
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement sameascust=driver.findElement(By.cssSelector("#chkSameShipp"));
		sameascust.click();
		WebElement consigneeid =driver.findElement(By.id("txtConsigneeId"));
		System.out.println("Enter the consigneeID:" +consigneeid.getAttribute("value"));
		WebElement thdpartyElement=driver.findElement(By.id("chbConsignee"));
		thdpartyElement.click();
		WebElement sameascusttd=driver.findElement(By.id("txtDeliveryId"));
		System.out.println("Enter the Thirdparty ID:" +sameascusttd.getAttribute("value"));
		
		
		
		
	}
	
	// Helper method to generate random alphanumeric string
	private String generateRandomAlphanumeric(int length) {
		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		
		for (int i = 0; i < length; i++) {
			int index = random.nextInt(chars.length());
			sb.append(chars.charAt(index));
		}
		return sb.toString();
	}
	
	@AfterMethod
	public void broswerclosure() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.close();

	}

}
