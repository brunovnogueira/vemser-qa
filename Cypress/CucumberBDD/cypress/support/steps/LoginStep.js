/// <reference types="cypress" />

import LoginPage from "../pages/LoginPage";
const loginPage = new LoginPage;

import DashboardPage from "../pages/DashboardPage";
const dashboardPage = new DashboardPage;

Given("que acesso o sistema {}", (site) => {
  loginPage.navegar(site);  
})

And("preencho com username {}", (username) => {
  loginPage.preencherUsername(username);
})

And("preencho com senha {}", (senha) => {
  loginPage.preencherPassword(senha);
})

When("clico botao login", () => {
  loginPage.clicarNoLoginBtn();
})