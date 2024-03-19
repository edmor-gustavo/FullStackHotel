package net.javaback.Hotelbackend.service.impl;


import lombok.AllArgsConstructor;
import net.javaback.Hotelbackend.dto.FuncionarioDto;
import net.javaback.Hotelbackend.entity.Funcionario;
import net.javaback.Hotelbackend.exception.ResourceNotFoundException;
import net.javaback.Hotelbackend.mapper.FuncionarioMapper;
import net.javaback.Hotelbackend.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
@AllArgsConstructor
public class FuncionarioService  implements net.javaback.Hotelbackend.service.FuncionarioService {

    private FuncionarioRepository funcionarioRepository;


    @Override
    public FuncionarioDto createFuncionario(FuncionarioDto funcionarioDto) {
        Funcionario funcionario = FuncionarioMapper.mapFuncionario(funcionarioDto);
        Funcionario savedFuncionario = funcionarioRepository.save(funcionario);
        return FuncionarioMapper.mapFuncionarioDto(savedFuncionario);
    }

    @Override
    public FuncionarioDto getFuncionarioById(Long funcionarioId) {
        Funcionario funcionario = funcionarioRepository.findById(funcionarioId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("O Id do funcionario não existe" + funcionarioId));
        return FuncionarioMapper.mapFuncionarioDto(funcionario);
    }

    @Override
    public List<FuncionarioDto> getAllFuncionario() {
        List<Funcionario> funcionarios = funcionarioRepository.findAll();
        return funcionarios.stream().map(FuncionarioMapper::mapFuncionarioDto)
                .collect(Collectors.toList());
    }

    @Override
    public FuncionarioDto updateFuncionario(Long funcionario, FuncionarioDto updateFuncionario) {
        Funcionario funcionario1 = funcionarioRepository.findById(funcionario).orElseThrow(
                () -> new ResourceNotFoundException("O Id do cliente não existe: " + funcionario)
        );
        funcionario1.setNome(updateFuncionario.getNome());
        funcionario1.setEmail(updateFuncionario.getEmail());

        Funcionario updatedFuncionarioObj = funcionarioRepository.save(funcionario1);
        return FuncionarioMapper.mapFuncionarioDto(updatedFuncionarioObj);
    }

    @Override
    public void deleteFuncionario(Long funcionarioId) {
        Funcionario funcionario = funcionarioRepository.findById (funcionarioId).orElseThrow(
                () -> new ResourceNotFoundException("O Id do cliente não existe")
        );
        funcionarioRepository.deleteById (funcionarioId);
    }

}