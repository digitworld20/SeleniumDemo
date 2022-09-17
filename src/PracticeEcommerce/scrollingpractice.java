package PracticeEcommerce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class scrollingpractice {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		js.executeScript("document.querySelector('div[class=\"tableFixHead\"]').scrollTop=300");
		
		int numRow = driver.findElements(By.cssSelector("div[class='tableFixHead'] td:nth-child(4)")).size();
		int count =0;
		for(int i=0;i<numRow ; i++) {
			int num1 = Integer.parseInt(driver.findElements(By.cssSelector("div[class='tableFixHead'] td:nth-child(4)")).get(i).getText());
			System.out.println(num1);
			count += num1;
			System.out.println(count);
		}
		System.out.println("total = " + count);

		int expectedNum = Integer.parseInt(driver.findElement(By.cssSelector("div[class='totalAmount']")).getText().split(":")[1].trim());
		
		Assert.assertEquals(count, expectedNum);
		
		
		
	}

}
