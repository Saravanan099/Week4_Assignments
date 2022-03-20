package Week4.Day2;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		 ChromeDriver driver=new ChromeDriver();
		 driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement elementUserName= driver.findElement(By.id("username"));
		 elementUserName.sendKeys("Demosalesmanager");
		 WebElement elementPassword= driver.findElement(By.id("password"));
		 elementPassword.sendKeys("crmsfa");
		 WebElement elementLogingButton= driver.findElement(By.className("decorativeSubmit"));
		 elementLogingButton.click();
		 WebElement elementCRMSFA= driver.findElement(By.linkText("CRM/SFA"));
		 elementCRMSFA.click();
		 driver.findElement(By.linkText("Contacts")).click();
		 driver.findElement(By.linkText("Merge Contacts")).click();
		 driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
		 Set<String> windowHandles = driver.getWindowHandles();
		 List<String> allwindowHandleList= new ArrayList<String>();
		 allwindowHandleList.addAll(windowHandles);
		System.out.println(driver.switchTo().window(allwindowHandleList.get(1)));
		System.out.println("Navigated page - "+driver.getCurrentUrl());
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
	    driver.switchTo().window(allwindowHandleList.get(0));
		System.out.println("Navigated page - "+driver.getCurrentUrl());
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		 Set<String> windowHandlesTwo = driver.getWindowHandles();
		 List<String> allwindowHandleListTwo= new ArrayList<String>();
		 allwindowHandleListTwo.addAll(windowHandlesTwo);
		System.out.println(driver.switchTo().window(allwindowHandleListTwo.get(1)));
		System.out.println("Navigated page - "+driver.getCurrentUrl());
		driver.manage().window().maximize();
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[2]")).click();
	    driver.switchTo().window(allwindowHandleList.get(0));
	    System.out.println("Navigated page - "+driver.getCurrentUrl());
	    driver.findElement(By.linkText("Merge")).click();
	    Alert alert = driver.switchTo().alert();
	    String text = alert.getText();
	    System.out.println("Alert Text " + text);
	    alert.accept();
	    System.out.println("After Navigate - "+driver.getCurrentUrl());
	    
	}
		 
}		 