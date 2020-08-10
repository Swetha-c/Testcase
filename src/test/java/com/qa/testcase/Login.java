package com.qa.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Login {
	

	public static WebDriver driver;

	@BeforeSuite
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"E:\\Testing\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@BeforeMethod
	public void enterurl() {
		driver.get("http://the-internet.herokuapp.com/login");
	}

	@Test(priority = 1)
	public void Valid_login() throws InterruptedException {
		driver.findElement(By.name("username")).sendKeys("tomsmith");
		driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.xpath("//*[@id=\"login\"]/button")).click();
		System.out.println(driver.getCurrentUrl());
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/a/i")).click();
	}
	
	

	@Test(priority = 2)
	public void Invalid_Login() {
		
		String actual ="http://the-internet.herokuapp.com/secure";
		driver.findElement(By.name("username")).sendKeys("swetha");
		driver.findElement(By.name("password")).sendKeys("swetha");
		driver.findElement(By.xpath("//*[@id=\"login\"]/button")).click();
		
		String expected = driver.getCurrentUrl();
		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actual, expected, "Invalid Username or Password  !!!");
		softAssert.assertAll();

	}
	

	@AfterTest
	public void close() {
		driver.close();
	}

}
