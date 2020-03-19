package com.bank.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bank.qa.base.TestBase;
import com.bank.qa.pages.HomePage;

public class HomePage extends TestBase {
	
	//Page Factory - OR:
	@FindBy(xpath ="//input[@name = 'email']" )
	WebElement username;
	
	@FindBy(xpath = "//input[@name = 'password']")
	WebElement password;
	
	@FindBy(xpath ="//div[contains(@class, 'ui fluid large blue submit button')]")
	WebElement loginBtn1;
	
	
	//Initializing the Page Objects:
		public HomePage(){
			PageFactory.initElements(driver, this);
		}

		//Actions:
		public HomePageFeatures login(String un, String pwd){
			username.sendKeys(un);
			password.sendKeys(pwd);
			//loginBtn.click();
			    	JavascriptExecutor js = (JavascriptExecutor)driver;
			    	js.executeScript("arguments[0].click();", loginBtn1);
			    	
			return new HomePageFeatures();
		}
		
}
