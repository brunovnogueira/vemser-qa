package aceitacao.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;
@Data
@JsonIgnoreProperties
public class Erro400DTO {

    private String timestamp;
    private String status;
    private List<String> errors;

}
