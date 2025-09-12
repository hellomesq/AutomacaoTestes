import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class aula {
    WebDriver driver=new ChromeDriver();
    String url="https://www.saucedemo.com/";
    
    @Test
    public void loginSucess(){
        driver.get(url);
        assert driver.getCurrentUrl().equals(url);
        assert driver.getTitle().equals("Swag Labs");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        assert driver.getCurrentUrl().equals(url +"inventory.html");
        assert driver.findElement(By.id("shopping_cart_container")).isDisplayed();
        driver.quit();

    }

    @Test
    public void urlError(){
        String urlError="https://www.saedemo.com/";
        driver.get(urlError);
        assert driver.getCurrentUrl().equals(urlError);
        assert driver.getTitle().equals("Swag Lab");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        assert driver.getCurrentUrl().equals(url +"inventory.html");
        assert driver.findElement(By.id("shopping_cart_container")).isDisplayed();
        driver.quit();

    }

    @Test
    public void loginErrorUsername(){
        driver.get(url);
        assert driver.getCurrentUrl().equals(url);
        assert driver.getTitle().equals("Swag Labs");

        driver.findElement(By.id("user-name")).sendKeys("standard_use");
        
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        assert driver.getCurrentUrl().equals(url +"inventory.html");
        assert driver.findElement(By.id("shopping_cart_container")).isDisplayed();
        driver.quit();

    }

        @Test
    public void loginErrorPassword(){
        driver.get(url);
        assert driver.getCurrentUrl().equals(url);
        assert driver.getTitle().equals("Swag Labs");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        
        driver.findElement(By.id("password")).sendKeys("secret_sauc");
        driver.findElement(By.id("login-button")).click();

        assert driver.getCurrentUrl().equals(url +"inventory.html");
        assert driver.findElement(By.id("shopping_cart_container")).isDisplayed();
        driver.quit();

    }



}
