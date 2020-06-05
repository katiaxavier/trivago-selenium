package test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import support.Web;

public class LoginTest {

	private static WebDriver driver;

	@BeforeEach
	public static void setUp() {
		driver = Web.createChrome("http://192.168.151.93:8080");

	}

	@AfterEach
	public static void tearDown() {
		driver.quit();
	}
	
	@Test
	public  void should_login() {
		driver.findElement(By.name("usuario")).sendKeys("v320");
		driver.findElement(By.name("password")).sendKeys("v320");
		driver.findElement(By.className("v-btn__content")).click();
	}
	
}
