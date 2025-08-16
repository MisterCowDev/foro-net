package com.lagos.foronet.controller;

import com.lagos.foronet.domain.topicos.DatosRegistroTopico;
import com.lagos.foronet.domain.topicos.Estado;
import com.lagos.foronet.domain.topicos.Topico;
import com.lagos.foronet.domain.topicos.TopicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/topicos")
public class ControllerTopico {

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    public ResponseEntity<?> registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico){
        if (topicoRepository.findByTituloAndMensaje(datosRegistroTopico.titulo(), datosRegistroTopico.mensaje()).isPresent()){
            return ResponseEntity.badRequest().body("Ya existe el titulo o mensaje");
        }

        Topico topico = new Topico(
                null,
                datosRegistroTopico.titulo(),
                datosRegistroTopico.mensaje(),
                LocalDateTime.now(),
                Estado.ACTIVO,
                datosRegistroTopico.autor(),
                datosRegistroTopico.curso()
        );

        topicoRepository.save(topico);
        return ResponseEntity.ok("Tópico registrado correctamente");
    }
}
