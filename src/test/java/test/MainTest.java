package test;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import support.Web;

public class MainTest {

	private WebDriver navegador;
	private WebDriverWait wait;

	@BeforeEach
	public void setUp() {
		navegador = Web.createChrome();
		wait = new WebDriverWait(navegador, 10);

	}

	@Test
	public void deve_buscar_hotel() {
		
		navegador.findElement(By.id("querytext")).sendKeys("Manaus");
		
		navegador.findElement(By.xpath("//li[@id='suggestion-56507/200']//span[@class='ssg-title']")).click();
		navegador.findElement(By.className("js-dealform-button-guests")).click();

		navegador.findElement(By.xpath("//div[@class='compass js-compass']//li[1]")).click();

		navegador.findElement(By.className("js-search-button")).click();

		assertTrue(navegador.findElement(By.xpath("//span[contains(text(),'Hotel Do Largo')]")).isDisplayed());
	}

}
