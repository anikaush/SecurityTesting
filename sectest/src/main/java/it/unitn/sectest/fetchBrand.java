package it.unitn.sectest;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.net.URISyntaxException;
import java.nio.file.Paths;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utils.BaseTest;

public class fetchBrand extends BaseTest{

	@Test
	
	public void testfetchBrand() {
		
		//To do list
		//1. login as admin
		//2. Go to Brand page
		//3. insert xss Brand name
		//4. Assertion on brand page
		
		//1. login as admin
		
		login("admin","admin");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//2. go to brand page
		
		WebElement brandBtn= driver.findElement(By.xpath("/html[1]/body[1]/nav[1]/div[1]/div[2]/ul[1]/li[2]/a[1]"));
	    brandBtn.click();
	    
	    WebElement addBtn = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/button[1]"));
	    addBtn.click();
	    
	    try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    
		//3. insert XSS in brand name
	    
	    WebElement brandTextBox = driver.findElement(By.id("brandName"));
	    brandTextBox.clear();
	    brandTextBox.sendKeys("<h1>XSS</h1>");
	    
	    Select element = new Select(driver.findElement(By.id("brandStatus")));
	    element.selectByVisibleText("Available");
	    
	    WebElement saveBtn=driver.findElement(By.id("createBrandBtn"));
	    saveBtn.click();
	    
	    WebElement closeBtn= driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[3]/button[1]"));
	    closeBtn.click();
	    
	    try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    
	  //4.Assertion on Brand Page
	    WebElement brandName=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/table[1]/tbody[1]/tr[6]/td[1]/h1[1]"));
	    String strng = brandName.getText();
	    assertEquals(strng, brandName.getText());
		
      }
	  //Support Methods
		
		private void login(String username, String password) {
			
			WebElement unameTextBox = driver.findElement(By.id("username"));
			unameTextBox.sendKeys(username);
			
			WebElement passwordTextBox = driver.findElement(By.id("password"));
			passwordTextBox.sendKeys(password);
			
			WebElement submitBtn= driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/form/fieldset/div[3]/div/button"));
			submitBtn.click();
			
		}
			
		}

