package newcountries;
 
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Augmenter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
 
public class ScareenShotTaken{
	
	
	/*

*
* date 18/12/2019
* 
* Autoher by Shailendra singh
*
*
*/
	
	/* public static WebDriver driver; */
 
static WebDriver webDriver;
	
	@Test
	public static void captureScreenMethod() throws Exception{
		
	/*System.setProperty("webdriver.chrome.driver", "D:\\SeleniumPrograms\\DataDrivenFramWork\\Lib\\chromedriver.exe");
		webDriver = new ChromeDriver();
			webDriver.manage().window().maximize();*/
			
			// Headless Browser
		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * "D:\\UBUY_WorkSpace\\UBUY Checkout\\lib\\chromedriver.exe");
		 * System.setProperty("webdriver.chrome.logfile",
		 * "D:\\UBUY_WorkSpace\\UBUY Checkout\\lib\\chromedriver.txt"); ChromeOptions op
		 * = new ChromeOptions(); op.addArguments("window-size=1400,800");
		 * op.addArguments("headless"); webDriver = new ChromeDriver(op);
		 */
		
		System.setProperty("webdriver.chrome.driver", "D:\\UBUY_WorkSpace\\UBUY Checkout\\lib\\chromedriver.exe");
		webDriver = new ChromeDriver();
			webDriver.manage().window().maximize();

			FileInputStream file = new FileInputStream(new File("D:\\Adrress.xlsx"));
			@SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheetAt(0);
		//	logger.info("Lauch URl");
			
			for(int i=0; i<=sheet.getLastRowNum(); i++)
			{
			String url = sheet.getRow(i).getCell(0).getStringCellValue();
			System.out.println(url);
			webDriver.get(url);
			
			
			
			
			String str1 = webDriver.findElement(By.xpath("//div[@class='dropdown country-selector']")).getText();
			
			
			Thread.sleep(5000);
			webDriver.findElement(By.xpath("//li[@class='mobile-hide-links']//a[contains(text(),'Contact Us')]")).click();
			
			
		
				
			
					
		String st	=webDriver.findElement(By.xpath("//div[@class='ubuy-india-address']")).getText();
				
			System.out.println(str1);
			System.out.println(st);
			System.out.println("------");
				
					
				
		
			
		
			
			
			File scrFile = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
			// Now you can do whatever you need to do with it, for example copy somewhere
			FileUtils.copyFile(scrFile, new File("c:\\tmp\\screenshot.png"+1));
			
			
			
			
			
			
			
	 
			}
 }
	
	
}