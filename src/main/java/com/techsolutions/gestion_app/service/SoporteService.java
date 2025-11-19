package com.techsolutions.gestion_app.service;
import java.util.List;

import com.techsolutions.gestion_app.model.Soporte;

public interface SoporteService {
    Soporte registar(Soporte soporte);
    List<Soporte> listar();
    Soporte actualizar(long id , Soporte soporte);
    void eliminar(Long id);
}