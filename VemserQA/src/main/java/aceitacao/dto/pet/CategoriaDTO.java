package aceitacao.dto.pet;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class CategoriaDTO {
    private String id;
    private String name;
}
