import Utils from "../utils/utils";
const utils = new Utils;

import UsuarioCriadoElements from "../elements/UsuarioCriadoElements";
const usuarioCriadoElements = new UsuarioCriadoElements;

export default class UsuarioCriadoPage{
  validarNome(){
    utils.validarText(usuarioCriadoElements.textoNomeCampo,'Bruno')
  }

  validarUltimoNome(){
    utils.validarText(usuarioCriadoElements.textoUltimoNomeCampo,'Souza')
  }

  validarEmail(){
    utils.validarText(usuarioCriadoElements.textoEmailCampo,'souza@email.com')
  }

  validarUniversidade(){
    utils.validarText(usuarioCriadoElements.textoUniversidadeCampo,'XPTO')
  }

  validarGenero(){
    utils.validarText(usuarioCriadoElements.textoGeneroCampo,'Masculino')
  }

  validarProfissao(){
    utils.validarText(usuarioCriadoElements.textoProfissaoCampo,'TESTE')
  }

  validarIdade(){
    utils.validarText(usuarioCriadoElements.textoIdadeCampo,'28')
  }

  validarEndereco(){
    utils.validarText(usuarioCriadoElements.textoEnderecoCampo,'Rua dois')
  }

  clicarBtnEditar(){
    utils.click(usuarioCriadoElements.btnEditar);
  }
}