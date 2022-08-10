/// <reference types="cypress" />

import DashboardPage from "../pages/DashboardPage";
const dashboardPage = new DashboardPage;

Then("devo verificar um texto na tela {}", (texto) => {
   dashboardPage.validarTextoNaTela(texto);
});