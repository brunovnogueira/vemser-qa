import Utils from "../utils/utils";
const utils = new Utils;

import UsuarioCriadoElements from "../elements/UsuarioCriadoElements";
const usuarioCriadoElements = new UsuarioCriadoElements;

export default class UsuarioEditadoPage{
  validarNomeEditado(){
    utils.validarText(usuarioCriadoElements.textoNomeCampo,'Augusto')
  }

  validarUltimoNomeEditado(){
    utils.validarText(usuarioCriadoElements.textoUltimoNomeCampo,"Nunes");
  }

  validarEmailEditado(){
    utils.validarText(usuarioCriadoElements.textoEmailCampo,"anunes@email.com")
  }
}