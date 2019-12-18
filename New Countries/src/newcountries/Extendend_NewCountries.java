package newcountries;
import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class Extendend_NewCountries extends elements{
	
	static WebDriver webDriver;
	
	@Test
	public static void captureScreenMethod() throws Exception{
		
	System.setProperty("webdriver.chrome.driver", "D:\\UBUY_WorkSpace\\UBUY Checkout\\lib\\chromedriver.exe");
		webDriver = new ChromeDriver();
			webDriver.manage().window().maximize();
			
			// Headless Browser
		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * "D:\\UBUY_WorkSpace\\UBUY Checkout\\lib\\chromedriver.exe");
		 * System.setProperty("webdriver.chrome.logfile",
		 * "D:\\UBUY_WorkSpace\\UBUY Checkout\\lib\\chromedriver.txt"); ChromeOptions op
		 * = new ChromeOptions(); op.addArguments("window-size=1400,800");
		 * op.addArguments("headless"); webDriver = new ChromeDriver(op);
		 */
		
		/*
		 * webDriver = new FirefoxDriver(); webDriver.manage().window().maximize();
		 */

			FileInputStream file = new FileInputStream(new File("D:\\New Countries URl1.xlsx"));
			@SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheetAt(5);
		//	logger.info("Lauch URl");
			
			for(int i=0; i<=sheet.getLastRowNum(); i++)
			{
			String url = sheet.getRow(i).getCell(0).getStringCellValue();
			System.out.println(url);
			webDriver.get(url);
			//logger.info(url);
			
			
			WebElement element5 = (new WebDriverWait(webDriver, 20)).until(ExpectedConditions.elementToBeClickable(By.xpath(search)));
			  element5.sendKeys("laptop");
			 System.out.println("Search Products LAPTOP");
		webDriver.findElement(By.xpath(clickonSaerchButton)).click();
			
			
		

			webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			webDriver.findElement(By.xpath(SelectProducts)).click();
			System.out.println("Select products");
			
			
			String st =webDriver.getCurrentUrl();
			System.out.println(i+" "+st);
			
		Thread.sleep(2000);
			//webDriver.navigate().refresh();
			WebElement element1 = (new WebDriverWait(webDriver, 20)).until(ExpectedConditions.elementToBeClickable(By.xpath(AddToCart)));
			  element1.click();	
			  
			  webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			  System.out.println("Click on Add to Cart Button");
			  String Parent_Window = webDriver.getWindowHandle();
				for (String Child_Window : webDriver.getWindowHandles())
				{		
					webDriver.switchTo().window(Child_Window); 
				
					webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				WebElement element = webDriver.findElement(By.xpath(PopUp));
				JavascriptExecutor executor = (JavascriptExecutor)webDriver;
				executor.executeScript("arguments[0].click();",element);
				
				System.out.println("Click on View cart and check outbutton at popup");
				}
				webDriver.switchTo().window(Parent_Window);
			  webDriver.findElement(By.xpath(ProceedToCheckOut)).click();
			  
			  webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			  System.out.println("Click on proceed to checkout button");
			  
			 // logger.info("click on Proceed To CheckOut button");
			  
			  webDriver.findElement(By.xpath(UserName)).sendKeys("shailendra.singh17120733@gmail.com");
			  System.out.println("Enter USerName");
			webDriver.findElement(By.xpath(Password)).sendKeys("123456");
			System.out.println("Enter Password");
		//	logger.info("Enter user login detail");
			
			webDriver.findElement(By.xpath(LoginButton)).click();
			System.out.println("Click on Login button");
			Thread.sleep(4000);
			
			try {
			if(webDriver.findElement(By.xpath(NewAdress)).isEnabled());
			{
				webDriver.findElement(By.xpath(NewAdress)).click();
			}
			}
			
			catch (Exception e) {
				// TODO: handle exception
			}
					
					
					
					
					
			webDriver.findElement(By.xpath(FirstNAme)).sendKeys("shailendra");
			System.out.println("Enter First Name");
			webDriver.findElement(By.xpath(LAstName)).sendKeys("singh");
			System.out.println("Enter Last Name");

			
			webDriver.findElement(By.xpath(TelephoneNumber)).sendKeys("1234567802");
			System.out.println("Enter Telephone number");
			
			String billingregion =State;
			System.out.println("Select State");
			String billingcity=state1;
			Boolean is_billingcity = false;
			WebElement ele1;
			try {
				ele1 = webDriver.findElement(By.xpath(billingregion));
				
				
			} catch (Exception e) {
				ele1 = webDriver.findElement(By.xpath(billingcity));
				is_billingcity=true;
				
			}
			if(ele1.isEnabled())
			{
				if(is_billingcity)
				{
					
					Select city1 = new Select(ele1);
					city1.selectByIndex(3);
				}
				else {
					
					Select city2 = new Select(ele1);
					city2.selectByIndex(3);
				}
			}
			 String input_city = "//input[@id='billing:city']";
			 String select_city ="//select[@id='billing:city']";
			 
			 Boolean is_select= false;
			 WebElement ele ;
			 
			 try {
				  ele = webDriver.findElement(By.xpath(input_city));
				
			} catch (Exception e) {
				 ele = webDriver.findElement(By.xpath(select_city));
				is_select=true;
			}
	         if (ele.isEnabled())
	        	 
	         {
	 
	        	if (is_select)
	        	{
	        		Select cityfromdrop = new Select(ele);	
	         		cityfromdrop.selectByIndex(1);
	        	}
	        	
	        	
	        	else  {
	        		
	        		ele.sendKeys("2589566");
	        	}
	        	
	         }
	         
			webDriver.findElement(By.xpath(House)).sendKeys("ElecTronicMarket");
			webDriver.findElement(By.xpath(Street)).sendKeys("Ridhi Sidhi");
			try {
				if(webDriver.findElement(By.xpath("//input[@id='billing:address_block']")).isEnabled())
				{
					webDriver.findElement(By.xpath("//input[@id='billing:address_block']")).sendKeys("T block");
					
				}
				
			} catch (Exception e) {
				
				
			}
			
			
			try {
				if(webDriver.findElement(By.xpath("//input[@id='billing:address_appartment']")).isEnabled())
				{
					webDriver.findElement(By.xpath("//input[@id='billing:address_appartment']")).sendKeys("Qatar AppartMent");
					
				}
				
			} catch (Exception e) {
				
				
			}
			
			try {
				if(webDriver.findElement(By.xpath("//input[@id='billing:address_avenue']")).isEnabled())
				{
					webDriver.findElement(By.xpath("//input[@id='billing:address_avenue']")).sendKeys("Qatar Avenue");
					
				}
				
			} catch (Exception e) {
				
				
			}
			
			//Jordan
			
			try {
				if(webDriver.findElement(By.xpath("//input[@id='billing:idnumber']")).isEnabled())
				{
					webDriver.findElement(By.xpath("//input[@id='billing:idnumber']")).sendKeys("12569857");
					
				}
				
			} catch (Exception e) {
				
				
			}
			
			
			
			try {
				if(webDriver.findElement(By.xpath(Zip)).isEnabled())
				{
					webDriver.findElement(By.xpath(Zip)).sendKeys("5454545454");
					
				}
				
			} catch (Exception e) {
				
				
			}
			webDriver.findElement(By.xpath(ContinueButton)).click();
			
			Thread.sleep(4000);
			webDriver.findElement(By.xpath(ShippingSelect)).click();
			System.out.println("Select Shipping method");
			
			webDriver.findElement(By.xpath(ContinueFromShipping)).click();
			System.out.println("Click on continue button");
			Thread.sleep(4000);
			//logger.info("Enter all mandatory field in address page");
			
			webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement element2 = webDriver.findElement(By.xpath("//*[@id='p_method_cybersecure' and @name='payment[method]']"));
			JavascriptExecutor executor = (JavascriptExecutor)webDriver;
			executor.executeScript("arguments[0].click();",element2);
			

			
			Select Card =new Select(webDriver.findElement(By.xpath(CardType)));
			Card.selectByIndex(2);
			System.out.println("Select Card type");
			//logger.info("Select card type ");
			webDriver.findElement(By.xpath(CardNumber)).sendKeys("5105105105105100");
			System.out.println("Enter Card number");
			Select ExpiryDate = new Select(webDriver.findElement(By.xpath(ExpiryMonth)));
			ExpiryDate.selectByVisibleText("03 - March");
			System.out.println("Select Expiry month");
			Select ExpiryDateYear = new Select(webDriver.findElement(By.xpath(ExpiryYear)));
			ExpiryDateYear.selectByVisibleText("2023");
			System.out.println("Select Expiry Year");
			webDriver.findElement(By.xpath(CardVerificationNumber)).sendKeys("123");
			System.out.println("enter CVV number");
			
			webDriver.findElement(By.xpath(ContinueFromPaymentOption)).click();
		//	logger.info("click on place order button");
			System.out.println("Click on Continue Button");
			Thread.sleep(5000);
			webDriver.findElement(By.xpath(PlaceOrderFinal)).click();
			System.out.println("Place orders");
			System.out.println("-------------------------------------------------------");
			
			
			
		
			}
		
		
	}
	

	@AfterMethod//AfterMethod annotation - This method executes after every test execution
	public void screenShot(ITestResult result){
	
		
		if(ITestResult.FAILURE==result.getStatus()){
			System.out.println("here 1");
			try{
				System.out.println("here 2");
				TakesScreenshot screenshot=(TakesScreenshot)webDriver;
				System.out.println("here 3");
				@SuppressWarnings("unused")
				File src=screenshot.getScreenshotAs(OutputType.FILE);
				
				
				
				File file = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
				System.out.println("here 4");
				FileUtils.copyFile(file, new File("D:\\Headless\\headless_screenshot.png"));
				System.out.println("Successfully captured a screenshot");
			
				EmailAttachment attachment = new EmailAttachment();
				  attachment.setPath("D:\\Headless\\headless_screenshot.png");
				  attachment.setDisposition(EmailAttachment.ATTACHMENT);
				  attachment.setDescription("Error");
				  attachment.setName("ErrorImage");
				  attachment.getURL();
			
				  // Create the email message
				  MultiPartEmail email = new MultiPartEmail();
				  email.setHostName("smtp.gmail.com");
					email.setSmtpPort(465);
					email.setAuthenticator(new DefaultAuthenticator("Shailendra1707198912@gmail.com", "testing123ubuy"));
					email.setSSLOnConnect(true);
					email.setFrom("Shailendra1707198912@gmail.com");
					email.setSubject("Error in Sites");
					email.setMsg("Website Error");
					email.addTo("shailendra.singh@ubuy.com");
				  email.attach(attachment);
				  email.send();
				 System.out.println("Mail sent succesfully");
			}
			
			catch (Exception e){
				System.out.println("Exception while taking screenshot "+e.getMessage());
			} 
	}
		webDriver.quit();
	}
}