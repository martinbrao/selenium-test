package com.dropdown;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropDownListTest {
	
	private WebDriver webdriver;
	DropdownList dropdown;

	@Before
	public void setUp() throws Exception {
		webdriver = new ChromeDriver();
		dropdown = new DropdownList(webdriver);
		webdriver.manage().window().maximize();
	}

	@After
	public void tearDown() throws Exception {
		webdriver.quit();
	}

	@Test
	public void test() throws InterruptedException {
		webdriver.get("http://the-internet.herokuapp.com/dropdown");
		dropdown.selectOption("Option 1");
		dropdown.selectOption("Option 1");
		dropdown.selectOption("Option 2");
		dropdown.selectOption("Option 2");
	}

}
