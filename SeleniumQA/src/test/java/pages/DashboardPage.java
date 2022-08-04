package pages;

import org.openqa.selenium.By;
import util.BaseTest;

public class DashboardPage {
    public static final By btnCreateNew = By.cssSelector("body > div > div > p:nth-child(4) > a");
    public static final By btnSearch = By.cssSelector("body > div > div > form > input.btn.btn-secondary.my-2.my-sm-0");
    public static final By btnEdit = By.cssSelector("body > div > div > table > tbody > tr:nth-child(2) > td:nth-child(7) > a.btn.btn-outline-primary");
    public static final By btnDelete = By.cssSelector("body > div > div > table > tbody > tr:nth-child(2) > td:nth-child(7) > a.btn.btn-outline-danger");
    public static final By searchField = By.cssSelector("#searching");
    public static final By welcome = By.cssSelector("body > div > div > h3");
    public static final By name = By.cssSelector("body > div > div > table > tbody > tr:nth-child(2) > td:nth-child(1)");
    public static final By email = By.cssSelector("body > div > div > table > tbody > tr:nth-child(2) > td:nth-child(6)");
    public static final By noMatch = By.cssSelector("body > div > div > table > tbody > tr:nth-child(2) > td");

    public void clicarCreateNew(){
        BaseTest.click(btnCreateNew);
    }

    public void clicarSearch(){
        BaseTest.click(btnSearch);
    }

    public void clicarEdit(){
        BaseTest.click(btnEdit);
    }

    public void clicarDelete(){
        BaseTest.click(btnDelete);
    }

    public void preencherSearch(){
        BaseTest.sendKeys(searchField,"Bruno N");
    }
    public void preencherSearchEdit(){
        BaseTest.sendKeys(searchField,"Teste123");
    }

    public String validarWelcome(){
        return BaseTest.getText(welcome);
    }

    public String validarName(){
        return BaseTest.getText(name);
    }

    public String validarEmail(){
        return BaseTest.getText(email);
    }

    public String validarNoMatch(){
        return BaseTest.getText(noMatch);
    }
}
