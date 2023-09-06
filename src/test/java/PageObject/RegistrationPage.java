package PageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
	
	WebDriver driver;
	
	public RegistrationPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath  = "//*[@class='nI-gNb-log-reg']/a[2]")
	WebElement registrationLinkll;
	
	@FindBy(xpath = "//div[@class='__inner']/input[@id='name']")
	WebElement fullNameTxtField;
	
	@FindBy(xpath = "//div[@class='__inner']/input[@id='email']")
	WebElement emailTxtField;
	
	@FindBy(xpath = "//div[@class='__inner']/input[@id='password']")
	WebElement passTxtField;
	
	@FindBy(xpath = "//div[@class='__inner']/input[@id='mobile']")
	WebElement mobileTxtField;
	
	@FindBy(xpath = "//div[@class='resume-upload']/div/button")
	WebElement fUpload;
	
	public void homeRegistration() {
		Actions actions = new Actions(driver);
		actions.moveToElement(registrationLinkll).click().build().perform();
	}	
	
	public void enterFullName(String fullname) {
		fullNameTxtField.sendKeys(fullname);
	}
	
	public void enterEmail(String email) {
		emailTxtField.sendKeys(email);
	}
	
	public void enterpass(String pass) {
		passTxtField.sendKeys(pass);
	}
	
	public void enterMobile(String mobile) {
		mobileTxtField.sendKeys(mobile);
	}
	
	public void clickUpload() {
		fUpload.click();
	}
	
}
