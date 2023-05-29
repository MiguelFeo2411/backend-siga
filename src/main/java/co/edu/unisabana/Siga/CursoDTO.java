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
    private String facultad;
    private int id;
    private ProfesorDTO profesor;
    private List<EstudianteDTO> estudiantes = new ArrayList<>();
}
