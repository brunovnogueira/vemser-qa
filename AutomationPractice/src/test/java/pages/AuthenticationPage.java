package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import util.BaseTest;

public class AuthenticationPage {
    private static final By emailField = By.cssSelector("#email_create");
    private static final By btnCreate = By.cssSelector("#SubmitCreate > span");
    private static final By emailLogin = By.cssSelector("#email");
    private static final By senhaLogin = By.cssSelector("#passwd");
    private static final By btnLogin = By.cssSelector("#SubmitLogin > span");

    Faker faker = new Faker();
    public void preencherEmail(){
        BaseTest.sendKeys(emailField,faker.internet().emailAddress());
    }

    public void clicarBtnCreate(){
        BaseTest.click(btnCreate);
    }

    public void preencherEmailLogin(){
        BaseTest.sendKeys(emailLogin,"bruno.nogueira@email.com");
    }
    public void preencherSenhaLogin(){
        BaseTest.sendKeys(senhaLogin,"12345");
    }
    public void clicarBtnLogin(){
        BaseTest.click(btnLogin);
    }
}
