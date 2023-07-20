package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Mynthra {

	public static void main(String[] args) throws IOException {

		ChromeOptions ch=new ChromeOptions();
        ch.addArguments("--disable-notifications");
		ChromeDriver  driver=new ChromeDriver(ch);
        driver.get("https://www.myntra.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        Actions act=new Actions(driver);
        WebElement men = driver.findElement(By.xpath("(//div[@class='desktop-navLink']/a)[1]"));
        act.moveToElement(men).perform();
        driver.findElement(By.xpath("(//a[text()='Jackets'])[1]")).click();
        String text = driver.findElement(By.xpath("//span[@class='title-count']")).getText();
        System.out.println("Total no.of products: "+text);
        driver.findElement(By.xpath("(//div[@class='common-checkboxIndicator'])[1]")).click();
        driver.findElement(By.xpath("//div[@class='brand-more']")).click();
        driver.findElement(By.xpath("//input[contains(@class,'FilterDirectory-searchInput')]")).sendKeys("duke");
        driver.findElement(By.xpath("(//label[@class=' common-customCheckbox']/div)[1]")).click();
        driver.findElement(By.xpath("//span[contains(@class,'FilterDirectory-close sprites-remove')]")).click();
        List<WebElement> brand = driver.findElements(By.xpath("//h3[@class='product-brand']"));
        List<String> allbrand=new ArrayList<String>();
        for(WebElement each: brand) {
        	String s=each.getText();
        	allbrand.add(s);
        	
        }
        System.out.println(allbrand);    
        WebElement sort = driver.findElement(By.xpath("//span[text()='Recommended']"));
        act.moveToElement(sort).perform();
        driver.findElement(By.xpath("(//label[contains(@class,'sort-label ')])[4]")).click();
        String price = driver.findElement(By.xpath("(//span[contains(@class,'product-discountedPrice')])[1]")).getText();
        System.out.println("Discount price: "+price);
        driver.findElement(By.xpath("(//span[contains(@class,'product-discountedPrice')])[1]")).click();
        Set<String> windowHandles = driver.getWindowHandles();
        List<String>list1=new ArrayList<String>(windowHandles);
        driver.switchTo().window(list1.get(1));
        File source=driver.getScreenshotAs(OutputType.FILE);
		File loc=new File("./snap/mynthra.png");
		FileUtils.copyFile(source, loc);
        driver.findElement(By.xpath("//span[text()='WISHLIST']")).click();
        driver.close();

	}

}
