package hospital;

import java.util.HashMap;

public class ListaHospital {
    HashMap<Integer, Hospital> hospitales;
    HashMap<Integer, String> lpass = new HashMap<Integer, String>();
    private int id = 1;

    public ListaHospital() {
        hospitales = new HashMap<Integer, Hospital>();
    }

    public void addListaHospital(Hospital hospital, String password) {
        hospitales.put(id, hospital);
        lpass.put(id, password);
        id++;
    }

    public Hospital nombreHospital(int id) {
        return hospitales.get(id);
    }

    public String passwordHospital(int id) {
        return lpass.get(id);
    }

    public void eliminaHospital(int id) {
        hospitales.remove(id);
    }

    public int cantidadHospitales() {
        return hospitales.size();
    }
}
