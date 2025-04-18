package Tema4_DiferenciacionIntegracion.Metodos_Difrerenciacion;

public class CincoPuntos {
    public static void main(String[] args) {
        // Definir Parámetros fijos para la derivación
    double x = 1;
    double h = 0.1;
    int n = 4;

    // Calcular la derivada usando el método de cinco puntos
    double resultado = cincoPuntos(x, h);

    //Imprimir Información
    System.out.println("Función: x * sin(x)");
    System.out.println("Punto de Derivación: " + x);
    System.out.printf("Resultado de la Derivada por el método de los Cinco Puntos: %.4g%n", resultado);
    }
    public static double funcion(double x){
        return x * Math.sin(x);
    }
    public static double cincoPuntos(double x, double h){
        //Evaluar la función en los puntos necesarios
        double fx1 = funcion(x + 2 * h); // f(x + 2h)
        double fx2 = funcion(x + h);     // f(x + h)
        double fx3 = funcion(x - h);     // f(x - h)
        double fx4 = funcion(x - 2 * h); // f(x - 2h)

        //Aplicar la fórmula de los Cinco Puntos: [- f(x + 2h) + 8f(x + h) - 8f(x - h) + f(x - 2h)] / (12h)
        return (-fx1 + 8 * fx2 - 8 * fx3 + fx4) / (12 * h);
    }
}
