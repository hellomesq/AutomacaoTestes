import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteBuscaProdutos {

    WebDriver driver = new ChromeDriver();
    String url = "https://www.demoecommerce.com/";

    @Test
    public void buscarProdutoExistente() {
        driver.get(url);
        assert driver.getCurrentUrl().equals(url);

        // Cenário de sucesso: produto existe
        driver.findElement(By.id("search-box")).sendKeys("Notebook");
        driver.findElement(By.id("search-button")).click();

        assert driver.findElement(By.id("results")).isDisplayed();
        assert driver.findElement(By.xpath("//div[contains(text(),'Notebook')]")).isDisplayed();

        driver.quit();
    }

    @Test
    public void buscarProdutoInexistente() {
        driver.get(url);
        assert driver.getCurrentUrl().equals(url);

        // Cenário de exceção: produto não existe
        driver.findElement(By.id("search-box")).sendKeys("ProdutoInexistente123");
        driver.findElement(By.id("search-button")).click();

        assert driver.findElement(By.id("no-results")).isDisplayed();

        driver.quit();
    }

    @Test
    public void buscarComCampoVazio() {
        driver.get(url);
        assert driver.getCurrentUrl().equals(url);

        // Cenário de exceção: campo de busca vazio
        driver.findElement(By.id("search-box")).sendKeys("");
        driver.findElement(By.id("search-button")).click();

        assert driver.findElement(By.id("warning")).isDisplayed();

        driver.quit();
    }

    @Test
    public void buscarProdutoComCaracteresEspeciais() {
        driver.get(url);
        assert driver.getCurrentUrl().equals(url);

        // Cenário de exceção: caracteres inválidos
        driver.findElement(By.id("search-box")).sendKeys("@#$%");
        driver.findElement(By.id("search-button")).click();

        assert driver.findElement(By.id("invalid-input")).isDisplayed();

        driver.quit();
    }
}
