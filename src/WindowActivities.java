import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class WindowActivities {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();	
		driver.manage().window().maximize();
		//Selenium pause until webpage is fully loaded
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		//static dropdown with SELECT tag
		Select dropdown = new Select(staticDropdown);
		//select by index - start from index 0
		dropdown.selectByIndex(3);
		//return a web element, then get text
		System.out.println(dropdown.getFirstSelectedOption().getText());
		Assert.assertEquals(dropdown.getFirstSelectedOption().getText(), "USD");
		
		//select by visible text
		dropdown.selectByVisibleText("AED");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		Assert.assertEquals(dropdown.getFirstSelectedOption().getText(), "AED");
		
		//value is attribute in HTML - value="INR"
		dropdown.selectByValue("INR");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		Assert.assertEquals(dropdown.getFirstSelectedOption().getText(), "INR");
		//driver.quit();
	}

}
