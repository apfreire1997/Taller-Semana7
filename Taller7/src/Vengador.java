public class Vengador {
    private String id;
    private String nombre;
    private String mision;
    private int nivelPeligrosidad;
    private double pagoMensual;

    public Vengador(String id, String nombre, String mision, int nivelPeligrosidad, double pagoMensual) {
        this.id = id;
        this.nombre = nombre;
        this.mision = mision;
        this.nivelPeligrosidad = nivelPeligrosidad;
        this.pagoMensual = pagoMensual;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMision() {
        return mision;
    }

    public void setMision(String mision) {
        this.mision = mision;
    }

    public int getNivelPeligrosidad() {
        return nivelPeligrosidad;
    }

    public void setNivelPeligrosidad(int nivelPeligrosidad) {
        this.nivelPeligrosidad = nivelPeligrosidad;
    }

    public double getPagoMensual() {
        return pagoMensual;
    }

    public void setPagoMensual(double pagoMensual) {
        this.pagoMensual = pagoMensual;
    }

    public double calcularAporteFondoHeroes() {
        return pagoMensual * 0.08;
    }

    public double calcularImpuestoGobierno() {
        double pagoAnual = pagoMensual * 12;
        if (pagoAnual <= 50000) {
            return 0;
        } else if (pagoAnual <= 100000) {
            return (pagoAnual - 50000) * 0.10;
        } else if (pagoAnual <= 200000) {
            return 5000 + (pagoAnual - 100000) * 0.20;
        } else {
            return 25000 + (pagoAnual - 200000) * 0.30;
        }
    }

    public double calcularPagoNeto() {
        return pagoMensual - calcularAporteFondoHeroes() - calcularImpuestoGobierno() / 12;
    }
}
