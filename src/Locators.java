import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//implicit wait - waiting for object to show on the page
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); 
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		//enter invalid login credential in login page
		driver.findElement(By.id("inputUsername")).sendKeys("rahul");
		driver.findElement(By.name("inputPassword")).sendKeys("gieoge");
		driver.findElement(By.className("signInBtn")).click();
		
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		
		//click 'forget password' and navigate to page
		driver.findElement(By.linkText("Forgot your password?")).click();
		//give wait time of 1 second after click forgot password
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("John");
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("abcd");
		//driver.findElement(By.xpath("//input[@placeholder='Email']")).clear();
		//driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("test");
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("6471231234");
		driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		
		//return to sign in page
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		//enter valid password and login credential
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
		//successfully login
		
		//driver.quit();
		
	}

}
