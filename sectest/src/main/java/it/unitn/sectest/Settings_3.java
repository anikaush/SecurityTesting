package it.unitn.sectest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import utils.BaseTest;

public class Settings_3 extends BaseTest {
	
	@Test
	public void testSettings_3() {
		
		//To Do List
		
		//1.login on page
		//2.Go to Settings
		//3.Change Bio by inserting xss
		//4.Check on settings after relogin
		
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
		
		//3.Change Bio by going in setting (XSS)
		
		WebElement bio = driver.findElement(By.id("bio"));
		bio.clear();
		bio.sendKeys("\"1\\\"><button>beware</button>");
	    //String xss= "1\"><button>beware</button><input type=\"hidden";
	    
	    //JavascriptExecutor jse = (JavascriptExecutor) driver;
	    //jse.executeScript("arguments[0].setAttribute('value', arguments[1])", usernText, xss);
		
	    WebElement changeBioBtn = driver.findElement(By.id("changeBioBtn"));
	    changeBioBtn.click();
		
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
		
		login("admin","admin");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//4.Check Dashboard
		
		WebElement biochge=driver.findElement(By.cssSelector("div.container:nth-child(2) div.row:nth-child(1) div.col-md-12 div.panel.panel-default div.panel-body form"));
		String expectedBio = biochge.getText();  
		
		assertEquals(expectedBio,biochge.getText());
		
		
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
