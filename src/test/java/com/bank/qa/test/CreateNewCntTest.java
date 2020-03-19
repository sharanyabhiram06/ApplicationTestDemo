package com.bank.qa.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bank.qa.base.TestBase;
import com.bank.qa.pages.AfterSaveCntPage;
import com.bank.qa.pages.ContactPage;
import com.bank.qa.pages.CreateNewCntPage;
import com.bank.qa.pages.HomePage;
import com.bank.qa.pages.HomePageFeatures;
import com.bank.qa.pages.LoginPage;
import com.bank.qa.util.TestUtil;

public class CreateNewCntTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	HomePageFeatures homePageFeatures;
	ContactPage contactPage;
	CreateNewCntPage createNewCntPage;
	TestUtil testUtil;
	AfterSaveCntPage afterSaveCntPage;
	//TestUtil testUtil;
	
	String sheetName = "contacts";
		
	public CreateNewCntTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		
		loginPage = new LoginPage();
		homePage = loginPage.validateLoginBtn();
		homePageFeatures = homePage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactPage = homePageFeatures.clickOnContact();
		createNewCntPage = contactPage.clickOnNewBtn();
		testUtil = new TestUtil();
		}
	
	/*@DataProvider
    public Object[][] getData() {
        return new Object[][]{{"sharu", "nikki", "kumar", "hcl"}, {"sharu1", "nikki1", "kumar1", "hcl1"}};
    }*/
	
	 @DataProvider
	 
	    public Object[][] Authentication() throws Exception{
	 
	         Object[][] testObjArray = testUtil.getTableArray(sheetName);
	 
	         return (testObjArray);
	 }
	
	@Test(priority =1,dataProvider = "Authentication")
	public void validateTestData(String firstName,String lastName,String middleName, String company ){
			createNewCntPage.testDataValues(firstName, lastName, middleName, company);
	}
	
	/*@Test(priority =1)
	public void validateTestData(){
			createNewCntPage.testDataValues("sharu", "nikki", "kumar", "hcl");
	}*/
	
	/*@DataProvider
	public Object[][] getCRMTestData(){
	Object data[][] = TestUtil.getTestData(sheetName);
	return data;
		
	}*/

/*	@Test(priority =1)
	//, dataProvider = "getCRMTestData")
	public void validateTestData(String fname, String lname,String mname,String comp){
		//String firstname, String lastname,String middlename,String company){
			createNewCntPage.testDataValues("sharu", "nikki", "kumar", "hcl");
		//createNewCntPage.testDataValues(firstname,lastname,middlename,company);
		
	}*/
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}


	
}
