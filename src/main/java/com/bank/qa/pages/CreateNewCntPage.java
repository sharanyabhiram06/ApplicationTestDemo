package com.bank.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bank.qa.base.TestBase;

public class CreateNewCntPage extends TestBase{
	
	//Page Factory - OR:
		@FindBy(xpath ="//input[@name  ='first_name']" )
		WebElement fName;
		
		@FindBy(xpath ="//input[@name  ='last_name']" )
		WebElement lName;
		
		@FindBy(xpath ="//input[@name  ='middle_name']" )
		WebElement mName;
		
		@FindBy(xpath ="//input[@class='search']" )
		WebElement company;
		
		@FindBy(xpath ="//i[@class='save icon']" )
		WebElement saveBtn;
		
		
		//Initializing the Page Objects:
			public CreateNewCntPage() {
			
				PageFactory.initElements(driver, this);
			}

			//Actions:
			public AfterSaveCntPage testDataValues(String fname, String lname,String mname,String comp){
				fName.sendKeys(fname);
				lName.sendKeys(lname);
				mName.sendKeys(mname);
				company.sendKeys(comp);
				//loginBtn.click();
				    	JavascriptExecutor js = (JavascriptExecutor)driver;
				    	js.executeScript("arguments[0].click();", saveBtn);
				    	
				return new AfterSaveCntPage();
			}
				
				
			


}
