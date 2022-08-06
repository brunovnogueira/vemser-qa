package aceitacao;

import aceitacao.dto.*;
import aceitacao.service.PessoaService;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.TestInstance;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PessoaAceitacao {
    PessoaService pessoaService = new PessoaService();
    public String lerJson(String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }

    @Test
    public void listarPessoasComSucesso(){
        PaginacaoPessoaDTO res = pessoaService.listarPessoas();

        Assert.assertEquals(res.getPage(),"0");
        Assert.assertEquals(res.getSize(),"20");
        Assert.assertEquals(res.getContent().get(0).getIdPessoa(),"797"); //quando add muda a posição na lista

    }

    @Test
    public void listarPessoasPorCpfComSucesso(){
        PessoaDTO res = pessoaService.listarPorCpf();

        Assert.assertEquals(res.getCpf(),"12345678911");
        Assert.assertEquals(res.getIdPessoa(),"724");
    }

    @Test //Lista de relatorio por id e retorna uma lista. Deveria retornar somente um objeto, pois id é unico
    public void listarRelatorioComSucesso(){
        RelatorioPessoaDTO[] res = pessoaService.listarRelatorio();

        Assert.assertEquals(res[0].getIdPessoa(),"724");
        Assert.assertEquals(res[0].getEmail(),"andrey.antochevis@gmail.com");
    }

    @Test //Lista de relatorio por id e retorna uma lista. Deveria retornar somente um objeto, pois id é unico
    public void listarListaCompletaComSucesso(){
        ListaCompletaDTO[] res = pessoaService.listarListaCompleta();

        Assert.assertEquals(res[0].getIdPessoa(),"1");
        Assert.assertEquals(res[0].getNome(),"Kaique Ceratinho");
        Assert.assertEquals(res[0].getContatos().get(0).getTelefone(),"51955565585");
        Assert.assertEquals(res[0].getContatos().get(0).getIdContato(),"1");
        Assert.assertEquals(res[0].getEnderecos().get(0).getCidade(),"Porto Alegre");
        Assert.assertEquals(res[0].getEnderecos().get(0).getIdEndereco(),"418");
    }

    @Test //Lista de relatorio por id e retorna uma lista. Deveria retornar somente um objeto, pois id é unico
    public void listarListaComEnderecoComSucesso(){
        ListaComEnderecoDTO[] res = pessoaService.listarListaComEndereco();

        Assert.assertEquals(res[0].getIdPessoa(),"1");
        Assert.assertEquals(res[0].getNome(),"Kaique Ceratinho");
        Assert.assertEquals(res[0].getEnderecos().get(0).getCidade(),"Porto Alegre");
        Assert.assertEquals(res[0].getEnderecos().get(0).getIdEndereco(),"418");
    }

    @Test //Lista de relatorio por id e retorna uma lista. Deveria retornar somente um objeto, pois id é unico
    public void listarListaComContatoComSucesso(){
        ListaComContatoDTO[] res = pessoaService.listarListaComContato();

        Assert.assertEquals(res[0].getIdPessoa(),"724");
        Assert.assertEquals(res[0].getNome(),"João Andrey");
        Assert.assertEquals(res[0].getContatos().get(0).getTipoContato(),"RESIDENCIAL");
        Assert.assertEquals(res[0].getContatos().get(0).getTelefone(),"(66)66666-6666");
    }

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

    @Test
    public void listarByName(){
        PessoaDTO[] res = pessoaService.listarByName();

        Assert.assertEquals(res[0].getIdPessoa(),"724");
        Assert.assertEquals(res[0].getNome(),"João Andrey");
    }

    @Test
    public void adicionarPessoa() throws IOException {
        String jsonBody = lerJson("src/test/resources/data/Pessoa.json");
        PessoaDTO res = pessoaService.adicionarPessoa(jsonBody);

        Assert.assertEquals(res.getEmail(),"bruno.nogueira@email.com.br");
        Assert.assertEquals(res.getNome(),"Bruno Nogueira");
    }

    @Test
    public void atualizarPessoa() throws IOException {
        String jsonBody = lerJson("src/test/resources/data/PessoaPut.json");
        PessoaDTO res = pessoaService.atualizarPessoa(jsonBody);

        Assert.assertEquals(res.getEmail(),"bruno@email.com");
        Assert.assertEquals(res.getNome(),"Bruno Nogueira");
    }

    @Test
    public void deletarPessoa(){
        pessoaService.deletarPessoa();
    }
}