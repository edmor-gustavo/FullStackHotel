package net.javaback.Hotelbackend.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDto {

    private long id;
    private String nome;
    private String identidade;
    private String contacto;
    private String numeroQuarto;

}
