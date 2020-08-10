package com.qa.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Infinitescroll {


	public static WebDriver driver;

	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"E:\\Testing\\chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/infinite_scroll");
	}

	@Test()
	public void scrolling() throws Exception {
		for (int i = 1; i <= 4; i++) {
			Thread.sleep(2000);
			((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		}
		Thread.sleep(3000);
		WebElement par = driver.findElement(By.xpath(
				"//div[@class='scroll large-8 columns large-centered']/div/descendant::div[@class='jscroll-added']"));
		System.out.println(par.getText());
	} 

	@AfterTest
	public void close() {
		driver.quit();
	}


}
