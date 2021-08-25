package com.prueba.basedatos.controllers;

import com.prueba.basedatos.dtos.CiudadDto;
import com.prueba.basedatos.requests.CiudadRequests;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.prueba.basedatos.responses.CiudadResponse;
import com.prueba.basedatos.services.CiudadService;


@RestController
public class CiudadController {

    @Autowired
    private CiudadService ciudadService;

    @GetMapping("/ciudad")
    public ResponseEntity<CiudadResponse> getCiudad() {
        return ciudadService.getCiudad();
    }

    @GetMapping("/ciudadxnombre/{nombre}")
    public ResponseEntity<CiudadResponse> getCiudadXNombre(@PathVariable(value = "nombre") String nombciud) {
        return ciudadService.getCiudadFinNombre(nombciud);
    }

    @GetMapping("/ciudadxnombrenative/{nombre}")
    public ResponseEntity<CiudadResponse> getCiudadXNombreNative(@PathVariable(value = "nombre") String nombciud) {
        return ciudadService.getCiudadFinNombreNative(nombciud);
    }

    @PostMapping("/ciudad")
    public ResponseEntity<CiudadResponse> addCiudad(@RequestBody CiudadDto ciudadDto) {
        return ciudadService.createEditCiudad(ciudadDto);
    }


    @PostMapping("/ciudadcambestado")
    public ResponseEntity<CiudadResponse> editStatusCiudad(@RequestBody CiudadRequests ciudadRequests) {
        return ciudadService.inactivarCiudadporPais(ciudadRequests);
    }



    @PutMapping("/ciudad")
    public ResponseEntity<CiudadResponse> editCiudad(@RequestBody CiudadDto ciudadDto) {
        return ciudadService.createEditCiudad(ciudadDto);
    }

    @DeleteMapping("/ciudad/{id}")
    public ResponseEntity<CiudadResponse> delCiudad(@PathVariable(value = "id") Integer idCiudad) {
        return ciudadService.removeCiudad(idCiudad);
    }

}
