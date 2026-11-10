
public interface MetodoPago {
    boolean procesarPago(double monto);   
    String obtenerNombreMetodo();        
    double calcularComision();            
}
