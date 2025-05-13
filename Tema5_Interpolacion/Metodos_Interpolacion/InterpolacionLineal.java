public class InterpolacionLineal {
    public static void main(String[] args) {
        // Puntos conocidos: (x0, y0) y (x1, y1)
        double x0 = 2;
        double y0 = 4;
        double x1 = 4;
        double y1 = 16;

        // Valor donde queremos interpolar
        double xBuscado = 3;

        // Valor real en x = 3 (si se conoce, por ejemplo si f(x)=x^2)
        double valorReal = 9;

        // Calcular el valor interpolado
        double resultado = interpolarLinealmente(x0, y0, x1, y1, xBuscado);

        // Mostrar el valor interpolado
        System.out.printf("Valor interpolado en x = %.1f: %.4f\n", xBuscado, resultado);

        // Calcular errores
        double errorAbsoluto = calcularErrorAbsoluto(valorReal, resultado);
        double errorPorcentual = calcularErrorPorcentual(valorReal, resultado);

        // Mostrar los errores
        System.out.printf("Error Absoluto: %.4f\n", errorAbsoluto);
        System.out.printf("Error Porcentual: %.2f%%\n", errorPorcentual);

        // Mostrar los Puntos utilizados 
        System.out.println("\nPuntos Utilizados:");
        System.out.printf("x0 = %.1f, y0 = %.1f\n", x0, y0);
        System.out.printf("x1 = %.1f, y1 = %.1f\n", x1, y1);

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
        return (Math.abs(valorReal - valorInterpolado) / valorReal) * 100;
    }

}
