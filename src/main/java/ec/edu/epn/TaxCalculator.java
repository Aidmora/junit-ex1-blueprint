package ec.edu.epn;

public class TaxCalculator {
    public double calculatorTax(double valor, double impuesto) {
        return valor + (valor * (impuesto / 100));
    }
}
