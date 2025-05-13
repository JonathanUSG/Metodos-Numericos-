public class InterpolacionLineal {
    public static void main(String[] args) {
        
    }

    // Método de Interpolación Lineal
    public static double interpolarLinealmente(double x0, double y0, double x1, double y1, double x){
        return y0 + ((y1 - y0) / (x1 - x0)) * (x - x0); 
    }

    // Método para calcular el error absoluto
    public static double calcularErrorAbsoluto(double valorReal, double valorInterpolado){
        return Math.abs(valorReal - valorInterpolado);
    }

    // Método para calcular el error porcentual
    public static double calcularErrorPorcentual(double valorReal, double valorInterpolado){
        return (Math.abs(valorInterpolado - valorInterpolado) / Math.abs(valorReal) * 100);
    }
}
