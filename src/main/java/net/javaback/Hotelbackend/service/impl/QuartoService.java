package net.javaback.Hotelbackend.service.impl;

import lombok.AllArgsConstructor;
import net.javaback.Hotelbackend.dto.QuartoDto;
import net.javaback.Hotelbackend.entity.Quarto;
import net.javaback.Hotelbackend.exception.ResourceNotFoundException;
import net.javaback.Hotelbackend.mapper.QuartoMapper;
import net.javaback.Hotelbackend.repository.QuartoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class QuartoService implements net.javaback.Hotelbackend.service.QuartoService {

    private final QuartoRepository quartoRepository;

    @Override
    public QuartoDto createQuarto(QuartoDto quartoDto) {
        Quarto quarto = QuartoMapper.mapQuarto(quartoDto);
        // Definir o quarto como disponível ao criar
        quarto.setDisponivel(true);
        Quarto savedQuarto = quartoRepository.save(quarto);
        return QuartoMapper.mapQuartoDto(savedQuarto);
    }

    @Override
    public QuartoDto getQuartoById(Long quartoId) {
        Quarto quarto = quartoRepository.findById(quartoId)
                .orElseThrow(() -> new ResourceNotFoundException("Quarto não encontrado com o id: " + quartoId));
        return QuartoMapper.mapQuartoDto(quarto);
    }

    @Override
    public List<QuartoDto> getAllQuartos() {
        List<Quarto> quartos = quartoRepository.findAll();
        return quartos.stream().map(QuartoMapper::mapQuartoDto).collect(Collectors.toList());
    }

    @Override
    public QuartoDto updateQuarto(Long quartoId, QuartoDto quartoDto) {
        Quarto quarto = quartoRepository.findById(quartoId)
                .orElseThrow(() -> new ResourceNotFoundException("Quarto não encontrado com o id: " + quartoId));

        // Atualizar informações do quarto
        quarto.setNumero(quartoDto.getNumero());
        quarto.setTipo(quartoDto.getTipo());
        // Atualize outros atributos conforme necessário

        Quarto updatedQuarto = quartoRepository.save(quarto);
        return QuartoMapper.mapQuartoDto(updatedQuarto);
    }

    @Override
    public void deleteQuarto(Long quartoId) {
        Quarto quarto = quartoRepository.findById(quartoId)
                .orElseThrow(() -> new ResourceNotFoundException("Quarto não encontrado com o id: " + quartoId));
        quartoRepository.delete(quarto);
    }

    @Override
    public void marcarComoOcupado(Long quartoId) {
        Quarto quarto = quartoRepository.findById(quartoId)
                .orElseThrow(() -> new ResourceNotFoundException("Quarto não encontrado com o id: " + quartoId));
        quarto.setDisponivel(false);
        quartoRepository.save(quarto);
    }

    @Override
    public void marcarComoDisponivel(Long quartoId) {
        Quarto quarto = quartoRepository.findById(quartoId)
                .orElseThrow(() -> new ResourceNotFoundException("Quarto não encontrado com o id: " + quartoId));
        quarto.setDisponivel(true);
        quartoRepository.save(quarto);
    }
}
