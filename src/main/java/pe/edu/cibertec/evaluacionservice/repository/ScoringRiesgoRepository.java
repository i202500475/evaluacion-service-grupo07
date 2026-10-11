package pe.edu.cibertec.evaluacionservice.repository;

import pe.edu.cibertec.evaluacionservice.dto.ScoringRiesgoDTO;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.HashMap;

@Repository
public class ScoringRiesgoRepository {

    private final Map<Long, ScoringRiesgoDTO> scorings = new HashMap<>();

    public ScoringRiesgoRepository() {
        scorings.put(2001L, new ScoringRiesgoDTO(
                2001L, 850, "BAJO", 15000.0,
                "Cliente con buen historial crediticio"
        ));

        scorings.put(2002L, new ScoringRiesgoDTO(
                2002L, 720, "MEDIO", 8000.0,
                "Cliente con riesgo moderado"
        ));

        scorings.put(2003L, new ScoringRiesgoDTO(
                2003L, 480, "ALTO", 2500.0,
                "Cliente con riesgo elevado"
        ));

        scorings.put(2004L, new ScoringRiesgoDTO(
                2004L, 300, "CRITICO", 500.0,
                "Cliente con alto riesgo de incumplimiento"
        ));
    }

    public ScoringRiesgoDTO buscarPorClienteId(Long clienteId) {
        return scorings.get(clienteId);
    }
}