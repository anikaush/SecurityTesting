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

public class index extends BaseTest {
	
@Test
	
	public void testindex() {
	
	//To do list
	//1. login as admin
	//2. Go to Add user page
	//3. Click on add user and insert XSS in username
	//4. Assertion on addUser page
	
	//1. login as admin
	
	login("admin","admin");
	
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	
	//2.Go to Add User page
	
	WebElement arrow=driver.findElement(By.xpath("/html[1]/body[1]/nav[1]/div[1]/div[2]/ul[1]/li[7]/a[1]/span[1]"));
	arrow.click();
	
	WebElement addUser=driver.findElement(By.xpath("/html[1]/body[1]/nav[1]/div[1]/div[2]/ul[1]/li[7]/ul[1]/li[1]/a[1]"));
	addUser.click();

	WebElement adduser=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/button[1]"));
	adduser.click();
	
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	
	//3. insert XSS vector in username
	
	WebElement username=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/div[2]/div[1]/input[1]"));
	username.clear();
	username.sendKeys("<h1>hello</h1>");
	
	WebElement password=driver.findElement(By.id("upassword"));
	password.clear();
	password.sendKeys("12345");
	
	WebElement email=driver.findElement(By.id("uemail"));
	email.clear();
	email.sendKeys("abc@xyz.com");
	
	WebElement saveBtn=driver.findElement(By.id("createUserBtn"));
	saveBtn.click();
	
	WebElement closeBtn=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[3]/button[1]"));
	closeBtn.click();
	
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	
	logout();
	
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	
	login("<h1>hello</h1>","12345");
	
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	
	
	//4. Assertion
	

    WebElement user=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]/span[1]/h1[1]"));
    String strng = user.getText();
	assertEquals(strng, user.getText());
	
	//Reset
	
    WebElement OutArrow=driver.findElement(By.xpath("/html[1]/body[1]/nav[1]/div[1]/div[2]/ul[1]/li[3]/a[1]/span[1]"));
    OutArrow.click();
    
    WebElement logOut = driver.findElement(By.xpath("/html[1]/body[1]/nav[1]/div[1]/div[2]/ul[1]/li[3]/ul[1]/li[2]/a[1]"));
    logOut.click();
	
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	
	login("admin","admin");
	
	WebElement arrowBtn=driver.findElement(By.xpath("/html[1]/body[1]/nav[1]/div[1]/div[2]/ul[1]/li[7]/a[1]/span[1]"));
	arrowBtn.click();
	
	WebElement aduser=driver.findElement(By.xpath("/html[1]/body[1]/nav[1]/div[1]/div[2]/ul[1]/li[7]/ul[1]/li[1]/a[1]"));
	aduser.click();

	WebElement act=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/table[1]/tbody[1]/tr[3]/td[2]/div[1]/button[1]/span[1]"));
	act.click();
	
	WebElement delete=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/table[1]/tbody[1]/tr[3]/td[2]/div[1]/ul[1]/li[2]/a[1]"));
	delete.click();
	
	WebElement saveChanges=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[4]/div[1]/div[1]/div[3]/button[2]"));
	saveChanges.click();
	
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
			
			
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
			private void logout() {
				
				WebElement dropDownBtn = driver.findElement(By.xpath("/html[1]/body[1]/nav[1]/div[1]/div[2]/ul[1]/li[7]/a[1]/span[1]"));
				dropDownBtn.click();
				
				WebElement logoutBtn = driver.findElement(By.xpath("/html[1]/body[1]/nav[1]/div[1]/div[2]/ul[1]/li[7]/ul[1]/li[3]/a[1]"));
				logoutBtn.click();
			}
}