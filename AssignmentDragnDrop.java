package Week4.Day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignmentDragnDrop {
	 	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		 ChromeDriver driver=new ChromeDriver();
		 driver.get("http://www.leafground.com/pages/drop.html");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Element for drag
		 WebElement From=driver.findElement(By.id("draggable"));
		 
		//Element for drop.
		 WebElement To=driver.findElement(By.id("droppable"));
		//Using Action class for drag and drop.		
         Actions act=new Actions(driver);					

	//Dragged and dropped.		
         act.dragAndDrop(From, To).build().perform();	
         
         if(driver.findElement(By.xpath("//p[text()='Dropped!']")).isDisplayed())							
      	{		
          	System.out.println("Drag and Drop is Successful !!!");					
      	}
 		else
      	{
         	System.out.println("Drag and Drop is not Successful !!!");					
      	}		
 
	}
}

