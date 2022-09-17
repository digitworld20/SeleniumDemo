import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class AutoSuggestive {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();	
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//autosuggest 
		driver.findElement(By.id("autosuggest")).sendKeys("ca");
		Thread.sleep(3000);
		
		//find all options with the same search result
		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		for(WebElement option : options) {
			if(option.getText().equals("Canada")) {
				option.click();
				break;
			}
		}
		
		//checkbox
		
		//expect false value and will return true - checkbox not select and return false as argument
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		
		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();

		//expect true value and will return true - checkbox selected and return true as argument
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected()); // return true
		
		//count the number of checkbox - find common locator 
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		
	}

}
