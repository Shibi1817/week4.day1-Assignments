package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions ch=new ChromeOptions();
        ch.addArguments("--disable-notifications");
		ChromeDriver  driver=new ChromeDriver(ch);
        driver.get("https://www.nykaa.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WebElement brands = driver.findElement(By.xpath("//a[text()='brands']"));
        Actions build=new Actions(driver);
        build.moveToElement(brands).perform();
        driver.findElement(By.id("brandSearchBox")).sendKeys("L'Oreal Paris");
        driver.findElement(By.partialLinkText("L'Oreal Paris")).click();
        Thread.sleep(5000);
        WebElement sort = driver.findElement(By.xpath("(//*[local-name()='svg' and @class='arrow-icon']/*[local-name()='path'])[1]"));        
        build.click(sort).perform();
        driver.findElement(By.xpath("(//div[contains(@class,'control-indicator radio ')])[4]")).click();
        driver.findElement(By.xpath("//a[@id='category']")).click();
        WebElement hair = driver.findElement(By.xpath("//a[text()='hair']"));
        build.moveToElement(hair).perform();
        driver.findElement(By.xpath("(//a[text()='Shampoo'])[1]")).click();
        Set<String> shampoo = driver.getWindowHandles();
        List<String>windowlist1=new ArrayList<String>(shampoo);
        driver.switchTo().window(windowlist1.get(1));
        WebElement img = driver.findElement(By.xpath("(//a[@class='css-qlopj4'])[2]"));
        build.moveToElement(img).perform();
        Thread.sleep(5000);
        WebElement size = driver.findElement(By.xpath("//button[contains(text(),'Preview Size')]"));
        build.click(size).perform();
        driver.findElement(By.xpath("(//label[contains(@class,' control css-9bkcvr')]/div)[2]")).click();
        Thread.sleep(2000);
        String text = driver.findElement(By.xpath("(//div[contains(@class,'css-1d0jf8e')])[2]/span[2]")).getText();
        System.out.println("The price of the product: "+ text);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class=' css-fe38g']/span")).click();
       
        driver.findElement(By.xpath("//button[@class='css-aesrxy']")).click();
        //*[local-name()='button' and @class='css-aesrxy']/*[local-name()='svg']
        WebElement frame = driver.findElement(By.xpath("//iframe[@class='css-acpm4k']"));
        driver.switchTo().frame(frame);
        String text2 = driver.findElement(By.xpath("//span[contains(@class,'css-1um1mkq e171rb9k3')]")).getText();
        System.out.println("The grand total of the product: "+text2);
        driver.findElement(By.xpath("//div[contains(@class,'css-ltzjhp e25lf6d7')]//div")).click();
        
        String text3 = driver.findElement(By.xpath("//p[contains(@class,'css-1e59vjt eka6zu20')]")).getText();
        if(text2.equals(text3)) {
        	System.out.println("The grand total is same");
        }
        else {
        	System.out.println("The grand total is different");
        }
        driver.findElement(By.xpath("//button[text()='Continue as guest']")).click();
        driver.quit();
        

	}

}
