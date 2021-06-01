package it.unitn.sectest;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utils.BaseTest;

public class Order_21 extends BaseTest {
	
	@Test
	
	public void testOrder_21() { 
		
		//To do list
		//1. login as admin
		//2. go to orders
		//3. go to add order
		//4. insert xss in client name
		//5. Assert
		
		//1. Login as admin
		login("admin","admin");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//2. go to orders
		
		WebElement orderBtn= driver.findElement(By.xpath("/html[1]/body[1]/nav[1]/div[1]/div[2]/ul[1]/li[5]/a[1]"));
		orderBtn.click();
		
		WebElement addorder=driver.findElement(By.xpath("/html[1]/body[1]/nav[1]/div[1]/div[2]/ul[1]/li[5]/ul[1]/li[1]/a[1]"));
		addorder.click();
		
		//3. Create order
		
		WebElement dateTextBox=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[2]/form[1]/div[1]/div[1]/input[1]"));
		dateTextBox.click();
				
		WebElement choosedate=driver.findElement(By.xpath("/html[1]/body[1]/div[2]/table[1]/tbody[1]/tr[2]/td[1]/a[1]"));
		choosedate.click();
				
		WebElement cliName= driver.findElement(By.id("clientName"));
		cliName.clear();
		cliName.sendKeys("<h1>Rome</h1>");
				
		WebElement cliContact=driver.findElement(By.id("clientContact"));
		cliContact.clear();
		cliContact.sendKeys("99999");
				
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
		
		//5.Assertion
		
		WebElement ordBtn=driver.findElement(By.xpath("/html[1]/body[1]/nav[1]/div[1]/div[2]/ul[1]/li[5]/a[1]"));
		ordBtn.click();
		
		WebElement mngeBtn=driver.findElement(By.xpath("/html[1]/body[1]/nav[1]/div[1]/div[2]/ul[1]/li[5]/ul[1]/li[2]/a[1]"));
		mngeBtn.click();
		
		WebElement clientName=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[2]/div[2]/table[1]/tbody[1]/tr[1]/td[3]/h1[1]"));
	
		String expectedcliname=clientName.getText();  
		
		assertEquals(expectedcliname, clientName.getText());
		
		//Reset by deleting the order
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

