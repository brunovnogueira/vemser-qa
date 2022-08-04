package pages;

import org.openqa.selenium.By;
import util.BaseTest;

public class SignUpPage {
    public static final By btnSubmit = By.cssSelector("#submit");
    public static final By firstNameField = By.cssSelector("#FirstName");
    public static final By surnameField = By.cssSelector("#Surname");
    public static final By epostField = By.cssSelector("#E_post");
    public static final By mobileField = By.cssSelector("#Mobile");
    public static final By usernameField = By.cssSelector("#Username");
    public static final By passwordField = By.cssSelector("#Password");
    public static final By confirmPasswordField = By.cssSelector("#ConfirmPassword");
    public static final By msg = By.cssSelector("body > div > form > div > div:nth-child(12) > div > label");

    public void clicarBtnSubmit(){
        BaseTest.click(btnSubmit);
    }

    public void preencherFirstName(){
        BaseTest.sendKeys(firstNameField,"Bruno");
    }

    public void preencherSurname(){
        BaseTest.sendKeys(surnameField,"Nogueira");
    }

    public void preencherEpost(){
        BaseTest.sendKeys(epostField,"05374889");
    }

    public void preencherMobile(){
        BaseTest.sendKeys(mobileField,"011995867849");
    }

    public void preencherUsername(){
        BaseTest.sendKeys(usernameField,"brn4");
    }

    public void preencherPassword(){
        BaseTest.sendKeys(passwordField,"123");
    }

    public void preencherConfirmPassword(){
        BaseTest.sendKeys(confirmPasswordField,"123");
    }

    public String validarMsg(){
        return BaseTest.getText(msg);
    }
}
