package Week4.Day2;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
public class FrameChercher {

	public static void main(String[] args) {
		 WebDriverManager.chromedriver().setup();
		 ChromeDriver driver=new ChromeDriver();
		 driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
		 List<WebElement> FrameCount=driver.findElements(By.tagName("iframe"));
		 System.out.println("Frame count is: "+FrameCount.size());
		 driver.switchTo().frame(0);
		 
//		 Frame 1
		 driver.findElement(By.xpath("(//input)[1]")).sendKeys("I'm Saravanan");
		 

//		 	Click checkbox
		 	WebElement Frame3 = driver.findElement(By.id("frame3"));						
			driver.switchTo().frame(Frame3);		
			driver.findElement(By.xpath("//input[@type='checkbox']")).click();

			
			//select animal
			driver.switchTo().defaultContent();
			WebElement Frame2 = driver.findElement(By.id("frame2"));						
			driver.switchTo().frame(Frame2);			
			WebElement DropDown = driver.findElement(By.id("animals"));
			Select DD = new Select(DropDown);
			DD.selectByVisibleText("Big Baby Cat");
			driver.switchTo().defaultContent();	 		 
	
	}

}
