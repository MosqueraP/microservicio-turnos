package com.microservicio.turnos.service;

import com.microservicio.turnos.model.Paciente;
import com.microservicio.turnos.model.Turno;
import com.microservicio.turnos.repository.ITurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;

@Service
public class TurnoService implements ITurnoService{

    @Autowired
    private ITurnoRepository turnoRepo;

    @Autowired
    private RestTemplate apiConsumir;



    // traer todos los turnos
    @Override
    public List<Turno> getTurnos() {
        return turnoRepo.findAll();
    }

    // guardar un turno
    @Override
    public void saveTurno(LocalDate fecha, String tratamiento, String dniPaciente) {
        // /pacientes/traerdni/{dni}
        Paciente pac = apiConsumir.getForObject ("http://localhost:9001/pacientes/traerdni/"+dniPaciente,
                Paciente.class);
        String nombreCompletoPaciente = pac.getNombre() + " " + pac.getApellido();

        Turno turno = new Turno();
        turno .setFecha(fecha);
        turno.setTratamiento(tratamiento);
        turno.setNombreCompletoPaciente(nombreCompletoPaciente);

        turnoRepo.save(turno);
    }

    // eliminar un turno por su ID
    @Override
    public void deleteTurno(Long id) {
        turnoRepo.deleteById(id);
    }

    // buscar un turno por su ID, retornar nullo si no existe
    @Override
    public Turno findTurno(Long id) {
        return turnoRepo.findById(id).orElse(null);
    }

    // editar un turno
    @Override
    public void editTurno(Long id, Turno turno) {

        // buscamos primero el turno original
        Turno turn = this.findTurno(id);

        // sobreescribimos mediante turn
        turn.setFecha(turno.getFecha());
        turn.setTratamiento(turno.getTratamiento());
        turn.setNombreCompletoPaciente(turno.getNombreCompletoPaciente());

        turnoRepo.save(turn); // guardamos el turno modificado
    }
}
