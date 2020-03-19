package com.bank.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bank.qa.base.TestBase;
import com.bank.qa.pages.HomePage;
import com.bank.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();
	}

	@Test(priority=1)
	public void loginPageTitleTest(){
		String titleName = driver.getTitle();
		System.out.println(titleName);
	}
	
	@Test(priority=2)
	public void loginPageValidTest(){
			
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Free CRM #1 cloud software for any business large or small");
		
	}
	
	
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
