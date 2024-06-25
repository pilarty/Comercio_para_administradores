package negocio;

public class Pago { //SUPERCLASE
	//private double monto;
	public double monto;
	 
	public Pago(double monto) {
		this.monto=monto;
	}
	

	public void setMonto(double valor) {
		monto = valor;
	}
	
	public double getMonto() {
		return monto;
	}

	public double calcularCosto() {
		return monto;
	}
	
	

}
