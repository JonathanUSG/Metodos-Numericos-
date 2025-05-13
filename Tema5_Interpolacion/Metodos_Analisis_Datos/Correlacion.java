package Tema5_Interpolacion.Metodos_Analisis_Datos;

public class Correlacion {
    public static void main(String[] args) {
        // Puntos conocidos en x, y
        double [] x = {1, 2, 3, 4, 5};
        double [] y = {2, 4, 6, 8, 10};

        //Mostrar los puntos utilizados
        System.out.println("Puntos Utilizados:");
        for(int i = 0; i < x.length; i++){
            System.out.printf("x = %.1f, y = %.1f\n", x[i], y[i]);
        }

        // Calcular el coeficiente de correlación
        double r = calcularCorrelacion(x,y);

        // Mostrar el resultado del coeficiente
        System.out.printf("\nCoeficiente de correlación: %.4f\n", r);

        // Calcular y mostrar el error absoluto y porcentual
        double errorAbsoluto = calcularErrorAbsoluto(r);
        double errorPorcentual = calcularErrorPorcentual(r);

        System.out.printf("Error Absoluto: %.4f\n", errorAbsoluto);
        System.out.printf("Error Porcentual: %.2f%%\n", errorPorcentual);

        // Interpretación rápida
        if (r == 1) 
            System.out.println("Correlación Perfecta Positiva");
         else if(r == -1)
            System.out.println("Correlación Perfecta Negativa");
         else if(r > 0)
            System.out.println("Correlación Positiva");
         else if(r < 0)
            System.out.println("Correlación Negativa");
         else 
            System.out.println("Sin correlación");
    }

    // Método para calcular el coeficiente de correlación de Pearson
    public static double calcularCorrelacion(double []x, double []y){
        int n =x.length;
        
        double sumaX = 0, sumaY = 0;
        double sumaXY = 0, sumaX2 = 0, sumaY2 = 0;

        for(int i = 0; i < n; i++){
            sumaX += x[i];
            sumaY += y[i];
            sumaXY += x[i] * y[i];
            sumaX2 += x[i] * x[i];
            sumaY2 += y[i] * y[i];  
        }

        // Aplicamos la fórmula
        double numerador = (n * sumaXY) - (sumaX * sumaY);
        double denominador = Math.sqrt((n * sumaX2 - sumaX * sumaX) * (n * sumaY2 - sumaY * sumaY));

        if (denominador == 0) {
            System.out.println("Error: División entre cero");
            return 0;
        }
        return numerador / denominador;
    }

    // Método para calcular el error Absoluto
    public static double calcularErrorAbsoluto(double r){
        return 1 - Math.abs(r);
    }

    // Método para calcular el error porcentual
    public static double calcularErrorPorcentual(double r){
        return (1 - Math.abs(r)) * 100;
    }
}
