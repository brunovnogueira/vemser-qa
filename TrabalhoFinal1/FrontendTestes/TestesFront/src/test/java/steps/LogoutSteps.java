package steps;

import org.junit.Assert;
import org.junit.Test;
import pages.HomePage;
import pages.LoggedPage;
import util.Browser;

public class LogoutSteps extends Browser {
    LoginSteps loginSteps = new LoginSteps();
    LoggedPage loggedPage = new LoggedPage();
    HomePage homePage = new HomePage();

    @Test
    public void logoutComSucesso(){
        loginSteps.login();
        loggedPage.clicarMenu();
        loggedPage.clicarBtnLogout();

        Assert.assertEquals(homePage.validarBtnLogin("name"),"login-button");
    }
}
