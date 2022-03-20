package Week4.Day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignmentLeafgroundsAppear {

	public static void main(String[] args) {
		
			WebDriverManager.chromedriver().setup();
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			
			ChromeDriver driver =new ChromeDriver();
			driver.get("http://www.leafground.com/pages/appear.html");
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	        
	        WebElement appearBtn = driver.findElement(By.id("btn"));
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			
			wait.until(ExpectedConditions.visibilityOf(appearBtn));
			System.out.println("Text During Visibility "+appearBtn.getText());
		    	
			if(appearBtn.isDisplayed())
			{
				System.out.println("Button Visible");
			}
			else
			{
				System.out.println("Button disappear");
			}


	}

}
