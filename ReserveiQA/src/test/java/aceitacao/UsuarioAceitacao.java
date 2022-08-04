package aceitacao;

import aceitacao.dto.UsuarioDTO;
import aceitacao.dto.UsuarioPutDTO;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class UsuarioAceitacao {
    String baseUri = "https://vemser-reservei-api.herokuapp.com";
    public String lerJson(String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }

    @Test
    public void listarUsuario(){
        String url = baseUri + "/usuario/listar";

        UsuarioDTO res = given()
                .contentType(ContentType.JSON)
                .header("Authorization","eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJwZXNzb2EtYXBpIiwianRpIjozLCJyb2xlcyI6WyJST0xFX0NMSUVOVEUiXSwiaWF0IjoxNjU5NjI1NDE0LCJleHAiOjE2NTk3MTE4MTR9.Za6r7YhQjuG8LdqSzQ6XsK8k3_bGLtDZrVxYzIQtKps")
                .when()
                .get(url)
                .then()
                .log().all()
                .statusCode(200)
                .extract().as(UsuarioDTO.class)
                ;

        Assert.assertEquals(res.getNome(),"Bruno Rodrigues");
        Assert.assertEquals(res.getCpf(),"85325298011");
    }

    @Test
    public void editarUsuario() throws IOException {
        String url = baseUri + "/usuario/editar";
        String jsonBody = lerJson("src/test/resources/data/usuario.json");

        UsuarioPutDTO res = given()
                .contentType(ContentType.JSON)
                .log().all()
                .header("Authorization","eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJwZXNzb2EtYXBpIiwianRpIjozLCJyb2xlcyI6WyJST0xFX0NMSUVOVEUiXSwiaWF0IjoxNjU5NjI1NDE0LCJleHAiOjE2NTk3MTE4MTR9.Za6r7YhQjuG8LdqSzQ6XsK8k3_bGLtDZrVxYzIQtKps")
                .body(jsonBody)
                .when()
                .put(url)
                .then()
                .log().all()
                .statusCode(200)
                .extract().as(UsuarioPutDTO.class)
                ;

        Assert.assertEquals(res.getNome(),"Bruno Nogueira");
        Assert.assertEquals(res.getTelefone(),"11887564758");
    }
}
