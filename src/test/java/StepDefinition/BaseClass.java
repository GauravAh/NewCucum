package StepDefinition;

import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;

import PageObject.LoginPage;
import PageObject.RegistrationPage;

public class BaseClass {
	
	public WebDriver driver;
	public LoginPage lpage;
	public RegistrationPage regis;
	String url;
	public static Logger logger;

}
