package Week4.Day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(" https://www.amazon.in/");
		
		//search as oneplus 9 pro 
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro",Keys.ENTER);
		
		//Get the price of the first product
		String text = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
		System.out.println("Price of the first product is: "+text);
		
		//print the number of customer ratings for the first displayed product
		WebElement cusRating = driver.findElement(By.xpath("(//span[@class=\"a-icon-alt\"])[1]"));
		String text2 = cusRating.getText();
		System.out.println("No of Customer Rated: "+text2);
		
		//click on the stars
		WebElement starElement = driver.findElement(By.xpath("(//a[@role='button']//i)[2]"));
		Thread.sleep(1000);
		//Get the percentage of ratings for the 5 star
		driver.findElement(By.xpath("(//a[@role='button'])[4]")).click();
		Actions builder = new Actions(driver);
		builder.click(starElement).perform();
		Thread.sleep(1000);
		WebElement ratingPercent = driver.findElement(By.xpath("(//a[@title='5 stars represent 65% of rating'])[3]"));
		String text3 = ratingPercent.getText();		
		System.out.println("Percentage for 5 star Rating "+text3);
		
//		7. Click the first text link of the first image
		driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();	
		
//		Switch to window
		 ArrayList<String> NewTAB = new ArrayList<String>(driver.getWindowHandles());
		 driver.switchTo().window(NewTAB.get(1));
		 Thread.sleep(2000);
		 
		 //Add to Cart		 	 
		 driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		 Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
			Set<String> windowHandles = driver.getWindowHandles();
			List<String> windowhandlesList=new ArrayList<String>(windowHandles);
			driver.switchTo().window(windowhandlesList.get(1));
		 

		 //Get the cart subtotal and verify if it is correct
		 WebElement cartAmt = driver.findElement(By.xpath("(//span[@id=\"attach-accessory-cart-subtotal\"])[1]"));
			String text4 = cartAmt.getText();
			String replaceAll = text4.replaceAll("['a-zA-Z?']", "");
			System.out.println("Cart subtotal is: "+text4);
			if(text.equalsIgnoreCase(replaceAll))
			{
				System.out.println("Price are Equal");
			}else{
				System.out.println("Price are not Equal");
			}
			
		}
		
}
