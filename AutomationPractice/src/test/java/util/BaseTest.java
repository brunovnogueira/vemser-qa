package util;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

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

    public static void clear(By by){
        waitElement(by);
        element(by).clear();
    }

    public static void selecionarLista(By by,String value){
        waitElement(by);
        Select objSelect = new Select(driver.findElement(by));
        objSelect.selectByValue(value);
    }
}