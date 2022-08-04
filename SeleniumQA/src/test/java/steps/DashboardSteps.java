package steps;

import org.junit.Assert;
import org.junit.Test;
import pages.CreateCustomerPage;
import pages.DashboardPage;
import pages.DeletePage;
import pages.EditCustomerPage;
import util.Browser;

public class DashboardSteps extends Browser {
    DashboardPage dashboardPage = new DashboardPage();
    LoginSteps loginSteps = new LoginSteps();
    CreateCustomerPage createCustomerPage = new CreateCustomerPage();
    EditCustomerPage editCustomerPage = new EditCustomerPage();
    DeletePage deletePage = new DeletePage();

    @Test
    public void createComSucesso(){
        loginSteps.logar();
        dashboardPage.clicarCreateNew();
        createCustomerPage.preencherName();
        createCustomerPage.preencherCompany();
        createCustomerPage.preencherAddress();
        createCustomerPage.preencherCity();
        createCustomerPage.preencherPhone();
        createCustomerPage.preencherEmail();
        createCustomerPage.clicarCreate();
        listar();
        Assert.assertEquals(dashboardPage.validarName(), "Bruno N");
        Assert.assertEquals(dashboardPage.validarEmail(), "teste@gmail.com");
        delete();
    }

    @Test
    public void listarClienteComSucesso(){
        loginSteps.logar();
        criar();
        dashboardPage.preencherSearch();
        dashboardPage.clicarSearch();
        Assert.assertEquals(dashboardPage.validarName(), "Bruno N");
        Assert.assertEquals(dashboardPage.validarEmail(), "teste@gmail.com");
        delete();
    }

    @Test
    public void editarClienteComSucesso(){
        loginSteps.logar();
        criar();
        listar();
        dashboardPage.clicarEdit();
        editCustomerPage.preencherName();
        editCustomerPage.preencherCompany();
        editCustomerPage.preencherAddress();
        editCustomerPage.preencherCity();
        editCustomerPage.preencherPhone();
        editCustomerPage.preencherEmail();
        editCustomerPage.clicarSave();
        dashboardPage.preencherSearchEdit();
        dashboardPage.clicarSearch();

        Assert.assertEquals(dashboardPage.validarName(), "Teste123");
        Assert.assertEquals(dashboardPage.validarEmail(), "teste@gmail.com");

        delete();
    }

    @Test
    public void deletarClienteComSucesso(){
        loginSteps.logar();
        criar();
        listar();
        dashboardPage.clicarDelete();
        deletePage.clicarDelete();
        listar();

        Assert.assertEquals(dashboardPage.validarNoMatch(),"No Match");
    }

    public void listar(){
        dashboardPage.preencherSearch();
        dashboardPage.clicarSearch();
    }


    public void criar(){
        dashboardPage.clicarCreateNew();
        createCustomerPage.preencherName();
        createCustomerPage.preencherCompany();
        createCustomerPage.preencherAddress();
        createCustomerPage.preencherCity();
        createCustomerPage.preencherPhone();
        createCustomerPage.preencherEmail();
        createCustomerPage.clicarCreate();
    }
     public void delete(){
         dashboardPage.clicarDelete();
         deletePage.clicarDelete();
     }
}
