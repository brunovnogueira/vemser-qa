package pages;

import org.openqa.selenium.By;
import util.BaseTest;

public class CreateCustomerPage {
    private static final By nameField = By.cssSelector("#Name");
    private static final By companyField = By.cssSelector("#Company");
    private static final By addressField = By.cssSelector("#Address");
    private static final By cityField = By.cssSelector("#City");
    private static final By phoneField = By.cssSelector("#Phone");
    private static final By emailField = By.cssSelector("#Email");
    private static final By btnCreate = By.cssSelector("body > div > form > div > div:nth-child(9) > div > input");

    public void preencherName(){
        BaseTest.sendKeys(nameField,"Bruno N");
    }

    public void preencherCompany(){
        BaseTest.sendKeys(companyField,"TESTE");
    }

    public void preencherAddress(){
        BaseTest.sendKeys(addressField,"TESTE");
    }

    public void preencherCity(){
        BaseTest.sendKeys(cityField,"TESTE");
    }

    public void preencherPhone(){
        BaseTest.sendKeys(phoneField,"99999999999");
    }

    public void preencherEmail(){
        BaseTest.sendKeys(emailField,"teste@gmail.com");
    }

    public void clicarCreate(){
        BaseTest.click(btnCreate);
    }
}
