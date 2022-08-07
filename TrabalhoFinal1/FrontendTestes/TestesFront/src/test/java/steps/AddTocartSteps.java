package steps;

import org.junit.Assert;
import org.junit.Test;
import pages.CartPage;
import pages.LoggedPage;
import util.Browser;

public class AddTocartSteps extends Browser {
    LoginSteps loginSteps = new LoginSteps();
    LoggedPage loggedPage = new LoggedPage();
    CartPage cartPage = new CartPage();

    @Test
    public void adicionarAoCarrinhoComSucesso(){
        loginSteps.login();
        loggedPage.clicarBtnAddToCart();
        loggedPage.clicarBtnCart();

        Assert.assertEquals(cartPage.validarProdutoCarrinho(),"Sauce Labs Backpack");
    }
}
