package dds.grupo3.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import dds.grupo3.api.dto.request.FactorEmisionDTO;

@RequestMapping("/factoresDeEmision")
public interface FactorEmisionController {
    @PutMapping("/{id}")
    public ResponseEntity<?> editarFactoresDeEmision(@PathVariable("id")Long id, @RequestBody FactorEmisionDTO fe);
}