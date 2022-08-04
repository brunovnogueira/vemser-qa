package pages;

import org.openqa.selenium.By;
import util.BaseTest;

public class EditCustomerPage {
    private static final By nameField = By.cssSelector("#Name");
    private static final By companyField = By.cssSelector("#Company");
    private static final By addressField = By.cssSelector("#Address");
    private static final By cityField = By.cssSelector("#City");
    private static final By phoneField = By.cssSelector("#Phone");
    private static final By emailField = By.cssSelector("#Email");
    private static final By btnSave = By.cssSelector("body > div > form > div > div:nth-child(10) > div > input");

    public void preencherName(){
        BaseTest.clear(nameField);
        BaseTest.sendKeys(nameField,"Teste123");
    }

    public void preencherCompany(){
        BaseTest.clear(companyField);
        BaseTest.sendKeys(companyField,"TESTE");
    }

    public void preencherAddress(){
        BaseTest.clear(addressField);
        BaseTest.sendKeys(addressField,"TESTE");
    }

    public void preencherCity(){
        BaseTest.clear(cityField);
        BaseTest.sendKeys(cityField,"TESTE");
    }

    public void preencherPhone(){
        BaseTest.clear(phoneField);
        BaseTest.sendKeys(phoneField,"99999999999");
    }

    public void preencherEmail(){
        BaseTest.clear(emailField);
        BaseTest.sendKeys(emailField,"teste@gmail.com");
    }

    public void clicarSave(){
        BaseTest.click(btnSave);
    }
}

