public class TarjetaCredito implements MetodoPago {
    private String numeroTarjeta;
    private int mesVencimiento;    
    private int anoVencimiento;  
    private String cvv;
    private double ultimoMonto;

    public TarjetaCredito(String numeroTarjeta, int mesVencimiento,int anoVencimiento, String cvv) {
        this.numeroTarjeta = numeroTarjeta;
        this.mesVencimiento = mesVencimiento;
        this.anoVencimiento = anoVencimiento;
        this.cvv = cvv;
    }

    private boolean fechaValida() {
        int mesActual = 11;
        int anoActual = 2026;

        if (mesVencimiento < 1 || mesVencimiento > 12) {
            return false; 
        }
        if (anoVencimiento > anoActual) {
            return true;
        }
        if (anoVencimiento == anoActual && mesVencimiento >= mesActual) {
            return true;
        }
        return false; 
    }

    @Override
    public boolean procesarPago(double monto) {
        ultimoMonto = monto;

        if (!fechaValida()) {
            System.out.println("rechazado por tarjeta vencida");
            return false;
        }
        return true;
    }

    @Override
    public String obtenerNombreMetodo() {
        return "tarjeta de credito";
    }

    @Override
    public double calcularComision() {
        // para 2 decimales
        return Math.round(ultimoMonto * 0.025 * 100.0) / 100.0;
    }
}
