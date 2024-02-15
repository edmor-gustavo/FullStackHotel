package net.javaback.Hotelbackend.mapper;


import net.javaback.Hotelbackend.dto.FuncionarioDto;
import net.javaback.Hotelbackend.entity.Funcionario;

public class FuncionarioMapper {
    public static FuncionarioDto mapFuncionarioDto(Funcionario funcionario){
        return new FuncionarioDto(
                funcionario.getId(),
                funcionario.getNome(),
                funcionario.getEmail()
        );

    }
    public static Funcionario mapToFuncionario(FuncionarioDto funcionario){
        return  new Funcionario(
                funcionario.getId(),
                funcionario.getNome(),
                funcionario.getEmail()
        );

    }
}
