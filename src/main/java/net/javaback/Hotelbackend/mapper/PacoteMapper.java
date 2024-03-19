package net.javaback.Hotelbackend.mapper;
import net.javaback.Hotelbackend.dto.PacoteDto;
import net.javaback.Hotelbackend.entity.Pacote;
public class PacoteMapper {
    public static PacoteDto mapPacoteDto(Pacote pacote) {
        return new PacoteDto(
                pacote.getId(),
                pacote.getNome(),
                pacote.getPreco(),
                pacote.getDescricao()
                // Mapear outros atributos conforme necessário
        );
    }

    public static Pacote mapPacote(PacoteDto pacoteDto) {
        return new Pacote(
                pacoteDto.getId(),
                pacoteDto.getNome(),
                pacoteDto.getPreco(),
                pacoteDto.getDescricao()
                // Mapear outros atributos conforme necessário
        );
    }
}
