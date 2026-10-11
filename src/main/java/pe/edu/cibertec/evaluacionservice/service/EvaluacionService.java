
package pe.edu.cibertec.evaluacionservice.service;

import pe.edu.cibertec.evaluacionservice.dto.EvaluacionClienteDTO;
import pe.edu.cibertec.evaluacionservice.dto.ScoringRiesgoDTO;
import pe.edu.cibertec.evaluacionservice.model.Cliente;
import pe.edu.cibertec.evaluacionservice.repository.ClienteRepository;
import pe.edu.cibertec.evaluacionservice.repository.ScoringRiesgoRepository;
import org.springframework.stereotype.Service;

@Service
public class EvaluacionService {

    private final ClienteRepository clienteRepository;
    private final ScoringRiesgoRepository scoringRiesgoRepository;

    public EvaluacionService(
            ClienteRepository clienteRepository,
            ScoringRiesgoRepository scoringRiesgoRepository) {
        this.clienteRepository = clienteRepository;
        this.scoringRiesgoRepository = scoringRiesgoRepository;
    }

    public ScoringRiesgoDTO obtenerScoring(Long clienteId) {
        return scoringRiesgoRepository.buscarPorClienteId(clienteId);
    }

    public EvaluacionClienteDTO obtenerEvaluacionCliente(Long clienteId) {
        Cliente cliente = clienteRepository.buscarPorId(clienteId);
        ScoringRiesgoDTO scoring = scoringRiesgoRepository.buscarPorClienteId(clienteId);

        if (cliente == null || scoring == null) {
            return null;
        }

        return new EvaluacionClienteDTO(
                cliente.getClienteId(),
                cliente.getNombreCliente(),
                cliente.getDni(),
                scoring
        );
    }
}
