package com.qa.opencart.testcase;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.opencart.factory.TestBase;
import com.qa.opencart.pages.HomePage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.RegistrationPage;
import com.qa.opencart.utils.Constants;

public class HomePageTest extends TestBase {
	private static Logger log = LogManager.getLogger(HomePageTest.class.getName());

	@Test(description = "TC_01 Verify the Open Cart Logo", priority = 1)
	public void verifyOpenCartTest() {
		log.info("Verify the open cart logo");
		Assert.assertTrue(homePg.isOpenCartLogoPresent());
	}

	@Test(description = "TC_02 Verify the Open Cart Title", priority = 2)
	public void verifyOpenCartTitle() {
		log.info("Verify the open cart Title");
		Assert.assertEquals(homePg.getTitle(), Constants.HOME_PAGE_TITLE);
	}

	@Test(description = "TC_03 Verifying the Feature Count", priority = 3)
	public void verifyTheFeatureCountTest() {
		log.info("Verify the Feature count test");
		Assert.assertTrue(homePg.getFeaturedSectionCount() == 4);
	}

	@Test(description = "TC_04 Navigating to Registration Link", priority = 4)
	public void navigateToRegisterLinkTest() throws InterruptedException {
		log.info("Navigate to register page");
		homePg.navigateToRegisterLink();
		regPg.waitForPageLoad(2000);
		log.info("Verify the Registration page");
		Assert.assertEquals(regPg.getTitle(), Constants.REGISTRATION_PAGE_TITLE);
		regPg.clickOnRegisterHomeIcon();
		
	}

	@Test(description = "TC_05 Navigating to login Link", priority = 5)
	public void navigateToLoginLinkTest() throws InterruptedException {
		log.info("Navigate to login page");
		homePg.navigateToLoginLink();
		loginPg.waitForPageLoad(2000);
		log.info("Verify the login page");
		Assert.assertEquals(loginPg.getTitle(), Constants.LOGIN_PAGE_TITLE);
		loginPg.clickLoginHomeIcon(); 
	}

	@BeforeClass
	public void beforeClass() {
		log.info("Initializing the pageclass object");
		homePg = new HomePage(driver);
		loginPg = new LoginPage(driver);
		regPg = new RegistrationPage(driver);

	}

	@AfterMethod
	public void afterMethod() {
		Assert.assertEquals(homePg.getTitle(), Constants.HOME_PAGE_TITLE);
		homePg.waitForPageLoad(2000);

	}

	@BeforeMethod
	public void beforeMethod() {
		homePg.waitForPageLoad(2000);

	}

}
