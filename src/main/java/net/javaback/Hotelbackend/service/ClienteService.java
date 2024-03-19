package net.javaback.Hotelbackend.service;

import lombok.AllArgsConstructor;
import net.javaback.Hotelbackend.dto.ClienteDto;
import net.javaback.Hotelbackend.dto.FuncionarioDto;
import net.javaback.Hotelbackend.entity.Funcionario;
import net.javaback.Hotelbackend.exception.ResourceNotFoundException;
import net.javaback.Hotelbackend.mapper.FuncionarioMapper;
import net.javaback.Hotelbackend.repository.FuncionarioRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

public interface ClienteService {
    ClienteDto createCliente(ClienteDto clienteDto);

    ClienteDto getClienteById(Long clienteId);

    List<ClienteDto> getAllCliente();

    ClienteDto updateCliente(Long cliente, ClienteDto updateCliente);


    void deleteCliente(Long clienteId);

    @Service
    @AllArgsConstructor
    class FuncionarioService implements net.javaback.Hotelbackend.service.FuncionarioService {

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
                            new ResourceNotFoundException("O ID fornecido do funcionario não existe: "+ funcionarioId));
            return  FuncionarioMapper.mapFuncionarioDto(funcionario);
        }
        @Override
        public List<FuncionarioDto> getAllFuncionario() {
            List<Funcionario> funcionario =  funcionarioRepository.findAll();
            return funcionario.stream().map(FuncionarioMapper::mapFuncionarioDto)
                    .collect(Collectors.toList());
        }

        @Override
        public FuncionarioDto updateFuncionario(Long funcionario, @NotNull FuncionarioDto updateFuncionario) {
            Funcionario funcionario1 = funcionarioRepository.findById(funcionario).orElseThrow(
                    () -> new ResourceNotFoundException("O ID fornecido do funcuinario não existe: "+ funcionario)
            );
            funcionario1.setNome(updateFuncionario.getNome());
            funcionario1.setEmail(updateFuncionario.getEmail());

            Funcionario updatedFuncionarioObj = funcionarioRepository.save(funcionario1);
            return FuncionarioMapper.mapFuncionarioDto(updatedFuncionarioObj);
        }

        @Override
        public void deleteFuncionario(Long funcionarioId) {
            Funcionario funcionario = funcionarioRepository.findById(funcionarioId).orElseThrow(
                    () -> new ResourceNotFoundException("O ID do funcionario fornecido não existe")
            );
            funcionarioRepository.deleteById(funcionarioId);
        }

    }
}
