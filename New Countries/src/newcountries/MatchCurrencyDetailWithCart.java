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
			
			System.out.println(DetailPrice);
			
			//Thread.sleep(5000);
			
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
				
				System.out.println(CartPagePrice);
				System.out.println("-----------");
				Thread.sleep(5000);
		
		
		
		
		
		}
	
}
}
