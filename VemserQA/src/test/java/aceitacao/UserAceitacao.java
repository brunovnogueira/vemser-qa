package aceitacao;

import aceitacao.dto.user.SimpleDTO;
import aceitacao.dto.user.UserDTO;
import aceitacao.service.UserService;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class UserAceitacao {

    UserService userService = new UserService();
    public String lerJson(String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }

    @Test
    public void adicionarUser() throws IOException {
        String jsonBody = lerJson("src/test/resources/data/user.json");
        JSONObject jsonObject = new JSONObject(jsonBody);

        SimpleDTO res = userService.adicionarUser(jsonBody);

        Assert.assertEquals(res.getCode(),"200"); //codigo de sucesso
        Assert.assertEquals(res.getMessage(),"1"); //numero do id

        deletarObject(jsonObject.get("username"));
    }

    @Test
    public void adicionarUserArray() throws IOException {
        String jsonBody = lerJson("src/test/resources/data/userList.json");

        SimpleDTO res = userService.adicionarUserArray(jsonBody);

        Assert.assertEquals(res.getCode(),"200"); //codigo de sucesso
        Assert.assertEquals(res.getMessage(),"ok");
    }

    @Test
    public void adicionarUserList() throws IOException {
        String jsonBody = lerJson("src/test/resources/data/userList.json");

        SimpleDTO res = userService.adicionarUserArray(jsonBody);

        Assert.assertEquals(res.getCode(),"200"); //codigo de sucesso
        Assert.assertEquals(res.getMessage(),"ok");
    }

    @Test
    public void listarPorUsername() throws IOException {
        String username = "bruno";

        adicionar();

        UserDTO res = userService.listarPorUsername(username);

        Assert.assertEquals(res.getUsername(),"bruno");
        Assert.assertEquals(res.getFirstName(),"Bruno");
        Assert.assertEquals(res.getPhone(),"117768574859");
        Assert.assertEquals(res.getEmail(),"bruno@gmail.com");


        deletarString(username);
    }

    @Test
    public void loginUser() throws IOException {
        String username = "bruno";
        String password = "123";

        adicionar();

        SimpleDTO res = userService.login(username,password);

        Assert.assertEquals(res.getCode(),"200");

        deletarString(username);
    }

    @Test
    public void logout() throws IOException {
        String username = "bruno";
        login();

        SimpleDTO res = userService.logout();

        Assert.assertEquals(res.getCode(),"200");
        Assert.assertEquals(res.getMessage(),"ok");

        deletarString(username);
    }

    @Test
    public void atualizarUser() throws IOException {
        String username = "bruno";
        String jsonBody = lerJson("src/test/resources/data/userPut.json");
        JSONObject jsonObject = new JSONObject(jsonBody);

        adicionar();

        SimpleDTO res = userService.atualizarUser(username,jsonBody);

        Assert.assertEquals(res.getCode(),"200");
        Assert.assertEquals(res.getMessage(),"1");

        listar(jsonObject.get("username").toString());

        deletarObject(jsonObject.get("username"));
    }

    @Test
    public void deletarUser() throws IOException {
        String username = "bruno";

        adicionar();

        SimpleDTO res = userService.deletar(username);

        Assert.assertEquals(res.getCode(),"200");
        Assert.assertEquals(res.getMessage(),"bruno");
    }


    /*UTIL-------------------------------------------------------------*/
    public void listar(String username) throws IOException {
        UserDTO res = userService.listarPorUsername(username);
    }

    public JSONObject adicionar() throws IOException {
        String jsonBody = lerJson("src/test/resources/data/user.json");
        JSONObject jsonObject = new JSONObject(jsonBody);

        SimpleDTO res = userService.adicionarUser(jsonBody);

        return jsonObject;
    }
    public void login() throws IOException {
        JSONObject jsonObject = adicionar();

        SimpleDTO res = userService.login(jsonObject.get("username").toString(),jsonObject.get("password").toString());
    }
    public void deletarObject(Object username) throws IOException {
        SimpleDTO res = userService.deletar(username.toString());
    }

    public void deletarString(String username) throws IOException {
        SimpleDTO res = userService.deletar(username.toString());
    }
}
