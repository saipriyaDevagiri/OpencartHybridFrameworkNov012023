package com.qa.opencart.pages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.opencart.utils.WebDriverUtils;

public class SearchPage extends WebDriverUtils {
private static Logger log = LogManager.getLogger(ResultsPage.class.getName());
private WebDriver driver;
	public ResultsPage(WebDriver driver) {
		super(driver);
		
			
	}
	@FindBy(xpath = "//ul[@class='breadcrumb']/li[2]/a")
	private WebElement searchBreadCrum;
	
	@FindBy(css="#content>h1")
	private WebElement searchHeader;
	
	@FindBy(xpath = "//div[@id='content']/div[3]/div")
	private List<WebElement> searchProductList;
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	private WebElement myAccountMenu;
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='My Account']")
	private WebElement myAccountOption;
	
	public String getSearchResultsPageTitle(String productName) {
		return waitForTitleContains(productName);
			
		}
	public int getSearchProductListSize() {
		return searchProductList.size();	
	}
	public void selectProduct(String productname) throws InterruptedException {
		log.debug("selecting the product :"+productname);
		click(getElement(By.linkText(productname)));
		Thread.sleep(2000);
	}
	public void navigateToMyAccountPage() throws InterruptedException {
		log.info("click on my account menu");
		click(myAccountMenu);
		waitForElementVisible(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='My Account']"));
		click(myAccountOption);
	}
}
