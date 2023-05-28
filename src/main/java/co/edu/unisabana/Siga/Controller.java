package co.edu.unisabana.Siga;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {
    List<FacultadDTO> facultades = new ArrayList<>();
    public Controller() {

        inicializarFacultades();
    }

    private void inicializarFacultades() {
        FacultadDTO eica = new FacultadDTO(FacultadEnum.EICA);
        FacultadDTO ingenieria = new FacultadDTO(FacultadEnum.INGENIERIA);
        FacultadDTO derecho = new FacultadDTO(FacultadEnum.DERECHO);
        FacultadDTO comunicacion = new FacultadDTO(FacultadEnum.COMUNICACION);
        FacultadDTO salud = new FacultadDTO(FacultadEnum.SALUD);
        FacultadDTO educacion = new FacultadDTO(FacultadEnum.EDUCACION);

        facultades.add(eica);
        facultades.add(ingenieria);
        facultades.add(derecho);
        facultades.add(comunicacion);
        facultades.add(salud);
        facultades.add(educacion);
    }
    //Estudiantes
    @GetMapping(path = "/estudiante/crear/") //
    public FacultadDTO crearEstudiante(@RequestParam String estudiante,@RequestBody FacultadDTO facultadAsignada) {
        for (FacultadDTO facultad : this.facultades) {
            if (facultad.equals(facultadAsignada)) {
                List<String> estudianteList = facultad.getEstudiantes();
                estudianteList.add(estudiante);
                facultad.setEstudiantes(estudianteList);
                return facultad;
            }

        }
        return new FacultadDTO();
    }

    //Profesores
    @GetMapping(path = "/profesor/crear/") //
    public FacultadDTO crearProfesor(@RequestParam String profesor,@RequestBody FacultadDTO facultadAsignada) {
        for (FacultadDTO facultad : this.facultades) {
            if (facultad.equals(facultadAsignada)) {
                List<String> profesorList = facultad.getProfesores();
                profesorList.add(profesor);
                facultad.setProfesores(profesorList);
                return facultad;
            }

        }
        return new FacultadDTO();
    }

    //Asignaturas
    @GetMapping(path = "/asignatura/crear/") //
    public FacultadDTO crearAsignatura(@RequestParam String asignatura,@RequestBody FacultadDTO facultadAsignada) {
        for (FacultadDTO facultad : this.facultades) {
            if (facultad.equals(facultadAsignada)) {
                List<String> asignaturaList = facultad.getMaterias();
                asignaturaList.add(asignatura);
                facultad.setMaterias(asignaturaList);
                return facultad;
            }

        }
        return new FacultadDTO();
    }

    //Cursos

}
