package aceitacao.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class UsuarioDTO {
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private String login;
}
