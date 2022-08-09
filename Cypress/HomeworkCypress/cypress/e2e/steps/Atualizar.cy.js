import EditarUsuarioPage from "../pages/EditarUsuarioPage";
const editarUsuarioPage = new EditarUsuarioPage;

import UsuarioCriadoPage from "../pages/UsuarioCriadoPage";
const usuarioCriadoPage = new UsuarioCriadoPage;

import CadastroPage from "../pages/CadastroPage";
const cadastroPage = new CadastroPage;

import UsuarioEditadoPage from "../pages/UsuarioEditadoPage"
const usuarioEditadoPage = new UsuarioEditadoPage;

describe('Atualizar com sucesso', () => {
  it('passes', () => {
    cadastroPage.criar();
    usuarioCriadoPage.clicarBtnEditar();
    editarUsuarioPage.preencherNome();
    editarUsuarioPage.preencherUltimoNome();
    editarUsuarioPage.preencherEmail();
    editarUsuarioPage.clicarBtnEditar();
    
    //validações
    usuarioEditadoPage.validarNomeEditado();
    usuarioEditadoPage.validarUltimoNomeEditado();
    usuarioEditadoPage.validarEmailEditado();
  })
})