import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertMsg {

	public static void main(String[] args) throws InterruptedException {

		String name = "Apple";

		/*
		 * Set up web driver
		 * 
		 */
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); 

		driver.findElement(By.id("name")).sendKeys(name);
		driver.findElement(By.id("alertbtn")).click();
		Thread.sleep(1000);
		//get text on alert
		System.out.println(driver.switchTo().alert().getText());
		//click positive side of alert button (ok, yes) on alert
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		driver.findElement(By.id("confirmbtn")).click();
		Thread.sleep(1000);
		System.out.println(driver.switchTo().alert().getText());
		// click negative side of alert button (cancel, no) on alert
		driver.switchTo().alert().dismiss();
		System.out.println("hi");
		System.out.println("second changes from GitSelenium");
		System.out.println("third changes from GitSelenium in a new branch");
		System.out.println("fourth changes from GitSelenium in a new branch by gitselenium");
	}

}
