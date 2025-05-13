package Tema5_Interpolacion.Metodos_Analisis_Datos;

public class MinimosCuadrados {
    public static void main(String[] args) {
        // Datos de Ejemplo
       double [] x = {1, 2, 3, 4, 5};
       double [] y = {2, 3, 5, 4, 6};
       
       // Imprimimos los datos originales como tabla para visualizarlos mejor
       mostrarDatos(x, y);
    }

    // Método para mostrar los valores de entrada x e y como una tabla
    public static void mostrarDatos(double []x, double []y){
        System.out.println(" x\t y");
        System.out.println("-----------");
        for(int i = 0; i < x.length; i++){
            System.out.printf("%.1f\t%.1f\n", x[i], y[i]);
        }
        System.out.println(); // Línea en blanco para separar visualmente
    }
}
