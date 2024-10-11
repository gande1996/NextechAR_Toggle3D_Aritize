package pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class newProductRequest {
	
	private WebDriver driver;
	
	public newProductRequest(WebDriver driver) {
		this.driver = driver;
	}

	//Locators
	
	private By ButtonProductRequest	 = By.xpath("//*[@id=\"panel1a-content\"]/div/div/div[8]/button[2]/span[1]");
	private By popupTitle = By.xpath("//*[@id=\"customized-dialog-title\"]/h2/p");
	private By titleField = By.id("title");
	private By urlField = By.id("url");
	private By SKUfield = By.id("sku");
	private By checkboxPublishAmazon = By.xpath("/html/body/div[2]/div[3]/div/div[3]/div/div/div[4]/label/span[1]/span[1]/input");
	private By Asinfield = By.id("asin");
	private By Marketplacedp = By.id("keyField");
	private By categoryField = By.id("client_category");
	private By heightField = By.id("heightValue");
	private By widthField =  By.id("widthValue");
	private By depthField = By.id("depthValue");
	private By noteField = By.id("note");
	private By productUrl = By.xpath("/html/body/div[2]/div[3]/div/div[3]/div/div/div[9]/div/div[1]/div/div/div/button[2]/span[1]");
	private By enterProductURL = By.id("url-0");
	private By sendRequest = By.xpath("/html/body/div[2]/div[3]/div/div[4]/button[2]/span[1]");
	
	
	
	public void clickOnProductRequest() {
		driver.findElement(ButtonProductRequest).click();
	}
	
	public String getPopupTitle() {
		return driver.findElement(popupTitle).getText();
	}
	
	public void enterTitleField(String title) {
		driver.findElement(titleField).sendKeys(title);
	}
	
	public void enterURLfield (String url) {
		driver.findElement(urlField).sendKeys(url);
	}
	
	public void enterSKU(String SKU) {
		driver.findElement(SKUfield).sendKeys(SKU);
	}
	
	public void checkboxpublishtomodeltoamazon() {
		driver.findElement(checkboxPublishAmazon).click();
	}
	public void enterAsin(String Asin) {
		driver.findElement(Asinfield).sendKeys(Asin);
	}
	public void selectmarketplaceid(String marketplace) {
		driver.findElement(Marketplacedp).sendKeys(marketplace);
		List<WebElement> dropdownOptionsMP =driver.findElements(By.xpath("//li[contains(@class, 'MuiAutocomplete-option')]"));
		for(WebElement option:dropdownOptionsMP ) {
			if(option.getText().equals("India")) {
				option.click();
				break;
			}
		}
	}
	
	public void enterCategory(String category) {
        driver.findElement(categoryField).sendKeys(category);
        List<WebElement> dropdownOptions = driver.findElements(By.xpath("//li[contains(@class, 'MuiAutocomplete-option')]"));
        for(WebElement option:dropdownOptions) {
        	if(option.getText().equals("Cricket Products")) {
        		option.click();
        		break;
        	}
        	
        }
    }

    public void enterDimensions(String height, String width, String depth) {
        driver.findElement(heightField).sendKeys(height);
        driver.findElement(widthField).sendKeys(width);
        driver.findElement(depthField).sendKeys(depth);
    }

    public void enterNote(String note) {
        driver.findElement(noteField).sendKeys(note);
    }

    public void clickOnUrlProduct() {
    	driver.findElement(productUrl).click();
    }
    public void enterProductUrl(String ProductUrl) {
    	driver.findElement(enterProductURL).sendKeys(ProductUrl);
    }

    public void clickSendRequestButton() {
        driver.findElement(sendRequest).click();
    }
    public String generateRandomSKU(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(chars.length());
            sb.append(chars.charAt(index));
        }
        return sb.toString();
    }
    public String generateRandomASIN(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sbn=new StringBuilder();
        Random randomasin= new Random();
        for(int i=0; i<length; i++) {
        	int index=randomasin.nextInt(chars.length());
        	sbn.append(chars.charAt(index));
        }
        return sbn.toString();
    }
//    //*[@id="app"]/div[2]/div/div/div/div/div/div
       
}
