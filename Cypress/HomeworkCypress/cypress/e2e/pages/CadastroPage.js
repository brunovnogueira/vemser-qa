import Utils from "../utils/utils";
const utils = new Utils;

import CadastroElements from "../elements/CadastroElements";
const cadastroElements = new CadastroElements;

export default class CadastroPage{
  abrirNavegador(){
    utils.navegar(cadastroElements.url);
  }

  preencherNome(){
    utils.preencherInput(cadastroElements.nomeCampo,'Bruno');
  }

  preencherUltimoNome(){
    utils.preencherInput(cadastroElements.ultimoNomeCampo,"Souza");
  }

  preencherEmail(){
    utils.preencherInput(cadastroElements.emailCampo,"souza@email.com")
  }

  preencherEndereco(){
    utils.preencherInput(cadastroElements.enderecoCampo,"Rua dois")
  }

  preencherUniversidade(){
    utils.preencherInput(cadastroElements.universidadeCampo,"XPTO")
  }

  preencherProfissao(){
    utils.preencherInput(cadastroElements.profissaoCampo,"TESTE")
  }

  preencherGenero(){
    utils.preencherInput(cadastroElements.generoCampo,"Masculino")
  }

  preencherIdade(){
    utils.preencherInput(cadastroElements.idadeCampo,"28")
  }

  clicarBtnCriar(){
    utils.click(cadastroElements.botaoCriar)
  }

  clicarBtnEditar(){
    utils.click(cadastroElements.botaoEditar)
  }

  criar(){
    utils.navegar(cadastroElements.url);
    utils.preencherInput(cadastroElements.nomeCampo,'Bruno');
    utils.preencherInput(cadastroElements.ultimoNomeCampo,"Souza");
    utils.preencherInput(cadastroElements.emailCampo,"souza@email.com");
    utils.click(cadastroElements.botaoCriar);
  }
}

