package Tema4_DiferenciacionIntegracion.Metodos_Integracion;

public class Simpson38 {
    public static void main(String[] args) {
        // Definir Parámetros fijos para la Integración
        double a = 0;       // Límite Inferior
        double b = 2;       // Límite Superior
        int n = 6;          // Número de Segmentos (Debe ser múltiplo de 3)
        
        // Calcular la integral usando la regla de Simpson 3/8
        double resultado = simpson38(a, b, n);

        //Imprimir Resultados
        System.out.println("Función: x * sin(x)");
        System.out.println("Límite Inferior: " + (int) a);
        System.out.println("Límite Superior: " + (int) b);
        System.out.println("Número de Segmentos: " + n);
        System.out.printf("Resultado de la Integral por el método de Simpson 3/8: %.4g%n", resultado);
    }    

    // Define la función a Integrar
    public static double funcion(double x){
        return x * Math.sin(x);
    }

    // Aplicación del Método de Simpson 3/8
    public static double simpson38(double a, double b, int n){
        //Validar que n sea múltiplo de 3
        if (n % 3 != 0) {
            throw new IllegalArgumentException("n debe ser múltiplo de 3");
        }

        // Calcular el tamaño del paso
        double h = (b - a) / n;

        // Sumar los extremos: f(a) y f(b)
        double suma = funcion(a) + funcion(b);
        
        // Sumar los puntos intermedios con coeficientes 3 (no múltiplo de 3) y 2 (múltiplo de 3)
        for(int i = 1; i < n; i++){
            double x = a + i * h;
            suma += (i % 3 == 0) ? 2 * funcion(x) : 3 * funcion(x);
        }
        return (3 * h / 8) * suma;
    }
}
