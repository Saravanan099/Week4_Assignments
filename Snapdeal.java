package Week4.Day2;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Snapdeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.snapdeal.com/");
		
		WebElement mensFashion = driver.findElement(By.xpath("//a[@class='menuLinks leftCategoriesProduct ']/span[contains(text(),'Men')]"));
		//Go to Shorts Shoes
		WebElement shoes = driver.findElement(By.xpath("//span[text()='Sports Shoes']"));
		
		
       Actions builder = new Actions(driver);
		builder.moveToElement(mensFashion).pause(1000).click(shoes).perform();
		
		String result = driver.findElement(By.xpath("//span[@class='category-name category-count']")).getText();
		System.out.println(result);
		
		//Click Training shoes
		WebElement trainingShoes = driver.findElement(By.xpath("//div[text()='Training Shoes']"));
		trainingShoes.click();
		
		//Sort by Low to High
           driver.findElement(By.xpath("//i[contains(@class,'sd-icon sd-icon-expand-arrow')]")).click();
		driver.findElement(By.xpath("(//ul[@class='sort-value']//li)[2]")).click();
		
		//Check if the items displayed are sorted correctly
		String text1=driver.findElement(By.xpath("(//div[contains(text(),\"Price Low To High\")])[1]")).getText();
		if(text1.equalsIgnoreCase("Price Low To High")) {
			System.out.println(text1);
		}
		
		
		
		//Select the price range (900-1200)
		 WebElement StartPrice =driver.findElement(By.xpath("(//input[@class=\"input-filter\"])[1]"));
		 StartPrice.clear();
		 StartPrice.sendKeys("900");
		
		 WebElement EndPrice=driver.findElement(By.xpath("(//input[@class=\"input-filter\"])[2]"));
		 EndPrice.clear();
		 EndPrice.sendKeys("1200");
		 Thread.sleep(1000);
		
	      driver.findElement(By.xpath("//div[contains(text(),'GO')]")).click();	       
	      Thread.sleep(1500);
	   	       
	     //Filter with color Navy 
//  driver.findElement(By.xpath("//label[@for='Color_s-Navy']")).click();
	      driver.findElement(By.xpath("span[@class=\"filter-color-tile Red \"]")).click();
	   
                
         //verify the all applied filters
      //  no shoes available in navy blue now
         
         
         //Mouse Hover on first resulting Training shoes
         		WebElement firstShoe = driver.findElement(By.xpath("(//img[@class='product-image wooble'])[1]"));
          		builder.moveToElement(firstShoe).perform();
 		 		Thread.sleep(2000);
 		
 		//click QuickView button
 		driver.findElement(By.xpath("//div[contains(text(),'Quick View')][1]")).click();
 		
// 		13. Print the cost and the discount percentage
 		String pricecart = driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText();
 		System.out.println("The cost of the shoe:"+pricecart);
 		
 		String discountcart = driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText();
 		System.out.println("The discount percentage of the shoe:"+discountcart);
 		
// 		14. Take the snapshot of the shoes.
 		WebElement snap= driver.findElement(By.xpath("//img[@class='cloudzoom']"));		
 		 File screenshot= snap.getScreenshotAs(OutputType.FILE);
 		 File image=new File("./snaps/image.png");
 		 FileUtils.copyFile(screenshot, image);
 		 WebElement Element = driver.findElement(By.xpath("//div[@class='close close1 marR10']"));
 		 Element.click();

// 		15. Close the current window 
 		 driver.close();
// 		16. Close the main window
 		
 		driver.quit();
	}

}
