package net.javaback.Hotelbackend.mapper;

import net.javaback.Hotelbackend.dto.ClienteDto;

import net.javaback.Hotelbackend.entity.Cliente;


public class ClienteMapper {

    public static ClienteDto mapClienteDto(Cliente cliente) {
        return new ClienteDto(
                cliente.getId(),
                cliente.getNome(),
                cliente.getIdentidade(),
                cliente.getContacto(),
                cliente.getNumeroQuarto()

        );
    }

    public static Cliente mapCliente (ClienteDto clienteDto) {
        return new Cliente(
                clienteDto.getId(),
                clienteDto.getNome(),
                clienteDto.getIdentidade(),
                clienteDto.getContacto(),
                clienteDto.getNumeroQuarto()
        );
    }
}

