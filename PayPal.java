public class PayPal implements MetodoPago {
    private String email;
    private double saldoDisponible;
    private double ultimoMonto;

    public PayPal(String email, double saldoDisponible) {
        this.email = email;
        this.saldoDisponible = saldoDisponible;
    }

    @Override
    public boolean procesarPago(double monto) {
        ultimoMonto = monto;

        double totalACobrar = monto + calcularComision();

        if (saldoDisponible < totalACobrar) {
            System.out.println("rechazado por saldo insuficiente (saldo: " + saldoDisponible+ "$ , se necesitan: " + totalACobrar + "$)");
            return false;
        }

        saldoDisponible = saldoDisponible - totalACobrar;  
        return true;
    }

    @Override
    public String obtenerNombreMetodo() {
        return "PayPal (" + email + ")";
    }

    @Override
    public double calcularComision() {
        return Math.round(ultimoMonto * 0.018 * 100.0) / 100.0;
    }

    public double getSaldoDisponible() {
        return saldoDisponible;
    }
}
