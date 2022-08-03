package aceitacao;

import aceitacao.dto.pet.DeleteDTO;
import aceitacao.dto.pet.PetPayloadDTO;
import org.testng.Assert;
import org.testng.annotations.Test;
import aceitacao.service.PetService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PetAceitacao {

    PetService petService = new PetService();

    //Massa de dados para o body
    public String lerJson(String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }

    //Método de testes
    @Test
    public void incluirPet() throws IOException {
        //caminho da massa de dados
        String jsonBody = lerJson("src/test/resources/data/pet.json");

        PetPayloadDTO resulService = petService.adicionarPet(jsonBody);

        Assert.assertEquals(resulService.getId(),"9223372036854034686");
    }

    @Test
    public void atualizarPet() throws IOException {
        //caminho da massa de dados
        String jsonBody = lerJson("src/test/resources/data/petPut.json");

        PetPayloadDTO resulService = petService.atualizarPet(jsonBody);

        Assert.assertEquals(resulService.getName(),"bob");

        //adicionar-editar-excluir
    }

    @Test
    public void listarPet() throws IOException {
        //caminho da massa de dados
        String petId = "9223372036854034686";

        PetPayloadDTO resulService = petService.listarPet(petId);

        Assert.assertEquals(resulService.getId(),"9223372036854034686");
    }

    @Test
    public void deletarPet() throws IOException {
        //caminho da massa de dados
        String petId = "9223372036854034686";

        DeleteDTO resulService = petService.deletarPet(petId);

        Assert.assertEquals(resulService.getCode(),"200");
    }

}
