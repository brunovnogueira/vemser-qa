import Utils from "../utils/utils";
const utils = new Utils;

import CadastroElements from "../elements/CadastroElements";
const cadastroElements = new CadastroElements;

export default class EditarUsuarioPage{
  preencherNome(){
    utils.preencherInput(cadastroElements.nomeCampo,'Augusto');
  }

  preencherUltimoNome(){
    utils.preencherInput(cadastroElements.ultimoNomeCampo,"Nunes");
  }

  preencherEmail(){
    utils.preencherInput(cadastroElements.emailCampo,"anunes@email.com")
  }

  clicarBtnEditar(){
    utils.click(cadastroElements.botaoEditar)
  }
}

