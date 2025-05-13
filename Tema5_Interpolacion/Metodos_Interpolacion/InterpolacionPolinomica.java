public class InterpolacionPolinomica{
    public static void main(String[] args) {
        // Valores conocidos (x, y)
        double [] x = {1, 2, 3};
        double [] y = {1, 8, 27};

        // Valor donde se desea interpolar
        double xBuscado = 2.5;

        // Valor real conocido en x = 3 (si lo sabemos, por ejemplo si f(x)=x^2)
        double valorReal = 15.625;

        // Resultado de la interpolación
        double resultado = interpolarPolinomio(x, y, xBuscado);

        // Mostrar Resultado
        System.out.printf("Valor Interpolado en x = %.1f: %.4f\n", xBuscado, resultado);

        // Calcular y mostrar cuota de error
        double errorAbsoluto = calcularError(valorReal, resultado);
        double errorPorcentual = calcularErrorPorcentual(valorReal, resultado);

        System.out.printf("Cuota de error estimada: %.4f\n", errorAbsoluto);
        System.out.printf("Error Porcentual: %.2f%%\n", errorPorcentual);

        // Mostrar los puntos usados
        System.out.println("\nPuntos Utilizados:");
        for(int i = 0; i < x.length; i++){
            System.out.printf("x = %.1f, y = %.1f\n", x[i], y[i]);
        }
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

    // Método para calcular el error porcentual
    public static double calcularErrorPorcentual(double valorReal, double valorInterpolado){
        return (Math.abs(valorInterpolado - valorReal) / Math.abs(valorReal)) * 100;
    }
    
}