import java.util.ArrayList;

public class GestorVengadores {
    private ArrayList<Vengador> vengadores;

    public GestorVengadores() {
        vengadores = new ArrayList<>();
    }

    public void agregarVengador(Vengador vengador) {
        vengadores.add(vengador);
    }

    public Vengador buscarVengadorPorId(String id) {
        for (Vengador vengador : vengadores) {
            if (vengador.getId().equals(id)) {
                return vengador;
            }
        }
        return null;
    }

    public ArrayList<Vengador> listarVengadores() {
        return vengadores;
    }
}
