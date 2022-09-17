package PracticeEcommerce;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeScope {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

		System.out.println(driver.findElements(By.tagName("a")).size());
//		List<WebElement> list1 = driver.findElements(By.tagName("a"));

		System.out.println(driver.findElements(By.xpath("//div[@id='gf-BIG'] //a")).size());

		// limiting scope by creating sub-section of the driver, i.e footer section
		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));

		System.out.println(footerDriver.findElements(By.tagName("a")).size());

		// column driver in footer
		WebElement footerC1Driver = footerDriver.findElement(By.xpath("//div[@id='gf-BIG'] /table/tbody/tr/td[1]"));

		int numLinks = footerC1Driver.findElements(By.tagName("a")).size();
		// check each link
		// List<WebElement> links = dfooterC1Driver.findElements(By.tagName("a"));
		for (int i = 1; i < numLinks; i++) {
			// enter multiple keyboard
			String openLink = Keys.chord(Keys.CONTROL, Keys.ENTER);

			footerC1Driver.findElements(By.tagName("a")).get(i).sendKeys(openLink);
			Thread.sleep(5000);

		}
		Set<String> ids = driver.getWindowHandles();

		Iterator<String> it = ids.iterator();
		while (it.hasNext()) {
			// hasNext only check if next index present
			// next will switch to next index
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
		driver.quit();

	}

}
