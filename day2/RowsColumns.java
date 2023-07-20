package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RowsColumns {

	public static void main(String[] args) {
		
		ChromeDriver  driver=new ChromeDriver();
        driver.get("https://html.com/tags/table/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        List<WebElement> rows = driver.findElements(By.xpath("//div[@class='render']/table//tr"));
        List<String> rowscount=new ArrayList<String>();
        for(int i=0;i<rows.size();i++) {
        	rowscount.add(rows.get(i).getText());
        }
        System.out.println("Rows Count: "+rowscount.size());
        
       List<WebElement> columns = driver.findElements(By.xpath("//div[@class='render']/table//th"));
       List<String> columnscount=new ArrayList<String>();
        for(int j=0;j<columns.size();j++) {
        	columnscount.add(rows.get(j).getText());        	
        }
        System.out.println("columns Count: "+columnscount.size());

	}

}
