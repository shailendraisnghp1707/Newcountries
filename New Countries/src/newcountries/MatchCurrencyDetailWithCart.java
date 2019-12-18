package newcountries;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.xml.xpath.XPath;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MatchCurrencyDetailWithCart extends elements {
	
	public static WebDriver driver;
	
	@Test
	public void MatchCurrency() throws IOException, InterruptedException
	{
	
	System.setProperty("webdriver.chrome.driver", "D:\\UBUY_WorkSpace\\UBUY Checkout\\lib\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
		


		FileInputStream file = new FileInputStream(new File("D:\\New Countries URl1.xlsx"));
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(5);
	//	logger.info("Lauch URl");
		
		for(int i=0; i<=sheet.getLastRowNum(); i++)
		{
		String url = sheet.getRow(i).getCell(0).getStringCellValue();
		//System.out.println(url);
		driver.get(url);
		
		Thread.sleep(5000);
		
		String CountryName = driver.findElement(By.xpath("//div[contains(@class,'dropdown country-selector')]")).getText();
		
		System.out.println(CountryName);
		
		WebElement element5 = (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.xpath(search)));
		  element5.sendKeys("laptop");
		// System.out.println("Search Products LAPTOP");
		 driver.findElement(By.xpath(clickonSaerchButton)).click();
		 
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath(SelectProducts)).click();
			//System.out.println("Select products");
			
			
			String DetailPrice = driver.findElement(By.xpath("//h3[@class='product-price']")).getText();
			String[] part = DetailPrice.split("(?<=\\D)(?=\\d)");
			System.out.println(part[0]);
			
			
		// Example  for Splits
			
			/*
			 * String str = "abcd1234"; String[] part = str.split("(?<=\\D)(?=\\d)");
			 * System.out.println(part[0]); System.out.println(part[1]);
			 */
			
			WebElement element1 = (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.xpath(AddToCart)));
			  element1.click();	
			
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			  //System.out.println("Click on Add to Cart Button");
			  String Parent_Window = driver.getWindowHandle();
				for (String Child_Window : driver.getWindowHandles())
				{		
					driver.switchTo().window(Child_Window); 
				
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				WebElement element = driver.findElement(By.xpath(PopUp));
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();",element);
				
				//System.out.println("Click on View cart and check outbutton at popup");
				}
				driver.switchTo().window(Parent_Window);
				
				String CartPagePrice = driver.findElement(By.xpath("//li[1]//span[1]//span[2]")).getText();
				
				String[] part1 = CartPagePrice.split("(?<=\\D)(?=\\d)");
				System.out.println(part1[0]);
				
				
				Thread.sleep(5000);
				
				
				
				
				
				driver.findElement(By.xpath(ProceedToCheckOut)).click();
				  
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				
				  
				  driver.findElement(By.xpath(UserName)).sendKeys("shailendra.singh17120733@gmail.com");
				
				  driver.findElement(By.xpath(Password)).sendKeys("123456");
			
			
				
				driver.findElement(By.xpath(LoginButton)).click();
				
				Thread.sleep(4000);
				try {
					if(driver.findElement(By.xpath(NewAdress)).isEnabled());
					{
						driver.findElement(By.xpath(NewAdress)).click();
					}
					}
					
					catch (Exception e) {
						// TODO: handle exception
					}
				
				
				driver.findElement(By.xpath(FirstNAme)).sendKeys("shailendra");
			
				driver.findElement(By.xpath(LAstName)).sendKeys("singh");
				

				
				driver.findElement(By.xpath(TelephoneNumber)).sendKeys("1234567802");
		
				
				String billingregion =State;
				System.out.println("Select State");
				String billingcity=state1;
				Boolean is_billingcity = false;
				WebElement ele1;
				try {
					ele1 = driver.findElement(By.xpath(billingregion));
					
					
				} catch (Exception e) {
					ele1 = driver.findElement(By.xpath(billingcity));
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
					  ele = driver.findElement(By.xpath(input_city));
					
				} catch (Exception e) {
					 ele = driver.findElement(By.xpath(select_city));
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
		         
		         driver.findElement(By.xpath(House)).sendKeys("ElecTronicMarket");
		         driver.findElement(By.xpath(Street)).sendKeys("Ridhi Sidhi");
				try {
					if(driver.findElement(By.xpath("//input[@id='billing:address_block']")).isEnabled())
					{
						driver.findElement(By.xpath("//input[@id='billing:address_block']")).sendKeys("T block");
						
					}
					
				} catch (Exception e) {
					
					
				}
				
				
				try {
					if(driver.findElement(By.xpath("//input[@id='billing:address_appartment']")).isEnabled())
					{
						driver.findElement(By.xpath("//input[@id='billing:address_appartment']")).sendKeys("Qatar AppartMent");
						
					}
					
				} catch (Exception e) {
					
					
				}
				
				try {
					if(driver.findElement(By.xpath("//input[@id='billing:address_avenue']")).isEnabled())
					{
						driver.findElement(By.xpath("//input[@id='billing:address_avenue']")).sendKeys("Qatar Avenue");
						
					}
					
				} catch (Exception e) {
					
					
				}
				
				//Jordan
				
				try {
					if(driver.findElement(By.xpath("//input[@id='billing:idnumber']")).isEnabled())
					{
						driver.findElement(By.xpath("//input[@id='billing:idnumber']")).sendKeys("12569857");
						
					}
					
				} catch (Exception e) {
					
					
				}
				
				
				
				try {
					if(driver.findElement(By.xpath(Zip)).isEnabled())
					{
						driver.findElement(By.xpath(Zip)).sendKeys("5454545454");
						
					}
					
				} catch (Exception e) {
					
					
				}
				driver.findElement(By.xpath(ContinueButton)).click();
				
				
				Thread.sleep(4000);
				String ship = driver.findElement(By.xpath("//label[contains(text(),'Ubuy Super Express 3-6 Business days (Customs dela')]")).getText();
				
				String[] part3 = ship.split("(?<=\\D)(?=\\d)");
			
				System.out.println(part3[0]);
				
				System.out.println("-----------");
				
				
				
				
				
				
				
				
				
		
		
		
		
		
		}
	
}
}
