package it.unitn.sectest;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.BaseTest;

public class Settings_1 extends BaseTest{

	@Test
	
	public void testSettings_1() {
		
		//To do List
		//1. Login as admin
		//2. Change Username (XSS)
		//3. Assert on dashboard
		
		//1. Login
		
		login("admin","admin");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//2. Go to Settings
		
		WebElement dropDownBtn = driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li[7]/a"));
		dropDownBtn.click();
		
		WebElement settingBtn = driver.findElement(By.cssSelector("#topNavSetting > a:nth-child(1)"));
		settingBtn.click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//3. Change Username
		
		WebElement unameTextBox= driver.findElement(By.id("username"));
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
		
		//4. Assert on Dashboard
		
		WebElement dbUname = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div/a/span"));
		
		String innerHtml = dbUname.getAttribute("innerHTML");
		
		assertEquals("<h1>admimn</h1>","innerHtml");
	}

	
	//Support Method
	

	private void login(String username, String password) {
		
		WebElement unameTextBox = driver.findElement(By.id("username"));
		unameTextBox.sendKeys(username);
		
		WebElement passwordTextBox = driver.findElement(By.id("password"));
		passwordTextBox.sendKeys(password);
		
		WebElement submitBtn= driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/form/fieldset/div[3]/div/button"));
		submitBtn.click();
		
	}
	
	private void logout() {
		
		WebElement dropDownBtn = driver.findElement(By.xpath("//*[@id=\\\"navSetting\\\"]/a"));
		dropDownBtn.click();
		
		WebElement logoutBtn = driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li[7]/ul/li[3]/a"));
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

