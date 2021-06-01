package it.unitn.sectest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.BaseTest;

public class DashBoard_10 extends BaseTest {
	
	@Test
	public void testDashBoard_10() {
		
		//To Do List
		
		//1.login on page
		//2.Go to Settings
		//3.Change Username by going in setting (XSS)
		//4.Check on Dashboard
		
		//1. Login on page
		
        login("admin", "admin");
		
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//2.Go to Settings
		
		WebElement dropDownButton = driver.findElement(By.xpath("/html[1]/body[1]/nav[1]/div[1]/div[2]/ul[1]/li[7]/a[1]/span[1]"));
		dropDownButton.click();
		
		WebElement setButton = driver.findElement(By.xpath("/html[1]/body[1]/nav[1]/div[1]/div[2]/ul[1]/li[7]/ul[1]/li[2]/a[1]"));
		setButton.click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//3.Change Username by going in setting (XSS)
		WebElement unameTextBox = driver.findElement(By.id("username"));
		unameTextBox.clear();
		unameTextBox.sendKeys("<h1>admin</h1>");
		
		WebElement changeUnameBtn = driver.findElement(By.id("changeUsernameBtn"));
		changeUnameBtn.click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		logout();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		login("<h1>admin</h1>","admin");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//4.Check Dashboard
		
		WebElement dbUname=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[5]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[1]/h1[1]"));
		String expectedUname = "admin";  
		
		assertEquals(expectedUname,dbUname.getText());
		
		
	}
	
//SupportMethods
	
	private void login(String username, String password) {
	
		WebElement unameTextBox = driver.findElement(By.id("username"));
		unameTextBox.sendKeys(username);
		
		WebElement passwordTextBox = driver.findElement(By.id("password"));
		passwordTextBox.sendKeys(password);
		
		WebElement submitBtn= driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/fieldset[1]/div[3]/div[1]/button[1]"));
		submitBtn.click();
		
	}
	
	private void logout() {
	
		WebElement dropDownBtn = driver.findElement(By.xpath("/html[1]/body[1]/nav[1]/div[1]/div[2]/ul[1]/li[7]/a[1]/span[1]"));
		dropDownBtn.click();
		
		WebElement logoutBtn = driver.findElement(By.xpath("/html[1]/body[1]/nav[1]/div[1]/div[2]/ul[1]/li[7]/ul[1]/li[3]/a[1]"));
		logoutBtn.click();
	}
	
	@After
	
	public void reset() {
		
		//0.At Dashboard
		
		//1.Go to Settings
		
		WebElement dropDownBtn=driver.findElement(By.xpath("//*[@id=\"navSetting\"]/a"));
		dropDownBtn.click();
		
		WebElement settingBtn= driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li[7]/ul/li[2]/a"));
		settingBtn.click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//2. Set username as admin
		
		WebElement unameTextBox = driver.findElement(By.id("username"));
		unameTextBox.clear();
		unameTextBox.sendKeys("admin");
		
		WebElement changeUnameBtn =driver.findElement(By.id("changeUsernameBtn"));
		changeUnameBtn.click();
	}
}
