package com.qa.opencart.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.qa.opencart.utils.WebDriverUtils;

public class ForgotPasswordPage extends WebDriverUtils {
private static Logger log = LogManager.getLogger(ForgotPasswordPage.class.getName());
	public ForgotPasswordPage(WebDriver driver) {
		super(driver);	
	}
	@FindBy(css = ".breadcrumb>li:nth-child(1)>a")
	private WebElement forgotHomeIcon;
	
	@FindBy(css = ".breadcrumb>li:nth-child(3)>a")
	private WebElement forgottenPasswordIcon;
	
	@FindBy(xpath = "//div[@id='content']/h1")
	private WebElement forgotPasswordHeader;
	
	@FindBy(xpath = "//legend[normalize-space()='Your E-Mail Address']")
	private WebElement emailAddressHeader;
	
	@FindBy(id = "input-email")
	private WebElement emailEditBox;
	
	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueButton;
	
	@FindBy(linkText = "Back")
	private WebElement backButton;
	
	@FindBy(css = ".alert.alert-danger")
	private WebElement forgotpageErrorMsg;
	
	public void clickForgotHomeIconPresent() throws InterruptedException {
		log.info("clicking on the Home Icon");
		click(forgotHomeIcon);		
	}
	
	public boolean isForgottenPasswordIconPresent() {
		log.info("Is Forgetten Password present or not");
		return isDisplayed(forgottenPasswordIcon);	
	}
	
	public String getForgotPasswordHeader() {
		return forgotPasswordHeader.getText();
		
	}
	
	public boolean isemailAddressHeaderPresent() {
		log.info("Is Email Address present or not");
		return isDisplayed(emailAddressHeader);	
	}
	
	public void clickOnContinueBtn() throws InterruptedException {
		log.info("Click on the Continue Button");
		click(continueButton);
	}
	public void clickOnBackBtn() throws InterruptedException {
		log.info("Click on the Back Button");
		click(backButton);
	}
	
	public String getforgotpageErrorMsg() {
		return forgotpageErrorMsg.getText();
		
	}
	
}
