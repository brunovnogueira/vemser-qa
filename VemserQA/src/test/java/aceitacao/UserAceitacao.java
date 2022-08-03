package aceitacao;

import aceitacao.dto.user.GetDTO;
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

        GetDTO res = userService.adicionarUser(jsonBody);

        Assert.assertEquals(res.getCode(),"200"); //codigo de sucesso
        Assert.assertEquals(res.getMessage(),"1"); //numero do id
    }
}
