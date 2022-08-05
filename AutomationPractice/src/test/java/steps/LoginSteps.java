package steps;

import org.junit.Assert;
import org.junit.Test;
import pages.AuthenticationPage;
import pages.HomePage;
import pages.LoggedPage;
import util.Browser;

public class LoginSteps extends Browser {
    HomePage homePage = new HomePage();
    AuthenticationPage authenticationPage = new AuthenticationPage();
    LoggedPage loggedPage = new LoggedPage();

    @Test
    public void loginComSucesso(){
        homePage.clicarSignUp();
        authenticationPage.preencherEmailLogin();
        authenticationPage.preencherSenhaLogin();
        authenticationPage.clicarBtnLogin();

        Assert.assertEquals(loggedPage.validarNome(),"Bruno Nogueira");
    }

    public void login(){
        authenticationPage.preencherEmailLogin();
        authenticationPage.preencherSenhaLogin();
        authenticationPage.clicarBtnLogin();
    }
}
