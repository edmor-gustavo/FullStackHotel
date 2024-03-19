package net.javaback.Hotelbackend.repository;

import net.javaback.Hotelbackend.entity.Quarto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuartoRepository extends JpaRepository<Quarto, Long> {
}
