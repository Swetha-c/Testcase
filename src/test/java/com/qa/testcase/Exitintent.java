package com.qa.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Exitintent {


	public static WebDriver driver;

	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"E:\\Testing\\chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/exit_intent");
	}

	@Test
	public void test() {
		WebElement e = driver.findElement(By.cssSelector("h3"));
		Actions action = new Actions(driver);
		action.moveToElement(e).moveByOffset(600, -2).build().perform();
		driver.findElement(By.xpath("//*[@id=\"ouibounce-modal\"]/div[2]/div[3]/p")).click();
	}

	@AfterTest
	public void quit() {
		driver.quit();
	}


}
