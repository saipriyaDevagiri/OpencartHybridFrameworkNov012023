package com.qa.opencart.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.WebDriverUtils;

public class LogoutPage extends WebDriverUtils {
	private WebDriver driver;
private static Logger log = LogManager.getLogger(LogoutPage.class.getName());
	public LogoutPage(WebDriver driver) {
		super(driver);
		this.driver= driver;
		
	}
@FindBy(linkText = "Logout")
private WebElement logoutMenu;

@FindBy(css = "i.fa.fa-home")
private WebElement logoutHomeIcon;

@FindBy(xpath = "//h1[normalize-space()='Account Logout']")
private WebElement accountLogoutHeader;

@FindBy(css="#content>p")
private WebElement accountLoggedOfMessage;

@FindBy(css=".btn.btn-primary")
private WebElement continueBtn;

public boolean isLogoutMenuPresent() {
	return isDisplayed(logoutMenu);
}

public boolean isLogoutHomeIconPresent() {
	return isDisplayed(logoutHomeIcon);
}

public String getAccountLogoutHeader() {
	log.info("Get the text of logout header ");
	return accountLogoutHeader.getText();	
}

public String getAccountLoggedOfMessage() {
	log.info("Get the text of loggged of message ");
	return accountLoggedOfMessage.getText();	
}

public void clickOnContinueBtn() throws InterruptedException {
	log.info("Click on continue Button");
	click(continueBtn);
}

public String getPageTitle() {
	log.info("Get the page title");
	return waitForTitleContains(Constants.ACCOUNT_LOGOUT_PAGE_TITLE);
	
}

}
