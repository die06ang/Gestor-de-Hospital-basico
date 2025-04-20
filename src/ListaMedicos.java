package hospital;

import java.util.ArrayList;

public class ListaMedicos {

    ArrayList<Medico> lm;

    public ListaMedicos() {
        lm = new ArrayList<Medico>();
    }

    //Añadir médico addListaM
    public void addListaM(Medico m) {
        lm.add(m);
    }

    public boolean existeDNI(String DNI) {
        for (Medico el : lm) {
            if (el.getDNI().equals(DNI)) {
                return true;
            }
        }
        return false;
    }
//    //Eliminar un médico
//    public void eliminarM (String DNI) {
//        //recorrer la lista y si encuentro un médico con ese dni lo borro y si no, pues mando un mensaje diciendo que no existe un médico con ese dni
//       boolean existeDNI = false;
//        for(Medico el:lm){
//            if(el.getDNI().equals(DNI)){
//                existeDNI = true;
//                lm.remove(el);
//                System.out.println("Médico borrado correctamente");
//                break;
//            }
//        }
//        if (existeDNI==false) {
//            System.out.println("No hay ningún médico con ese dni");
//        }
//    }

    //Eliminar un médico
    public void eliminarM(String DNI) {
        //Recorrer la lista y si encuentro un médico con ese dni lo borro y si no, pues mando un mensaje diciendo que no existe un médico con ese dni
        if (existeDNI(DNI)) {
            for (Medico el : lm) {
                if (el.getDNI().equals(DNI)) {
                    lm.remove(el);
                    System.out.println("Médico borrado correctamente");
                    break;
                }
            }
        } else {
            System.out.println("No hay ningún médico con ese dni");
        }
    }

    //Pintar lista de médicos listaMedicos
    public void listaMedicos() {
        for (Medico el : lm) {
            System.out.println(el.toString());
        }
    }

    //Comprobar si hay un médico con esa especialidad

    public boolean existeMedicoEsp(String esp) {
        for (Medico el : lm) {
            if (el.getEspecialidad().equals(esp)) {
                return true;
            }
        }
        return false;
    }

    //Médico con menos pacientes de una especialidad
    public Medico medicoAtendera(String esp) {
        Medico m = null;
        int minP = 0;
        //Busco el primer médico de esa especialidad
        for (Medico el : lm) {
            if (el.getEspecialidad().equals(esp)) {
                m = el;
                break;
            }
        }
        //Recorro el resto y si encuentro un médico de esa especialidad, pero con menos pacientes devuelvo ese
        for (Medico el : lm) {
            if (el.getEspecialidad().equals(esp)) {
                if (el.nPacientes() < minP) {
                    m = el;
                    minP = el.nPacientes();
                }
            }
        }
        return m;
    }

    public Medico recuperarMedicoDNI(String DNI) {
        for (Medico el : lm) {
            if (el.getDNI().equals(DNI)) {
                return el;
            }
        }
        return null;
    }

    public void listarPacientesDeMedicos() {
        System.out.println("Listado total de pacientes\n");
        for (Medico el : lm) {
            el.mostrarPacientes();
            System.out.println();
        }
    }

    public int cantidadMedicos() {
        return lm.size();
    }
}
