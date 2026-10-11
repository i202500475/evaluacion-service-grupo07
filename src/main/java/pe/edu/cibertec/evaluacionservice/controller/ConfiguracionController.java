package pe.edu.cibertec.evaluacionservice.controller;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Propiedades obtenidas del repositorio de Riesgos (patron evaluacion-*).
 */
@RefreshScope
@RestController
@RequestMapping("/api/v1/evaluaciones")
public class ConfiguracionController {

    @Value("${fintech.scoring-minimo-aprobacion}")
    private Integer scoringMinimoAprobacion;

    @Value("${fintech.factor-endeudamiento-max}")
    private BigDecimal factorEndeudamientoMax;

    @Value("${fintech.mensaje-riesgos}")
    private String mensajeRiesgos;

    @Value("${spring.datasource.url}")
    private String datasourceUrl;

    @GetMapping("/configuracion")
    public ResponseEntity<Map<String, Object>> obtenerConfiguracion() {
        Map<String, Object> configuracion = new LinkedHashMap<>();
        configuracion.put("scoring-minimo-aprobacion", scoringMinimoAprobacion);
        configuracion.put("factor-endeudamiento-max", factorEndeudamientoMax);
        configuracion.put("mensaje-riesgos", mensajeRiesgos);
        configuracion.put("datasource.url", datasourceUrl);
        return ResponseEntity.ok(configuracion);
    }
}
