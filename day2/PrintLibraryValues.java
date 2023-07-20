package week4.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrintLibraryValues {

	public static void main(String[] args) {
		
		ChromeDriver  driver=new ChromeDriver();
        driver.get("https://html.com/tags/table/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        List<WebElement> marketShare = driver.findElements(By.xpath("//div[@class='render']/table//tbody/tr[1]/td"));
        for(int i=0;i<marketShare.size();i++) {
        	System.out.println(marketShare.get(i).getText()); 
        }
        List<WebElement> absoluteUsage = driver.findElements(By.xpath("//div[@class='render']/table//tbody/tr[2]/td"));
        for(int j=0;j<absoluteUsage.size();j++) {
        	System.out.println(absoluteUsage.get(j).getText());
        }
        driver.close();

	}

}
