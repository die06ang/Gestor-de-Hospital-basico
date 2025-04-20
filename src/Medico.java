package hospital;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Medico {
    //Array estático de especialidadesMedico
    //private static String[] especialidadesMedico={"dermatología","cardiología", "neumología", "pediatría","traumatología"};
    private static ArrayList<String> especialidadesMedico = new ArrayList<>(
            Arrays.asList("dermatología", "cardiología",
                    "neumología", "pediatría", "traumatología")
    );
    private String DNI;
    private String nombre;
    private String apellido;
    private String especialidad;
    private ArrayList<Paciente> lp;

    public Medico(String DNI, String nombre, String apellido, String especialidad) {

        this.DNI = DNI;
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidad = especialidad.toLowerCase();
        lp = new ArrayList<Paciente>();
        System.out.println("El médico ha sido guardado correctamente");

    }

    public static boolean especialidadValidad(String esp) {
        for (String el : especialidadesMedico) {
            if (el.equals(esp)) {
                return true;
            }
        }
        return false;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
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

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public ArrayList<String> getEspecialidadesMedico() {
        return especialidadesMedico;
    }

    public static void setEspecialidadesMedico(ArrayList<String> especialidadesMedico) {
        Medico.especialidadesMedico = especialidadesMedico;
    }

    public ArrayList<Paciente> getLp() {
        return lp;
    }

    public void setLp(ArrayList<Paciente> lp) {
        this.lp = lp;
    }

    @Override
    public String toString() {
        return "Medico{" +
                "DNI='" + DNI + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", especialidad='" + especialidad + '\'' +
                '}';
    }

    public void aniadirPaciente(Paciente p) {
        lp.add(p);
    }

    public int nPacientes() {
        return lp.size();
    }

    public void mostrarPacientes() {
        System.out.println("Pacientes del médico " + getNombre() + " " + getApellido() + " :");
        int cont = 0;
        for (Paciente el : lp) {
            System.out.println(el.toString());
            cont++;
        }
        if (cont == 0) System.out.println("El médico no tiene pacientes");
    }

    public void aniadirEspecialidadMedico(ArrayList<String> especialidadesMedico) {
        String especialidad;
        Scanner sc = new Scanner(System.in);
        especialidad = sc.nextLine();
        especialidadesMedico.add(especialidad);
    }

    public void mostrarEspecialidadesMedico(ArrayList<String> especialidadesMedico) {
        for (String el : especialidadesMedico) {
            System.out.println(el);
        }
    }
}
