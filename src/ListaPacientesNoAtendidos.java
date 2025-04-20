package hospital;

import java.util.ArrayList;

public class ListaPacientesNoAtendidos {
    ArrayList<Paciente> lpna;

    public ListaPacientesNoAtendidos() {
        lpna = new ArrayList<Paciente>();
    }

    public void addListaP(Paciente p) {
        lpna.add(p);
    }

    public boolean existeDNI(String DNI) {
        for (Paciente el : lpna) {
            if (el.getDNI().equals(DNI)) {
                return true;
            }
        }
        return false;
    }

    public void eliminarP(String DNI) {
        //recorrer la lista y si encuentro un médico con ese dni lo borro y si no, pues mando un mensaje diciendo que no existe un médico con ese dni
        if (existeDNI(DNI)) {
            for (Paciente el : lpna) {
                if (el.getDNI().equals(DNI)) {
                    lpna.remove(el);
                    System.out.println("Paciente borrado correctamente");
                    break;
                }
            }
        } else {
            System.out.println("No hay ningún paciente con ese dni");
        }
    }

    public void listaPacientes() {
        for (Paciente el : lpna) {
            System.out.println(el.toString());
        }

    }
}
