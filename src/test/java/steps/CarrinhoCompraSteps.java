package steps;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.cucumber.junit.Cucumber;

public class CarrinhoCompraSteps {

	private WebDriver driver;
	private String nomeProduto;

	@Dado("que estou acessando a aplicação")
	public void queEstouAcessandoAAplicação() {
		System.setProperty("webdriver.chorome.driver", "/home/user/Downloads/Driver/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.magazineluiza.com.br/");
	}

	@Quando("pesquisar pelo produto {string}")
	public void pesquisarPeloProduto(String string) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("inpHeaderSearch")).sendKeys(string);
	}

	@Quando("selecionar o ícone de busca")
	public void selecionarOÍconeDeBusca() {
		driver.findElement(By.id("btnHeaderSearch")).click();
	}

	@Então("visualizo uma lista contendo {string}")
	public void visualizoUmaListaContendo(String string) {
		List<WebElement> li = driver.findElements(By.xpath("//li[@class='nm-product-item']"));

		String text = li.get(0).getText();

		Assert.assertTrue(text.contains(string));
	}

	@Quando("seleciono um produto")
	public void selecionoUmProduto() {
		List<WebElement> li = driver.findElements(By.xpath("//li[@class='nm-product-item']"));

		nomeProduto = li.get(3).getText();
		li.get(3).click();
	
	}

	@Quando("adiciono ao carrinho")
	public void adicionoAoCarrinho() {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath(
				"//*[@class='container-button-banner']")).click();

		driver.findElement(By.xpath(
				"//*[@class='button__buy button__buy-product-detail js-add-cart-button js-main-add-cart-button js-add-box-prime']")).click();

	}

	@Quando("abrir carrinho de compras")
	public void abrirCarrinhoDeCompras() {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='BasketPage-title']")));

		String texto = driver.findElement(By.xpath("//div[@class='BasketPage-title']")).getText();

		System.out.println(texto);
		Assert.assertEquals("Sacola", texto);

	}

	@Então("devo encontrar o produto selecionado")
	public void devoEncontrarOProdutoSelecionado() {
		String titulo = driver.findElement(By.xpath("//p[contains(text(),'Abajur Diamante Dome')]")).getText();
		Assert.assertEquals("Abajur Diamante Dome Branco Com Aramado Preto - Marryluz", titulo);
	}

	@After(order = 1)
	public void screenshot(Scenario cenario) {
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("target/screenshot/" + cenario.getName() + ".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@After(order = 0)
	public void fecharBrowser() {
		driver.quit();
	}
}
