package StepDefinition;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
//import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import PageObject.LoginPage;
import PageObject.RegistrationPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefi extends BaseClass {
	
	@Before
	public void setUp() {
		logger = LogManager.getLogger("StepDefi");
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		options.addArguments("--start-maximized");
		driver = new ChromeDriver(options);
		logger.info("Chrome driver loaded");
	}

	@Given("User should launch browser")
	public void user_should_launch_browser() {
		System.out.println("Launched Browser");
	}

	@When("User open url {string}")
	public void user_open_url(String naukriUrl) {
		driver.get(naukriUrl);
	}

	@When("User Click on login button")
	public void user_click_on_login_button() throws Exception {
		Thread.sleep(3000);
		lpage = new LoginPage(driver);
		lpage.homeLogin();
	}

	@When("User enters valid Emailid as {string} and Password as {string}")
	public void user_enters_valid_emailid_as_and_password_as(String emailE, String passP) throws Exception {
		lpage.enterEmail(emailE);
		Thread.sleep(1000);
		lpage.enterPassword(passP);
	}

	@When("User click on login")
	public void user_click_on_login() {
		lpage.clickLogin();
	}

	@Then("User should be able to redirect to the homepage")
	public void user_should_be_able_to_redirect_to_the_homepage() throws Exception {
		Thread.sleep(5000);
		url = driver.getCurrentUrl();
	}

	@Then("User should verify the Url")
	public void user_should_verify_the_url() {
		Assert.assertEquals("https://www.naukri.com/mnjuser/homepage", url);
		logger.info("Url is Matched");
	}

	@Then("Close the browser")
	public void close_the_browser() {
		System.out.println("Browser Closed");
	}

	@When("User Click on forget password link")
	public void user_click_on_forget_password_link() throws Exception {
		Thread.sleep(3000);
		lpage.clickForgetLink();
	}
	
	@Then("Link should be redirected to New Tab")
	public void link_should_be_redirected_to_new_tab() throws Exception {
	  Thread.sleep(2000);
	  String parentWindow = driver.getWindowHandle();
	  Set<String> allWindows = driver.getWindowHandles();
	  
	  Iterator<String> itr = allWindows.iterator();
	  while(itr.hasNext()) {
		  String childWindow = itr.next();
		  if(!parentWindow.equals(childWindow)) {
			  driver.switchTo().window(childWindow);
		  }
	  }
	}
	
	@Then("Enter valid Emailid")
	public void enter_valid_emailid(DataTable dataTable) throws Exception {
		Thread.sleep(3000);
		List<Map<String, String>> dt = dataTable.asMaps();
		int valSizze = dt.size();
		System.out.println("Size is.." + valSizze);
		for(int i=0;i<valSizze;i++) {
		String email = dt.get(i).get("Emailid");
		lpage.sendForgetEmailId(email);
		Thread.sleep(2000);
		}
		
	}
	
	@When("User click on Register link")
	public void user_click_on_register_link() throws Exception {
		Thread.sleep(5000);
		regis = new RegistrationPage(driver);
		Thread.sleep(1000);
		regis.homeRegistration();
	}
	@Then("Registration detail page is opened")
	public void registration_detail_page_is_opened() {
	   
	}
	@Then("User enter full name")
	public void user_enter_full_name() {
		regis.enterFullName("Gaurav Ahuja");
	}
	@Then("User enter emailid")
	public void user_enter_emailid() {
		regis.enterEmail("abbc@gmail.com");
	}
	@Then("User enter password")
	public void user_enter_password() {
		regis.enterpass("11112");
	}
	@Then("User enter mobile no")
	public void user_enter_mobile_no() {
		regis.enterMobile("99885566");
	}
	@Then("User attach a file")
	public void user_attach_a_file() throws Exception {
		regis.clickUpload();
		Thread.sleep(8000);
		
		String fExtension =System.getProperty("user.dir") + "\\FileUpload\\naukri.exe";
		String fUpload = System.getProperty("user.dir") +"\\FileUpload\\TestingDoc.docx";
		
		String[] arr = {fExtension,fUpload};	
		Runtime.getRuntime().exec(arr);
		
	}
	
	@After
	public void quitBrowser(Scenario sc) throws Exception {
		driver.quit();
	}

}
