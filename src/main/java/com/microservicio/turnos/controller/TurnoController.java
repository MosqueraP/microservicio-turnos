package com.microservicio.turnos.controller;

import com.microservicio.turnos.dto.TurnoDTO;
import com.microservicio.turnos.model.Turno;
import com.microservicio.turnos.service.ITurnoService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import java.util.List;

@RestController
@RequestMapping ("/turnos")
public class TurnoController {

    @Autowired
    private ITurnoService turnoServ;
    //1- crear un nuevo turno
    @PostMapping ("/crear")
    public String crearTurno ( @RequestBody TurnoDTO turno) {
        turnoServ.saveTurno(turno.getFecha() ,
                turno.getTratamiento(),
                turno.getDniPaciente());

        return "Turno creado correctamente";
    }


    //2- obtener todos los turnos
    @GetMapping ("/traer")
    public List<Turno> traerTurnos () {
        return turnoServ.getTurnos();
    }

    //3- Eliminar un turno
    @DeleteMapping("/borrar/{id}")
    public String deleteTurno(@PathVariable Long id) {
        turnoServ.deleteTurno(id);

        return "El Turno fue eliminado correctamente";
    }

    //4 - Editar Turno
    @PutMapping("/editar/{id_original}")
    public Turno editTurno (@PathVariable Long id_original,
                            @RequestBody Turno turnoEditar) {

        turnoServ.editTurno(id_original, turnoEditar);

        return turnoServ.findTurno(id_original);
    }

    //5- obtener un turno en particular
    @Operation(
            summary = "Obtener un turno por ID",
            description = "Devuelve la información de un turno específico dado su ID."
    )
    @ApiResponse(responseCode = "200", description = "Turno encontrado exitosamente")
    @ApiResponse(responseCode = "404", description = "No se encontró un turno con el ID especificado")
    @GetMapping("/traer/{id}")
    public Turno traerTurno(
            @Parameter(description = "ID del turno a buscar", example = "1")
            @PathVariable Long id
    ) {
        return turnoServ.findTurno(id);
    }
}
