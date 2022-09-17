package PracticeEcommerce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionDemo {

	public static void main(String[] args) {
		// testing in samsung website
		
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.samsung.com/ca/");

		Actions a = new Actions(driver);

		//mouse over - move to specific element
		//a.moveToElement(driver.findElement(By.xpath("(//span[@class='indicator__label'])[3]"))).build().perform();
		//or using
		WebElement move = driver.findElement(By.xpath("(//span[@class='indicator__label'])[3]"));
		a.moveToElement(move).build().perform();
		
		driver.findElement(By.xpath("//div[@class='gnb__mobile-menu']/a[@class='gnb__search-btn gnb__search-btn-js']")).click();
		
		WebElement move1 = driver.findElement(By.id("gnb-search-keyword"));
		a.moveToElement(move1).click().sendKeys("galaxY").doubleClick().build().perform();
				
				
	}

}
