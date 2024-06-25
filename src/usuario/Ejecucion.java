package usuario;
import java.util.ArrayList;
import java.util.Scanner;
import negocio.*; //--> importa todas las clases


public class Ejecucion {
    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    	
    	while (true) {
    	    System.out.println("¿Qué operación deseas realizar?");
    	    System.out.println("1. Agregar producto");
    	    System.out.println("2. Listar productos");
    	    System.out.println("3. Modificar producto");
    	    System.out.println("4. Eliminar producto");
    	    System.out.println("5. Registrar venta");
    	    System.out.println("6. Salir");

    	    int opcion = scanner.nextInt();

    	    if (opcion == 1) {
    	        agregarProducto(scanner);
    	    } 
    	    
    	    else if (opcion == 2) {
    	        Mercado.listarProducto();
    	    } 
    	    
    	    else if (opcion == 3) {
    	    	modificarProducto(scanner);
    	    } 
    	    
    	    else if (opcion == 4) {
    	    	System.out.print("Código del producto a eliminar: ");
    	        int codigoEliminar = scanner.nextInt();
    	    	Mercado.eliminarProducto(codigoEliminar);
    	    }
    	    
    	    else if (opcion == 5) {
    	    	registrarVentaMain(scanner);
    	        
    	    } 
    	    else if (opcion == 6) {
    	    	scanner.close();
    	        System.exit(0);
    	    }
    	    
    	    else {
    	        System.out.println("Error. Ingrese de nuevo.");
    	    }
    	}
    }
    
    private static void agregarProducto(Scanner scanner) {
        System.out.print("Código: ");
        int codigo = scanner.nextInt();

        System.out.print("Descripción: ");
        String descripcion = scanner.next();

        System.out.print("Precio unitario: ");
        double precioUnitario = scanner.nextDouble();

        System.out.print("Ingrese la cantidad en stock del producto: ");
        int cantidadStock = scanner.nextInt();

        System.out.print("Ingrese el stock mínimo del producto: ");
        int stockMinimo = scanner.nextInt();

        Producto nuevoProducto = new Producto(codigo, descripcion, precioUnitario, cantidadStock, stockMinimo);
        Mercado.registrarProducto(nuevoProducto);
        
    }

    private static void modificarProducto(Scanner scanner) {
        ArrayList <Producto> listaProductos = Mercado.getProductos();

        if (listaProductos.isEmpty()) {
            System.out.println("No hay productos.");
            return;
        }

        System.out.println("Lista de productos:");
        Mercado.listarProducto();

        System.out.print("Ingrese el código del producto que desea modificar: ");
        int codigoModificar = scanner.nextInt();

        for (Producto producto : listaProductos) {
            if (producto.getCodigo() == codigoModificar) {
                System.out.println("Producto encontrado.");

                System.out.print("Nueva descripción: ");
                String nuevaDescripcion = scanner.next();
                
                System.out.print("Nuevo precio unitario: ");
                double nuevoPrecioUnitario = scanner.nextDouble();

                System.out.print("Nueva cantidad en stock: ");
                int nuevaCantidadStock = scanner.nextInt();

                System.out.print("Nuevo stock mínimo: ");
                int nuevoStockMinimo = scanner.nextInt();
                
                Mercado.modificarProducto(codigoModificar, nuevaCantidadStock, nuevaDescripcion, nuevoPrecioUnitario, nuevoStockMinimo);
                
                return;
            }
        }

        System.out.println("Producto no encontrado. No se ha modificado ningún producto.");
    }

    public static void registrarVentaMain(Scanner scanner) {
    	System.out.print("Ingrese el código del producto: ");
        int codigoProducto = scanner.nextInt();

        System.out.print("Ingrese cant: ");
        int cantidadProductos = scanner.nextInt();

        System.out.print("Elija el medio de pago (Credito/Debito/Efectivo): ");
        String medioPago = scanner.next();

        int cuotas = 0;
        if (medioPago == "Credito") {
            System.out.print("Ingrese la cantidad de cuotas (0, 2, 3, o 6): ");
            cuotas = scanner.nextInt();
        }

        Mercado.registrarVenta(codigoProducto, cantidadProductos, cuotas, medioPago);
    }
    
    
}
