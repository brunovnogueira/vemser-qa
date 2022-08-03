package aceitacao.service;

import aceitacao.dto.user.SimpleDTO;
import aceitacao.dto.user.UserDTO;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class UserService {
    String baseuri = "https://petstore.swagger.io/v2/user";

    public SimpleDTO adicionarUser(String jsonBody){
        SimpleDTO res = given()
                .contentType(ContentType.JSON)
                .log().all()
                .body(jsonBody)
        .when()
                .post(baseuri)
        .then()
                .log().all()
                .statusCode(200)
                .extract().as(SimpleDTO.class);

        return res;
    }

    public SimpleDTO adicionarUserArray(String jsonBody){
        String postUrl = baseuri + "/" + "createWithArray";

        SimpleDTO res = given()
                .contentType(ContentType.JSON)
                .log().all()
                .body(jsonBody)
        .when()
                .post(postUrl)
        .then()
                .log().all()
                .statusCode(200)
                .extract().as(SimpleDTO.class);

        return res;
    }

    public SimpleDTO adicionarUserList(String jsonBody){
        String postUrl = baseuri + "/" + "createWithList";

        SimpleDTO res = given()
                .contentType(ContentType.JSON)
                .log().all()
                .body(jsonBody)
        .when()
                .post(postUrl)
        .then()
                .log().all()
                .statusCode(200)
                .extract().as(SimpleDTO.class);

        return res;
    }

    public UserDTO listarPorUsername(String username){
        String getUrl = baseuri + "/" + username;

        UserDTO res = given()
                .contentType(ContentType.JSON)
                .log().all()
        .when()
                .get(getUrl)
        .then()
                .log().all()
                .statusCode(200)
                .extract().as(UserDTO.class)
        ;

        return res;
    }

    public SimpleDTO login(String username, String password){
        String getUrl = baseuri + "/login?" + "username=" + username + "&password=" + password;

        SimpleDTO res = given()
                .contentType(ContentType.JSON)
                .log().all()
        .when()
                .get(getUrl)
        .then()
                .log().all()
                .statusCode(200)
                .extract().as(SimpleDTO.class);

        return res;
    }

    public SimpleDTO logout(){
        String getUrl = baseuri + "/logout";

        SimpleDTO res = given()
                .contentType(ContentType.JSON)
                .log().all()
        .when()
                .get(getUrl)
        .then()
                .log().all()
                .statusCode(200)
                .extract().as(SimpleDTO.class);

        return res;
    }

    public SimpleDTO atualizarUser(String username, String jsonBody){
        String putUrl = baseuri + "/" + username;

        SimpleDTO res = given()
                .contentType(ContentType.JSON)
                .log().all()
                .body(jsonBody)
        .when()
                .put(putUrl)
        .then()
                .log().all()
                .statusCode(200)
                .extract().as(SimpleDTO.class);

        return res;
    }

    public SimpleDTO deletar(String username){
        String deleteUrl = baseuri + "/" + username;

        SimpleDTO res = given()
                .contentType(ContentType.JSON)
                .log().all()
        .when()
                .delete(deleteUrl)
        .then()
                .log().all()
                .statusCode(200)
                .extract().as(SimpleDTO.class);

        return res;
    }
}
