package PracticeEcommerce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FrameTest {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://jqueryui.com/droppable/");
		
		//frame ID
		//frame webelement
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='demo-frame']")));
		
		//frame index
		driver.switchTo().frame(0); //first frame in the web
		
		//click frame inside an iframe
		driver.findElement(By.id("draggable")).click();
		
		
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));

		//drag and drop
		Actions a = new Actions(driver);
		a.dragAndDrop(source, target).build().perform();
		
		//switch back to normal window from iFrame 
		driver.switchTo().defaultContent();
		
		
		
		
		
	}

}
