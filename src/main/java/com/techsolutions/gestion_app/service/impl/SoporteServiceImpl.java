package com.techsolutions.gestion_app.service.impl;
import java.util.List;

import org.springframework.stereotype.Service;

import com.techsolutions.gestion_app.model.Soporte;
import com.techsolutions.gestion_app.repository.SoporteRepository;
import com.techsolutions.gestion_app.service.SoporteService;
@Service
public class SoporteServiceImpl implements SoporteService {

    private final SoporteRepository soporteRepository;

    public SoporteServiceImpl(SoporteRepository soporteRepository) {
        this.soporteRepository = soporteRepository;
    }

    @Override
    public Soporte registar(Soporte soporte) {
        soporte.setEstado("Registrado");
        return soporteRepository.save(soporte);
    }

    @Override
    public List<Soporte> listar() {
        return soporteRepository.findAll();
    }

    @Override
    public Soporte actualizar(long id, Soporte soporte) {
        Soporte existente = soporteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Soporte no encontrado con id: " + id));
                existente.setDescripcion(soporte.getDescripcion());
                existente.setEstado(soporte.getEstado());
        return soporteRepository.save(existente);
    }

    @Override
    public void eliminar(Long id) {
        soporteRepository.deleteById(id);
    }
}