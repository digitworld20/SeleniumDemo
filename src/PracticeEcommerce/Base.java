package PracticeEcommerce;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {

	public static void main(String[] args) throws InterruptedException {

		/*
		 * Set up web driver
		 * 
		 */
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//implicit wait apply 5 seconds of wait time to each steps 
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); 
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Explicit webdriverwait - declare globally 
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		//item to be added
		String[] arrProducts = { "Cucumber", "Brocolli", "Tomato" };
		Thread.sleep(1000);
		additem(driver, arrProducts);
		
		//click cart icon
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		
		//explicit wait until promo button presented
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='promoCode']")));
		driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("helloworld");
		
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		
		//explicit wait until promo code invalid message is presented
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).isDisplayed());

		
		
		
		
	}
	
	public static void additem(WebDriver driver, String[] arrProducts) {
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

		for (int i = 0; i < products.size(); i++) {

			// convert array to arraylist for easy search
			List arrList = Arrays.asList(arrProducts);

			String productLabel = products.get(i).getText().split(" ")[0].trim();
			// trim text from "Brocolli - 1 Kg" to ""Brocolli"
			System.out.println(productLabel);

			int count = 0;
			if (arrList.contains(productLabel)) {
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				count++;
				if (count == arrProducts.length) {
					break;
				}
			}
		}
	}

}
