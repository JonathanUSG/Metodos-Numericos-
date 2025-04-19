package Tema4_DiferenciacionIntegracion.Metodos_Integracion;

public class CuadraturaGaussiana {
    public static void main(String[] args) {
        //Definir parámetros fijos para la Integración
        double a = 0;       // Límite Inferior
        double b = 2;       // Límite Superior
        int n = 4;          //Númerode Segmentos

        //Imprimir Información
        System.out.println("Función: x * sin(x)");
        System.out.println("Límite Inferior: " + (int) a);
        System.out.println("Límite Superior: " + (int) b );
        System.out.println("Número de Segementos: " + n);
    }

    // Define la función a Integrar
    public static double funcion(double x){
        return x * Math.sin(x);
    }
}
