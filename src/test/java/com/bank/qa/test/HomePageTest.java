package com.bank.qa.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bank.qa.base.TestBase;
import com.bank.qa.pages.HomePage;
import com.bank.qa.pages.HomePageFeatures;
import com.bank.qa.pages.LoginPage;

public class HomePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
		
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.validateLoginBtn();
	}
	
	@Test(priority=1)
	public void giveUnPsdTest(){
				homePage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
