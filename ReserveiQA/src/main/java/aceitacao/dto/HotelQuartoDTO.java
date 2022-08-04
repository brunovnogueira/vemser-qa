package aceitacao.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class HotelQuartoDTO {
    private String nome;
    private String cidade;
    private String telefone;
    private String classificacao;
    private String idHotel;
}
