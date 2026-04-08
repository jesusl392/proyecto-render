package com.example.demo.Service;

import com.example.demo.DTO.MascotaDTO;
import com.example.demo.Mapper.MascotaMapper;
import com.example.demo.Model.Mascota;
import com.example.demo.Repository.MascotaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MascotaService {

    private final MascotaRepository mascotaRepository;
    private final MascotaMapper mascotaMapper;

    public List<MascotaDTO> obtenerTodas() {
        return mascotaRepository.findAll()
                .stream().map(mascotaMapper::toDTO).collect(Collectors.toList());
    }

    public MascotaDTO obtenerPorId(Long id) {
        Mascota mascota = mascotaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mascota no encontrada con id: " + id));
        return mascotaMapper.toDTO(mascota);
    }

    public MascotaDTO crear(MascotaDTO dto) {
        Mascota mascota = mascotaMapper.toEntity(dto);
        return mascotaMapper.toDTO(mascotaRepository.save(mascota));
    }

    public MascotaDTO actualizar(Long id, MascotaDTO dto) {
        Mascota mascota = mascotaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mascota no encontrada con id: " + id));
        mascota.setNombre(dto.getNombre());
        mascota.setEspecie(dto.getEspecie());
        mascota.setRaza(dto.getRaza());
        mascota.setFechaNacimiento(dto.getFechaNacimiento());
        mascota.setSexo(dto.getSexo());
        mascota.setPeso(dto.getPeso());
        mascota.setNombreDueno(dto.getNombreDueno());
        mascota.setTelefonoDueno(dto.getTelefonoDueno());
        return mascotaMapper.toDTO(mascotaRepository.save(mascota));
    }

    public void eliminar(Long id) {
        mascotaRepository.deleteById(id);
    }
}