package net.javaback.Hotelbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuartoDto {
    private Long id;
    private String numero;
    private String tipo;
    private boolean disponivel;
}
