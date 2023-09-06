package dds.grupo3.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import dds.grupo3.api.dto.request.AgenteSectorialDTO;

@RequestMapping("/agentesSectoriales")
public interface AgenteSectorialController {
    @GetMapping("")
    public ResponseEntity<?> obtenerListaAgentesSectoriales();

    @PostMapping("")
    public ResponseEntity<?> crearAgenteSectorial(@RequestBody AgenteSectorialDTO ags);

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarAgenteSectorial(@PathVariable("id")Long id);

    @PutMapping("/{id}")
    public ResponseEntity<?> editarAgenteSectorial(@PathVariable("id")Long id, @RequestBody AgenteSectorialDTO ags);
}
