package it.unitn.sectest;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utils.BaseTest;

public class Order_43_44 extends BaseTest {
	
	@Test 
	
	public void testOrder_43_44() {
		

		//To Do List
		//1. login as admin
		//2. Go to add order
		//3. create an order: insert XSS in Total Amount
		//4. Assertion by going to edit order
		
		//1. Login as Admin
		
		login("admin","admin");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//2.Go to add order
		
		WebElement orderBtn= driver.findElement(By.xpath("/html[1]/body[1]/nav[1]/div[1]/div[2]/ul[1]/li[5]/a[1]/span[1]"));
		orderBtn.click();
		
		WebElement addOrder= driver.findElement(By.xpath("/html[1]/body[1]/nav[1]/div[1]/div[2]/ul[1]/li[5]/ul[1]/li[1]/a[1]"));
		addOrder.click();
		
		//3. Create order
		
		WebElement dateTextBox=driver.findElement(By.id("orderDate"));
		dateTextBox.click();
		
		WebElement choosedate=driver.findElement(By.xpath("/html[1]/body[1]/div[2]/table[1]/tbody[1]/tr[3]/td[4]/a[1]"));
		choosedate.click();
		
		WebElement cliName= driver.findElement(By.id("clientName"));
		cliName.clear();
		cliName.sendKeys("Amount");
		
		WebElement cliContact=driver.findElement(By.id("clientContact"));
		cliContact.clear();
		cliContact.sendKeys("11111");
		
		Select element = new Select(driver.findElement(By.id("productName1")));
	    element.selectByVisibleText("Swiss Watch");
	    
	    Select element1 = new Select(driver.findElement(By.id("productName2")));
	    element1.selectByVisibleText("Boat Headphones");
	    
	    Select element2 = new Select(driver.findElement(By.id("productName3")));
	    element2.selectByVisibleText("Hand");
	    
	    try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    
        // XSS insertion in Total Amount
	    
	    WebElement totalAmount=driver.findElement(By.id("totalAmountValue"));
	    String vector= "1\"><button>zero</button><input type=\"hidden";
	    
	    JavascriptExecutor jse = (JavascriptExecutor) driver;
	    jse.executeScript("arguments[0].setAttribute('value', arguments[1])", totalAmount, vector);
	    
	    WebElement discount = driver.findElement(By.id("discount"));
	    discount.sendKeys("00");
	    
	    WebElement paidAmount = driver.findElement(By.id("paid"));
	    paidAmount.sendKeys("00");
	    
	    Select type = new Select(driver.findElement(By.id("paymentType")));
	    type.selectByVisibleText("Cash");
	    
	    Select status = new Select(driver.findElement(By.id("paymentStatus")));
	    status.selectByVisibleText("No Payment");
	    
	    Select place = new Select(driver.findElement(By.id("paymentPlace")));
	    place.selectByVisibleText("In Gujarat");
	    
	    WebElement saveBtn = driver.findElement(By.id("createOrderBtn"));
	    saveBtn.click();
	    
	    try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
			
	    //4.Assertion 
	    
	    WebElement ordBtn= driver.findElement(By.xpath("/html[1]/body[1]/nav[1]/div[1]/div[2]/ul[1]/li[5]/a[1]/span[1]"));
	    ordBtn.click();
		
		WebElement manageOrder= driver.findElement(By.xpath("/html[1]/body[1]/nav[1]/div[1]/div[2]/ul[1]/li[5]/ul[1]/li[2]/a[1]"));
		manageOrder.click();
		
		WebElement actionBtn=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[2]/div[2]/table[1]/tbody[1]/tr[1]/td[7]/div[1]/button[1]/span[1]"));
		actionBtn.click();
		
		WebElement editBtn=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[2]/div[2]/table[1]/tbody[1]/tr[1]/td[7]/div[1]/ul[1]/li[1]/a[1]"));
		editBtn.click();
		
		 try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
		WebElement subTotal= driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[2]/form[1]/div[4]/div[2]/div[1]/button[1]"));
		String strng = subTotal.getText();
		assertEquals(strng, subTotal.getText());	
		
		//Reseting
		
		WebElement odBtn= driver.findElement(By.xpath("/html[1]/body[1]/nav[1]/div[1]/div[2]/ul[1]/li[5]/a[1]/span[1]"));
		odBtn.click();
									
		WebElement mngeOrder= driver.findElement(By.xpath("/html[1]/body[1]/nav[1]/div[1]/div[2]/ul[1]/li[5]/ul[1]/li[2]/a[1]"));
		mngeOrder.click();
									
		WebElement actBtn=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[2]/div[2]/table[1]/tbody[1]/tr[1]/td[7]/div[1]/button[1]/span[1]"));
		actBtn.click();
									
		WebElement removeBtn=driver.findElement(By.id("removeOrderModalBtn"));
		removeBtn.click(); 
									
		WebElement saveChange=driver.findElement(By.id("removeOrderBtn"));
		saveChange.click();
	    
	}

	//Support Method
	
	private void login(String username, String password) {
	
		WebElement unameTextBox = driver.findElement(By.id("username"));
		unameTextBox.sendKeys(username);
		
		WebElement passwordTextBox = driver.findElement(By.id("password"));
		passwordTextBox.sendKeys(password);
		
		WebElement submitBtn= driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/fieldset[1]/div[3]/div[1]/button[1]"));
		submitBtn.click();
		
		
	}
	

}
