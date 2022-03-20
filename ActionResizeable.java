package Week4.Day2;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionResizeable {

	public static void main(String[] args)  {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
				driver.get("https://jqueryui.com/resizable");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				WebElement findFrame = driver.findElement(By.className("demo-frame"));
				driver.switchTo().frame(findFrame);		
				WebElement sourceElement = driver.findElement(By.xpath("//div[contains(@class,'ui-resizable-handle ui-resizable-se')]"));
			    Actions builder=new Actions(driver);
				builder.clickAndHold().dragAndDropBy(sourceElement, 40, 20).perform();
		
		
		
		
		
		
//		driver.findElement(By.tagName("iframe")).click();
//		
//		System.out.println(driver.findElements(By.tagName("iframe")).size());
//		  
//		  driver.switchTo().frame(0);
//		  
//		  WebElement resize = driver.findElement(By.xpath("//*[@id='resizable']/div[3]"));
//		  
//		  Actions action = new Actions(driver);
//		  
//		  action.moveToElement(resize).dragAndDropBy(resize, 300, 100).build().perform();
//		  
//			
//		
//		WebElement frame = driver.findElement(By.xpath("html>body"));
//		
//		//WebElement frame = driver.findElement(By.xpath("//div[@id='content']//iframe[1]"));
//		driver.switchTo().frame(frame);
//		WebElement element = driver.findElement(By.xpath("(//div[@id='resizable']//div)[3]"));
//	Actions action = new Actions(driver);
//	action.dragAndDropBy(element, 300, 100).perform();
	
	}
}
