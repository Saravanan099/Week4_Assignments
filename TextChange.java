package Week4.Day2;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TextChange {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		  ChromeDriver driver=new ChromeDriver();
		  driver.get("http://www.leafground.com/pages/TextChange.html");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Click ME!']")));
	    driver.findElement(By.xpath("//button[text()='Click ME!']")).click();
	    Alert alert = driver.switchTo().alert();
	    alert.accept();
	    
	    File src = driver.getScreenshotAs(OutputType.FILE) ;
	
	    
	     FileUtils.copyFile(src, new File("./snaps/snap4.jpg"));

	}

}