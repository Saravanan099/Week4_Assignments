package Week4.Day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException{
		WebDriverManager.chromedriver().setup();
		
		//launching chromebrowser by disabling notifications
				ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.nykaa.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		// Locating the Main Menu (Parent element)
		WebElement mainMenu = driver.findElement(By.xpath("//a[text()=\"brands\"]"));

		
		//Instantiating Actions class
		Actions actions = new Actions(driver);
		

		//Hovering on main menu
		actions.moveToElement(mainMenu).perform();
		

//		// Locating the element from Sub Menu
//		WebElement subMenu = driver.findElement(By.xpath("(//div[@class='css-ov2o3v']//a)[6]"));
		WebElement subMenu = driver.findElement(By.xpath("//a[text()=\"L'Oreal Paris\"]"));
		subMenu.click();
		
		//4) Check the title contains L'Oreal Paris(Hint-GetTitle)
		if(driver.getTitle().equalsIgnoreCase("L'Oreal Paris")){
			System.out.println("Find title loreal paris");
		}
		
		//Click sort By and select customer top rated
		driver.findElement(By.xpath("//span[text()=\"Sort By : popularity\"]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.xpath("//span[text()=\"customer top rated\"]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
//		click category
		driver.findElement(By.xpath("//span[text()=\"Category\"]")).click();
		
//		click Hair
		driver.findElement(By.xpath("//span[text()=\"Hair\"]")).click();	
		
		
//		click hair care
		driver.findElement(By.xpath("//span[text()=\"Hair Care\"]")).click();
		
//		click shampoo
		driver.findElement(By.xpath("//span[text()=\"Shampoo\"]")).click();
		
//		click concern
		driver.findElement(By.xpath("//span[text()=\"Concern\"]")).click();
//		click color protection
		driver.findElement(By.xpath("//span[text()='Color Protection']/following::div[@class='control-indicator checkbox '][1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

//8)check whether the Filter is applied with Shampoo
		
			if((driver.findElement(By.xpath("(//div[@class=\"css-xrzmfa\"])[1]")).getText()).equalsIgnoreCase("Shampoo")) {
				System.out.println("Filter applied for shampoo");
			}
						
			
			driver.findElement(By.xpath("(//div[@class='css-xrzmfa'])[1]")).click();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Thread.sleep(2000);
			//9) GO to the new window and select size as 175ml
			//now get the window handles too
			Set<String> windowHandles = driver.getWindowHandles();
			ArrayList<String> windowList = new ArrayList<String>(windowHandles);
			String newwindow = windowList.get(1);
			driver.switchTo().window(newwindow);
			String title=driver.getTitle();
			System.out.println(title);
			
			WebElement selml=driver.findElement(By.xpath("//select[@title=\"SIZE\"]"));
			Select ml = new Select(selml);
			ml.selectByValue("0");
			
//			11) Print the MRP of the product
			WebElement findMRP = driver.findElement(By.xpath("(//span[@class='css-1jczs19'])[1]"));
			System.out.println("The MRP is:"+findMRP.getText());
			
//			12) Click on ADD to BAG
			driver.findElement(By.xpath("(//span[@class=\"btn-text\"])[1]")).click();			
			
//			13) Go to Shopping Bag 
			driver.findElement(By.xpath("//button[@class=\"css-g4vs13\"]")).click();
			
//			14) Print the Grand Total amount
			
			driver.switchTo().frame(0);
			String GrandTotal = driver.findElement(By.xpath("//div[@class=\"value medium-strong\"]")).getText();
			String GrandTotal1=GrandTotal.replace("?","");
			System.out.println("Grand Total is: "+GrandTotal1);			
			
			
//			15) Click Proceed
			driver.findElement(By.xpath("//button[@class=\"btn full fill no-radius proceed \"]")).click();
			
			
//			16) Click on Continue as Guest
			driver.findElement(By.xpath("//button[@class=\"btn full big\"]")).click();
			
//			17) Check if this grand total is the same in step 14
			String Guest_GrandTotal = driver.findElement(By.xpath("(//div[@class=\"value\"])[2]")).getText();
			String Guest_GrandTotal1=GrandTotal.replace("?","");
			System.out.println("Guest Grand Total is: "+Guest_GrandTotal1);	
			
			if (GrandTotal1==Guest_GrandTotal1) {
				System.out.println("Both prize are matching: " + Guest_GrandTotal1 );	
			}else {
				System.out.println("Both prize are not matching: " + Guest_GrandTotal1 );		
			}
			
//			18) Close all windows
			driver.quit();
			
			
//			
			
			
		
		
//		
//		//5) Click sort By and select customer top rated
//		 		driver.findElement(By.xpath("//div[@class='css-0']//button[1]")).click();
//		//Customer top rated
//		driver.findElement(By.xpath("//span[text()='Avg Customer Rating']")).click(); 	
		//6) Click Category and click Shampoo
//		Thread.sleep(5000);
//		driver.findElement(By.xpath("//div[@class='filter-open css-1kwl9pj']")).click();
//		driver.findElement(By.xpath("//li[@class='css-1do4irw']//div")).click();
//		driver.findElement(By.xpath("(//li[@class='css-1do4irw']//div)[2]")).click();
		
		
		
		
		
		
	
//		//7) Click->Concern->Color Protection
//		driver.findElement(By.xpath("(//div[@class='filter-open css-1kwl9pj'])[6]")).click();
//		driver.findElement(By.xpath("(//div[@class='control-indicator checkbox '])[6]")).click();
//		//8) Click on L'Oreal Paris Colour Protect Shampoo
//		driver.findElement(By.xpath("//img[@src='https://images-static.nykaa.com/media/catalog/product/tr:w-200,h-200,cm-pad_resize/1/5/153d065LPSAMP.jpg']")).click();
//		//9) GO to the new window and select size as 175ml
//		//now get the window handles too
//		Set<String> winSet1=driver.getWindowHandles();
//		List<String> winList1=new ArrayList<String>(winSet1);
//		driver.switchTo().window(winList1.get(2));
//		String title=driver.getTitle();
//		System.out.println(title);
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//span[text()='175ml']")).click();
//		//driver.findElementByXPath("(//span[@class='size-pallets'])[2]").click();
//		Thread.sleep(2000);
//		//10) Print the MRP of the product
//		String shampooprice=driver.findElement(By.xpath("//div[@class='css-1d0jf8e']//span)[3]")).getText();
//		String price=shampooprice.replaceAll("\\D","");
//		int pricevalue=Integer.parseInt(price);
//		System.out.println(pricevalue);
//		Thread.sleep(2000);
//		//11) Click on ADD to BAG
//		driver.findElement(By.xpath("//div[@class='css-6u29zb']//button[1]")).click();
//		Thread.sleep(2000);
//		//12) Go to Shopping Bag 
//		driver.findElement(By.xpath("//button[@class='css-g4vs13']//span[1]")).click();
//		Thread.sleep(2000);
//		//13) Print the Grand Total amount
//		String pr1=driver.findElement(By.xpath("//span[text()='Grand Total']/following-sibling::div")).getText();
//		//String pr2=pr1.replaceAll("\\D","");
//		//int prval=Integer.parseInt(pr2);
//		System.out.println("The grand total amount is"+pr1);
//		//14) Click Proceed
//		driver.findElement(By.xpath("//button[contains(@class,'btn full')]")).click();
//
//		//15) Click on Continue as Guest
//		driver.findElement(By.xpath("//button[text()='CONTINUE AS GUEST']")).click();
//
//		//17) Check if this grand total is the same in step 14
//		
//		//18) Close all windows
//		driver.quit();
//		
//		
//		
//		
//	      
//		
//		//build()- used to compile all the actions into a single step 
//		actions.click().build().perform();
		

	}

}
