package net.javaback.Hotelbackend.service;

import net.javaback.Hotelbackend.dto.PacoteDto;

import java.util.List;

public interface PacoteService {
    PacoteDto createPacote(PacoteDto pacoteDto);

    PacoteDto getPacoteById(Long pacoteId);

    List<PacoteDto> getAllPacotes();

    PacoteDto updatePacote(Long pacoteId, PacoteDto pacoteDto);

    void deletePacote(Long pacoteId);
}
