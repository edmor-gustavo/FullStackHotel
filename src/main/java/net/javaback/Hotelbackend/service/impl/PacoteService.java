package net.javaback.Hotelbackend.service.impl;

import lombok.AllArgsConstructor;
import net.javaback.Hotelbackend.dto.PacoteDto;
import net.javaback.Hotelbackend.entity.Pacote;
import net.javaback.Hotelbackend.exception.ResourceNotFoundException;
import net.javaback.Hotelbackend.mapper.PacoteMapper;
import net.javaback.Hotelbackend.repository.PacoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PacoteService implements net.javaback.Hotelbackend.service.PacoteService {

    private final PacoteRepository pacoteRepository;
    @Override
    public PacoteDto createPacote(PacoteDto pacoteDto) {
        Pacote pacote = PacoteMapper.mapPacote(pacoteDto);
        Pacote savedPacote = pacoteRepository.save(pacote);
        return PacoteMapper.mapPacoteDto(savedPacote);
    }
    @Override
    public PacoteDto getPacoteById(Long pacoteId) {
        Pacote pacote = pacoteRepository.findById(pacoteId)
                .orElseThrow(() -> new ResourceNotFoundException("Pacote not found with id: " + pacoteId));
        return PacoteMapper.mapPacoteDto(pacote);
    }
    @Override
    public List<PacoteDto> getAllPacotes() {
        List<Pacote> pacotes = pacoteRepository.findAll();
        return pacotes.stream().map(PacoteMapper::mapPacoteDto).collect(Collectors.toList());
    }
    @Override
    public PacoteDto updatePacote(Long pacoteId, PacoteDto pacoteDto) {
        Pacote pacote = pacoteRepository.findById(pacoteId)
                .orElseThrow(() -> new ResourceNotFoundException("Pacote not found with id: " + pacoteId));

        pacote.setNome(pacoteDto.getNome());
        pacote.setPreco(pacoteDto.getPreco());
        // Atualize outros atributos conforme necessário

        Pacote updatedPacote = pacoteRepository.save(pacote);
        return PacoteMapper.mapPacoteDto(updatedPacote);
    }
    @Override
    public void deletePacote(Long pacoteId) {
        Pacote pacote = pacoteRepository.findById(pacoteId)
                .orElseThrow(() -> new ResourceNotFoundException("Pacote not found with id: " + pacoteId));
        pacoteRepository.delete(pacote);
    }
}
