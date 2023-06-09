package co.edu.unisabana.Siga;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {
    List<FacultadDTO> facultades = new ArrayList<>();
    List<CursoDTO> cursos = new ArrayList<>();
    public Controller() {

        inicializarFacultades();
    }

    private void inicializarFacultades() {
        FacultadDTO eica = new FacultadDTO("EICA");
        FacultadDTO ingenieria = new FacultadDTO("INGENIERIA");
        FacultadDTO derecho = new FacultadDTO("DERECHO");
        FacultadDTO comunicacion = new FacultadDTO("COMUNICACION");
        FacultadDTO salud = new FacultadDTO("SALUD");
        FacultadDTO educacion = new FacultadDTO("EDUCACION");

        facultades.add(eica);
        facultades.add(ingenieria);
        facultades.add(derecho);
        facultades.add(comunicacion);
        facultades.add(salud);
        facultades.add(educacion);
    }
    //Estudiantes
    @PostMapping(path = "/estudiante/crear/") //
    public FacultadDTO crearEstudiante(@RequestParam String estudianteNombre, @RequestParam int id ,@RequestParam String facultadAsignada) {
        for (FacultadDTO facultad : this.facultades) {
            if (facultad.getFacultad().equalsIgnoreCase(facultadAsignada)) {
                List<EstudianteDTO> estudianteList = facultad.getEstudiantes();
                EstudianteDTO estudiante = new EstudianteDTO(estudianteNombre,id);
                estudianteList.add(estudiante);
                facultad.setEstudiantes(estudianteList);
                return facultad;
            }

        }
        return new FacultadDTO();
    }

    //Profesores
    @PostMapping(path = "/profesor/crear/")
    public FacultadDTO crearProfesor(@RequestParam String profesorNombre, @RequestParam int id ,@RequestParam String facultadAsignada) {
        for (FacultadDTO facultad : this.facultades) {
            if (facultad.getFacultad().equalsIgnoreCase(facultadAsignada)) {
                List<ProfesorDTO> profesorList = facultad.getProfesores();
                ProfesorDTO profesor = new ProfesorDTO(profesorNombre,id);
                profesorList.add(profesor);
                facultad.setProfesores(profesorList);
                return facultad;
            }

        }
        return new FacultadDTO();
    }

    //Asignaturas
    @GetMapping(path = "/asignatura/crear/") //
    public FacultadDTO crearAsignatura(@RequestParam String asignatura,@RequestParam String facultadAsignada) {
        for (FacultadDTO facultad : this.facultades) {
            if (facultad.getFacultad().equalsIgnoreCase(facultadAsignada)) {
                List<String> asignaturaList = facultad.getMaterias();
                asignaturaList.add(asignatura);
                facultad.setMaterias(asignaturaList);
                return facultad;
            }

        }
        return new FacultadDTO();
    }

    //Cursos
    @GetMapping(path = "/curso/libre/crear/") //
    public List<CursoDTO> crearCursoLibre(@RequestParam String asignatura, @RequestParam String facultadAsignada,@RequestParam int id) {
        CursoDTO curso = new CursoDTO();
        List<EstudianteDTO> estudiantes = new ArrayList<>();
        curso.setId(id);
        curso.setFacultad(facultadAsignada);
        curso.setProfesor(new ProfesorDTO());
        curso.setMateria(asignatura);
        curso.setEstudiantes(estudiantes);
        this.cursos.add(curso);
        return this.cursos;
    }
    @GetMapping(path = "/cursos") //
    public List<CursoDTO> obtenerCursos() {
        return this.cursos;
    }
    @PutMapping(path = "/cursos/editar/")
    public CursoDTO editarCurso(@RequestBody List<EstudianteDTO> listEstudiante, @RequestParam int idCurso ,@RequestParam String profesorNombre,@RequestParam int idProfesor) {
        for (CursoDTO curso : this.cursos) {
            if (curso.getId()==idCurso) {
                ProfesorDTO profesor = new ProfesorDTO(profesorNombre,idProfesor);
                curso.setProfesor(profesor);
                curso.setEstudiantes(listEstudiante);

                return curso;
            }

        }
        return new CursoDTO();
    }
    @GetMapping(path = "/facultades") //
    public List<FacultadDTO> obtenerFacultades() {
        return this.facultades;
    }



}
