package net.javaback.Hotelbackend.service;

import net.javaback.Hotelbackend.dto.FuncionarioDto;

import java.util.List;

public interface FuncionarioService {
    FuncionarioDto createFuncionario(FuncionarioDto funcionarioDto);

    FuncionarioDto getFuncionarioById(Long funcionarioId);

    List<FuncionarioDto> getAllFuncionario();

    FuncionarioDto updateFuncionario(Long funcionario, FuncionarioDto updateFuncionario);

    void deleteFuncionario(Long funcionarioId);
}
