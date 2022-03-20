package Week4.Day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignmentSortableElement {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/sortable.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebElement item1 = driver.findElement(By.xpath("//li[@class = \"ui-state-default ui-sortable-handle\"][7]"));
		WebElement item2 = driver.findElement(By.xpath("//li[@class = \"ui-state-default ui-sortable-handle\"][6]"));
		WebElement item3 = driver.findElement(By.xpath("//li[@class = \"ui-state-default ui-sortable-handle\"][5]"));
		WebElement item4 = driver.findElement(By.xpath("//li[@class = \"ui-state-default ui-sortable-handle\"][4]"));
		WebElement item5 = driver.findElement(By.xpath("//li[@class = \"ui-state-default ui-sortable-handle\"][3]"));
	WebElement item6 = driver.findElement(By.xpath("//li[@class = \"ui-state-default ui-sortable-handle\"][2]"));
	WebElement item7 = driver.findElement(By.xpath("//li[@class = \"ui-state-default ui-sortable-handle\"][1]"));
	
	Actions actions = new Actions(driver);
	// Call moveToElement() method of actions class to move mouse cursor to a WebElement A. 
	  actions.moveToElement(item1); 
	   actions.clickAndHold(); 
	   actions.moveToElement(item2); 
	   actions.clickAndHold(); 
	   actions.moveToElement(item3); 
	   actions.clickAndHold(); 
	   actions.moveToElement(item4); 
	   actions.clickAndHold(); 
	   actions.moveToElement(item5); 
	   actions.clickAndHold(); 
	   actions.moveToElement(item6); 
	   actions.clickAndHold(); 
	   actions.moveToElement(item7); 
	   actions.clickAndHold().release().perform(); 
	
	}
	
}
