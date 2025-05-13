public class InterpolacionPolinomica{
    public static void main(String[] args) {
        
    }

    // Método de Interpolación de Lagrange
    public static double interpolarPolinomio(double []x, double []y, double xBuscado){
        double resultado =0;
        for(int i = 0; i < x.length;i++){
            double termino = y[i];

            for(int j = 0; j < x.length; j++){
                if (j != i) {
                    termino *= (xBuscado - x[j]) / (x[i] - x[j]); 
                }
            }
            resultado += termino;
        }
        return resultado;
    }

    // Método para calcular el error absoluto
    public static double calcularError(double valorReal, double valorInterpolado){
        return Math.abs(valorReal - valorInterpolado);
    }
}