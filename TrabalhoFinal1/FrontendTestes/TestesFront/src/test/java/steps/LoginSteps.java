package steps;

import org.junit.Assert;
import org.junit.Test;
import pages.HomePage;
import pages.LoggedPage;
import util.Browser;

public class LoginSteps extends Browser {
    HomePage homePage = new HomePage();
    LoggedPage loggedPage = new LoggedPage();

    @Test
    public void loginComSucesso(){
        homePage.preencherLogin("standard_user");
        homePage.preencherPassword("secret_sauce");
        homePage.clicarLogin();
        Assert.assertEquals(loggedPage.validarTitle(),"PRODUCTS");
    }

    public void login(){
        homePage.preencherLogin("standard_user");
        homePage.preencherPassword("secret_sauce");
        homePage.clicarLogin();
    }
}
