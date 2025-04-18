package Tema4_DiferenciacionIntegracion.Metodos_Difrerenciacion;

public class TresPuntos {
    public static void main(String[] args) {
        double x = 1; // Punto donde se calcula la derivada.
        double h = 0.1; // Tamaño del Paso
        int n = 4;  // Número Fijo para compatibilidad 

        
        //Imprimir Información de la Función
        System.out.println("Función: x * sin(x)");
        System.out.println("Punto de derivación: " + x);
        System.out.println("Tamaño del Paso: " + h);
    }

    // Definir la función a derivar, puede modificarse
    public static double funcion(double x){
        return x * Math.sin(x); // Función f(x) = x * sin(x)
    }

}
