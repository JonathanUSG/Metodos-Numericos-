package Tema4_DiferenciacionIntegracion.Metodos_Integracion;

public class CuadraturaGaussiana {
    public static void main(String[] args) {
        //Definir parámetros fijos para la Integración
        double a = 0;       // Límite Inferior
        double b = 2;       // Límite Superior
        int n = 4;          //Númerode Segmentos

        // Calcular la integral de la cunción segun el método de Cuadratura Gaussiana
        double resultado = cuadraturaGaussiana(a, b);
        //Imprimir Información
        System.out.println("Función: x * sin(x)");
        System.out.println("Límite Inferior: " + (int) a);
        System.out.println("Límite Superior: " + (int) b );
        System.out.println("Número de Segementos: " + n);
        System.out.printf("Resultado de la Integral por el método de Cuadratura Gaussiana: %.4g%n", resultado);
    }

    // Define la función a Integrar
    public static double funcion(double x){
        return x * Math.sin(x);
    }

    // Aplica el método de Simpson
    public static double cuadraturaGaussiana(double a, double b){
        // Puntos de Gauss y peso para la cuadratura de dos puntos
        double t1 = -0.577350269; // Primer Punto de Gauss
        double t2 = 0.577350269; // Segundo Punto de Gauss
        double w = 1.0;
        
        //Transformar los puntos de [-1,1] al intervalo [a,b]
        double x1 = ((b - a) * t1 + (b + a)) / 2; // x1 = (b-a)t1/2 + (b+a)/2
        double x2 = ((b - a) * t2 + (b + a)) / 2; // x1 = (b-a)t1/2 + (b+a)/2

        //Evaluar la función en los puntos transformados
        double fx1 = funcion(x1);
        double fx2 = funcion(x2);
        
        // Aplicar la fórmula: (b-a)/2 * (w * f(x1) + w * f(x2))
        return (b - a) / 2 * (w * fx1 + w * fx2);
    }
}
