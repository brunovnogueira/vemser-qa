package aceitacao.service;
import aceitacao.dto.pet.DeleteDTO;
import aceitacao.dto.pet.PetPayloadDTO;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class PetService {
    String baseuri = "https://petstore.swagger.io/v2/pet";

    public PetPayloadDTO adicionarPet(String jsonBody){
        PetPayloadDTO resul = given()
                .contentType(ContentType.JSON)
                .log().all()
                .body(jsonBody)
        .when()
                .post(baseuri)
        .then()
                .log().all()
        .statusCode(200)
                .extract().as(PetPayloadDTO.class)
        ;

        return resul;
    }

    public PetPayloadDTO atualizarPet(String jsonBody){
        PetPayloadDTO resul = given()
                .contentType(ContentType.JSON)
                .log().all()
                .body(jsonBody)
        .when()
                .put(baseuri)
        .then()
                .log().all()
                .statusCode(200)
                .extract().as(PetPayloadDTO.class)
        ;

        return resul;
    }

    public PetPayloadDTO listarPet(String petId){
        String getUrl = baseuri + "/"+ petId;
        PetPayloadDTO resul = given()
                .contentType(ContentType.JSON)
                .log().all()
        .when()
                .get(getUrl)
        .then()
                .log().all()
                .statusCode(200)
                .extract().as(PetPayloadDTO.class)
        ;

        return resul;
    }

    public DeleteDTO deletarPet(String petId){
        String getUrl = baseuri + "/"+ petId;
        DeleteDTO resul = given()
                .contentType(ContentType.JSON)
                .log().all()
        .when()
                .delete(getUrl)
        .then()
                .log().all()
                .statusCode(200)
                .extract().as(DeleteDTO.class)
        ;

        return resul;
    }
}
