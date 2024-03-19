package net.javaback.Hotelbackend.mapper;

import net.javaback.Hotelbackend.dto.QuartoDto;

import net.javaback.Hotelbackend.entity.Quarto;


public class QuartoMapper {

    public static QuartoDto mapQuartoDto(Quarto quarto) {
        return new QuartoDto(
                quarto.getId(),
                quarto.getNumero(),
                quarto.getTipo(),
                quarto.isDisponivel()
                // Mapear outros atributos conforme necessário
        );
    }

    public static Quarto mapQuarto(QuartoDto quartoDto) {
        return new Quarto(
                quartoDto.getId(),
                quartoDto.getNumero(),
                quartoDto.getTipo(),
                quartoDto.isDisponivel()
                // Mapear outros atributos conforme necessário
        );
    }
}
