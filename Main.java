package hospital;

import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ListaMedicos lm = new ListaMedicos();
        ListaHospital hospitales = new ListaHospital();
        ListaPacientes lp = new ListaPacientes();
        ListaPacientesNoAtendidos lpna = new ListaPacientesNoAtendidos();
        Medico m = null;
        ValidadorDNI validadorDNI = null;


        //Menu
        Scanner sc1 = new Scanner(System.in);
        int opcion1;
        do {
            System.out.println();
            System.out.println();
            System.out.println("BIENVENIDO A HOSPITALES DIEGO");
            System.out.println("ESTE MOMENTO DISPONEMOS DE " + hospitales.cantidadHospitales() + " HOSPITALES DONDE PODER ATENDERLE");
            int i = 1;
            for (String value : hospitales.lpass.values()) {
                System.out.println(i + " - " + value);
                i++;
            }
            System.out.println("8 - Nuevo Hospital");
            System.out.println("9 - Borrar Hospital");
            System.out.println("ELIJA EL HOSPITAL QUE QUIERE GESTIONAR");
            System.out.println("INSERTE UN NÚMERO:");
            opcion1 = sc1.nextInt();

            switch (opcion1) {
                case 8:
                    if (hospitales.cantidadHospitales() < 5) {
                        crearHospital(hospitales);
                    } else {
                        System.out.println("No se admiten más hospitales");
                    }
                    break;
                case 9:
                    borrarHospital(hospitales);
                    break;
            }
        } while (opcion1 == 8 || opcion1 == 9);

        Scanner sc2 = new Scanner(System.in);
        int opcion2;
        do {
            System.out.println();
            System.out.println();
            System.out.println("BIENVENIDO A " + hospitales.nombreHospital(opcion1).getNombre() + "\nACTUALMENTE TENEMOS " + lm.cantidadMedicos() + " DOCTORES Y " + cantidadPacientesSatisfechos(lm.lm) + " PACIENTES SATISFECHOS\nPARA MÁS INFORMACIÓN UTILICE LAS SIGUIENTES OPCIONES:\n");
            System.out.println("Menú:");
            System.out.println("1 - Dar de alta un paciente");
            System.out.println("2 - Dar de alta un medico");
            System.out.println("3 - Modificar paciente");
            System.out.println("4 - Modificar medico");
            System.out.println("5 - Listar pacientes");
            System.out.println("6 - Listar medicos");
            System.out.println("7 - Dar de baja un médico");
            System.out.println("8 - Atender paciente");
            System.out.println("9 - Especialidades de nuestro hospital [Info]");
            System.out.println("10 - Nueva especialidad");
            System.out.println("11 - Salir");
            System.out.print("Elija una opción: ");
            opcion2 = sc2.nextInt();

            switch (opcion2) {
                case 1:
                    System.out.println("Has elegido dar de alta un paciente");
                    darAltaPaciente(lp);
                    break;
                case 2:
                    System.out.println("Has elegido dar de alta un médico");
                    darAltaMedico(lm);
                    break;
                case 3:
                    System.out.println("Has elegido modificar paciente");
                    System.out.println("Introduce el DNI del paciente a modificar");
                    String dni = sc2.nextLine();
                    //Si existe el dni del paciente
                    if (lp.existeDNI(dni)) {
                        lp.eliminarP(dni);
                        darAltaPaciente(lp);
                        //Lo borro y lo añado
                    } else {
                        System.out.println("No existe un paciente con ese dni");
                    }
                    break;
                case 4:
                    System.out.println("Has elegido modificar médico");
                    System.out.println("Introduce el DNI del médico a modificar");
                    dni = sc2.nextLine();
                    if (lm.existeDNI(dni)) {
                        lm.eliminarM(dni);
                        darAltaMedico(lm);
                    } else {
                        System.out.println("No existe un médico con ese dni");
                    }
                    break;
                case 5:
                    System.out.println("Elige una opción del 1 al 4");
                    System.out.println("5.1 - Listar todos los pacientes atendidos");
                    System.out.println("5.2 - Listar pacientes atendidos por un médico");
                    System.out.println("5.3 - Listar pacientes en espera");
                    System.out.println("5.4.- Listar pacientes que no han podido ser atendidos");
                    String choiceS = sc2.nextLine();
                    int choice = Integer.valueOf(choiceS);

                    switch (choice) {

                        case 1:
                            System.out.println("Has elegido listar todos los pacientes atendidos");
                            lm.listarPacientesDeMedicos();

                            break;
                        case 2:
                            System.out.println("Has elegido pacientes atendidos por un médico");
                            //Pedir el dni del médico al usuario
                            System.out.println("Introduce el DNI del médico a mostrar sus pacientes");
                            dni = sc2.nextLine();
                            if (lm.existeDNI(dni)) {
                                //Recuperar el médico con ese DNI (ListaMedicos)
                                m = lm.recuperarMedicoDNI(dni);
                                //Mostrar la lista de pacientes de ese médico (Médico)
                                m.mostrarPacientes();
                            } else {
                                System.out.println("No existe un médico con ese DNI");
                            }
                            break;
                        case 3:
                            System.out.println("Has elegido listar pacientes en espera");
                            lp.listaPacientes();
                            break;
                        case 4:
                            System.out.println("Has elegido listar pacientes que no han podido ser atendidos");
                            lpna.listaPacientes();
                            break;
                        default:
                            System.out.println("Opción no correcta");
                    }
                    break;
                case 6:
                    System.out.println("Has elegido Listar médicos");
                    lm.listaMedicos();
                    break;
                case 7:
                    System.out.println("Has elegido dar de baja un médico");
                    System.out.println("Introduce el DNI del médico a borrar");
                    dni = sc2.nextLine();
                    lm.eliminarM(dni);
                    break;

                case 8:
                    System.out.println("Has elegido atender paciente");
                    atenderPaciente(lp, lpna, lm);
                    break;
                case 9:
                    System.out.println("Has elegido ver las especialidades");
                    m.getEspecialidadesMedico();
                    break;
                case 10:
                    System.out.println("Has elegido añadir una nueva especialidad");
                    System.out.println("DNI del médico:");
                    dni = sc2.nextLine();
                    lm.existeDNI(dni);
                    m.aniadirEspecialidadMedico(m.getEspecialidadesMedico());
                    m.aniadirEspecialidadMedico(m.getEspecialidadesMedico());
                    break;
                case 11:
                    System.out.println("Saliendo del programa");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        } while (opcion2 != 11);
    }

    public static void darAltaPaciente(ListaPacientes lp) {
        Scanner s = new Scanner(System.in);
        //Pedirle los datos
        System.out.println("Introduce el DNI del paciente");
        String dni = s.nextLine();
        System.out.println("Introduce el NSS del paciente");
        String nss = s.nextLine();
        System.out.println("Introduce el nombre del paciente");
        String nombre = s.nextLine();
        System.out.println("Introduce el apellido del paciente");
        String apellido = s.nextLine();
        System.out.println("Introduce el teléfono del paciente");
        String telefono = s.nextLine();
        System.out.println("Introduce la dolencia del paciente");
        String dolencia = s.nextLine();
        //Crearé la instancia de paciente
        Paciente p = new Paciente(dni, nss, nombre, apellido, telefono, dolencia);
        //Lo añadiré a la lista
        lp.addListaP(p);
    }

    public static void darAltaMedico(ListaMedicos lm) {
        Scanner s = new Scanner(System.in);

        //Pedirle los datos
        System.out.println("Introduce el DNI del médico");
        String dni = s.nextLine();
        System.out.println("Introduce el nombre del médico");
        String nombre = s.nextLine();
        System.out.println("Introduce el apellido del médico");
        String apellido = s.nextLine();
        System.out.println("Introduce la especialidad del médico");
        String especialidad = s.nextLine();

        if (Medico.especialidadValidad(especialidad)) {
            //Crearé la instancia de médico
            Medico m = new Medico(dni, nombre, apellido, especialidad);
            //Lo añadiré a la lista
            lm.addListaM(m);
        } else {
            System.out.println("No se ha podido crear el médico pues su especialidad no pertenece a las especialidades de nuestro hospital.");
        }
    }

    public static void atenderPaciente(ListaPacientes lp, ListaPacientesNoAtendidos lpna, ListaMedicos lm) {
        //Cojo el primer elemento de lista pacientes
        Paciente p = lp.pacientePrimero();
        //Si el paciente pertenece a la lista de especialidades
        // lo asignaremos a un médico
        //Si no lo asignamos a la lista de pacientes no atencidos
        if (lm.existeMedicoEsp(p.getDolencia())) {
            //Devuelva el médico con menos pacientes de una especialidad
            Medico m = lm.medicoAtendera(p.getDolencia());
            //Añadir paciente
            m.aniadirPaciente(p);
            System.out.println("El paciente ha sido atendido por el médico" + m.getNombre() + " " + m.getApellido());
        } else {
            lpna.addListaP(p);
            System.out.println("No existe ningún médico con la especialidad de " + p.getDolencia() + " por lo que el paciente no ha podido ser atendido.");
        }
        lp.eliminarP(p.getDNI());
    }

    public static int cantidadPacientesSatisfechos(ArrayList<Medico> lm) {
        int count = 0;
        for (Medico el : lm) {
            count += el.nPacientes();
        }
        return count;
    }

    public static void crearHospital(ListaHospital hospitales) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Asignar nombre del hospital:");
        String nombre = sc.nextLine();
        System.out.println("Asignar contraseña del hospital:");
        String password = sc.nextLine();
        System.out.println("Asignar número de especialidades del hospital:");
        int nesp = sc.nextInt();
        System.out.println("Asignar especialidades en cuestión del hospital (introducir de una en una):");
        String[] especialidades = new String[nesp + 1];
        for (int i = 0; i <= nesp; i++) {
            especialidades[i] = sc.nextLine();
        }
        Hospital hospital = new Hospital(nombre, especialidades);
        hospitales.addListaHospital(hospital, password);
    }

    public static void borrarHospital(ListaHospital hospitales) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Número del hospital que desea borrar:");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Contraseña del hospital:");
        String password = sc.nextLine();

        if (password.equals(hospitales.passwordHospital(id))) {
            hospitales.eliminaHospital(id);
        } else {
            System.out.println("Contraseña incorrecta");
        }
    }
}
