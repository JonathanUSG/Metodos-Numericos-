package Tema5_Interpolacion.Metodos_Analisis_Datos;

public class Correlacion {
    public static void main(String[] args) {
        
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
