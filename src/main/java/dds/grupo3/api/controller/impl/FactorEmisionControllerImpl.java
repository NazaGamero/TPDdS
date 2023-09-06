package dds.grupo3.api.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import dds.grupo3.api.controller.FactorEmisionController;
import dds.grupo3.api.dto.request.FactorEmisionDTO;
import dds.grupo3.api.service.FactorEmisionService;

@RestController
public class FactorEmisionControllerImpl implements FactorEmisionController {
    @Autowired
    FactorEmisionService factorEmisionService;

    @Override
    public ResponseEntity<?> editarFactoresDeEmision(Long id, FactorEmisionDTO fe) {
        factorEmisionService.editarFE(id,fe.getValor());
        return new ResponseEntity<>("Se edito correctamente", HttpStatus.OK);
    }
}