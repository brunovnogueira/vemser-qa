package aceitacao.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class QuartoHotelDTO {
    private String idHotel;
    private String numero;
    private String tipoQuarto;
    private String precoDiaria;
    private String idQuarto;
}
