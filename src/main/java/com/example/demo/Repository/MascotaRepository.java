package com.example.demo.Repository;

import com.example.demo.Model.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Long> {
    List<Mascota> findByEspecieIgnoreCase(String especie);
    List<Mascota> findByNombreDuenoContainingIgnoreCase(String nombreDueno);
}