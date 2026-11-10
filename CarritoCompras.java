public class CarritoCompras {

    private static int contadorTransacciones = 1;
    private Producto[] listaProductos;   
    private int cantidad;                
    private double total;

    public CarritoCompras() {
        listaProductos = new Producto[10];  
        cantidad = 0;
        total = 0;
    }

    public void agregarProducto(Producto producto) {
        if (cantidad < listaProductos.length) {
            listaProductos[cantidad] = producto;
            cantidad = cantidad + 1;
            total = total + producto.getPrecio();
        } else {
            System.out.println("el carrito esta lleno");
        }
    }

    public double getTotal() {
        return total;
    }

    public boolean procesarCompra(MetodoPago metodo) {
        if (cantidad == 0) {
            System.out.println("el carrito esta vacio");
            return false;
        }

        System.out.println("TRANSACCION "+ contadorTransacciones++);
        for (int i = 0; i < cantidad; i++) {
            System.out.println(listaProductos[i].getNombre()+ ": $" + listaProductos[i].getPrecio());
        }
        System.out.println("metodo de pago: " + metodo.obtenerNombreMetodo());
        System.out.println("subtotal: $" + total);

        boolean aprobado = metodo.procesarPago(total);

        if (aprobado) {
            double comision = metodo.calcularComision();
            System.out.println("comisión: " + comision+"$");
            System.out.println("Total cobrado: " + (total + comision)+"$");
            System.out.println("PAGO APROBADO");

            cantidad = 0;
            total = 0;
        } else {

            System.out.println("PAGO RECHAZADO");
        }
        System.out.println();
        return aprobado;
    }
}
