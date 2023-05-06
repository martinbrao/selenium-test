package com.login;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
	
	private WebDriver webdriver;
	

	@Before
	public void setUp() throws Exception {
		webdriver = new ChromeDriver();
		webdriver.manage().window().maximize();
	}

	@After
	public void tearDown() throws Exception {
		webdriver.close();
	}

	@Test
	public void test() throws InterruptedException {
		webdriver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
		WebElement message = webdriver.findElement(By.xpath("//p"));
		System.out.print(message.getText());
		assertEquals("Congratulations! You must have the proper credentials.", message.getText());
	}

}
