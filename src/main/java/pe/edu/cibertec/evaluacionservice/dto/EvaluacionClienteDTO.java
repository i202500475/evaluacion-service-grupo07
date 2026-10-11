package pe.edu.cibertec.evaluacionservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EvaluacionClienteDTO {

    private Long clienteId;
    private String nombreCliente;
    private String dni;
    private ScoringRiesgoDTO scoringActual;
}