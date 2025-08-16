package com.lagos.foronet.domain.topicos;

import java.time.LocalDateTime;

public record DatosRespuestaTopico(Long id, String titulo, String mensaje, LocalDateTime fechaCreacion, String autor, String curso) {
}
