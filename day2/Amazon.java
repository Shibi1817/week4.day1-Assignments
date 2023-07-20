package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Amazon {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		ChromeOptions ch=new ChromeOptions();
        ch.addArguments("--disable-notifications");
		ChromeDriver  driver=new ChromeDriver(ch);
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro",Keys.ENTER);
        String price = driver.findElement(By.xpath("(//span[@class='a-price-symbol']/following-sibling::span)[1]")).getText();
		System.out.println("Price of the product: "+price);
		driver.findElement(By.xpath("(//i[contains(@class,'a-icon a-icon-popover')])[1]")).click();	
		
		String rating = driver.findElement(By.xpath("//span[contains(@class,'a-size-medium a-color-base a-text-beside-button a-text-bold')]")).getText();
		System.out.println("Rating: "+rating);
		
		String percentage = driver.findElement(By.xpath("(//span[@class='a-size-base']/a)[2]")).getText();
		System.out.println("Percentage for 5stars: "+percentage);
		
		driver.findElement(By.xpath("(//a[contains(@class,'a-link-normal s-no-outline')]//img)[1]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> list1=new ArrayList<String>(windowHandles);
		driver.switchTo().window(list1.get(1));
		WebElement img = driver.findElement(By.xpath("//div[@class='imgTagWrapper']/img"));
		Actions build=new Actions(driver);
		build.scrollToElement(img).perform();
		File source=driver.getScreenshotAs(OutputType.FILE);
		File loc=new File("./snap/amazon.png");
		FileUtils.copyFile(source, loc);
		driver.findElement(By.id("add-to-cart-button")).click();
		Thread.sleep(5000);
		String total = driver.findElement(By.xpath("//span[contains(@id,'attach-accessory-cart-subtotal')]")).getText();
		System.out.println("Grand total amount is: "+total);
		
		

	}

}
