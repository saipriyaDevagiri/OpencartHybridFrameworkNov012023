package com.qa.opencart.testcase;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.factory.TestBase;
import com.qa.opencart.pages.HomePage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.LogoutPage;
import com.qa.opencart.pages.MyAccountPage;
import com.qa.opencart.pages.ResultsPage;
import com.qa.opencart.utils.Constants;

public class MyAccountPageTest extends TestBase {
	private static Logger log = LogManager.getLogger(MyAccountPageTest.class.getName());
	
@Test(description = "TC_01_Verify my account url", priority = 1)
public void verifyMyAccUrlTest() {
	log.info("Verify the my account page url");
	Assert.assertTrue(myaccountPg.myAccountPageUrl().contains(Constants.ACC_PAGE_FRACTION_URL));
}
@Test(description = "TC_02_Verify my account Title", priority = 2)
public void verifyMyAccTitleTest() {
	log.info("Verify the my account page title");
	Assert.assertTrue(myaccountPg.getTitle().contains(Constants.MY_ACCOUNT_PAGE_TITLE));
}
@Test(description = "TC_03_Verify my account Page Elements", priority = 3)
public void verifyMyAccpageElementsTest() throws InterruptedException {
	log.info("Verify the my account page Elements");
	Assert.assertTrue(myaccountPg.isAccountBreadcrumbPresent());
	Assert.assertTrue(myaccountPg.isSearchEditBoxPresent());
	Assert.assertTrue(myaccountPg.isSearchTorchIconPresent());
	Assert.assertTrue(myaccountPg.isLogOutLinkPresent());
	Actions act = new Actions(driver);
	act.sendKeys(Keys.ESCAPE).perform();
}
@Test(description = "TC_04_Verify my account menu list", priority = 4)
public void verifyMyAccMenuList() throws InterruptedException {
	log.info("Verify my account menu list");
	Assert.assertEquals(myaccountPg.getMyAccountMenuList(), Constants.EXPECTED_MYACC_MENU_OPTS_LIST);
}
@Test(description = "TC_05_Verify my account header list", priority = 5)
public void verifyMyAccountHeaderList() throws InterruptedException {
	log.info("Verify my account header list");
	Assert.assertEquals(myaccountPg.getMyAccountHeaderList(), Constants.EXPECTED_MYACC_HEADER_LIST);
}
@Test(description = "TC_06_Verify my account ordered list", priority = 6)
public void verifyMyOrdersHeaderOptionList() throws InterruptedException {
	log.info("Verify my orders header option list");
	Assert.assertEquals(myaccountPg.getMyOrdersHeaderOptionList(), Constants.EXPECTED_MYACC_ORDER_LIST);
}
@Test(description = "TC_07_Verify my account header options list", priority = 7)
public void verifyMyAccountHeaderOptionList() throws InterruptedException {
	log.info("Verify my Account header option list");
	Assert.assertEquals(myaccountPg.getMyAccountHeaderOptionList(), Constants.EXPECTED_MYACC_HEADER_OPTION_LIST);
}
@Test(description = "TC_08_Verify my account NewsLetter options list", priority = 8)
public void verifyMyNewsLetterHeaderOptionList() throws InterruptedException {
	log.info("Verify my news letters header option list");
	Assert.assertEquals(myaccountPg.getMyNewsLetterHeaderOptionList(), Constants.EXPECTED_NEWSLETTER_HEADER_OPTION_LIST);
}
@Test(description="TC_09_verify the broken links in my account page",priority=9)
public void verifyBrokenLinksInMyAccountPageTest() throws IOException {
	log.info("Verify the broken links in my account page");
	List<WebElement>pageLinksList=driver.findElements(By.tagName("a"));
	for(WebElement ele:pageLinksList) {
		String URL= ele.getAttribute("href");
		verifyUrls(URL);
	}
}
@DataProvider(name= "products")
public Object[][] productTestData(){
	return new Object[][] {
		 {"MacBook"},
		 {"iMac"},
		 {"Samsung"}
	 };
	
}
@Test(description="TC_10_Perform product search",priority=10,dataProvider="products")
public void PerformProductSearchTest(String productName) throws InterruptedException {
	  log.info("Perform product search for:"+productName);
	  resultPg=myaccountPg.doProductSearch(productName);
	  String actualResultPgTitle=resultPg.getTitle();
	  log.info("search results page title :"+actualResultPgTitle);
	  new SoftAssert().assertEquals(actualResultPgTitle, "Search - "+productName);
	  Assert.assertTrue(resultPg.getSearchProductListSize()>0);
	 
}
@BeforeClass
public void beforeClass() throws InterruptedException {
	log.info("Initalizing the page objects");
	loginPg = new LoginPage(driver);
	homePg = new HomePage(driver);
	myaccountPg = new MyAccountPage(driver);
	logoutPg = new LogoutPage(driver);
	resultPg=new ResultsPage(driver);
	log.info("Naviagte  to home page");
	homePg.navigateToLoginLink();
	loginPg.loginOperations(rb.getString("username"), rb.getString("pwd"));
	myaccountPg.waitForPageLoad(3000);
	log.info("verify my account page title");
	Assert.assertEquals(myaccountPg.getTitle(), Constants.MY_ACCOUNT_PAGE_TITLE);
}

@AfterClass
public void doLogout() throws InterruptedException {
	  log.info("click on logout link");
	  myaccountPg.clickOnLogOutLink();
	  logoutPg.waitForPageLoad(2000);
	  Assert.assertEquals(logoutPg.getTitle(), Constants.ACCOUNT_LOGOUT_PAGE_TITLE);
	  log.info("Click on Continue button in Logout page");
	  logoutPg.clickOnContinueBtn();
	  homePg.waitForPageLoad(2000);
	  Assert.assertEquals(homePg.getTitle(), Constants.HOME_PAGE_TITLE);
}

}
