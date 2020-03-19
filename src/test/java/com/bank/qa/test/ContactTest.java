package com.bank.qa.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bank.qa.base.TestBase;
import com.bank.qa.pages.ContactPage;
import com.bank.qa.pages.HomePage;
import com.bank.qa.pages.HomePageFeatures;
import com.bank.qa.pages.LoginPage;

public class ContactTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	HomePageFeatures homePageFeatures;
	ContactPage contactPage;
		
	public ContactTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.validateLoginBtn();
		homePageFeatures = homePage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactPage = homePageFeatures.clickOnContact();
	}

	@Test(priority =1)
	public void clickOnNewBtn(){
			contactPage.clickOnNewBtn();
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
