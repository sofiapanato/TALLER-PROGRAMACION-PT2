public class PruebaPagos {

    public static CarritoCompras crearCarrito() {
        CarritoCompras carrito = new CarritoCompras();
        carrito.agregarProducto(new Producto("Teclado", 80.0));
        carrito.agregarProducto(new Producto("Mouse", 25.5));
        carrito.agregarProducto(new Producto("Audífonos", 44.5));   
        return carrito;
    }
    public static void main(String[] args) {

        System.out.println("PAGOS APROBADOS");
        crearCarrito().procesarCompra(new TarjetaCredito("4111111111111111", 12, 2029, "123"));
        crearCarrito().procesarCompra(new PayPal("ana@correo.com", 500.0));
        crearCarrito().procesarCompra(new TransferenciaBancaria("1234567890", "Banco Nacional"));

        System.out.println("PAGOS RECHAZADOS");
        crearCarrito().procesarCompra(new TarjetaCredito("4111111111111111", 1, 2020, "123")); // vencida
        crearCarrito().procesarCompra(new PayPal("pobre@correo.com", 100.0));                   // sin saldo
        crearCarrito().procesarCompra(new TransferenciaBancaria("12345", "Banco Nacional"));    // cuenta corta

        System.out.println("COMISIONES PARA UN PAGO DE $100");
        MetodoPago[] metodos = new MetodoPago[3];
        metodos[0] = new TarjetaCredito("5500000000000004", 6, 2030, "456");
        metodos[1] = new PayPal("luis@correo.com", 1000.0);
        metodos[2] = new TransferenciaBancaria("1122334455", "Banco Nacional");

        for (int i = 0; i < metodos.length; i++) {
            metodos[i].procesarPago(100.0);
            System.out.println(metodos[i].obtenerNombreMetodo()
                    + " -> comisión: $" + metodos[i].calcularComision());
        }
    }
}
