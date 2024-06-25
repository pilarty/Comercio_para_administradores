package negocio;

public class Efectivo extends Pago{ 
	public int descuento = 10;
	
	public Efectivo(double monto) {
		super(monto); //pone en la superclase, el monto
	}
	
	public double calcularCosto() {
		double total = getMonto() - (monto*descuento/100);
		return total;
	}
	
	public String getTipo() {
		return "Efectivo";
	}
	

}
