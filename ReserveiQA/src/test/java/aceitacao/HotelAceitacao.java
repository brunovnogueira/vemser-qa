package aceitacao;

import aceitacao.dto.*;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class HotelAceitacao {
    String baseUri = "https://vemser-reservei-api.herokuapp.com";
    public String lerJson(String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }

    //Endpoints sem autenticação
    @Test
    public void listarHoteis(){
        String url = baseUri + "/hotel/listar";

        HotelDTO[] res = given()
                .contentType(ContentType.JSON)
                .log().all()
        .when()
                .get(url)
        .then()
                .log().all()
                .statusCode(200)
                .extract().as(HotelDTO[].class);
        ;

        Assert.assertEquals(res[0].getIdHotel(),"1");
        Assert.assertEquals(res[0].getCidade(),"Porto Alegre");
        Assert.assertEquals(res[0].getNome(),"Ibis");
        Assert.assertEquals(res[0].getQuartos().get(0).getNumero(),"201");
        Assert.assertEquals(res[0].getQuartos().get(1).getNumero(),"101");
    }

    @Test
    public void listarHoteisPorCidade(){
        String url = baseUri + "/hotel/cidade?cidade={cidade}";

        HotelDTO[] res = given()
                .contentType(ContentType.JSON)
                .pathParam("cidade","São Paulo")
                .log().all()
        .when()
                .get(url)
        .then()
                .log().all()
                .statusCode(200)
                .extract().as(HotelDTO[].class);
        ;

        Assert.assertEquals(res[0].getIdHotel(),"3");
        Assert.assertEquals(res[0].getCidade(),"São Paulo");
        Assert.assertTrue(res[0].getNome().contains("Quality"));
        Assert.assertEquals(res[0].getQuartos().get(0).getNumero(),"103");
        Assert.assertEquals(res[0].getQuartos().get(1).getNumero(),"203");
    }

    @Test
    public void listarQuartos(){
        String url = baseUri + "/quarto/listar";

        QuartoDTO[] res = given()
                .contentType(ContentType.JSON)
                .log().all()
        .when()
                .get(url)
        .then()
                .log().all()
                .statusCode(200)
                .extract().as(QuartoDTO[].class);
        ;

        Assert.assertEquals(res[0].getNumero(),"101");
        Assert.assertEquals(res[0].getTipoQuarto(),"QUARTO_SOLTEIRO");
        Assert.assertEquals(res[0].getHotel().getCidade(),"Porto Alegre");
    }

    @Test
    public void listarQuartosPorTipo(){
        String url = baseUri + "/quarto/tipo-quarto?tipoQuarto={tipo}&pagina={pagina}&registro={registro}";
        String tipo = "QUARTO_SOLTEIRO";
        Integer pagina = 0;
        Integer registro = 10;

        PaginacaoDTO res = given()
                .contentType(ContentType.JSON)
                .pathParam("tipo",tipo)
                .pathParam("pagina",pagina)
                .pathParam("registro",registro)
        .when()
                .get(url)
        .then()
                .log().all()
                .statusCode(200)
                .extract().as(PaginacaoDTO.class)
        ;

        Assert.assertEquals(res.getPage(),pagina.toString());
        Assert.assertEquals(res.getSize(),registro.toString());
        Assert.assertEquals(res.getContent().get(1).getNumero(),"102");
        Assert.assertEquals(res.getContent().get(1).getTipoQuarto(),tipo);
        Assert.assertEquals(res.getContent().get(1).getHotel().getNome(),"Light Aurora Resort");
    }
}
