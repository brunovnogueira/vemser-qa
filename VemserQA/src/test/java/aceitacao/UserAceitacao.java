package aceitacao;

import aceitacao.dto.user.SimpleDTO;
import aceitacao.dto.user.UserDTO;
import aceitacao.service.UserService;
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

        SimpleDTO res = userService.adicionarUser(jsonBody);

        Assert.assertEquals(res.getCode(),"200"); //codigo de sucesso
        Assert.assertEquals(res.getMessage(),"1"); //numero do id
    }

    @Test
    public void listarPorUsername() throws IOException {
        String username = "bruno";

        adicionarUser();

        UserDTO res = userService.listarPorUsername(username);

        Assert.assertEquals(res.getUsername(),"bruno");
        Assert.assertEquals(res.getFirstName(),"Bruno");
        Assert.assertEquals(res.getPhone(),"117768574859");
        Assert.assertEquals(res.getEmail(),"bruno@gmail.com");
    }

    @Test
    public void login() throws IOException {
        String username = "bruno";
        String password = "123";

        adicionarUser();

        SimpleDTO res = userService.login(username,password);

        Assert.assertEquals(res.getCode(),"200");
    }

    @Test
    public void logout() throws IOException {
        login();

        SimpleDTO res = userService.logout();

        Assert.assertEquals(res.getCode(),"200");
        Assert.assertEquals(res.getMessage(),"ok");
    }

    @Test
    public void atualizarUser() throws IOException {
        String username = "bruno";
        String jsonBody = lerJson("src/test/resources/data/userPut.json");

        listarPorUsername();

        SimpleDTO res = userService.atualizarUser(username,jsonBody);

        Assert.assertEquals(res.getCode(),"200");
        Assert.assertEquals(res.getMessage(),"1");

        listar("lucas");
    }

    @Test
    public void deletar() throws IOException {
        String username = "bruno";

        login();

        SimpleDTO res = userService.deletar(username);

        Assert.assertEquals(res.getCode(),"200");
        Assert.assertEquals(res.getMessage(),"bruno");
    }

    /*UTIL-------------------------------------------------------------*/
    public void listar(String username) throws IOException {
        UserDTO res = userService.listarPorUsername(username);
    }
}
