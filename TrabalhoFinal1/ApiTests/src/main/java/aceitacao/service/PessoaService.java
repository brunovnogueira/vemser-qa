package aceitacao.service;

import aceitacao.dto.*;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class PessoaService {
    String baseUrl = "https://dbc-pessoa-api.herokuapp.com/";

    public PaginacaoPessoaDTO listarPessoas(Integer pagina, Integer tamanho){
        String url = baseUrl + "pessoa?pagina={pagina}&tamanhoDasPaginas={tamanho}";
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ2ZW1zZXItYXBpIiwianRpIjoiNDA0IiwiY2FyZ29zIjpbXSwiaWF0IjoxNjU5OTc0ODg4LCJleHAiOjE2NjAwNjEyODh9.Ql5a4H2PmDOWNezwJz-iDVueke5xpgb0uCkFWbcJN_0";

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

    public PessoaDTO listarPorCpf(String cpf){
        String url = baseUrl + "pessoa/{cpf}/cpf";
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ2ZW1zZXItYXBpIiwianRpIjoiNDA0IiwiY2FyZ29zIjpbXSwiaWF0IjoxNjU5OTc0ODg4LCJleHAiOjE2NjAwNjEyODh9.Ql5a4H2PmDOWNezwJz-iDVueke5xpgb0uCkFWbcJN_0";

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

    public Erro500DTO listarPorCpfVazio(String cpf){
        String url = baseUrl + "pessoa/{cpf}/cpf";
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ2ZW1zZXItYXBpIiwianRpIjoiNDA0IiwiY2FyZ29zIjpbXSwiaWF0IjoxNjU5OTc0ODg4LCJleHAiOjE2NjAwNjEyODh9.Ql5a4H2PmDOWNezwJz-iDVueke5xpgb0uCkFWbcJN_0";

        Erro500DTO res = given()
                .contentType(ContentType.JSON)
                .log().all()
                .header("Authorization",token)
                .pathParam("cpf",cpf)
                .when()
                .get(url)
                .then()
                .log().all()
                .statusCode(500)
                .extract().as(Erro500DTO.class)
                ;

        return res;
    }

    public RelatorioPessoaDTO[] listarRelatorio(String id){
        String url = baseUrl + "pessoa/relatorio?idPessoa={id}";
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ2ZW1zZXItYXBpIiwianRpIjoiNDA0IiwiY2FyZ29zIjpbXSwiaWF0IjoxNjU5OTc0ODg4LCJleHAiOjE2NjAwNjEyODh9.Ql5a4H2PmDOWNezwJz-iDVueke5xpgb0uCkFWbcJN_0";

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

    public ListaCompletaDTO[] listarListaCompleta(String id){
        String url = baseUrl + "pessoa/lista-completa?idPessoa={id}";
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ2ZW1zZXItYXBpIiwianRpIjoiNDA0IiwiY2FyZ29zIjpbXSwiaWF0IjoxNjU5OTc0ODg4LCJleHAiOjE2NjAwNjEyODh9.Ql5a4H2PmDOWNezwJz-iDVueke5xpgb0uCkFWbcJN_0";

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

    public ListaComEnderecoDTO[] listarListaComEndereco(String id){
        String url = baseUrl + "pessoa/lista-com-enderecos?idPessoa={id}";
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ2ZW1zZXItYXBpIiwianRpIjoiNDA0IiwiY2FyZ29zIjpbXSwiaWF0IjoxNjU5OTc0ODg4LCJleHAiOjE2NjAwNjEyODh9.Ql5a4H2PmDOWNezwJz-iDVueke5xpgb0uCkFWbcJN_0";

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

    public ListaComContatoDTO[] listarListaComContato(String id){
        String url = baseUrl + "pessoa/lista-com-contatos?idPessoa={id}";
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ2ZW1zZXItYXBpIiwianRpIjoiNDA0IiwiY2FyZ29zIjpbXSwiaWF0IjoxNjU5OTc0ODg4LCJleHAiOjE2NjAwNjEyODh9.Ql5a4H2PmDOWNezwJz-iDVueke5xpgb0uCkFWbcJN_0";

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
//        String token = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ2ZW1zZXItYXBpIiwianRpIjoiNDA0IiwiY2FyZ29zIjpbXSwiaWF0IjoxNjU5OTc0ODg4LCJleHAiOjE2NjAwNjEyODh9.Ql5a4H2PmDOWNezwJz-iDVueke5xpgb0uCkFWbcJN_0";  String token = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ2ZW1zZXItYXBpIiwianRpIjoiNDA0IiwiY2FyZ29zIjpbXSwiaWF0IjoxNjU5Nzk5NDYxLCJleHAiOjE2NTk4ODU4NjF9.0ARNPOb3vsvH817Ur-mv9VOCPUlzTFaOMCuO0M-4SPU";
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

    public PessoaDTO[] listarByName(String nome){
        String url = baseUrl + "pessoa/byname?nome={nome}";
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ2ZW1zZXItYXBpIiwianRpIjoiNDA0IiwiY2FyZ29zIjpbXSwiaWF0IjoxNjU5OTc0ODg4LCJleHAiOjE2NjAwNjEyODh9.Ql5a4H2PmDOWNezwJz-iDVueke5xpgb0uCkFWbcJN_0";

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
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ2ZW1zZXItYXBpIiwianRpIjoiNDA0IiwiY2FyZ29zIjpbXSwiaWF0IjoxNjU5OTc0ODg4LCJleHAiOjE2NjAwNjEyODh9.Ql5a4H2PmDOWNezwJz-iDVueke5xpgb0uCkFWbcJN_0";

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

    public Erro400DTO adicionarPessoaErro(String jsonBody){
        String url = baseUrl + "pessoa";
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ2ZW1zZXItYXBpIiwianRpIjoiNDA0IiwiY2FyZ29zIjpbXSwiaWF0IjoxNjU5OTc0ODg4LCJleHAiOjE2NjAwNjEyODh9.Ql5a4H2PmDOWNezwJz-iDVueke5xpgb0uCkFWbcJN_0";

        Erro400DTO res = given()
                .contentType(ContentType.JSON)
                .log().all()
                .header("Authorization",token)
                .body(jsonBody)
                .when()
                .post(url)
                .then()
                .log().all()
                .statusCode(400)
                .extract().as(Erro400DTO.class)
                ;

        return res;
    }

    public PessoaDTO atualizarPessoa(String jsonBody,String id){
        String url = baseUrl + "pessoa/{id}";
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ2ZW1zZXItYXBpIiwianRpIjoiNDA0IiwiY2FyZ29zIjpbXSwiaWF0IjoxNjU5OTc0ODg4LCJleHAiOjE2NjAwNjEyODh9.Ql5a4H2PmDOWNezwJz-iDVueke5xpgb0uCkFWbcJN_0";

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

    public Erro400DTO atualizarPessoaErro(String jsonBody, String id){
        String url = baseUrl + "pessoa/{id}";
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ2ZW1zZXItYXBpIiwianRpIjoiNDA0IiwiY2FyZ29zIjpbXSwiaWF0IjoxNjU5OTc0ODg4LCJleHAiOjE2NjAwNjEyODh9.Ql5a4H2PmDOWNezwJz-iDVueke5xpgb0uCkFWbcJN_0";

        Erro400DTO res = given()
                .contentType(ContentType.JSON)
                .log().all()
                .header("Authorization",token)
                .pathParam("id",id)
                .body(jsonBody)
                .when()
                .put(url)
                .then()
                .log().all()
                .statusCode(400)
                .extract().as(Erro400DTO.class)
                ;

        return res;
    }

    public void deletarPessoa(String id){
        String url = baseUrl + "pessoa/{id}";
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ2ZW1zZXItYXBpIiwianRpIjoiNDA0IiwiY2FyZ29zIjpbXSwiaWF0IjoxNjU5OTc0ODg4LCJleHAiOjE2NjAwNjEyODh9.Ql5a4H2PmDOWNezwJz-iDVueke5xpgb0uCkFWbcJN_0";

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

    public Erro404DTO deletarPessoaErro(String id){
        String url = baseUrl + "pessoa/{id}";
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ2ZW1zZXItYXBpIiwianRpIjoiNDA0IiwiY2FyZ29zIjpbXSwiaWF0IjoxNjU5OTc0ODg4LCJleHAiOjE2NjAwNjEyODh9.Ql5a4H2PmDOWNezwJz-iDVueke5xpgb0uCkFWbcJN_0";

        Erro404DTO res = given()
                .contentType(ContentType.JSON)
                .log().all()
                .header("Authorization",token)
                .pathParam("id",id)
                .when()
                .delete(url)
                .then()
                .log().all()
                .statusCode(404)
                .extract().as(Erro404DTO.class)
        ;

        return res;
    }

    /*UTIL---------------------------------------------------------------------------------------------------------------*/

}
