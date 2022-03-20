package Week4.Day2;
	
	import java.util.Collections;
	import java.util.HashSet;
	import java.util.LinkedHashSet;
	import java.util.List;
	import java.util.Set;
	import java.util.TreeSet;
	import java.time.Duration;
	import java.util.ArrayList;
	import java.util.Arrays;
	import java.util.Collection;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


	public class WebTable {

		public static void main(String[] args) {
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.get("http://www.leafground.com/pages/table.html");
			
			//table
			WebElement table = driver.findElement(By.id("table_id"));
			
			//find column count
			List<WebElement> ColumnCount= table.findElements(By.tagName("th"));					 
			System.out.println("The count of column:"+ColumnCount.size());			
			//find row count
			List<WebElement> RowCount= table.findElements(By.tagName("tr"));			
			System.out.println("The count of rows:"+RowCount.size());		
							
//				/loop through table
				for(int i=1;i<RowCount.size();i++) {
					WebElement EachRow = RowCount.get(i);
					WebElement ColData = EachRow.findElements(By.tagName("td")).get(0);
					if(ColData.getText().equals("Learn to interact with Elements")) {
					String Progresstext = EachRow.findElements(By.tagName("td")).get(1).getText();
						System.out.println("The progress value of Learn to interact with Elements:" +Progresstext);
						}
				}
				
				
				//find least completed progress
				List<Integer> TableAdd=new ArrayList<Integer>();
				
				List<WebElement> TBrowcount= table.findElements(By.tagName("tr"));
				
				for(int k=1;k<TBrowcount.size();k++) {
					WebElement EachRow1 = TBrowcount.get(k);
					WebElement ColData1 = EachRow1.findElements(By.tagName("td")).get(1);
					String text = ColData1.getText();
					String replace=text.replace("%", "");
					int value=Integer.parseInt(replace);
					TableAdd.add(value);
					Collections.sort(TableAdd);
				}				
				
				Integer Pvalue = TableAdd.get(0);		
				if (Pvalue.equals(30)) {					
					driver.findElements(By.xpath("//td/input")).get(2).click();
				}
				
				
	}
}
