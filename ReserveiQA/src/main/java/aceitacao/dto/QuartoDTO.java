package aceitacao.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties
public class QuartoDTO {
    private String numero;
    private String tipoQuarto;
    private String precoDiaria;
    private HotelQuartoDTO hotel;
}
