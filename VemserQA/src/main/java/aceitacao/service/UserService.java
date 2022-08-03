package aceitacao.service;

import aceitacao.dto.user.GetDTO;
import aceitacao.dto.user.UserDTO;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UserService {
    String baseuri = "https://petstore.swagger.io/v2/user";

    public GetDTO adicionarUser(String jsonBody){
        GetDTO res = given()
                .contentType(ContentType.JSON)
                .log().all()
                .body(jsonBody)
        .when()
                .post(baseuri)
        .then()
                .log().all()
                .statusCode(200)
                .extract().as(GetDTO.class);

        return res;
    }
}
