package com.qa.opencart.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.opencart.utils.WebDriverUtils;

public class ProductDetailsPage extends WebDriverUtils {
	private static Logger log = LogManager.getLogger(ProductDetailsPage.class.getName());
	private WebDriver driver;

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id='content']/div[1]/div[2]//h1")
	private WebElement productHeader;

	@FindBy(css = "a.thumbnail")
	private List<WebElement> productImageList;

	@FindBy(xpath = "//div[@id ='content']/div[1]/div[2]/ul[1]/li")
	private List<WebElement> productMetaDataList;

	@FindBy(xpath = "(////div[@id ='content']/div[1]/div[2]/ul[2]/li")
	private List<WebElement> productPriceList;

	@FindBy(css = "input[id='input-quantity']")
	private WebElement quantityEditBox;

	@FindBy(id = "button-cart")
	private WebElement addToCartBtn;

	public String getProductName() {
		return productHeader.getText();
	}

	public int getProductImageCount() {
		return productImageList.size();
	}

	private Map<String, String> productMap;

	public void getProductMetaData() {
		log.info("Product metadata count is:" + productMetaDataList.size());
		for (WebElement ele : productMetaDataList) {
			String txt = ele.getText();
			log.info("split the metatext based on :");
			String[] metaData = txt.split(":");
			log.info("fetch meta key and value");
			String metaKey = metaData[0].trim();
			String metaValue = metaData[1].trim();
			productMap.put(metaKey, metaValue);
		}
	}

	public void getProductPriceData() {
		log.info("Product meta price count is:" + productPriceList.size());
		String price = productPriceList.get(0).getText().trim();
		String exTaxprice = productPriceList.get(1).getText().trim();
		log.info("store the price values in the map");
		productMap.put("actualprice", price);
		productMap.put("actualtaxprice", exTaxprice);

	}
	
	public Map<String,String> getProductInformation(){
		productMap=new HashMap<String,String>();
		getProductMetaData();
		getProductPriceData();
		return productMap;
	}
	public void clickQuantityEditBox(String num) throws InterruptedException {
		log.info("click on Quantity Editbox");
		clearText(quantityEditBox);
		sendData(quantityEditBox, num);
	}
	public void clickAddToCartBtn() throws InterruptedException {
		log.info("click on add to cart button");
		click(addToCartBtn);
	}

}
