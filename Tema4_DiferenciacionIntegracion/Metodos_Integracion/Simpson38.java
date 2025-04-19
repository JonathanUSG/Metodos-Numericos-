package Tema4_DiferenciacionIntegracion.Metodos_Integracion;

public class Simpson38 {
    public static void main(String[] args) {
        // Definir Parámetros fijos para la Integración
        double a = 0;       // Límite Inferior
        double b = 2;       // Límite Superior
        int n = 6;          // Número de Segmentos (Debe ser múltiplo de 3)
        
        //Imprimir Resultados
        System.out.println("Función: x * sin(x)");
        System.out.println("Límite Inferior: " + (int) a);
        System.out.println("Límite Superior: " + (int) b);
        System.out.println("Número de Segmentos: " + n);
    }    

    // Define la función a Integrar
    public static double funcion(double x){
        return x * Math.sin(x);
    }

}
