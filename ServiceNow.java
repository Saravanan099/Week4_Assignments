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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNow {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://dev112133.service-now.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebElement frameelement = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(frameelement);
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("Go1ns1de");
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		driver.findElement(By.id("filter")).sendKeys("Incidents",Keys.ENTER);
		driver.findElement(By.xpath("(//div[text()='Incidents'])[1]")).click();
		
		
		 WebElement frameElement1 = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(frameElement1);
		driver.findElement(By.xpath("//button[text()='New']")).click();
		String IncidentNumber = driver.findElement(By.id("incident.number")).getAttribute("value");
		System.out.println(IncidentNumber);
		driver.findElement(By.xpath("//input[@name='incident.short_description']")).sendKeys("TESTING FRAMES");
		driver.findElement(By.id("lookup.incident.caller_id")).click();
		
		Set<String> windowHandlesset = driver.getWindowHandles();
		List<String> windowHandleslist =new ArrayList<String>();
		windowHandleslist.addAll(windowHandlesset);
		String NewWindow = windowHandleslist.get(1);
		driver.switchTo().window(NewWindow);
		driver.findElement(By.xpath("//a[text()='Abel Tuter']")).click();
		String Oldwindow = windowHandleslist.get(0);
		driver.switchTo().window(Oldwindow);
		driver.switchTo().frame(frameElement1);
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		WebElement element = driver.findElement(By.linkText("All"));
		element.click();
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(IncidentNumber,Keys.ENTER);
		
		String Verify = driver.findElement(By.xpath("//a[@class='linked formlink']")).getText();
		if(IncidentNumber.equals(Verify))
		{
			System.out.println("Both Incident numbers are same");
		}
		else
		{
			System.out.println("Both Incident numbers are different");
		}
		
		File src = driver.getScreenshotAs(OutputType.FILE) ;
	
		FileUtils.copyFile(src, new File("./snaps/imag001.jpg"));
	
	
	
	}

}