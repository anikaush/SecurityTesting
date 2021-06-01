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

public class Product_2 extends BaseTest {
	
@Test
	
	public void testProduct_2() {
		
	//To do list
			//1. login as admin
			//2. Go to Category page
			//3. insert xss category name
			//4. go to product page
			//5. click on add product and fill the details
			//6. Assertion
			
			//1. login as admin
			
			login("admin","admin");
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			//2. go to category page
			
			WebElement categoryBtn= driver.findElement(By.xpath("/html[1]/body[1]/nav[1]/div[1]/div[2]/ul[1]/li[3]/a[1]"));
			categoryBtn.click();
		    
		    WebElement addBtn = driver.findElement(By.id("addCategoriesModalBtn"));
		    addBtn.click();
		    
		    try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		    
			//3. insert XSS in category name
		    
		    WebElement categoryTextBox = driver.findElement(By.id("categoriesName"));
		    categoryTextBox.clear();
		    categoryTextBox.sendKeys("<h1>art</h1>");
		    
		    Select element = new Select(driver.findElement(By.id("categoriesStatus")));
		    element.selectByVisibleText("Available");
		    
		    WebElement saveBtn=driver.findElement(By.id("createCategoriesBtn"));
		    saveBtn.click();
		    
		    WebElement closeBtn= driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[3]/button[1]"));
		    closeBtn.click();
		    
		    try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		    
		    // 4. Go to product page
		    
		    WebElement productBtn=driver.findElement(By.xpath("/html[1]/body[1]/nav[1]/div[1]/div[2]/ul[1]/li[4]/a[1]"));
		    productBtn.click();
		    
		    WebElement addProductBtn=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/button[1]"));
		    addProductBtn.click();
		   
		  //5. click on add product and fill the details
		    
		    java.net.URL res = getClass().getClassLoader().getResource("Hand_Model.jpg");
		    File file = null;
		    try {
		      file = Paths.get(res.toURI()).toFile();
		    } catch (URISyntaxException e) {
		      // TODO Auto-generated catch block
		      e.printStackTrace();
		    }
		    String absPath = file.getAbsolutePath();
		    
		    WebElement productImage = driver.findElement(By.id("productImage"));
		    productImage.sendKeys(absPath);
		    
		    WebElement productName=driver.findElement(By.id("productName"));
		    productName.clear();
		    productName.sendKeys("test");
		    
		    WebElement quantity = driver.findElement(By.id("quantity"));
		    quantity.clear();
		    quantity.sendKeys("8");
		    
		    WebElement rate = driver.findElement(By.id("rate"));
		    rate.clear();
		    rate.sendKeys("50");
		    
		    try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		    
		    Select brand = new Select(driver.findElement(By.id("brandName")));
		    brand.selectByVisibleText("Boat");
		    
		    Select category = new Select(driver.findElement(By.id("categoryName")));
		    category.selectByVisibleText("art");
		    
		    Select product = new Select(driver.findElement(By.id("productStatus")));
		    product.selectByVisibleText("Available");
		    
		    try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		    
		    WebElement saveProductBtn=driver.findElement(By.id("createProductBtn"));
		    saveProductBtn.click();
		    
		    WebElement closeProBtn= driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[3]/button[1]"));
		    closeProBtn.click();
		    
		    try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		    
		    
		    //6. Assertion
		    
		    WebElement cName=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/table[1]/tbody[1]/tr[5]/td[6]/h1[1]"));
		    String strng = cName.getText();
			assertEquals(strng, cName.getText());
		    
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
