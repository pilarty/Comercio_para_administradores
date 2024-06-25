package negocio;

public class Debito extends Pago{
	public Debito(double monto) {
		super(monto); //pone en la superclase, el monto
	}
	
	public double calcularCosto() {
		return monto;
	}
	
	public String getTipo() {
		return "Debito";
	}

}
