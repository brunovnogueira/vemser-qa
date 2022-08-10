/// <reference types="cypress" />

import Utils from '../utils/Utils'
const utils = new Utils

import AuthenticationElement from '../elements/AuthenticationElement';
const authenticationElement = new AuthenticationElement;

var Chance = require('chance');
var chance = new Chance();

let email = chance.email();

export default class AuthenticationPage {
    navegar(url){
      utils.navegar(url);
    }

    preencherEmail(){
      utils.preencherInput(authenticationElement.email,email);
    }

    clicarBtnCreateAccount(){
      utils.click(authenticationElement.btnCreateAccount);
    }
}