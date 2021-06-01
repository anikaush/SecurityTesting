package it.unitn.sectest;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utils.BaseTest;

public class Product_3 extends BaseTest {
	
	@Test
	public void testProduct_3() {
		
		//To do list
		//1. login as admin
		//2. go to product page
		//3. go to edit option
		//4. change the brand name
		//5. Assert
		
		
		//1. login as admin
		
		login("admin","admin");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//2.go to product Page
		
		WebElement proPage=driver.findElement(By.xpath("/html[1]/body[1]/nav[1]/div[1]/div[2]/ul[1]/li[4]/a[1]"));
		proPage.click();
		
		WebElement action=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/table[1]/tbody[1]/tr[1]/td[8]/div[1]/button[1]/span[1]"));
		action.click();
		
		//3.Go to edit 
		
		WebElement edit=driver.findElement(By.id("editProductModalBtn"));
		edit.click();
		
		WebElement info=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[2]/ul[1]/li[2]/a[1]"));
		info.click();
		
		//4.Change the Brand name
		
		Select brand = new Select(driver.findElement(By.id("editBrandName")));
	    brand.selectByVisibleText("art");
	    
	    WebElement save=driver.findElement(By.id("editProductBtn"));
	    save.click();
	    
	    WebElement close=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/form[1]/div[8]/button[1]"));
        close.click();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//5. Assertion

		WebElement chngBrand= driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/table[1]/tbody[1]/tr[1]/td[5]/h1[1]"));
		String strng = chngBrand.getText();
		assertEquals(strng, chngBrand.getText());	
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
		
}
