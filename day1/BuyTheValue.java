package week4.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;

public class BuyTheValue {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver  driver=new ChromeDriver();
		driver.manage().window().maximize();
        driver.get("https://buythevalue.in/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//a[@class='product-title']")).click();
        Thread.sleep(5000);
        WebElement close = driver.findElement(By.xpath("//div[@class='hxt-spm-clickable']"));
        close.click();
        driver.findElement(By.xpath("//input[@id='wk_zipcode']")).sendKeys("636903");
        Thread.sleep(4000);
        driver.findElement(By.xpath("//div[@class='wk_zipfinder_btn']/input")).click();
        Thread.sleep(4000);
        
        
        driver.findElement(By.id("product-add-to-cart")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//a[text()='View Cart'])[2]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("(//div[contains(@id,'com-hextom-smartpushmarketing')])[3]")).click();
        
        driver.findElement(By.xpath("//input[@id='checkout']")).click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        alert.accept();

	}

}
