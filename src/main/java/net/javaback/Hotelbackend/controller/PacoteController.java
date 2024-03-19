package net.javaback.Hotelbackend.controller;

import lombok.AllArgsConstructor;
import net.javaback.Hotelbackend.dto.PacoteDto;
import net.javaback.Hotelbackend.service.impl.PacoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/pacotes")
public class PacoteController {

    private final PacoteService pacoteService;

    @PostMapping
    public ResponseEntity<PacoteDto> createPacote(@RequestBody PacoteDto pacoteDto) {
        PacoteDto savedPacote = pacoteService.createPacote(pacoteDto);
        return new ResponseEntity<>(savedPacote, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacoteDto> getPacoteById(@PathVariable("id") Long pacoteId) {
        PacoteDto pacoteDto = pacoteService.getPacoteById(pacoteId);
        return ResponseEntity.ok(pacoteDto);
    }

    @GetMapping
    public ResponseEntity<List<PacoteDto>> getAllPacotes() {
        List<PacoteDto> pacotes = pacoteService.getAllPacotes();
        return ResponseEntity.ok(pacotes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PacoteDto> updatePacote(@PathVariable("id") Long pacoteId, @RequestBody PacoteDto pacoteDto) {
        PacoteDto updatedPacote = pacoteService.updatePacote(pacoteId, pacoteDto);
        return ResponseEntity.ok(updatedPacote);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePacote(@PathVariable("id") Long pacoteId) {
        pacoteService.deletePacote(pacoteId);
        return ResponseEntity.ok("Pacote deleted successfully");
    }
}
