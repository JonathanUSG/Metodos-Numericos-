package Tema4_DiferenciacionIntegracion.Metodos_Integracion;

public class Trapecio {
    public static void main(String[] args) {
         //Definir Parámetros fijos para la Integración
         double a = 0;      // Límite Inferior
         double b = 2;      // Límite Superior
         int n = 4;         // Número de Segmentos

         // Calcular La Integral usando la Regla del Trapecio
         double resultado = trapecio(a, b, n);

        // Imprimir Información y resultado Formateado
        System.out.println("Función: x * sin(x)");
        System.out.println("Límite Inferior: " + (int) a);
        System.out.println("Límite Superior: " + (int) b);
        System.out.println("Número de Segmentos: " + n);
        System.out.printf("Resultado de la integral por el método del Trapecio: %.4g%n", resultado);
    }

    // Método que define la función a integrar, es modificable
    public static double funcion(double x){
        return x * Math.sin(x);
    }  

    public static double trapecio(double a, double b, int n){
        //Calcular el tamaño del Paso
        double h = (b - a) / n;

        //Sumar los extremos: (f(a) + f(b)) / 2
        double suma = (funcion(a) + funcion(b)) / 2;

        // Sumar Los Puntos Intermedios: f(x_i) para i = 1  hasta n - 1
        for(int i = 0; i < n; i++ ){
            double x = a + i * h;
            suma += funcion(x);
        }
        return h * suma;
    }
}
