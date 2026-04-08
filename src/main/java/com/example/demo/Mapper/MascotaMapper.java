package com.example.demo.Mapper;

import com.example.demo.DTO.MascotaDTO;
import com.example.demo.Model.Mascota;
import org.springframework.stereotype.Component;

@Component
public class MascotaMapper {

    public MascotaDTO toDTO(Mascota mascota) {
        return MascotaDTO.builder()
                .id(mascota.getId())
                .nombre(mascota.getNombre())
                .especie(mascota.getEspecie())
                .raza(mascota.getRaza())
                .fechaNacimiento(mascota.getFechaNacimiento())
                .sexo(mascota.getSexo())
                .peso(mascota.getPeso())
                .nombreDueno(mascota.getNombreDueno())
                .telefonoDueno(mascota.getTelefonoDueno())
                .build();
    }

    public Mascota toEntity(MascotaDTO dto) {
        return Mascota.builder()
                .nombre(dto.getNombre())
                .especie(dto.getEspecie())
                .raza(dto.getRaza())
                .fechaNacimiento(dto.getFechaNacimiento())
                .sexo(dto.getSexo())
                .peso(dto.getPeso())
                .nombreDueno(dto.getNombreDueno())
                .telefonoDueno(dto.getTelefonoDueno())
                .build();
    }
}