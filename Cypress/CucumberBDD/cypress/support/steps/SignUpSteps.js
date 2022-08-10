/// <reference types="cypress" />

import AuthenticationPage from "../pages/AuthenticationPage";
const authenticationPage = new AuthenticationPage;

import SignUpPage from "../pages/SignUpPage";
const signUpPage = new SignUpPage;


Given("que acesso o sistema {}", (site) => {
  authenticationPage.navegar(site);  
})

And("preencho o campo email", () => {
  authenticationPage.preencherEmail();
})

And("clico no botao create an account", () => {
  authenticationPage.clicarBtnCreateAccount();
})

And("clico no botao para selecionar o titulo", () => {
  signUpPage.clicarTitle();
})

And("preencho o campo first name", () => {
  signUpPage.preencherFirstName();
})

And("preencho o campo last name", () => {
  signUpPage.preencherLastName();
})

And("preencho o campo password", () => {
  signUpPage.preencherPassword();
})

And("seleciono o dia de aniversario", () => {
  signUpPage.selecionarDia();
})

And("seleciono o mes de aniversario", () => {
  signUpPage.selecionarMes();
})

And("seleciono o ano de aniversario", () => {
  signUpPage.selecionarAno();
})


And("preencho o campo address", () => {
  signUpPage.preencherAddress();
})

And("preencho o campo city", () => {
  signUpPage.preencherCity();
})

And("seleciono o estado", () => {
  signUpPage.selecionarEstado();
})

And("preencho o campo zip", () => {
  signUpPage.preencherCep();
})

And("seleciono o pais", () => {
  signUpPage.selecionarPais();
})

And("preencho o campo mobile", () => {
  signUpPage.preencherTelefone();
})

When("clico botao register", () => {
  signUpPage.clicarRegistrar();
})