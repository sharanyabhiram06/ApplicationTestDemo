package com.bank.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bank.qa.base.TestBase;

public class ContactPage extends TestBase{
	
	//Page Factory - OR:
		@FindBy(xpath ="//i[@class = 'edit icon']" )
		WebElement newBtn;
		
		
		
		//Initializing the Page Objects:
			public ContactPage() {
			
				PageFactory.initElements(driver, this);
			}

			//Actions:
			public CreateNewCntPage clickOnNewBtn(){
				//clickContact.click();
				
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("arguments[0].click();", newBtn);
				
				return new CreateNewCntPage();
			}

}
