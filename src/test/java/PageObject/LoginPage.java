package PageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="login_Layer")
	WebElement lgnButton;

	@FindBy(css = ".form-row>input[placeholder='Enter your active Email ID / Username']")
	WebElement email;
	
	@FindBy(how = How.CSS,using = ".form-row>input[placeholder='Enter your password']")
	WebElement password;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement lgnBtn;
	
	@FindBy(css = ".forgot-pass>a[target='_blank']")
	WebElement forgetPass;
	
	public void clickForgetLink() {
		forgetPass.click();
	}
	
	@FindBy(css = ".input-field>div>input#usernameField")
	WebElement forgetEmailid;
	
	public void sendForgetEmailId(String emailid) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
		jsExecutor.executeScript("arguments[0].value='"+emailid+"';",forgetEmailid);
	}

	@FindBy(css = "EmailRadio")
	WebElement radioEmailid;
	
	public void selectRadio() {
		JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
		jsExecutor.executeScript("arguments[0].click()",radioEmailid);
	}
	
	public void homeLogin() {
		lgnButton.click();
	}
	
	public void enterEmail(String emailid) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
		jsExecutor.executeScript("arguments[0].value='"+emailid+"';",email);
	}
	
	public void enterPassword(String pass) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
		jsExecutor.executeScript("arguments[0].value='"+pass+"';",password);
	}
	
	public void clickLogin() {
		JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
		jsExecutor.executeScript("arguments[0].click()",lgnBtn);
	}
	
	
	
}
