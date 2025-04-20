package hospital;

public class Hospital {

    private String nombre;
    private String[] especialidades;

    public Hospital(String nombre, String[] especialidades) {
        this.nombre = nombre;
        this.especialidades = especialidades;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String[] getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(String[] especialidades) {
        this.especialidades = especialidades;
    }
}
