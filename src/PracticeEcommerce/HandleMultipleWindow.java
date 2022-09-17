package PracticeEcommerce;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleMultipleWindow {

	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://accounts.google.com/SignUp?hl=en");


		WebElement help = driver.findElement(By.xpath("//a[@href='https://support.google.com/accounts?hl=en&p=account_iph']"));
		WebElement privacy = driver.findElement(By.xpath("//a[@href='https://accounts.google.com/TOS?loc=CA&hl=en&privacy=true']"));
		
		help.click();
		privacy.click();
		Thread.sleep(10);
//		driver.findElement(By.id("yDmH0d")).sendKeys("testing");
//		driver.findElement(By.xpath("//a[@class='gb_1 gb_2 gb_8d gb_8c']")).click();


		
		Set<String>ids= driver.getWindowHandles();

		Iterator<String> it= ids.iterator();

		String parentID =it.next();
		String ChildID1 =it.next();
		String ChildID2 =it.next();

		driver.switchTo().window(parentID);
		driver.switchTo().window(ChildID2);
		driver.switchTo().window(ChildID1);
		


//
//		driver.findElement(By.xpath("//a[@href='https://www.google.com/policies/']")).click();
//
//		ids= driver.getWindowHandles();
//
//		it= ids.iterator();
//
//		parentid=it.next();
//
//		Childid=it.next();
//
//		String Subchildid=it.next();
//
//		driver.switchTo().window(Subchildid);
//
//		System.out.println(driver.getTitle());
	}

}
