package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.WebDriverUtils;

public class MyAccountPage extends WebDriverUtils {
	private static Logger log = LogManager.getLogger(MyAccountPage.class.getName());
	private WebDriver driver;

	public MyAccountPage(WebDriver driver) {
		super(driver);
		this.driver = driver;

	}

	@FindBy(xpath = "//div[@id='top-links']/ul/li[2]/a")
	private WebElement myAccountMenu;

	@FindBy(xpath = "//div[@id='top-links']/ul/li[2]/ul/li")
	private List<WebElement> myAccountMenuList;
	
	@FindBy(linkText = "Logout")
	private WebElement myAccountLogout;

	@FindBy(xpath = "//ul[@class='breadcrumb']/li[2]/a")
	private WebElement AccountBreadcrumb;

	@FindBy(xpath = "//ul[@class='breadcrumb']/li[1]/a")
	private WebElement myAccountHomeIconlink;

	@FindBy(css = "input[name='search'][placeholder='Search']")
	private WebElement searchTextBox;

	@FindBy(xpath = "//span[@class='input-group-btn']/button")
	private WebElement searchTorchIcon;

	@FindBy(css = "#content>h2")
	private List<WebElement> myAccountHeaderList;

	@FindBy(xpath = "//div[@id='content']/ul[1]/li")
	private List<WebElement> myAccountHeaderOptionList;

	@FindBy(xpath = "//div[@id='content']/ul[2]/li")
	private List<WebElement> myOrdersHeaderOptionList;

	@FindBy(xpath = "//div[@id='content']/ul[3]/li")
	private List<WebElement> myNewsLetterHeaderOptionList;

	public String myAccountPageUrl() {
		log.info("Fetch the URL");
		return waitForTitleContains(Constants.ACC_PAGE_FRACTION_URL);
	}

	public void clickOnMyAccountMenu() throws InterruptedException {
		log.info("Click on the My Account menu list");
		click(myAccountMenu);
	}

	public void clickOnLogOutLink() throws InterruptedException {
		log.info("Click on the logout link");
		click(myAccountLogout);
	}
	public boolean isLogOutLinkPresent() throws InterruptedException {
		log.info("is logout link prsent");
		clickOnMyAccountMenu();
		return isDisplayed(myAccountLogout);
		
	}

	public boolean isAccountBreadcrumbPresent() throws InterruptedException {
		log.info("Verify weather the Account BreadCrumb is present");
		return isDisplayed(AccountBreadcrumb);
	}

	public boolean isSearchEditBoxPresent() throws InterruptedException {
		log.info("Click On The Search Edit Box");
		return isDisplayed(searchTextBox);
	}

	public boolean isMyAccountHomeIconlinkPresent() throws InterruptedException {
		log.info("Verify weather the Home Icon BreadCrumb is present");
		return isDisplayed(myAccountHomeIconlink);
	}

	public boolean isSearchTorchIconPresent() throws InterruptedException {
		log.info("Click On The Search torch Icon");
		return isDisplayed(searchTorchIcon);
	}

	public List<String> getMyAccountMenuList() throws InterruptedException {
		log.info("Click on My account MenuList");
		clickOnMyAccountMenu();
		List<String> myAccountMenuOptText = new ArrayList<String>();
		for (WebElement ele : myAccountMenuList) {
			// get each element text
			String text = ele.getText();
			myAccountMenuOptText.add(text);
		}
		return myAccountMenuOptText;

	}

	public List<String> getMyAccountHeaderList() throws InterruptedException {
		log.info("Click on My Account Header List");
		clickOnMyAccountMenu();
		List<String> myAccountHeaderListText = new ArrayList<String>();
		for (WebElement ele : myAccountHeaderList) {
			String text = ele.getText();
			myAccountHeaderListText.add(text);
		}
		return myAccountHeaderListText;
	}

	public List<String> getMyOrdersHeaderOptionList() throws InterruptedException {
		log.info("click on my order header");
		clickOnMyAccountMenu();
		List<String> myOrdersHeaderOptionListText = new ArrayList<String>();
		for (WebElement ele : myOrdersHeaderOptionList) {
			String text = ele.getText();
			myOrdersHeaderOptionListText.add(text);
		}
		return myOrdersHeaderOptionListText;
	}

	public List<String> getMyAccountHeaderOptionList() throws InterruptedException {
		log.info("click on my Account header");
		clickOnMyAccountMenu();
		List<String> myAccountHeaderOptionListText = new ArrayList<String>();
		for (WebElement ele : myAccountHeaderOptionList) {
			String text = ele.getText();
			myAccountHeaderOptionListText.add(text);
		}
		return myAccountHeaderOptionListText;
	}

	public List<String> getMyNewsLetterHeaderOptionList() throws InterruptedException {
		log.info("click on my news letter header");
		clickOnMyAccountMenu();
		List<String> myNewsLetterHeaderOptionListText = new ArrayList<String>();
		for (WebElement ele : myNewsLetterHeaderOptionList) {
			String text = ele.getText();
			myNewsLetterHeaderOptionListText.add(text);
		}
		return myNewsLetterHeaderOptionListText;
	}

	public ResultsPage doProductSearch(String productname) throws InterruptedException {
		log.info("Search the Product name:" + productname);
		if (isSearchEditBoxPresent()) {
			log.info("Perform the type Action On Search button");
			sendData(searchTextBox, productname);
			log.info("Click On the Search Button");
			click(searchTorchIcon);
			return new ResultsPage(driver);
		}
		return null;

	}
}
