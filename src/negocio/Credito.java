package negocio;

public class Credito extends Pago {
    public int numeroCuotas;

    public Credito(int cuotas, double monto) {
        super(monto);
        this.numeroCuotas = cuotas;
    }
    
    public String getTipo() {
		return "Credito";
	}
	
	public void setNumeroCuotas(int cuotas) {
		if (cuotas == 2 || cuotas == 3 || cuotas == 6) {
            numeroCuotas = cuotas;
        } 
		else
            System.out.println("Error: La cantidad de cuotas solo puede ser 2, 3 o 6.");
	}
	
	public int getNumeroCuotas() {
		return numeroCuotas;
	}
	
	public double calcularCosto() {
		if (numeroCuotas == 2) {
			double total = monto + (monto*0.06);
			monto = total;
			return monto;

		}
		else if (numeroCuotas == 3) {
			double total = monto + (monto*0.12);
			monto = total;
			return monto;
		}
		else if (numeroCuotas == 6){
			double total = monto + (monto*0.20);
			monto = total;
			return monto;
		}
		else { //si no selecciono cuotas
			
			return monto;
			
		}
	}
	
	public double calcularValorCuota() {
        if (monto <= 0) {
            System.out.println("Error: El monto total es menor a 0.");
            return 0;
        }
        else {
        	double valorCuota = monto / getNumeroCuotas();
        	return valorCuota;
        }
    }
}
