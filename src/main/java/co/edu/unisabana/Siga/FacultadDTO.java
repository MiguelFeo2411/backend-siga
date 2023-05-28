package co.edu.unisabana.Siga;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FacultadDTO {
    private FacultadEnum facultad;
    private List<String> estudiantes = new ArrayList<>();
    private List<String> profesores = new ArrayList<>();
    private List<String> materias = new ArrayList<>();
    private List<CursoDTO> cursos = new ArrayList<>();



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FacultadDTO facultad1 = (FacultadDTO) o;
        return facultad == facultad1.facultad;
    }

    @Override
    public int hashCode() {
        return Objects.hash(facultad);
    }
}