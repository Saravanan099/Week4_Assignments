package Week4.Day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionDraggable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/drag.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		 WebElement From=driver.findElement(By.xpath("//div[@id=\"draggable\"]"));
//			WebElement dropEle = driver.findElement(By.id("droppable"));	 
				//Using Action class for drag and drop.		
			        Actions act=new Actions(driver);					
			      
			        //Drag and Drop by Offset.		
			        act.dragAndDropBy(From,135, 40).build().perform();
		
	}

}
