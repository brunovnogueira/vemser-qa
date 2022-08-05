package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import util.BaseTest;

public class AuthenticationPage {
    private static final By emailField = By.cssSelector("#email_create");
    private static final By btnCreate = By.cssSelector("#SubmitCreate > span");
    Faker faker = new Faker();
    public void preencherEmail(){
        BaseTest.sendKeys(emailField,faker.internet().emailAddress());
    }

    public void clicarBtnCreate(){
        BaseTest.click(btnCreate);
    }
}
