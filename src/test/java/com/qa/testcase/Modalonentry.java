package com.qa.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Modalonentry {
	public static WebDriver driver;

	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "E:\\Testing\\chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/entry_ad");
	}

	@Test
	public void modal() {
		System.out.println("modal is displayed on page load");

		driver.findElement(By.xpath("//*[@id=\"modal\"]/div[2]/div[3]/p")).click();

		System.out.println("click here");

		driver.findElement(By.xpath("//*[@id=\"restart-ad\"]")).click();
		
		System.out.println("the modal is not displayed on page-reload if the modal is closed once");
	}

	@AfterTest
	public void close() {
		driver.close();
	}

}
