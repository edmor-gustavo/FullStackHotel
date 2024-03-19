package net.javaback.Hotelbackend.controller;

import lombok.AllArgsConstructor;
import net.javaback.Hotelbackend.dto.QuartoDto;
import net.javaback.Hotelbackend.service.impl.QuartoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/quartos")
public class QuartoController {

    private final QuartoService quartoService;

    @PostMapping
    public ResponseEntity<QuartoDto> createQuarto(@RequestBody QuartoDto quartoDto) {
        QuartoDto savedQuarto = quartoService.createQuarto(quartoDto);
        return new ResponseEntity<>(savedQuarto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuartoDto> getQuartoById(@PathVariable("id") Long quartoId) {
        QuartoDto quartoDto = quartoService.getQuartoById(quartoId);
        return ResponseEntity.ok(quartoDto);
    }

    @GetMapping
    public ResponseEntity<List<QuartoDto>> getAllQuartos() {
        List<QuartoDto> quartos = quartoService.getAllQuartos();
        return ResponseEntity.ok(quartos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<QuartoDto> updateQuarto(@PathVariable("id") Long quartoId, @RequestBody QuartoDto quartoDto) {
        QuartoDto updatedQuarto = quartoService.updateQuarto(quartoId, quartoDto);
        return ResponseEntity.ok(updatedQuarto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteQuarto(@PathVariable("id") Long quartoId) {
        quartoService.deleteQuarto(quartoId);
        return ResponseEntity.ok("Quarto deleted successfully");
    }

    @PostMapping("/{id}/marcar-ocupado")
    public ResponseEntity<String> marcarQuartoComoOcupado(@PathVariable("id") Long quartoId) {
        quartoService.marcarComoOcupado(quartoId);
        return ResponseEntity.ok("Quarto marcado como ocupado");
    }

    @PostMapping("/{id}/marcar-disponivel")
    public ResponseEntity<String> marcarQuartoComoDisponivel(@PathVariable("id") Long quartoId) {
        quartoService.marcarComoDisponivel(quartoId);
        return ResponseEntity.ok("Quarto marcado como disponível");
    }
}
