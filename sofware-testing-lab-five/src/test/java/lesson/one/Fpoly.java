package lesson.one;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Fpoly {

	@Test
	public void test() {
		// Khởi tạo driver kết nối với chrome
		WebDriverManager.chromedriver().setup();
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setExperimentalOption("excludeSwitches", List.of("disable-popup-blocking", "enable-automation"));
		WebDriver driver = new ChromeDriver(chromeOptions);
		String url = "http://lms.poly.edu.vn";
		String tile_website = "Hệ thống quản trị học tập FPT Polytechnic";
		String title_expected = "";
		driver.manage().window().maximize();
		driver.get(url);
		title_expected = driver.getTitle();
		if (title_expected.contentEquals(tile_website)) {
			System.out.println("Test pass");
		} else {
			System.out.println("Test faill");
		}
		driver.close();
	}
}
