package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSeleniumTest {
	
	@Test
	public void test() {
		// Cấu hình
		WebDriverManager.chromedriver().setup();
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setExperimentalOption("excludeSwitches", List.of("disable-popup-blocking","enable-automation"));
		WebDriver driver = new ChromeDriver(chromeOptions);
		// Tạo Url và set kích thước cho trình duyệt
		String url = "http://google.com";
		driver.manage().window().maximize();
		driver.get(url);
		// Khi trình duyệt mở lên sẽ nhập gì vào Ô search
		driver.findElement(By.name("q")).sendKeys("MrBeast");
		// tạo nút nhấn
		WebElement element = driver.findElements(By.name("btnK")).get(1);
		
		Actions actions = new Actions(driver).click(element);
		actions.build().perform();
		
	}

}
