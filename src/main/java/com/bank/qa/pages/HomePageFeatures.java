package com.bank.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.bank.qa.base.TestBase;

public class HomePageFeatures extends TestBase {
	
	//Page Factory - OR:
	@FindBy(xpath ="//span[contains(text(),'Sharanya Bhiram')]")
	WebElement ownerName;
	
	@FindBy(xpath ="//span[text()='Contacts']")
	WebElement clickContact;
	
	
	//Initializing the Page Objects:
			public HomePageFeatures() {
				PageFactory.initElements(driver, this);
			}
	public String oName;
	
	//Actions:
 public String validateOwnerName(){
	  oName = ownerName.getText();
	  return oName;
 }
			
public void verifyOName(){
    oName = ownerName.getText();
    Assert.assertEquals("sharanya bhiram","Nishal Dhashik");
	
}

public ContactPage clickOnContact(){
	//clickContact.click();
	
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();", clickContact);
	
	return new ContactPage();
}
 
}
