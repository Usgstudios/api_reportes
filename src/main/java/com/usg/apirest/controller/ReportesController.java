package com.usg.apirest.controller;

import com.usg.apirest.SetDatosReportes;
import com.usg.apirest.reportes.DatosActualizarReportes;
import com.usg.apirest.reportes.DatosReportes;
import com.usg.apirest.reportes.IRepositoryReportes;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reportes")
public class ReportesController {

    @Autowired
    private IRepositoryReportes iRepositoryReportes;

    @PostMapping
    public void registrarReportes(@RequestBody @Valid DatosReportes datosReportes){
        iRepositoryReportes.save(new SetDatosReportes(datosReportes));
    }

    @GetMapping
    public List<SetDatosReportes> listareportes(){
        return iRepositoryReportes.findAll();
    }

    @PutMapping
    @Transactional
    public void actualizarReportes(@RequestBody @Valid DatosActualizarReportes datosActualizarReportes){
        SetDatosReportes setDatosReportes = iRepositoryReportes.getReferenceById(datosActualizarReportes.id());
        setDatosReportes.actualizarDatos(datosActualizarReportes);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void eliminarReporte(@PathVariable Long id){
        SetDatosReportes setDatosReportes = iRepositoryReportes.getReferenceById(id);
        iRepositoryReportes.delete(setDatosReportes);
    }
}
