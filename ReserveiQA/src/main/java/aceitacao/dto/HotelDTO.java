package aceitacao.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties
public class HotelDTO {
    private String nome;
    private String cidade;
    private String telefone;
    private String classificacao;
    private String idHotel;
    private List<QuartoHotelDTO> quartos;
}
