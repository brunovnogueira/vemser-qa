package aceitacao.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class PessoaDTOTESTE {
    private String nome;
    private String dataNascimento;
    private String cpf;
    private String email;
    private String idPessoa;
}
