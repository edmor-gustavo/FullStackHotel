package net.javaback.Hotelbackend.controller;



import lombok.AllArgsConstructor;
import net.javaback.Hotelbackend.dto.FuncionarioDto;
import net.javaback.Hotelbackend.service.impl.FuncionarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/funcionario")
public class FuncionarioController {

    private FuncionarioService funcionarioService;
    @PostMapping
    public ResponseEntity<FuncionarioDto> createFuncionario(@RequestBody FuncionarioDto funcionarioDto){
        FuncionarioDto saveFuncionario = funcionarioService.createFuncionario(funcionarioDto);
        return new ResponseEntity<>(saveFuncionario, HttpStatus.CREATED);
    }
    @GetMapping("id")
    public  ResponseEntity<FuncionarioDto> getFuncionarioById(@PathVariable("id") Long funcionarioId){
        FuncionarioDto funcionarioDto =  funcionarioService.getFuncionarioById(funcionarioId);
        return  ResponseEntity.ok(funcionarioDto);
    }
    @GetMapping
    public ResponseEntity<List<FuncionarioDto>> getAllFuncionario(){
        List<FuncionarioDto> funcionario = funcionarioService.getAllFuncionario();
        return ResponseEntity.ok(funcionario);
    }
    @PutMapping({"id"})
    public  ResponseEntity<FuncionarioDto> updateFuncionario(@PathVariable("id") Long funcionarioId,
                                                             @RequestBody FuncionarioDto updateFuncionario){
        FuncionarioDto funcionarioDto = funcionarioService.updateFuncionario(funcionarioId, updateFuncionario);
        return  ResponseEntity.ok(funcionarioDto);

    }
    @DeleteMapping("id")
    public ResponseEntity<String> deleteFuncionario(@PathVariable("id") Long funcionarioId){
        funcionarioService.deleteFuncionario(funcionarioId);
        return ResponseEntity.ok("Funcionario excluido com sucesso!");
    }
}
