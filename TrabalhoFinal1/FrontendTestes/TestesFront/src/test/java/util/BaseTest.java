package util;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class BaseTest extends Elements{

    //Método de clicar
    public static void click(By by){
        waitElement(by);
        element(by).click();
    }
    //Método de pegar texto na tela
    public static String getText(By by){
        waitElement(by);
        return element(by).getText();
    }
    //Método de escrever em campo
    public static void sendKeys(By by,String texto){
        waitElement(by);
        element(by).sendKeys(texto);
    }
    //Método limpar campo
    public static void clear(By by){
        waitElement(by);
        element(by).clear();
    }
    //Método de selecionar item de lista drop-down por valor
    public static void selecionarLista(By by,String value){
        waitElement(by);
        Select objSelect = new Select(driver.findElement(by));
        objSelect.selectByValue(value);
    }
    //Método hover
    public static void hover(By by){
        waitElement(by);
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(by)).perform();
    }
    //Método de acrescentar tempo de espera
    public static void esperar(int tempo){
        driver.manage().timeouts().implicitlyWait(tempo, TimeUnit.MILLISECONDS);
    }
    //Método de copy
    public static void copy(By by){
        waitElement(by);
        Actions builder = new Actions(driver);
        builder.doubleClick(element(by)).perform();
        builder.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();
    }
    //Método de paste
    public static void paste(By by){
        waitElement(by);
        Actions builder = new Actions(driver);
        builder.click(element(by)).perform();
        builder.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();
    }
    public static String getAtribute(By by,String atributo){
        waitElement(by);
        return element(by).getAttribute(atributo);
    }
}
