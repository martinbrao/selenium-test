package com.dropdown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DropdownList{

	By options = By.id("dropdown");
	private String beforeoption;
	private WebDriver webdriver;
	
	public DropdownList(WebDriver driver) {
		webdriver = driver;
		// TODO Auto-generated constructor stub
	}
	
	public void selectOption(String option) {
		WebElement dropdown = webdriver.findElement(options);
		List<WebElement> values = dropdown.findElements(By.tagName("option"));
		for(int i = 0; i < values.size(); i++) {
			if((values.get(i).getText()).equals(option)) {
				(values.get(i)).click();
				if(beforeoption == option) {
					System.out.println("El valor no cambio, sigue siendo: " + beforeoption);
				}else {
					System.out.println("El valor cambio, es: " + option);
					beforeoption = option;
				}				
			}
		}
	}
}

