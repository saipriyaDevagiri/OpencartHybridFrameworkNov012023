package com.qa.opencart.testcase;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qa.opencart.factory.TestBase;
import com.qa.opencart.pages.ForgotPasswordPage;
import com.qa.opencart.pages.HomePage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.LogoutPage;
import com.qa.opencart.pages.MyAccountPage;
import com.qa.opencart.pages.RegistrationPage;
import com.qa.opencart.utils.Constants;

public class LoginPageTest extends TestBase {
	private static Logger log = LogManager.getLogger(LoginPageTest.class.getName());

	@Test(description = "TC_01_Verify Login Url", priority = 1)
	public void verifyLoginUrl() {
		log.info("Verifying the Login url");
		Assert.assertTrue(loginPg.getLoginPageUrl().contains(Constants.LOGIN_PAGE_FRACTION_URL));
	}

	@Test(description = "TC_02_Verify Login page title", priority = 2)
	public void verifyLoginPageTitle() {
		log.info("Verifying the Login page title");
		Assert.assertEquals(loginPg.getTitle(), Constants.LOGIN_PAGE_TITLE);
	}

	@Test(description = "TC_03_verifying the login page elements", priority = 3)
	public void verifyLoginPageElementTest() {
		log.info("Verifying the Login Page Elements");
		Assert.assertTrue(loginPg.isreturnCustomerHeaderPresent());
		Assert.assertTrue(loginPg.isLoginIconPresent());
		Assert.assertTrue(loginPg.isNewCustomerHeaderPresent());
	}

	@Test(description = "TC_04_Navigate to registration page from login", priority = 4)
	public void navigateToRegistrationPageTest() throws InterruptedException {
		log.info("Navigate to registration page");
		loginPg.clickOncontinueButton();
		regPg.waitForPageLoad(3000);
		log.info("Verify the registration page title");
		Assert.assertEquals(regPg.getTitle(), Constants.REGISTRATION_PAGE_TITLE);
		log.info("click back to go to the login page");
		// driver.navigate().back();
		regPg.navigateBrowserBack();

	}

	@Test(description = "TC_05_Navigate to forgot password page from login", priority = 5)
	public void navigateToForgetPasswordPageTest() throws InterruptedException {
		log.info("Navigate to forgetpassword page");
		loginPg.clickOnForgetPwdLink();
		forgotpwdPg.waitForPageLoad(3000);
		log.info("Verify the forgot page title");
		Assert.assertEquals(forgotpwdPg.getTitle(), Constants.FORGOT_PWD_PAGE_TITLE);
		log.info("click back to go to the login page");
		// driver.navigate().back();
		forgotpwdPg.clickOnBackBtn();
	}

	@Test(description = "TC_06_Empty Credentials login to OpenCart", priority = 6)
	public void emptyCredentialsLoginTest() throws InterruptedException {
		log.info("click login withb empty credentials");
		loginPg.loginOperations("", "");
		loginPg.waitForPageLoad(3000);
		log.info("Verify the Error message");
		Assert.assertTrue(loginPg.getErrorMessageText().contains(Constants.LOGIN_NOMATCH_ERR_MSG));

	}

	@Test(description = "TC_07_Happypath Do Login Operations", priority = 7)
	public void doLoginOperation() throws InterruptedException {
		log.info("Perform the Login Operation");
		loginPg.loginOperations(rb.getString("username"), rb.getString("pwd"));
		myaccountPg.waitForPageLoad(3000);
		log.info("verify my account page title");
		Assert.assertEquals(myaccountPg.getTitle(), Constants.MY_ACCOUNT_PAGE_TITLE);
	}

	@Test(description = "logout test", priority = 8, dependsOnMethods = { "doLoginOperation" })
	public void logoutTest() throws InterruptedException {
		log.info("Click on the logout link");
		myaccountPg.clickOnLogOutLink();
		logoutPg.waitForPageLoad(3000);
		log.info("verify the logout page title");
		Assert.assertEquals(logoutPg.getTitle(), Constants.ACCOUNT_LOGOUT_PAGE_TITLE);
		log.info("Click on continue button");
		logoutPg.clickOnContinueBtn();
		homePg.waitForPageLoad(3000);
		log.info("Verify the home page title");
		Assert.assertEquals(homePg.getTitle(), Constants.HOME_PAGE_TITLE);
	}

	@BeforeClass
	public void beforeClass() throws InterruptedException {
		log.info("Initalizing the page object classes");
		homePg = new HomePage(driver);
		loginPg = new LoginPage(driver);
		regPg = new RegistrationPage(driver);
		forgotpwdPg = new ForgotPasswordPage(driver);
		myaccountPg = new MyAccountPage(driver);
		logoutPg = new LogoutPage(driver);
		log.info("Navigate to Home page");
		homePg.navigateToLoginLink();
	}

	@BeforeMethod
	public void beforeMethod() {
		log.info("Wait for login page load");
		loginPg.waitForPageLoad(3000);
	}

}
