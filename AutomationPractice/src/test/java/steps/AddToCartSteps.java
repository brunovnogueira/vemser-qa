package steps;

import org.junit.Assert;
import org.junit.Test;
import pages.*;
import util.Browser;

public class AddToCartSteps extends Browser {
    SearchSteps searchSteps = new SearchSteps();
    SearchPage searchPage = new SearchPage();
    CheckoutPage checkoutPage = new CheckoutPage();
    AuthenticationPage authenticationPage = new AuthenticationPage();
    LoginSteps loginSteps = new LoginSteps();
    HomePage homePage = new HomePage();
    @Test
    public void adicionarCarrinhoComSucesso(){
        homePage.clicarSignUp();
        loginSteps.login();
        searchSteps.pesquisarTShirt();
        searchPage.hoverAddToCart();
        searchPage.clicarBtnAddToCart();
        searchPage.clicarBtnCheckout();

        Assert.assertEquals(checkoutPage.validarProdutoCheckout(),"Faded Short Sleeve T-shirts");
    }
}
