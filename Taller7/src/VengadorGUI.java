import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VengadorGUI{
    private JPanel panelPrincipal;
    private JTextField campoId;
    private JTextField campoNombre;
    private JTextField campoMision;
    private JTextField campoPeligrosidad;
    private JTextField campoPagoMensual;
    private JButton botonAgregar;
    private JButton botonModificar;
    private JButton botonListar;
    private JTextArea areaResultados;

    private GestorVengadores gestor = new GestorVengadores();

    public VengadorGUI() {
        botonAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = campoId.getText();
                String nombre = campoNombre.getText();
                String mision = campoMision.getText();
                int peligrosidad = Integer.parseInt(campoPeligrosidad.getText());
                double pagoMensual = Double.parseDouble(campoPagoMensual.getText());

                Vengador vengador = new Vengador(id, nombre, mision, peligrosidad, pagoMensual);
                gestor.agregarVengador(vengador);
                areaResultados.setText("¡Vengador agregado con éxito!");
            }
        });

        botonModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = campoId.getText();
                Vengador vengador = gestor.buscarVengadorPorId(id);

                if (vengador != null) {
                    vengador.setMision(campoMision.getText());
                    vengador.setNivelPeligrosidad(Integer.parseInt(campoPeligrosidad.getText()));
                    vengador.setPagoMensual(Double.parseDouble(campoPagoMensual.getText()));
                    areaResultados.setText("¡Vengador modificado con éxito!");
                } else {
                    areaResultados.setText("Vengador no encontrado.");
                }
            }
        });

        botonListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder sb = new StringBuilder();
                for (Vengador vengador : gestor.listarVengadores()) {
                    sb.append("Nombre: ").append(vengador.getNombre()).append("\n")
                            .append("Pago Mensual: $").append(vengador.getPagoMensual()).append("\n")
                            .append("Aporte Fondo Héroes: $").append(vengador.calcularAporteFondoHeroes()).append("\n")
                            .append("Impuesto Gobierno: $").append(vengador.calcularImpuestoGobierno() / 12).append("\n")
                            .append("Pago Neto: $").append(vengador.calcularPagoNeto()).append("\n\n");
                }
                areaResultados.setText(sb.toString());
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Gestión de Vengadores");
        frame.setContentPane(new VengadorGUI().panelPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
