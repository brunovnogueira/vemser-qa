package pages;

import org.openqa.selenium.By;
import util.BaseTest;

public class LoggedPage {
    private static final By btnLogOut = By.cssSelector("#header > div.nav > div > div > nav > div:nth-child(2) > a");
    private static final By btnNome = By.cssSelector("#header > div.nav > div > div > nav > div:nth-child(1) > a > span");
    private static final By searchField = By.cssSelector("#search_query_top");
    private static final By btnSearch = By.cssSelector("#searchbox > button");

    public String validarLog(){
        BaseTest.esperar(6000);
        return BaseTest.getText(btnLogOut);
    }
    public String validarNome(){
        BaseTest.esperar(6000);
        return BaseTest.getText(btnNome);
    }
    public void preencherSearchField(){
        BaseTest.sendKeys(searchField,"T-shirts");
    }
    public void clicarBtnSearch(){
        BaseTest.click(btnSearch);
    }
}
