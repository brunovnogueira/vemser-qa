package aceitacao;

import aceitacao.dto.*;
import aceitacao.service.PessoaService;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PessoaAceitacao {
    PessoaService pessoaService = new PessoaService();
    public String lerJson(String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }

    /*------------------------------------------------------------------------------------------------------------------------------------*/
    @Test
    public void listarPessoasComSucesso() throws IOException {
        String jsonBody = lerJson("src/test/resources/data/Pessoa.json");
        PessoaDTO pessoa = pessoaService.adicionarPessoa(jsonBody);
        PaginacaoPessoaDTO res = pessoaService.listarPessoas(0,1000);

        Assert.assertEquals(res.getPage(),"0");
        Assert.assertEquals(res.getSize(),"1000");
        Assert.assertFalse(res.getContent().isEmpty());

        pessoaService.deletarPessoa(pessoa.getIdPessoa());
    }
    @Test
    public void listarPessoasSemElementosNaPagina(){
        PaginacaoPessoaDTO res = pessoaService.listarPessoas(1000,20);

        Assert.assertTrue(res.getContent().isEmpty());

    }
    /*------------------------------------------------------------------------------------------------------------------------------------*/
    @Test
    public void listarPessoasPorCpfComSucesso() throws IOException {
        String jsonBody = lerJson("src/test/resources/data/Pessoa.json");
        PessoaDTO pessoa = pessoaService.adicionarPessoa(jsonBody);
        PessoaDTO res = pessoaService.listarPorCpf(pessoa.getCpf());

        Assert.assertEquals(res.getCpf(),pessoa.getCpf());
        Assert.assertEquals(res.getIdPessoa(),pessoa.getIdPessoa());

        pessoaService.deletarPessoa(pessoa.getIdPessoa());
    }
    @Test
    public void listarPessoasPorCpfSemSucesso(){
        Erro500DTO res = pessoaService.listarPorCpfVazio("");

        Assert.assertEquals(res.getError(),"Internal Server Error");
        Assert.assertEquals(res.getStatus(),"500");
    }
    /*------------------------------------------------------------------------------------------------------------------------------------*/
    @Test //Lista de relatorio por id e retorna uma lista. Deveria retornar somente um objeto, pois id é unico
    public void listarRelatorioComSucesso() throws IOException {
        String jsonBody = lerJson("src/test/resources/data/Pessoa.json");
        PessoaDTO pessoa = pessoaService.adicionarPessoa(jsonBody);

        RelatorioPessoaDTO[] res = pessoaService.listarRelatorio(pessoa.getIdPessoa());

        Assert.assertEquals(res[0].getIdPessoa(),pessoa.getIdPessoa());
        Assert.assertEquals(res[0].getEmail(),pessoa.getEmail());

        pessoaService.deletarPessoa(pessoa.getIdPessoa());
    }
    @Test //Lista de relatorio por id e retorna uma lista. Deveria retornar somente um objeto, pois id é unico
    public void listarRelatorioComNulos(){
        RelatorioPessoaDTO[] res = pessoaService.listarRelatorio("");

        Assert.assertNull(res[0].getCidade());
        Assert.assertNull(res[0].getCep());
        Assert.assertNull(res[0].getEstado());
        Assert.assertNull(res[0].getPais());
    }
    /*------------------------------------------------------------------------------------------------------------------------------------*/
    @Test //Lista de relatorio por id e retorna uma lista. Deveria retornar somente um objeto, pois id é unico
    public void listarListaCompletaComSucesso() throws IOException {
        String jsonBody = lerJson("src/test/resources/data/Pessoa.json");
        PessoaDTO pessoa = pessoaService.adicionarPessoa(jsonBody);

        ListaCompletaDTO[] res = pessoaService.listarListaCompleta(pessoa.getIdPessoa());

        Assert.assertEquals(res[0].getIdPessoa(),pessoa.getIdPessoa());
        Assert.assertEquals(res[0].getNome(),pessoa.getNome());

        pessoaService.deletarPessoa(pessoa.getIdPessoa());
    }
    @Test //Lista de relatorio por id e retorna uma lista. Deveria retornar somente um objeto, pois id é unico
    public void listarListaCompletaComCamposVazios(){
        ListaCompletaDTO[] res = pessoaService.listarListaCompleta("");

        Assert.assertEquals(res[0].getIdPessoa(),"800");
        Assert.assertTrue(res[0].getContatos().isEmpty());
        Assert.assertTrue(res[0].getEnderecos().isEmpty());
    }
    /*------------------------------------------------------------------------------------------------------------------------------------*/
    @Test //Lista de relatorio por id e retorna uma lista. Deveria retornar somente um objeto, pois id é unico
    public void listarListaComEnderecoComSucesso() throws IOException {
        String jsonBody = lerJson("src/test/resources/data/Pessoa.json");
        PessoaDTO pessoa = pessoaService.adicionarPessoa(jsonBody);

        ListaComEnderecoDTO[] res = pessoaService.listarListaComEndereco(pessoa.getIdPessoa());

        Assert.assertEquals(res[0].getIdPessoa(),pessoa.getIdPessoa());
        Assert.assertEquals(res[0].getNome(),pessoa.getNome());
        Assert.assertTrue(res[0].getEnderecos().isEmpty());

        pessoaService.deletarPessoa(pessoa.getIdPessoa());
    }
    @Test //Lista de relatorio por id e retorna uma lista. Deveria retornar somente um objeto, pois id é unico
    public void listarListaComEnderecoVazio(){
        ListaComEnderecoDTO[] res = pessoaService.listarListaComEndereco("");

        Assert.assertEquals(res[0].getIdPessoa(),"800");
        Assert.assertTrue(res[0].getEnderecos().isEmpty());
    }
    /*------------------------------------------------------------------------------------------------------------------------------------*/
    @Test //Lista de relatorio por id e retorna uma lista. Deveria retornar somente um objeto, pois id é unico
    public void listarListaComContatoComSucesso() throws IOException {
        String jsonBody = lerJson("src/test/resources/data/Pessoa.json");
        PessoaDTO pessoa = pessoaService.adicionarPessoa(jsonBody);

        ListaComContatoDTO[] res = pessoaService.listarListaComContato(pessoa.getIdPessoa());

        Assert.assertEquals(res[0].getIdPessoa(),pessoa.getIdPessoa());
        Assert.assertEquals(res[0].getNome(),pessoa.getNome());
        Assert.assertTrue(res[0].getContatos().isEmpty());

        pessoaService.deletarPessoa(pessoa.getIdPessoa());
    }
    @Test //Lista de relatorio por id e retorna uma lista. Deveria retornar somente um objeto, pois id é unico
    public void listarListaComContatoVazio(){
        ListaComContatoDTO[] res = pessoaService.listarListaComContato("");

        Assert.assertEquals(res[0].getIdPessoa(),"800");
        Assert.assertTrue(res[0].getContatos().isEmpty());
    }
    /*------------------------------------------------------------------------------------------------------------------------------------*/
//    @Test
//    public void listarDataNascimentoComSucesso(){
//        PessoaDTO[] res = pessoaService.listarDataNascimento();

//        Assert.assertEquals(res[0].getIdPessoa(),"724");
//        Assert.assertEquals(res[0].getNome(),"João Andrey");
//        Assert.assertEquals(res[0].getContatos().get(0).getTipoContato(),"RESIDENCIAL");
//        Assert.assertEquals(res[0].getContatos().get(0).getTelefone(),"(66)66666-6666");
//    }
//https://dbc-pessoa-api.herokuapp.com/pessoa/data-nascimento?data=01%2F01%2F2000&dtFinal=31%2F12%2F2022
//https://dbc-pessoa-api.herokuapp.com/pessoa/data-nascimento?data=01%2F01%2F2000&dtFinal=31%2F12%2F2022
    /*------------------------------------------------------------------------------------------------------------------------------------*/
    @Test
    public void listarByName() throws IOException {
        String jsonBody = lerJson("src/test/resources/data/Pessoa.json");
        PessoaDTO pessoa = pessoaService.adicionarPessoa(jsonBody);

        PessoaDTO[] res = pessoaService.listarByName(pessoa.getNome());

        Assert.assertEquals(res[0].getIdPessoa(),pessoa.getIdPessoa());
        Assert.assertEquals(res[0].getNome(),pessoa.getNome());

        pessoaService.deletarPessoa(pessoa.getIdPessoa());
    }
    @Test
    public void listarByNameSemSucesso(){
        PessoaDTO[] res = pessoaService.listarByName("");

        //Não deveria trazer nomes, mas traz
        Assert.assertFalse(res[0].getIdPessoa().isEmpty());
    }
    /*------------------------------------------------------------------------------------------------------------------------------------*/
    @Test
    public void adicionarPessoaComSucesso() throws IOException {
        String jsonBody = lerJson("src/test/resources/data/Pessoa.json");
        PessoaDTO res = pessoaService.adicionarPessoa(jsonBody);

        Assert.assertEquals(res.getEmail(),"bruno.nogueira@email.com.br");
        Assert.assertEquals(res.getNome(),"Bruno Nogueira");

        pessoaService.deletarPessoa(res.getIdPessoa());
    }
    @Test
    public void adicionarPessoaSemSucesso() throws IOException {
        String jsonBody = lerJson("src/test/resources/data/PessoaErro.json");
        Erro400DTO res = pessoaService.adicionarPessoaErro(jsonBody);

        Assert.assertEquals(res.getErrors().get(0),"cpf: size must be between 0 and 11");
    }
    /*------------------------------------------------------------------------------------------------------------------------------------*/
    @Test
    public void atualizarPessoaComSucesso() throws IOException {
        String jsonBodyAdd = lerJson("src/test/resources/data/Pessoa.json");
        PessoaDTO pessoa = pessoaService.adicionarPessoa(jsonBodyAdd);

        String jsonBody = lerJson("src/test/resources/data/PessoaPut.json");
        PessoaDTO res = pessoaService.atualizarPessoa(jsonBody, pessoa.getIdPessoa());

        Assert.assertEquals(res.getEmail(),"bruno@email.com");
        Assert.assertEquals(res.getNome(),"Bruno Nogueira");

        pessoaService.deletarPessoa(pessoa.getIdPessoa());
    }
    @Test
    public void atualizarPessoaSemSucesso() throws IOException {
        String jsonBody = lerJson("src/test/resources/data/PessoaPutErro.json");
        Erro400DTO res = pessoaService.atualizarPessoaErro(jsonBody,"890");

        Assert.assertEquals(res.getErrors().get(0),"dataNascimento: must be a past date");
    }
    /*------------------------------------------------------------------------------------------------------------------------------------*/
    @Test
    public void deletarPessoa() throws IOException {
        String jsonBody = lerJson("src/test/resources/data/Pessoa.json");
        PessoaDTO pessoa = pessoaService.adicionarPessoa(jsonBody);

        pessoaService.deletarPessoa(pessoa.getIdPessoa());

        Assert.assertEquals(pessoaService.listarByName(pessoa.getNome()).length, 0);

    }
    @Test
    public void deletarPessoaSemSucesso(){
        Erro404DTO res = pessoaService.deletarPessoaErro("2000");

        Assert.assertEquals(res.getMessage(),"ID da pessoa nao encontrada");
    }
}