package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTest {

	private static WebDriver driver;
	private static WebDriverWait wait;

	@BeforeEach
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 10);
		driver.get("http://192.168.151.17");
	}

	@AfterEach
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void deve_fazer_login() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userLogin"))).sendKeys("v456");
		driver.findElement(By.id("next")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("passwordLogin"))).sendKeys("v456");
		driver.findElement(By.id("next")).click();
		assertEquals("456 - ANDERSON BARAT",
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("user"))).getText());
	}

	@Test
	public void nao_deve_fazer_login() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userLogin"))).sendKeys("v456");
		driver.findElement(By.id("next")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("passwordLogin"))).sendKeys("111");
		driver.findElement(By.id("next")).click();

		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.className("hint-error"), "Senha inválida"));

		String msg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("hint-error"))).getText();

		assertEquals("Senha inválida", msg);
	}

}
