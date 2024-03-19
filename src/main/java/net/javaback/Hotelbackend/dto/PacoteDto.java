package net.javaback.Hotelbackend.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PacoteDto {
    private Long id;
    private String nome;
    private double preco;
    private String descricao;
    // Outros atributos do pacote
}
