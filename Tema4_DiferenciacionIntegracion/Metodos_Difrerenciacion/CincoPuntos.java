package Tema4_DiferenciacionIntegracion.Metodos_Difrerenciacion;

public class CincoPuntos {
    public static void main(String[] args) {
        // Definir Parámetros fijos para la derivación
    double x = 1;
    double h = 0.1;
    int n = 4;
    
    //Imprimir Información
    System.out.println("Función: x * sin(x)");
    System.out.println("Punto de Derivación: " + x);

    }
    public static double funcion(double x){
        return x * Math.sin(x);
    }
}
