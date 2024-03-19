package net.javaback.Hotelbackend.repository;

import net.javaback.Hotelbackend.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
