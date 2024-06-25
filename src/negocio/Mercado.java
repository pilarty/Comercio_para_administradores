package negocio;
import java.util.ArrayList;

public class Mercado {
    static ArrayList<Producto> productos = new ArrayList<>();

    public static ArrayList<Producto> getProductos() {
        return productos;
    }

    public static void registrarProducto(Producto prod) {
        productos.add(prod);
        System.out.println("Producto registrado.");
    }
	
	public static void getStockMinimo(){
		for(Producto p:productos) {
			if(p.getCantidadStock()<=p.getStockMinimo()){
					System.out.println(p.getDescripcion() + "sin stock.");
				}
		}
	}
	
public static void cargarProducto(int codigo, int cant) {	
	for(Producto p:productos) {
		if(p.getCodigo()==codigo){
			p.setCantStock(p.getCantidadStock() + cant);
		}
	}
}

public static void modificarProducto(int codigo,int cant,String descripcion,double precioUnitario,int stockMinimo) {
	for(Producto p:productos) {
		if(p.getCodigo()==codigo){
			p.setCantStock(cant);
			p.setDescripcion(descripcion);
            p.setPrecioUnitario(precioUnitario);
            p.setStockMinimo(stockMinimo);
            System.out.println("Producto modificado.");
			}
		}
	}

public static void listarProducto() {
	for (Producto p : productos) {
		System.out.println("Descripción: " + p.getDescripcion());
		System.out.println("Código: " + p.getCodigo());
	    System.out.println("Precio Uni.: " + p.getPrecioUnitario());
	    System.out.println("CantStock: " + p.getCantidadStock());
	    System.out.println("StockMín: " + p.getStockMinimo());
	    System.out.println();	
		}
}

public static void eliminarProducto(int codigo) {
	for(int i=0; i<productos.size(); i++) {
		if(productos.get(i).getCodigo()==codigo){
			productos.remove(i);
            System.out.println("Producto eliminado.");
			}
		}
	}

public static Pago registrarPago(double monto, String medio, int cuotas) {
    Pago nuevoPago = null;

    if ("Credito".equalsIgnoreCase(medio)) {
		nuevoPago = new Credito(cuotas, monto);
    } else if ("Debito".equalsIgnoreCase(medio)) {
        nuevoPago = new Debito(monto);
    } else {
        nuevoPago = new Efectivo(monto);
    }

    return nuevoPago;
}

public static void registrarVenta(int codigo, int cant, int cuotas, String medio) {
    for (Producto p : productos) {
        if (p.getCodigo() == codigo) {
            if (cant > p.getCantidadStock()) {
                System.out.println("Stock insuficiente para el producto con código " + codigo + ".");
            } 
            else {
                int nuevoStock = p.getCantidadStock() - cant;
                p.setCantStock(nuevoStock);

                double monto = p.getPrecioUnitario() * cant;
                
                System.out.println("Venta registrada para el producto con código " + codigo + ".");
                Pago pago = registrarPago(monto, medio, cuotas);
            }
        }
    }
}

}



