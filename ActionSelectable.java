package Week4.Day2;

	import java.time.Duration;

	import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.interactions.Actions;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class ActionSelectable {

		public static void main(String[] args) throws Throwable{
			WebDriverManager.edgedriver().setup();
			 EdgeDriver driver=new EdgeDriver();
			 driver.get("https://jqueryui.com/selectable/");
			 driver.manage().window().maximize();
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			
			 WebElement frameElement = driver.findElement(By.className("demo-frame"));
				frameElement.click();
	       	driver.switchTo().frame(frameElement);
				
					WebElement item1 = driver.findElement(By.xpath("//li[text()='Item 1']"));
					WebElement item2 = driver.findElement(By.xpath("//li[text()='Item 3']"));
					WebElement item3 = driver.findElement(By.xpath("//li[text()='Item 5']"));
//					WebElement item4 = driver.findElement(By.xpath("//li[text()='Item 7']"));
					
					Actions builder = new Actions(driver);
				  builder.keyDown(Keys.CONTROL).click(item1) .click(item2) .click(item3)
					 .keyUp(Keys.CONTROL).perform();
					 
					//Actions builder = new Actions(driver);	
//					builder.clickAndHold(item1)
//						.moveToElement(item3)
//						.release()
//						.perform();
//	    
//	    
//	    builder.keyDown(Keys.CONTROL).click(item1).click(item2).click(item3).keyUp(Keys.CONTROL).perform();
		}
	}
	
	    
	    