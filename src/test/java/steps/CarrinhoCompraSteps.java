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
	private List<WebElement> li;
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
		System.out.println(li.get(0).getText());
		System.out.println(li.size());

		Assert.assertTrue(text.contains(string));
	}

	@Quando("seleciono um produto")
	public void selecionoUmProduto() {
		List<WebElement> li = driver.findElements(By.xpath("//li[@class='nm-product-item']"));

		System.out.println(li.size());

		System.out.println(li.get(3).getText());
		nomeProduto = li.get(3).getText();
		li.get(3).click();
		// driver.findElement(By.id("product_deje76h9e2")).click();

	}

	@Quando("adiciono ao carrinho")
	public void adicionoAoCarrinho() {
		// driver.findElement(By.xpath("//*[@class='button__buy
		// button__buy-product-detail js-add-cart-button js-main-add-cart-button
		// js-add-box-prime']"));

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.findElement(By.xpath("//p[text()='Abajur Diamante Dome Branco Com
		// Aramado Preto - Marryluz']"));
	}

	@Quando("abrir carrinho de compras")
	public void abrirCarrinhoDeCompras() {

	}

	@Então("devo encontrar o produto selecionado")
	public void devoEncontrarOProdutoSelecionado() {

	}

	@After(order = 1)
	public void screenshot(Scenario cenario) {
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("target/screenshot/" + cenario.getName()+ ".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@After(order = 0)
	public void fecharBrowser() {
		driver.quit();
	}
}
