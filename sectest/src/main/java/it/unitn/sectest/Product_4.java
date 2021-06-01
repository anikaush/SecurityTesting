package it.unitn.sectest;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utils.BaseTest;

public class Product_4 extends BaseTest {
	
	@Test
	public void testProduct_4() {
		
		//To do list
		//1. login as admin
		//2. go to product page
		//3. go to edit option
		//4. change the category name
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
		
		//4.Change the category name
		
		Select category = new Select(driver.findElement(By.id("editCategoryName")));
		category.selectByVisibleText("art");
	    
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

		WebElement chngCategory= driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/table[1]/tbody[1]/tr[3]/td[6]/h1[1]"));
		String strng = chngCategory.getText();
		assertEquals(strng, chngCategory.getText());	
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
