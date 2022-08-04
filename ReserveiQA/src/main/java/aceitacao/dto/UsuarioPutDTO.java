package aceitacao.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class UsuarioPutDTO {
    private String nome;
    private String telefone;
    private String email;
    private String login;
}
