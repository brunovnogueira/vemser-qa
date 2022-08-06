package aceitacao.service;

import aceitacao.dto.*;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class PessoaService {
    String baseUrl = "https://dbc-pessoa-api.herokuapp.com/";

    public PaginacaoPessoaDTO listarPessoas(){
        String url = baseUrl + "pessoa?pagina={pagina}&tamanhoDasPaginas={tamanho}";
        Integer pagina = 0;
        Integer tamanho = 20;
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ2ZW1zZXItYXBpIiwianRpIjoiNDA0IiwiY2FyZ29zIjpbXSwiaWF0IjoxNjU5Nzk5NDYxLCJleHAiOjE2NTk4ODU4NjF9.0ARNPOb3vsvH817Ur-mv9VOCPUlzTFaOMCuO0M-4SPU";

        PaginacaoPessoaDTO res = given()
                .contentType(ContentType.JSON)
                .log().all()
                .header("Authorization",token)
                .pathParam("pagina",pagina)
                .pathParam("tamanho",tamanho)
        .when()
                .get(url)
        .then()
                .log().all()
                .statusCode(200)
                .extract().as(PaginacaoPessoaDTO.class)
        ;

        return res;
    }

    public PessoaDTO listarPorCpf(){
        String url = baseUrl + "pessoa/{cpf}/cpf";
        String cpf = "12345678911";
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ2ZW1zZXItYXBpIiwianRpIjoiNDA0IiwiY2FyZ29zIjpbXSwiaWF0IjoxNjU5Nzk5NDYxLCJleHAiOjE2NTk4ODU4NjF9.0ARNPOb3vsvH817Ur-mv9VOCPUlzTFaOMCuO0M-4SPU";


        PessoaDTO res = given()
                .contentType(ContentType.JSON)
                .log().all()
                .header("Authorization",token)
                .pathParam("cpf",cpf)
        .when()
                .get(url)
        .then()
                .log().all()
                .statusCode(200)
                .extract().as(PessoaDTO.class)
        ;

        return res;
    }

    public RelatorioPessoaDTO[] listarRelatorio(){
        String url = baseUrl + "pessoa/relatorio?idPessoa={id}";
        String id = "724";
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ2ZW1zZXItYXBpIiwianRpIjoiNDA0IiwiY2FyZ29zIjpbXSwiaWF0IjoxNjU5Nzk5NDYxLCJleHAiOjE2NTk4ODU4NjF9.0ARNPOb3vsvH817Ur-mv9VOCPUlzTFaOMCuO0M-4SPU";

        RelatorioPessoaDTO[] res = given()
                .contentType(ContentType.JSON)
                .log().all()
                .header("Authorization",token)
                .pathParam("id",id)
        .when()
                .get(url)
        .then()
                .log().all()
                .statusCode(200)
                .extract().as(RelatorioPessoaDTO[].class)
        ;

        return res;
    }

    public ListaCompletaDTO[] listarListaCompleta(){
        String url = baseUrl + "pessoa/lista-completa?idPessoa={id}";
        String id = "1";
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ2ZW1zZXItYXBpIiwianRpIjoiNDA0IiwiY2FyZ29zIjpbXSwiaWF0IjoxNjU5Nzk5NDYxLCJleHAiOjE2NTk4ODU4NjF9.0ARNPOb3vsvH817Ur-mv9VOCPUlzTFaOMCuO0M-4SPU";

        ListaCompletaDTO[] res = given()
                .contentType(ContentType.JSON)
                .log().all()
                .header("Authorization",token)
                .pathParam("id",id)
        .when()
                .get(url)
        .then()
                .log().all()
                .statusCode(200)
                .extract().as(ListaCompletaDTO[].class)
        ;

        return res;
    }

    public ListaComEnderecoDTO[] listarListaComEndereco(){
        String url = baseUrl + "pessoa/lista-com-enderecos?idPessoa={id}";
        String id = "1";
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ2ZW1zZXItYXBpIiwianRpIjoiNDA0IiwiY2FyZ29zIjpbXSwiaWF0IjoxNjU5Nzk5NDYxLCJleHAiOjE2NTk4ODU4NjF9.0ARNPOb3vsvH817Ur-mv9VOCPUlzTFaOMCuO0M-4SPU";

        ListaComEnderecoDTO[] res = given()
                .contentType(ContentType.JSON)
                .log().all()
                .header("Authorization",token)
                .pathParam("id",id)
        .when()
                .get(url)
        .then()
                .log().all()
                .statusCode(200)
                .extract().as(ListaComEnderecoDTO[].class)
        ;

        return res;
    }

    public ListaComContatoDTO[] listarListaComContato(){
        String url = baseUrl + "pessoa/lista-com-contatos?idPessoa={id}";
        String id = "724";
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ2ZW1zZXItYXBpIiwianRpIjoiNDA0IiwiY2FyZ29zIjpbXSwiaWF0IjoxNjU5Nzk5NDYxLCJleHAiOjE2NTk4ODU4NjF9.0ARNPOb3vsvH817Ur-mv9VOCPUlzTFaOMCuO0M-4SPU";

        ListaComContatoDTO[] res = given()
                .contentType(ContentType.JSON)
                .log().all()
                .header("Authorization",token)
                .pathParam("id",id)
        .when()
                .get(url)
        .then()
                .log().all()
                .statusCode(200)
                .extract().as(ListaComContatoDTO[].class)
        ;

        return res;
    }

//    public PessoaDTO[] listarDataNascimento(){
//        String url = baseUrl + "pessoa/data-nascimento?data={data}&dtFinal={dataFinal}";
//        String data = "01/01/2000";
//        String dataFinal = "31/12/2022";
//        String token = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ2ZW1zZXItYXBpIiwianRpIjoiNDA0IiwiY2FyZ29zIjpbXSwiaWF0IjoxNjU5Nzk5NDYxLCJleHAiOjE2NTk4ODU4NjF9.0ARNPOb3vsvH817Ur-mv9VOCPUlzTFaOMCuO0M-4SPU";
//
//        PessoaDTO[] res = given()
//                .contentType(ContentType.JSON)
//                .log().all()
//                .header("Authorization",token)
//                .pathParam("data", data)
//                .pathParam("dataFinal", dataFinal)
//                .when()
//                .get(url)
//                .then()
//                .log().all()
//                .statusCode(200)
//                .extract().as(PessoaDTO[].class)
//                ;
//
//        return res;
//    }

    public PessoaDTO[] listarByName(){
        String url = baseUrl + "pessoa/byname?nome={nome}";
        String nome = "João";
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ2ZW1zZXItYXBpIiwianRpIjoiNDA0IiwiY2FyZ29zIjpbXSwiaWF0IjoxNjU5Nzk5NDYxLCJleHAiOjE2NTk4ODU4NjF9.0ARNPOb3vsvH817Ur-mv9VOCPUlzTFaOMCuO0M-4SPU";

        PessoaDTO[] res = given()
                .contentType(ContentType.JSON)
                .log().all()
                .header("Authorization",token)
                .pathParam("nome",nome)
                .when()
                .get(url)
                .then()
                .log().all()
                .statusCode(200)
                .extract().as(PessoaDTO[].class)
                ;

        return res;
    }

    public PessoaDTO adicionarPessoa(String jsonBody){
        String url = baseUrl + "pessoa";
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ2ZW1zZXItYXBpIiwianRpIjoiNDA0IiwiY2FyZ29zIjpbXSwiaWF0IjoxNjU5Nzk5NDYxLCJleHAiOjE2NTk4ODU4NjF9.0ARNPOb3vsvH817Ur-mv9VOCPUlzTFaOMCuO0M-4SPU";

        PessoaDTO res = given()
                .contentType(ContentType.JSON)
                .log().all()
                .header("Authorization",token)
                .body(jsonBody)
                .when()
                .post(url)
                .then()
                .log().all()
                .statusCode(200)
                .extract().as(PessoaDTO.class)
                ;

        return res;
    }

    public PessoaDTO atualizarPessoa(String jsonBody){
        String url = baseUrl + "pessoa/{id}";
        String id = "861";
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ2ZW1zZXItYXBpIiwianRpIjoiNDA0IiwiY2FyZ29zIjpbXSwiaWF0IjoxNjU5Nzk5NDYxLCJleHAiOjE2NTk4ODU4NjF9.0ARNPOb3vsvH817Ur-mv9VOCPUlzTFaOMCuO0M-4SPU";

        PessoaDTO res = given()
                .contentType(ContentType.JSON)
                .log().all()
                .header("Authorization",token)
                .pathParam("id",id)
                .body(jsonBody)
                .when()
                .put(url)
                .then()
                .log().all()
                .statusCode(200)
                .extract().as(PessoaDTO.class)
                ;

        return res;
    }

    public void deletarPessoa(){
        String url = baseUrl + "pessoa/{id}";
        String id = "824";
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ2ZW1zZXItYXBpIiwianRpIjoiNDA0IiwiY2FyZ29zIjpbXSwiaWF0IjoxNjU5Nzk5NDYxLCJleHAiOjE2NTk4ODU4NjF9.0ARNPOb3vsvH817Ur-mv9VOCPUlzTFaOMCuO0M-4SPU";

        given()
                .contentType(ContentType.JSON)
                .log().all()
                .header("Authorization",token)
                .pathParam("id",id)
                .when()
                .delete(url)
                .then()
                .log().all()
                .statusCode(200)
                ;

    }
}
