
package pe.edu.cibertec.evaluacionservice.controller;

import pe.edu.cibertec.evaluacionservice.dto.EvaluacionClienteDTO;
import pe.edu.cibertec.evaluacionservice.dto.ScoringRiesgoDTO;
import pe.edu.cibertec.evaluacionservice.service.EvaluacionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/evaluaciones")
public class EvaluacionController {

    private final EvaluacionService evaluacionService;

    public EvaluacionController(EvaluacionService evaluacionService) {
        this.evaluacionService = evaluacionService;
    }

    @GetMapping("/scoring/{clienteId}")
    public ResponseEntity<ScoringRiesgoDTO> obtenerScoring(
            @PathVariable Long clienteId) {

        ScoringRiesgoDTO scoring = evaluacionService.obtenerScoring(clienteId);

        if (scoring == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(scoring);
    }

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<EvaluacionClienteDTO> obtenerEvaluacionCliente(
            @PathVariable Long clienteId) {

        EvaluacionClienteDTO evaluacion =
                evaluacionService.obtenerEvaluacionCliente(clienteId);

        if (evaluacion == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(evaluacion);
    }
}
