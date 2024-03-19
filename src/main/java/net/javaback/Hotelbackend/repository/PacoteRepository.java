package net.javaback.Hotelbackend.repository;


import net.javaback.Hotelbackend.entity.Pacote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacoteRepository extends JpaRepository<Pacote, Long> {
}

