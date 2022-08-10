import Utils from "../utils/Utils";
const utils = new Utils;

import LoggedElement from "../elements/LoggedElement";
const loggedElement = new LoggedElement;

export default class LoggedPage{
  validarBtnLogin(){
    utils.validarText(loggedElement.btnSignOut,'Sign out')
  }
}