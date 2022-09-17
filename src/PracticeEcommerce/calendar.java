package PracticeEcommerce;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class calendar {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://www.path2usa.com/travel-companion");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,800)");

		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='form-field-travel_comp_date']")).click();
		
		//identify the month desired to select 
		//input[@class='numInput cur-year']
		WebElement month = driver.findElement(By.xpath("//div[@class='flatpickr-current-month']"));
		System.out.println(month.getText());
		while (!month.getText().contains("October")){
			driver.findElement(By.xpath("//span[@class='flatpickr-next-month']")).click();
			System.out.println(month.getText());
			Thread.sleep(3000);
		}

		int count = driver.findElements(By.xpath("//span[@class='flatpickr-day ']")).size();

		for (int i = 0; i < count; i++)

		{

			String text = driver.findElements(By.xpath("//span[@class='flatpickr-day ']")).get(i).getText();

			if (text.equalsIgnoreCase("26"))

			{
				// driver.findElements(By.cssSelector("td[class*='day']")).get(i).click();
				driver.findElements(By.xpath("//span[@class='flatpickr-day ']")).get(i).click();
				System.out.println(text);
				break;

			}

		}

		System.out
				.println(driver.findElement(By.xpath("//*[@id='form-field-travel_comp_date']")).getAttribute("value"));

	}

}
