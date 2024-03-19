package net.javaback.Hotelbackend.repository;

import net.javaback.Hotelbackend.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    // Aqui você pode adicionar métodos personalizados de consulta, se necessário
}
