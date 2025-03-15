package com.microservicio.turnos.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Turno {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id_turno;
    //@Temporal(TemporalType.DATE)
    private LocalDate fecha;
    private String tratamiento;
    private String nombreCompletoPaciente;


}

