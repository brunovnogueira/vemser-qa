/// <reference types="cypress" />

import Utils from "../utils/Utils";
const utils = new Utils;

import SignUpElement from "../elements/SignUpElement";
import { util } from "chai";
const signUpElement = new SignUpElement;

var Chance = require('chance');
var chance = new Chance();

let firstName = chance.first();
let lastName = chance.last();
let password = '12345';
let address = chance.address();
let city = chance.city();
let zip = chance.zip();
let mobile = chance.phone();

export default class SignUpPage{
  clicarTitle(){
    utils.tempo(10000)
    utils.click(signUpElement.btnMr);
  }

  preencherFirstName(){
    utils.preencherInput(signUpElement.firstName,firstName)
  }

  preencherLastName(){
    utils.preencherInput(signUpElement.lastName,lastName)
  }

  preencherPassword(){
    utils.preencherInput(signUpElement.password,password)
  }

  selecionarDia(){
    utils.select(signUpElement.day,'1')
  }

  selecionarMes(){
    utils.select(signUpElement.month,'January')
  }

  selecionarAno(){
    utils.select(signUpElement.year,'2012')
  }

  preencherAddress(){
    utils.preencherInput(signUpElement.address, address)
  }

  preencherCity(){
    utils.preencherInput(signUpElement.city, city)
  }

  selecionarEstado(){
    utils.select(signUpElement.state,'1');
    utils.tempo(5000)
  }

  preencherCep(){
    utils.preencherInput(signUpElement.zip,zip)
  }

  preencherTelefone(){
    utils.preencherInput(signUpElement.mobile,mobile)
  }

  clicarRegistrar(){
    utils.click(signUpElement.btnRegister)
  }
}