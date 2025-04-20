package hospital;

import java.util.ArrayList;

public class ListaPacientes {
    ArrayList<Paciente> lp;

    public ListaPacientes() {
        lp = new ArrayList<Paciente>();
    }

    public void addListaP(Paciente p) {
        lp.add(p);
    }

    public boolean existeDNI(String DNI) {
        for (Paciente el : lp) {
            if (el.getDNI().equals(DNI)) {
                return true;
            }
        }
        return false;
    }

    public void eliminarP(String DNI) {
        //recorrer la lista y si encuentro un médico con ese dni lo borro y si no, pues mando un mensaje diciendo que no existe un médico con ese dni
        if (existeDNI(DNI)) {
            for (Paciente el : lp) {
                if (el.getDNI().equals(DNI)) {
                    lp.remove(el);
                    System.out.println("Paciente borrado correctamente");
                    break;
                }
            }
        } else {
            System.out.println("No hay ningún paciente con ese dni");
        }
    }

    public void listaPacientes() {
        for (Paciente el : lp) {
            System.out.println(el.toString());
        }

    }

    public Paciente pacientePrimero() {
        return lp.get(0);
    }
}
