package PracticeEcommerce;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeChildWindow {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		//click link to open child window
		driver.findElement(By.cssSelector("a[class='blinkingText']")).click();
		
		//traverse windows
		Set<String> window = driver.getWindowHandles(); //[parentID, childID]
		Iterator<String> id = window.iterator();
		String parentID = id.next();
		String childID = id.next();
		
		driver.switchTo().window(childID);
		System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());

		driver.findElement(By.cssSelector(".im-para.red")).getText();

		String emailId= driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
		
		driver.switchTo().window(parentID);

		driver.findElement(By.id("username")).sendKeys(emailId);
		
		driver.switchTo().window(childID);
	}

}
