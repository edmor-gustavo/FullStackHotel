package net.javaback.Hotelbackend.repository;


import net.javaback.Hotelbackend.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
