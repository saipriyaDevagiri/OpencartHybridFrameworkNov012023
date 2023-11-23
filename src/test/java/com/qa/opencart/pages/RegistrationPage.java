package com.qa.opencart.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.qa.opencart.utils.WebDriverUtils;

public class RegistrationPage extends WebDriverUtils {
	private static Logger log = LogManager.getLogger(RegistrationPage.class.getName());

	public RegistrationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = ".breadcrumb>li:nth-child(1)>a")
	private WebElement registerHomeIcon;

	@FindBy(css = ".breadcrumb>li:nth-child(3)>a")
	private WebElement registerIcon;

	@FindBy(xpath = "//div[@id='content']/h1")
	private WebElement registerHeadetText;

	@FindBy(xpath = "//div[@id='content']/p")
	private WebElement registerAccountStaticTxt;

	@FindBy(css = "#account>legend")
	private WebElement personalDetailHeader;

	@FindBy(id = "input-firstname")
	private WebElement firstNameEditbox;

	@FindBy(name = "lastname")
	private WebElement lastNameEditbox;

	@FindBy(xpath = "//input[@type='email']")
	private WebElement emailEditBox;

	@FindBy(name = "telephone")
	private WebElement telephoneEditbox;

	@FindBy(css = "#input-fax")
	private WebElement faxEditbox;

	@FindBy(css = "#address>legend")
	private WebElement yourAddressHeader;

	@FindBy(id = "input-company")
	private WebElement companyEditbox;

	@FindBy(name = "address_1")
	private WebElement address_1Editbox;

	@FindBy(name = "address_2")
	private WebElement address_2Editbox;

	@FindBy(id = "input-city")
	private WebElement cityEditbox;

	@FindBy(name = "postcode")
	private WebElement postcodeEditbox;

	@FindBy(id = "input-country")
	private WebElement countryDropdown;

	@FindBy(id = "input-zone")
	private WebElement stateDropdown;

	@FindBy(xpath = "//legend[normalize-space()='Your Password']")
	private WebElement yourPasswordHeader;

	@FindBy(id = "input-password")
	private WebElement passwordEditbox;

	@FindBy(name = "confirm")
	private WebElement pwdConfirmEditbox;

	@FindBy(css = "fieldset:nth-child(4)>legend")
	private WebElement newsLetterHeader;

	@FindBy(xpath = "//input[@value='1' and @name='newsletter']")
	private WebElement subscribeYesRadioBtn;

	@FindBy(css = "input[value='0'][name='newsletter']")
	private WebElement subscribeNoRadioBtn;

	@FindBy(xpath = "//input[@type='checkbox']")
	private WebElement privacyPolicyCheckBox;

	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueBtn;

	@FindBy(css = "div.alert.alert-danger")
	private WebElement agreeErrMsg;

	@FindBy(css = "a.btn.btn-primary")
	private WebElement accntCreatedContinueBtn;

	@FindBy(css = ".breadcrumb> li:nth-child(3) > a")
	private WebElement accntCreatedBreadCrumbSuccessLink;

	@FindBy(xpath = "//a[normalize-space()='Contact Us']")
	private WebElement contactUsLink;
	
	@FindBy(css = "#content>h1")
	private WebElement accountCreatedHeader;
	
	@FindBy(css="div#content>p")
	private WebElement accntCreatedSuccMsg;
	

	public void clickOnRegisterHomeIcon() throws InterruptedException {
		log.info("Click on the home icon");
		click(registerHomeIcon);
	}

	public boolean isRegisterIconPresent() {
		return isDisplayed(registerIcon);
	}

	public String getRegisterHeadetText() throws InterruptedException {
		return getText(registerHeadetText);

	}

	public String getRegisterAccountStaticTxt() {
		return registerAccountStaticTxt.getText();
	}

	public boolean isPersonalDetailHeaderPresentOrNot() {
		return isDisplayed(personalDetailHeader);
	}

	public String getFirstNameEditbox() {
		return firstNameEditbox.getAttribute("value");
	}

	public void setFirstNameEditbox(String fname) throws InterruptedException {
		log.info("Type the first name value");
		sendData(firstNameEditbox, fname);

	}

	public String getLastNameEditbox() {
		return lastNameEditbox.getAttribute("value");
	}

	public void setLastNameEditbox(String lname) throws InterruptedException {
		log.info("Type the last name value");
		sendData(lastNameEditbox, lname);

	}

	public String getEmailEditBox() {
		return emailEditBox.getAttribute("value");
	}

	public void setEmailEditBox(String email) throws InterruptedException {
		log.info("Enter the Email value");
		sendData(emailEditBox, email);
	}

	public String getTelephoneEditbox() {
		return telephoneEditbox.getAttribute("value");
	}

	public void setTelephoneEditbox(String phno) throws InterruptedException {
		log.info("Enter the phno value");
		sendData(telephoneEditbox, phno);
	}

	public String getFaxEditbox() {
		return faxEditbox.getAttribute("value");
	}

	public void setFaxEditbox(String fax) throws InterruptedException {
		log.info("Enter the fax value");
		sendData(faxEditbox, fax);
	}

	public boolean isYourAddressHeaderPresentOrNot() {
		return isDisplayed(yourAddressHeader);
	}

	public String getCompanyEditbox() {
		return companyEditbox.getAttribute("value");
	}

	public void setCompanyEditbox(String company) throws InterruptedException {
		log.info("Enter the company value");
		sendData(companyEditbox, company);
	}

	public String getAddress_1Editbox() {
		return address_1Editbox.getAttribute("value");
	}

	public void setAddress_1Editbox(String address1) throws InterruptedException {
		log.info("Enter the Address1 value");
		sendData(address_1Editbox, address1);
	}

	public String getAddress_2Editbox() {
		return address_2Editbox.getAttribute("value");
	}

	public void setAddress_2Editbox(String address2) throws InterruptedException {
		log.info("Enter the Address2 value");
		sendData(address_2Editbox, address2);
	}

	public String getCityEditbox() {
		return cityEditbox.getAttribute("value");
	}

	public void setCityEditbox(String city) throws InterruptedException {
		log.info("Enter the city value");
		sendData(cityEditbox, city);
	}
	public String getPostalEditbox() {
		return postcodeEditbox.getAttribute("value");
	}

	public void setPostalEditbox(String code) throws InterruptedException {
		log.info("Enter the city value");
		sendData(postcodeEditbox, code);
	}

	public void selectCountry(String optionTxt) {
		log.info("select an option from country dropdown by label");
		selectOptionByVisibleText(countryDropdown, optionTxt);
		waitForPageLoad(1000);
	}

	public void selectState(String optionTxt) {
		log.info("select an option from State dropdown by label");
		selectOptionByVisibleText(stateDropdown, optionTxt);

	}

	public boolean isYourPasswordHeaderPresentOrNot() {
		return isDisplayed(yourPasswordHeader);
	}

	public String getPasswordEditbox() {
		return passwordEditbox.getAttribute("value");
	}

	public void SetPasswordEditbox(String pwd) throws InterruptedException {
		log.info("Enter the password");
		sendData(passwordEditbox, pwd);
	}

	public String getPwdConfirmEditbox() {
		return passwordEditbox.getAttribute("value");
	}

	public void SetPwdConfirmEditbox(String pwdconfirm) throws InterruptedException {
		log.info("Enter the confirm password");
		sendData(pwdConfirmEditbox, pwdconfirm);
	}

	public boolean isNewsLetterHeader() {
		return isDisplayed(newsLetterHeader);
	}

	public void selectSubscribe(String subscribe) throws InterruptedException {
		log.info("select newsletter subscription value");
		if (subscribe.equalsIgnoreCase("Yes")) {
			log.info("select Yes Radio button");
			click(subscribeYesRadioBtn);
		} else {
			log.info("select No Radio button");
			click(subscribeNoRadioBtn);
		}
	}

	public void clickPrivacyPolicyCheckBox() throws InterruptedException {
		log.info("Click on the Privacy policy Checkbox");
		click(privacyPolicyCheckBox);
	}
	
	public void clickContinueBtn() throws InterruptedException {
		log.info("Click on continue button");
		click(continueBtn);
	}
   
	public boolean isAgreeErrMsgPresent() {
		return isDisplayed(agreeErrMsg);	
	}
	
	public void isAccntCreatedContinueBtn() throws InterruptedException {
		log.info("Click on the Account created continue button");
		click(accntCreatedContinueBtn);
	}
	
	public boolean isBreadCrumbSuccessLinkPresent() {
		return isDisplayed(accntCreatedBreadCrumbSuccessLink);	
	}
	public String getAccountCreatedHeader() throws InterruptedException {
		return getText(accountCreatedHeader);
	}
	public String getAccntCreatedSuccMsg() throws InterruptedException {
		return getText(accntCreatedSuccMsg);
	}

	public boolean isAccntCreatedSuccMsgPresent() {
		return isDisplayed(accntCreatedSuccMsg);
	}
	
	public void setPersonalDetails(String fname,String lname,String email,String tel,String fax) throws InterruptedException {
		setFirstNameEditbox(fname);
		setLastNameEditbox(lname);
		setEmailEditBox(email);
		setTelephoneEditbox(tel);
		setFaxEditbox(fax);
	}
	public void setAddressDetails(String company,String addr1,String addr2,String city,String postCode,String country,String state) throws InterruptedException {
		setCompanyEditbox(company);
		setAddress_1Editbox(addr1);
		setAddress_2Editbox(addr2);
		setCityEditbox(city);
		setPostalEditbox(postCode);
		selectCountry(country);
		selectState(state);
	}
	
	public void setPasswordDetails(String pwd,String confirmPwd) throws InterruptedException {
		SetPasswordEditbox(pwd);
		SetPwdConfirmEditbox(confirmPwd);
	}
	
}
