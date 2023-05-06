package com.sortdatatable;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SortDataTableTest {
	
	private WebDriver webdriver;
	@Before
	public void setUp() throws Exception {
		webdriver = new ChromeDriver();
		webdriver.manage().window().maximize();
	}

	@After
	public void tearDown() throws Exception {
		webdriver.quit();
	}

	@Test
	public void test() throws InterruptedException {
		HashMap<String, String> duesByEmail = new HashMap<String, String>();
		
		webdriver.get("http://the-internet.herokuapp.com/tables");
		WebElement targetTable = webdriver.findElement(By.id("table2"));
		List<WebElement> tableRows = targetTable.findElement(By.tagName("tbody")).findElements(By.tagName("tr"));

		for (WebElement row : tableRows) {
			String dues = row.findElement(By.className("dues")).getText();
			String email = row.findElement(By.className("email")).getText();
			duesByEmail.put(email, dues);
		}
		targetTable.findElement(By.className("last-name")).click();
		WebElement secondRow = targetTable.findElement(By.tagName("tbody")).findElements(By.tagName("tr")).get(1);
		assertEquals(duesByEmail.get(secondRow.findElement(By.className("email")).getText()),  secondRow.findElement(By.className("dues")).getText());
	}

}
