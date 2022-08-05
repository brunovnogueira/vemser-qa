package steps;

import org.junit.Assert;
import org.junit.Test;
import pages.HomePage;
import pages.SignUpPage;
import util.Browser;

public class SignUpSteps extends Browser {

    SignUpPage signUpPage = new SignUpPage();
    HomePage homePage = new HomePage();

    @Test
    public void cadastrarUsuarioSemSucesso(){
        //Acessa a tela de sign up
        homePage.clicarBtnSignUp();

        //Preencher formulário
        signUpPage.preencherFirstName();
        signUpPage.preencherSurname();
        signUpPage.preencherEpost();
        signUpPage.preencherMobile();
        signUpPage.preencherUsername();
        signUpPage.preencherPassword();
        signUpPage.preencherConfirmPassword();

        //Clicar no submit
        signUpPage.clicarBtnSubmit();

        //Validar
        Assert.assertEquals(signUpPage.validarMsg(),"Username already exist");
    }
}
