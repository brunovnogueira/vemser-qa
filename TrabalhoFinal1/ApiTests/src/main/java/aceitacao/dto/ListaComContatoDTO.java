package aceitacao.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties
public class ListaComContatoDTO extends PessoaDTO {
    List<ContatoDTO> contatos;
}
