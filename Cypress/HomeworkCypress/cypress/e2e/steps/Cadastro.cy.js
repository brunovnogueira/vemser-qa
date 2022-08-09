import CadastroPage from "../pages/CadastroPage";
const cadastroPage = new CadastroPage;

import UsuarioCriadoPage from "../pages/UsuarioCriadoPage";
const usuarioCriadoPage = new UsuarioCriadoPage;

describe('Cadastro com sucesso', () => {
  it('passes', () => {
    cadastroPage.abrirNavegador(); 
    cadastroPage.preencherNome();
    cadastroPage.preencherUltimoNome();
    cadastroPage.preencherEmail();
    cadastroPage.preencherEndereco();
    cadastroPage.preencherUniversidade();
    cadastroPage.preencherProfissao();
    cadastroPage.preencherGenero();
    cadastroPage.preencherIdade();
    cadastroPage.clicarBtnCriar();

    //validações
    usuarioCriadoPage.validarNome();
    usuarioCriadoPage.validarUltimoNome();
    usuarioCriadoPage.validarEmail();
    usuarioCriadoPage.validarUniversidade();
    usuarioCriadoPage.validarGenero();
    usuarioCriadoPage.validarProfissao();
    usuarioCriadoPage.validarIdade();
    usuarioCriadoPage.validarEndereco();
  })
})