package com.guru99.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.guru99.pages.LoginPage;
import com.guru99.utils.TestDataSource;

import commonLibs.implementation.CommonDriver;


public class LoginPageTests {
	
	CommonDriver cmnDriver;
	
	String url = "http://demo.guru99.com/v4";
	
	LoginPage loginPage;
	
	@BeforeMethod
	public void setup() throws Exception {
		
		cmnDriver = new CommonDriver("chrome");
		
		cmnDriver.navigateToFirstUrl(url);
		
		loginPage = new LoginPage(cmnDriver.getDriver());
		
	}
	
	@Test(dataProvider = "getDataFromDatabase" /*"getData"*/, dataProviderClass = TestDataSource.class)
	public void verifyLogin(String username, String password) throws Exception {
		//String username = "mngr484236";
		//String password = "Enemepa";
		
		loginPage.loginToApplication(username, password);
		
		String actualTitle = cmnDriver.getTitle();
		
		String expectedTitle = "Guru99 Bank Manager HomePage";

		Assert.assertEquals(actualTitle, expectedTitle);
	
	}
	
	@AfterMethod
	public void cleanUp() throws Exception {
		cmnDriver.closeAllBrowsers();
	}
	
}
