package com.bank.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bank.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//webelements of pageobject
	
	@FindBy(xpath = "//a[contains(@class , 'btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left')]")
	WebElement loginBtn;
	
	
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	
	//Initializing the page Objects
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	

	//Actions:
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public HomePage validateLoginBtn(){
		loginBtn.click();
		
		return new HomePage();
	}
	
	
}
