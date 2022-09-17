package PracticeEcommerce;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

public class FluentWaitPractice {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

		driver.findElement(By.xpath("//div[@id='start']/button")).click();

		// fluent wait
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);

		// fluent wait has not pre-define functions, we have to design our own

		WebElement validate1 = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				// customized if condition for element to be visible
				if (driver.findElement(By.xpath("//div[@id='finish']/h4")).isDisplayed()) {
					return driver.findElement(By.xpath("//div[@id='finish']/h4"));
				}else {
					return null;
				}
			}
		});
		System.out.println(driver.findElement(By.xpath("//div[@id='finish']/h4")).getText());
	}

}
