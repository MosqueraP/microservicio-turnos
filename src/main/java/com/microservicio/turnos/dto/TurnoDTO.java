package com.microservicio.turnos.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class TurnoDTO {
    private LocalDate fecha;
    private String tratamiento;
    private String dniPaciente;
}
