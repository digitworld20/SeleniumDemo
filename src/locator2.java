import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class locator2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//create variable
		String name = "rahul";
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//implicit wait - waiting for object to show on the page
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); 
		
		String password = getpassword(driver);
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		//enter valid login credential in login page
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		driver.findElement(By.className("signInBtn")).click();
		
		//login successfully
		//check message printed on screen
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.tagName("p")).getText());
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		Assert.assertEquals(driver.findElement(By.cssSelector("div [class='login-container'] h2")).getText(),"Hello " + name +",");
		
		//logout
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		
	}
	public static String getpassword(WebDriver driver) throws InterruptedException{
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
		String passwordText = driver.findElement(By.cssSelector("form p")).getText();
		String[] passwordArray = passwordText.split("'");
		String password = passwordArray[1].split("'")[0];
		System.out.println(password);
		return password;
	}

}
