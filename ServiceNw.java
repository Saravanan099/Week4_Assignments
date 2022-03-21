package Week4.Day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class ServiceNw {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		 ChromeDriver driver=new ChromeDriver();
		 driver.get("https://dev108965.service-now.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("Salem@1988");
		driver.findElement(By.id("sysverb_login")).click();
		driver.findElement(By.id("filter")).sendKeys("incident");
		driver.findElement(By.xpath("(//div[text()='All'])[2]")).click();
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("sysverb_new")).click();
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.id("lookup.incident.caller_id")).click();
		
		Set<String> allWindowHandleSet = driver.getWindowHandles();
		List<String> allWindowHandleList = new ArrayList<String>();
		allWindowHandleList.addAll(allWindowHandleSet);
		String newWindow = allWindowHandleList.get(1);
		driver.switchTo().window(newWindow);
		System.out.println(driver.getCurrentUrl());
		
		driver.findElement(By.xpath("//a[text()='Abel Tuter']")).click();
		//driver.switchTo().defaultContent();
		String newWindow1 = allWindowHandleList.get(0);
		driver.switchTo().window(newWindow1);
		System.out.println(driver.getCurrentUrl());
		
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("incident.short_description")).sendKeys("Testing the page service now");
		String incidentNumber = driver.findElement(By.id("incident.number")).getAttribute("Value");
		//String text = driver.findElement(By.xpath("//input[@data-type='string']")).getAttribute(newWindow1)
		System.out.println(incidentNumber);
		driver.findElement(By.xpath("(//button[text()='Submit'])[1]")).click();
		
		//String newWindow2 = allWindowHandleList.get(1);
		//driver.switchTo().window(newWindow2);
		//System.out.println(driver.getCurrentUrl());
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(incidentNumber);
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(Keys.ENTER);
		String incidentcheck = driver.findElement(By.xpath("(//td[@class='vt']/a)[1]")).getText();
		if(incidentNumber.equals(incidentcheck))
		{
			System.out.println("Incident Number verified");
		}
		
		File screenShot = driver.getScreenshotAs(OutputType.FILE);
		// Create an image file to store the screen shot
		File image = new File("./snaps/Service.jpg");
		// Merging temp screenshot and image file togeather
		FileUtils.copyFile(screenShot, image);

	}

}