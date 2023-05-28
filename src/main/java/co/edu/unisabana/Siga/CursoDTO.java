package co.edu.unisabana.Siga;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CursoDTO {
    private String materia;
    private FacultadEnum facultad;
    private int id;
    private String profesor;
    private List<EstudianteDTO> estudiantes = new ArrayList<>();
}
