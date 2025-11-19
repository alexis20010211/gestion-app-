package com.techsolutions.gestion_app.controller;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techsolutions.gestion_app.model.Soporte;
import com.techsolutions.gestion_app.service.SoporteService;
@RestController
@RequestMapping("/api/soportes")
public class SoporteController {

    private final SoporteService soporteService;

    public SoporteController(SoporteService soporteService) {
        this.soporteService = soporteService;
    }

    @PostMapping
    public Soporte registar(@RequestBody Soporte soporte) {
        return soporteService.registar(soporte);
    }

    @GetMapping
    public List<Soporte> listar() {
        return soporteService.listar();
    }

    @PutMapping("/{id}")
    public Soporte actualizar(@PathVariable long id, @RequestBody Soporte soporte) {
        return soporteService.actualizar(id, soporte);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        soporteService.eliminar(id);
    }
}