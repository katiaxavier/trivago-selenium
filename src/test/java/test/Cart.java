package test;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Cart {

	private static WebDriver driver;
	private static WebDriverWait wait;

	@BeforeEach
	public void setUp() {
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 10);
		driver.get("http://192.168.151.17");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userLogin"))).sendKeys("v456");
		driver.findElement(By.id("next")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("passwordLogin"))).sendKeys("v456");
		driver.findElement(By.id("next")).click();
	}

	@AfterEach
	public void tearDown() {
//		driver.quit();
	}

	@Test
	public void should_finalize_sale() {
		// Informar o objeto de busca
		driver.findElement(By.id("search-top-search")).sendKeys("hg33036");
		// Clicar no botão de buscar
		driver.findElement(By.id("search-top-search-button")).click();
		// Esperar que o primeiro elemento de adicionar no carrinho esteja visivel e
		// clicar
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class=\"material-icons pointer\"]")))
				.click();
		// espera que a classe message esteja visivel
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("message"))).isDisplayed();
		// clicar no botão do carrinho
		driver.findElement(By.id("navbar_shopping")).click();
		// clicar em finalizar venda
		driver.findElement(By.id("cartFooterEndPayment")).click();
		// esperar ate que o elemento seja clicavel
		wait.until(ExpectedConditions.elementToBeClickable(By.className("enviarCaixaButton"))).click();
		// verificar se o elemento esta visivel
		assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("appLogin"))).isDisplayed());
	}
}
