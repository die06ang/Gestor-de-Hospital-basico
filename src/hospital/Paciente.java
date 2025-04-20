package hospital;

public class Paciente {
    //Atributos
    private String DNI;
    private String NSS;
    private String nombre;
    private String apellido;
    private String telefono;
    private String dolencia;

    public Paciente(String DNI, String NSS, String nombre, String apellido, String telefono, String dolencia) {
        this.DNI = DNI;
        this.NSS = NSS;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.dolencia = dolencia;
        System.out.println("El paciente ha sido guardado correctamente");
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNSS() {
        return NSS;
    }

    public void setNSS(String NSS) {
        this.NSS = NSS;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDolencia() {
        return dolencia;
    }

    public void setDolencia(String dolencia) {
        this.dolencia = dolencia;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "DNI='" + DNI + '\'' +
                ", NSS='" + NSS + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", telefono='" + telefono + '\'' +
                ", dolencia='" + dolencia + '\'' +
                '}';
    }
}
