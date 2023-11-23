package com.qa.opencart.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.WebDriverUtils;

public class LoginPage extends WebDriverUtils {
	private static Logger log= LogManager.getLogger(LoginPage.class.getName());

	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(css=".breadcrumb>li:nth-child(1)>a")
	private WebElement loginHomeIcon;
	
	@FindBy(css=".breadcrumb>li:nth-child(3)>a")
	private WebElement loginIcon;
	
	@FindBy(xpath="//h2[normalize-space()='New Customer']")
	private WebElement newCustomerHeader;
	
	@FindBy(linkText ="Continue")
	private WebElement newCustomerContinueBtn;
	
	@FindBy(xpath="//h2[normalize-space()='Returning Customer']")
	private WebElement returningCustomerHeader;
	
	@FindBy(id = "input-email")
	private WebElement emailTextBox;
	
	@FindBy(name = "password")
	private WebElement passwordEditBox;
	
	@FindBy(partialLinkText = "Forgotten Password")
	private WebElement forgotPasswordBox;
	
	@FindBy(xpath = "//input[@type='submit'] ")
	private WebElement loginBtn;
	
	@FindBy(css = "div.alert.alert-danger")
	private WebElement errorMesssageText;
	
	public void clickLoginHomeIcon() throws InterruptedException{
		log.info("Click on the Home page icon");
		click(loginHomeIcon);
	}
	
	public boolean isLoginIconPresent() {
		log.info("Login Icon is present");
		return isDisplayed(loginIcon);
	}
	
	public boolean isNewCustomerHeaderPresent() {
		log.info("new customer header text is present or not");
		return isDisplayed(newCustomerHeader);
		
	}
	
	public boolean isreturnCustomerHeaderPresent() {
		log.info("Return customer header text is present or not");
		return isDisplayed(returningCustomerHeader);
		
	}
	
	public void loginOperations(String email,String pwd) throws InterruptedException {
		log.info("Performing the Login Operations");
		sendData(emailTextBox, email);
		sendData(passwordEditBox, pwd);
		log.info("Click on Login button");
		click(loginBtn);	
	}
	public void clickOncontinueButton() throws InterruptedException {
		log.info("click on the customer continue button");
		click(newCustomerContinueBtn);
	}
	
	public void clickOnForgetPwdLink() throws InterruptedException {
		log.info("click on the forgot password link");
		click(forgotPasswordBox);
	}
	public String getErrorMessageText() {
		log.info("Get the error message text");
		return errorMesssageText.getText();
		
	}
	public String getLoginPageUrl() {
		return waitForUrlContains(Constants.LOGIN_PAGE_FRACTION_URL);
		
	}

}
