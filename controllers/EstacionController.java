package org.example.controllers;

import org.example.entities.Estacion;
import org.example.services.EstacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EstacionController {

    @Autowired
    EstacionService estacionService;

    @GetMapping("/estaciones")
    public ResponseEntity<List<Estacion>> listAllEstaciones() {
        return new ResponseEntity<>(estacionService.listAll(), HttpStatus.OK);
    }

    @PostMapping("/estaciones")
    public ResponseEntity<Estacion> addEstacion(@RequestBody Estacion estacion){
        Estacion newEstacion = estacionService.addEstacion(estacion);
        if (newEstacion != null) {
            return new ResponseEntity<>(newEstacion, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/estaciones/{id}")
    public ResponseEntity<Estacion> getEstacionById(@PathVariable("id") Long id) {
        Estacion estacion = estacionService.findById(id);
        if (estacion == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(estacion, HttpStatus.OK);
    }

    @PutMapping("/estaciones/{id}")
    public ResponseEntity<Estacion> updateEstacion(@PathVariable("id") Long id, @RequestBody Estacion estacion) {
        Estacion updatedEstacion = estacionService.updateEstacion(id, estacion);
        if (updatedEstacion != null) {
            return new ResponseEntity<>(updatedEstacion, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping("/estaciones/{id}")
    public ResponseEntity<HttpStatus> deleteEstacion(@PathVariable("id") Long id) {
        estacionService.deleteEstacion(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}