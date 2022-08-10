/// <reference types="cypress" />

import LoggedPage from "../pages/LoggedPage";
const loggedPage = new LoggedPage;

Then("devo verificar um botao Sign out", () => {
   loggedPage.validarBtnLogin();
});