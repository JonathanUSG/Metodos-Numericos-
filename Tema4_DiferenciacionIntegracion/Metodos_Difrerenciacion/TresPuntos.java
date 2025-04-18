package Tema4_DiferenciacionIntegracion.Metodos_Difrerenciacion;

public class TresPuntos {
    public static void main(String[] args) {
        double x = 1; // Punto donde se calcula la derivada.
        double h = 0.1; // Tamaño del Paso
        int n = 4;  // Número Fijo para compatibilidad 

        // Calcular la derivada usando el método de tres puntos
        double resultado = tresPuntos(x, h);

        //Imprimir Información de la Función 
        System.out.println("Función: x * sin(x)");  // Función Evaluada
        System.out.println("Punto de derivación: " + x); // Punto de Evaluación
        System.out.println("Tamaño del Paso: " + h);    // Tamaño del Paso
        System.out.printf("Resultado de la derivada por el método de los Tres puntos: %.3g%n", resultado);
    }

    // Definir la función a derivar, puede modificarse
    public static double funcion(double x){
        return x * Math.sin(x); // Función f(x) = x * sin(x)
    }

    // Calcula la derivada numérica usando la fórmula de tres puntos
    public static double tresPuntos(double x, double h){
        double fx1 = funcion(x + + h); // f(x + h)
        double fx2 = funcion(x - h);    // f(x - h)

        //Aplicando la fórmula: [f(x + h) - f(x - h)] / (2h)
        return (fx1 - fx2) / (2 * h);
    }
}
