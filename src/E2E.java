import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class E2E {

	public static void main(String[] args) throws InterruptedException {
		/* Set up variable 
		 * 
		 * */
		String att;
		
		
		/* Set up web driver 
		 * 
		 * */
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();	
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		
		/* select FROM location - dynamic dropDown
		 * 
		 * */
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		
		
		/* select TO location - dynamic dropDown
		 * 
		 * */
		driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
		Thread.sleep(2000);
		//optional ->  driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();

		
		/* Validate Arrival calendar is disabled when the default selection is one way trip
		 * 
		 * isEnabled functional may not work in some cases in modern technology
		 * */
		//optional -> System.out.println(driver.findElement(By.cssSelector("input[name='ctl00$mainContent$view_date2']")).isEnabled()); 
		att = driver.findElement(By.id("Div1")).getAttribute("Style");
		System.out.println(att);
		if (att.contains("0.5")) {
			// opacity 1 indicate enable in this website
			System.out.println("calendar is disabled");
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
		
		
		/* click round trip radio button
		 * 
		 * */
		driver.findElement(By.cssSelector("input[id='ctl00_mainContent_rbtnl_Trip_1']")).click();
		
		/* click default day in calendar 
		 * 
		 * */
		driver.findElement(By.cssSelector("a.ui-state-default.ui-state-highlight")).click();
		

		/* Validate Arrival calendar is enabled when the default selection is one way trip
		 * 
		 * */
		//Optional -> System.out.println(driver.findElement(By.cssSelector("input[name='ctl00$mainContent$view_date2']")).isEnabled());
		att = driver.findElement(By.id("Div1")).getAttribute("Style");
		System.out.println(att);
		if (att.contains("1")) {
			// opacity 1 indicate enable in this website
			System.out.println("calendar is enabled");
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
		
		/* add passenger - static dropdown 
		 * 
		 * */
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		//select the same object multiple time

		addAdult(4, driver);
		driver.findElement(By.id("btnclosepaxoption")).click();
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
		
		/* select current - static dropdown with SELECT tag
		 * 
		 * */
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
		
		/*click checkbox
		 * 
		 * */
		
		//expect false value and will return true - checkbox not select and return false as argument
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
				
		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();

		//expect true value and will return true - checkbox selected and return true as argument
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected()); // return true
				
		//count the number of checkbox - find common locator 
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
				
		/* click search
		 * 
		 * */
		driver.findElement(By.xpath("(//input[@type='submit'])[1]")).click();
//		driver.quit();

	}
	public static void addAdult(int adult, WebDriver driver) {
		int count=0;
		while(count<adult) {			
			driver.findElement(By.id("hrefIncAdt")).click();
			count++;
		}
	}

}
