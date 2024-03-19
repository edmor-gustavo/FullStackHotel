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

    public static Funcionario  mapFuncionario(FuncionarioDto funcionarioDto) {
        return new Funcionario(
                funcionarioDto.getId(),
                funcionarioDto.getNome(),
                funcionarioDto.getEmail()
        );

      }
    }

