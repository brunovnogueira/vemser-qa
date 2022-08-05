package steps;

import org.junit.Assert;
import org.junit.Test;
import pages.AuthenticationPage;
import pages.HomePage;
import pages.LoggedPage;
import pages.SignUpPage;
import util.Browser;

public class SignUpSteps extends Browser {
    HomePage homePage = new HomePage();
    AuthenticationPage authenticationPage = new AuthenticationPage();
    SignUpPage signUpPage = new SignUpPage();
    LoggedPage loggedPage = new LoggedPage();

    @Test
    public void cadastroComSucesso(){
        homePage.clicarSignUp();
        authenticationPage.preencherEmail();
        authenticationPage.clicarBtnCreate();
        signUpPage.clicarBtnMale();
        signUpPage.preencherName();
        signUpPage.preencherLastName();
        signUpPage.preencherPassword();
        signUpPage.selecionarDaysList();
        signUpPage.selecionarMonthsList();
        signUpPage.selecionarYearList();
        signUpPage.preencherFirstNameAddress();
        signUpPage.preencherLastNameAddress();
        signUpPage.preencherAddress();
        signUpPage.preencherCity();
        signUpPage.selecionarStateList();
        signUpPage.preencherPostCode();
        signUpPage.selecionarCountryList();
        signUpPage.preencherMobilePhone();
        signUpPage.clicarBtnSubmit();

        Assert.assertEquals(loggedPage.validarLog(),"Sign out");
    }

    public void cadastrar(){
        homePage.clicarSignUp();
        authenticationPage.preencherEmail();
        authenticationPage.clicarBtnCreate();
        signUpPage.clicarBtnMale();
        signUpPage.preencherName();
        signUpPage.preencherLastName();
        signUpPage.preencherPassword();
        signUpPage.selecionarDaysList();
        signUpPage.selecionarMonthsList();
        signUpPage.selecionarYearList();
        signUpPage.preencherFirstNameAddress();
        signUpPage.preencherLastNameAddress();
        signUpPage.preencherAddress();
        signUpPage.preencherCity();
        signUpPage.selecionarStateList();
        signUpPage.preencherPostCode();
        signUpPage.selecionarCountryList();
        signUpPage.preencherMobilePhone();
        signUpPage.clicarBtnSubmit();
    }
}
