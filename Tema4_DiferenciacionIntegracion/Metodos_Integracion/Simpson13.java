package Tema4_DiferenciacionIntegracion.Metodos_Integracion;

public class Simpson13 {
    public static void main(String[] args) {
        //Definir Parámetros Fijos para la Integración
        double a = 0;       // Límite Inferior
        double b = 2;       // Límite Superior
        int n = 4;          // Número de Segmentos (debe ser par)

        // Calculo de la Integral usando la regla de Simpson 1/3
        double resultado = simpson13(a, b, n); 

        // Imprimir Información y Resultado Formateado
        System.out.println("Función; x * sin(x)");
        System.out.println("Límite inferior " + (int) a);
        System.out.println("Límite Superior: " + (int) b);
        System.out.println("Número deSegementos: " + n);
        System.out.printf("Resultado de la Integral por el método de Simpson 1/3: %.4g%n", resultado);
    }

    //Define la función a Integrar
    public static double funcion(double x){
        return x * Math.sin(x);
    }

    //  Calcula la Integral usando la regla de Simpson 1/3
    public static double simpson13(double a, double b, int n){
        //Validando que n sea par
        if (n % 2 != 0) {
            throw new IllegalArgumentException("n debe ser un número par");
        }

        //Calcular el tamaño del paso
        double h = (b - a) / n;

        //Sumar los extremos: f(a) + f(b)
        double suma = funcion(a) + funcion(b);

        //Sumar los puntos intermedios con coeficientes 4 (impar) y  2 (par)
        for(int i = 0; i < n; i++){
            double x = a + i * h;
            suma +=(i % 2 == 0) ? 2 * funcion(x) : 4 * funcion(x);
        }
        return (h / 3) * suma;
    }

}
