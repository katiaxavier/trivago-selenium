package test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProdutoTest {
	private static WebDriver driver;
	private static WebDriverWait wait;

	@BeforeEach
	public void setUp() {
		driver = new ChromeDriver();
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
	}

	@Test
	public void deve_adicionar_produto() {
		// inserir codigo de usuario
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userLogin"))).sendKeys("v456");
		// clicar no botão para prosseguir
		driver.findElement(By.id("next")).click();
		// inserir senha
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("passwordLogin"))).sendKeys("v456");
		// clicar no botão para prosseguir
		driver.findElement(By.id("next")).click();
		// Informar o objeto de busca
		driver.findElement(By.id("search-top-search")).sendKeys("hg33036");
		// Clicar no botão de buscar
		driver.findElement(By.id("search-top-search-button")).click();
		// Esperar que o primeiro elemento de adicionar no carrinho esteja visivel e
		// clicar
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class=\"material-icons pointer\"]")))
				.click();
		// Validar se mensagem de sucesso foi exibida e se há 1 item no carrinho
		assertAll(
				() -> assertEquals("Item adicionado com sucesso",
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("message"))).getText()),
				() -> assertEquals("1", driver.findElement(By.className("count_itens-cart")).getText()));

	}
}
