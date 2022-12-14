package aceitacao.dto.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class SimpleDTO {
    private String code;
    private String type;
    private String message;
}
