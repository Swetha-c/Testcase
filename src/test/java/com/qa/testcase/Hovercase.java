package com.qa.testcase;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Hovercase {

	public static WebDriver driver;

	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "E:\\Testing\\chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/hovers");
	}

	@Test
	public void check() throws Exception {
		List<WebElement> users = driver.findElements(By.xpath("//*[@id=\"content\"]/div/div"));

		System.out.println("total users-->" + users.size());

		for (int i = 1; i <= users.size(); i++) {

			String beforeXpath = "//*[@id=\"content\"]/div/div[";
			String afterXpath = "]/img";
			String actual_xpath = beforeXpath + i + afterXpath;
			Actions act = new Actions(driver);
			act.moveToElement(driver.findElement(By.xpath(actual_xpath))).build().perform();
			Thread.sleep(3000);

			String username_beforeXpath = "//*[@id=\"content\"]/div/div[";
			String username_afterXpath = "]/div";
			WebElement toolTip = driver.findElement(By.xpath(username_beforeXpath + i + username_afterXpath));

			System.out.println(toolTip.getText());

		}
	}

	@AfterTest
	public void quit() {
		driver.quit();
	}

}
