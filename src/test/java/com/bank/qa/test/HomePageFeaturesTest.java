package com.bank.qa.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bank.qa.base.TestBase;
import com.bank.qa.pages.HomePage;
import com.bank.qa.pages.HomePageFeatures;
import com.bank.qa.pages.LoginPage;

public class HomePageFeaturesTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	HomePageFeatures homePageFeatures;
		
	public HomePageFeaturesTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.validateLoginBtn();
		homePageFeatures = homePage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority =1)
	public void validOwnrName(){
			String nameLabel = homePageFeatures.validateOwnerName();
			System.out.println("OwnerName: "+nameLabel);
	}
	
	@Test(priority =2)
	public void clickOnContacts(){
		homePageFeatures.clickOnContact();
	}
	
	@Test(priority =3)
	public void checkOName(){
		homePageFeatures.verifyOName();
	}

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
