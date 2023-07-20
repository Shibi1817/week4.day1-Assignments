package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Chittorgarh {

	public static void main(String[] args) {
		
		ChromeDriver  driver=new ChromeDriver();
        driver.get("https://www.chittorgarh.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(By.id("navbtn_stockmarket")).click();
        driver.findElement(By.linkText("NSE Bulk Deals")).click();
        List<WebElement> securityName = driver.findElements(By.xpath("//table[contains(@class,'table table-bordered table')]//td/a"));
        List<String> securityNamelist=new ArrayList<String>();
        for(int i=0;i<securityName.size();i++) {
        	securityNamelist.add(securityName.get(i).getText());
        }
        System.out.println(securityNamelist);
        
        System.out.println();
        Set<String> set1=new LinkedHashSet<String>(securityNamelist);
        if(securityNamelist.size()==set1.size()) {
        	System.out.println("No Duplicates in the List");
        }
        else {
        	System.out.println("The list  contains Duplicate");
        }

	}

}
