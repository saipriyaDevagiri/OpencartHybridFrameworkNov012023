package com.qa.opencart.pages;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.opencart.utils.WebDriverUtils;

public class HomePage extends WebDriverUtils {
private static Logger log = LogManager.getLogger(HomePage.class.getName());
	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(css = "#logo>a>img")
	private WebElement openCartLogo;
	
	@FindBy(xpath = "//span[normalize-space()='My Account']")
	private WebElement myAccountMenu;
	
	@FindBy(linkText = "Register")
	private WebElement registerationLink;
	
	@FindBy(linkText = "Login")
	private WebElement loginLink;
	
	@FindBy(xpath = "//div[@id='content']/div[2]/div")
	private List<WebElement> featureSectionCards;
	
	public boolean isOpenCartLogoPresent() {
		log.info("Verifying is opencart logo is displayed or not");
		return isDisplayed(openCartLogo);
		
	}
	public void openMyAccountMenu() throws InterruptedException {
		log.info("Clicking on MyAccount menu");
		click(myAccountMenu);
	}
	public void navigateToRegisterLink() throws InterruptedException {
		log.info("Navigating to register page");
		openMyAccountMenu();
		click(registerationLink);
	}
	public void navigateToLoginLink() throws InterruptedException {
		log.info("Navigating to login page");
		openMyAccountMenu();
		click(loginLink);
	}
	public int getFeaturedSectionCount() {
		log.info("number of featured sections");
		return featureSectionCards.size();
		
	}
}
