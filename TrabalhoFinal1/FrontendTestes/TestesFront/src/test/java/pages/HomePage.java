package pages;

import org.openqa.selenium.By;
import util.BaseTest;

public class HomePage {
    private static final By loginField = By.cssSelector("#user-name");//*[@id="logout_sidebar_link"]
    private static final By passwordField = By.cssSelector("#password");
    private static final By btnLogin = By.cssSelector("#login-button");

    public void preencherLogin(String texto){
        BaseTest.sendKeys(loginField,texto);
    }

    public void preencherPassword(String texto){
        BaseTest.sendKeys(passwordField,texto);
    }

    public void clicarLogin(){
        BaseTest.click(btnLogin);
    }

    public String validarBtnLogin(){
        return BaseTest.getText(btnLogin);
    }
}
