package com.bank.qa.base;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.bank.qa.util.TestUtil;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	private final String propertyFilePath= "D:\\FunctionalTesting\\webtesting\\src\\main\\java\\com\\bank\\qa\\config\\config.properties";
	public static BufferedReader reader;
	
	public TestBase(){
		//BufferedReader reader;
	
		try {
			
			String current = System.getProperty("user.dir");
			System.out.println(current);
			//D:\FunctionalTesting\webtesting
		/*	String propFileName = "config.properties";
			is = getClass().getClassLoader().getResourceAsStream(propFileName);*/
			reader = new BufferedReader(new FileReader(propertyFilePath));
			prop = new Properties();
		
		try{
			prop.load(reader);
			//reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void initialization(){
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "D:\\Seleniumworkout\\Jar\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver", "D:\\Seleniumworkout\\Jar\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
	
}
