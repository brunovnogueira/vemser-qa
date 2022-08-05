package steps;

import org.junit.Assert;
import org.junit.Test;
import pages.LoggedPage;
import pages.SearchPage;
import util.Browser;

public class SearchSteps extends Browser {
    LoggedPage loggedPage = new LoggedPage();
    SearchPage searchPage = new SearchPage();
    SignUpSteps signUpSteps = new SignUpSteps();

    @Test
    public void pesquisaComSucesso(){
        signUpSteps.cadastrar();
        loggedPage.preencherSearchField();
        loggedPage.clicarBtnSearch();

        Assert.assertTrue(searchPage.validarProduto().contains("T-shirts"));
    }

}
