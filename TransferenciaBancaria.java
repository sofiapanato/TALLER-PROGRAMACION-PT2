public class TransferenciaBancaria implements MetodoPago {
    private String numeroCuenta;
    private String nombreBanco;

    public TransferenciaBancaria(String numeroCuenta, String nombreBanco) {
        this.numeroCuenta = numeroCuenta;
        this.nombreBanco = nombreBanco;
    }

    @Override
    public boolean procesarPago(double monto) {
        // devuelve los caracteres que tenga el String
        if (numeroCuenta.length() < 10) {
            System.out.println("rechazado: el número de cuenta debe tener mínimo 10 dígitos.");
            return false;
        }
        return true;
    }

    @Override
    public String obtenerNombreMetodo() {
        return "Transferencia bancaria (" + nombreBanco + ")";
    }

    @Override
    public double calcularComision() {
        return 5.0; 
    }
}
