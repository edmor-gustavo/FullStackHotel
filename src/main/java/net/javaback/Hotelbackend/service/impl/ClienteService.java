package net.javaback.Hotelbackend.service.impl;

import lombok.AllArgsConstructor;
import net.javaback.Hotelbackend.dto.ClienteDto;
import net.javaback.Hotelbackend.entity.Cliente;
import net.javaback.Hotelbackend.exception.ResourceNotFoundException;
import net.javaback.Hotelbackend.mapper.ClienteMapper;
import net.javaback.Hotelbackend.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClienteService implements net.javaback.Hotelbackend.service.ClienteService  {

    private ClienteRepository clienteRepository;

    @Override
    public ClienteDto createCliente(ClienteDto clienteDto) {
        Cliente cliente = ClienteMapper.mapCliente(clienteDto);
        Cliente savedCliente = clienteRepository.save(cliente);
        return ClienteMapper.mapClienteDto(savedCliente);
    }

    @Override
    public ClienteDto getClienteById(Long clienteId) {
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("O Id do cliente não existe"  + clienteId));
        return ClienteMapper.mapClienteDto(cliente);
    }

    @Override
    public List<ClienteDto> getAllCliente() {
        List<Cliente> cliente = clienteRepository.findAll();
        return cliente.stream().map(ClienteMapper::mapClienteDto)
                .collect(Collectors.toList());
    }
    @Override
    public ClienteDto updateCliente(Long cliente, ClienteDto updateCliente) {
        Cliente cliente1 = clienteRepository.findById (cliente).orElseThrow(
                () -> new ResourceNotFoundException("O Id do cliente não existe: "+ cliente)
        );
        cliente1.setNome (updateCliente.getNome());
        cliente1.setIdentidade(updateCliente.getIdentidade());
        cliente1.setContacto(updateCliente.getContacto());
        cliente1.setNumeroQuarto(updateCliente.getNumeroQuarto());

      Cliente updatedClienteObj = clienteRepository.save (cliente1);
        return ClienteMapper.mapClienteDto (updatedClienteObj);
    }
    @Override
    public void deleteCliente(Long clienteId) {
        Cliente cliente = clienteRepository.findById(clienteId).orElseThrow(
                () -> new ResourceNotFoundException("O Id do cliente não existe")
        );
        clienteRepository.deleteById (clienteId);
    }
}