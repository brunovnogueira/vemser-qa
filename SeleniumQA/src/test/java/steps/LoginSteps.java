package steps;

import org.junit.Assert;
import org.junit.Test;
import pages.DashboardPage;
import pages.HomePage;
import pages.LoginPage;
import util.Browser;

import java.util.concurrent.TimeUnit;

public class LoginSteps extends Browser {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();

    @Test
    public void logarComSucesso(){
        homePage.clicarBtnLogin();
        loginPage.preencherLogin();
        loginPage.preencherPassword();
        loginPage.clicarLogin();

        Assert.assertEquals(dashboardPage.validarWelcome(),"Welcome brn");
    }

    public void logar(){
        homePage.clicarBtnLogin();
        loginPage.preencherLogin();
        loginPage.preencherPassword();
        loginPage.clicarLogin();
    }
}
