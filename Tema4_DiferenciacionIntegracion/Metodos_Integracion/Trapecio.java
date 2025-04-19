package Tema4_DiferenciacionIntegracion.Metodos_Integracion;

public class Trapecio {
    public static void main(String[] args) {
         //Definir Parámetros fijos para la Integración
         double a = 0;      // Límite Inferior
         double b = 2;      // Límite Superior
         int n = 4;         // Número deSegmentos

        // Imprimir Información y resultado Formateado
        System.out.println("Función: x * sin(x)");
        System.out.println("Límite Inferior: " + (int) a);
        System.out.println("Límite Superior: " + (int) b);
        System.out.println("Número de Segmentos: " + n);

    }

    // Método que define la función a integrar, es modificable
    public static double función(double x){
        return x * Math.sin(x);
    }  
    
}
