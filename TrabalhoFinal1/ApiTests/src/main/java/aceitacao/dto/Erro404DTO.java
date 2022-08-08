package aceitacao.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class Erro404DTO {
    private String timestamp;
    private String status;
    private String message;
}
