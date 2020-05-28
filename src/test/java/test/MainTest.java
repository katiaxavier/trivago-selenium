package test;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainTest {

	private static WebDriver driver;

	@BeforeEach
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://www.trivago.com.br");
	}

	@AfterEach
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void deve_buscar_hotel() {
		WebElement hotelDestino = driver.findElement(By.id("querytext"));

		hotelDestino.sendKeys("Manaus");
		
		WebElement sugestao = driver
				.findElement(By.id("suggestion-56507/200"));
		sugestao.click();

		WebElement tipoQuarto = driver.findElement(By.className("js-dealform-button-guests"));
		tipoQuarto.click();

		WebElement individual = driver.findElement(By.xpath("//div[@class='compass js-compass']//li[1]"));
		individual.click();

		WebElement pesquisar = driver.findElement(By.className("js-search-button"));
		pesquisar.click();

		
		WebElement verificar = driver.findElement(By.xpath("//span[contains(text(),'Hotel Do Largo')]"));
		assertTrue(verificar.isDisplayed());
	}
}

