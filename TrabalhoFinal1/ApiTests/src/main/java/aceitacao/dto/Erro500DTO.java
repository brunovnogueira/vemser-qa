package aceitacao.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class Erro500DTO {
    private String timestamp;
    private String status;
    private String error;
    private String path;
}
