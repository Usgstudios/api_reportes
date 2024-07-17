package com.usg.apirest.reportes;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarReportes(
        @NotNull
        Long id,
        String título,
        String mensaje,
        String curso
) {
}
