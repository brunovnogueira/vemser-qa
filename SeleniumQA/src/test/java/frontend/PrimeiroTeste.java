package frontend;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class PrimeiroTeste {
    public static WebDriver driver;
    public static WebDriverWait wait;

    public void comandosSelenium(){
        //Acessar site
        driver.get("https://itera-qa.azurewebsites.net/");

        //Pegar elemento da página
        //por seletor css
        driver.findElement(By.cssSelector("#navbarColor01 > form > ul > li:nth-child(2) > a"));

        //Interação
        //clicar
        driver.findElement(By.cssSelector("#navbarColor01 > form > ul > li:nth-child(2) > a")).click();
        //escrever
        driver.findElement(By.cssSelector("#navbarColor01 > form > ul > li:nth-child(2) > a")).sendKeys("bruno");

        //Controlar o tempo
        driver.manage().timeouts().implicitlyWait(6000, TimeUnit.MILLISECONDS);

        //Espera condicional (espera elemento aparecer e depois clica)
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("#navbarColor01 > form > ul > li:nth-child(2) > a")));
        driver.findElement(By.cssSelector("#navbarColor01 > form > ul > li:nth-child(2) > a")).click();

    }
}
