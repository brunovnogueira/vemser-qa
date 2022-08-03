package aceitacao.dto.pet;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class DeleteDTO {
    String code;
    String type;
    String message;
}
