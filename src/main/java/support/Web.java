package support;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Web {
	private static WebDriver navegador;

	public static void browser() {
		navegador.manage().deleteAllCookies();
		navegador.manage().window().maximize();
		navegador.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		navegador.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
	}

	public static WebDriver createChrome() {

		return createChrome("https://www.trivago.com.br/");
	}

	public static WebDriver createChrome(String ip) {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");

		navegador = new ChromeDriver();
		navegador.get(ip);
		browser();

		return navegador;
	}

	public static WebDriver createFirefox(String ip) {
		System.setProperty("webdriver.chrome.driver", "drivers/geckodriver");

		navegador = new FirefoxDriver();
		navegador.get(ip);
		browser();

		return navegador;
	}

}
