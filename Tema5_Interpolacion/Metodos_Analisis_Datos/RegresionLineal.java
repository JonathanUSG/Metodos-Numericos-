package Tema5_Interpolacion.Metodos_Analisis_Datos;

public class RegresionLineal {
    public static void main(String[] args) {
        double [] x = {1, 2, 3, 4, 5};
        double [] y = {2, 3, 5, 4, 6};

        // Mostramos los datos en forma de tabla
        mostrarDatos(x, y);
    }

    // Muestra los valores de x y y como tabla
    public static void mostrarDatos(double []x, double []y){
        System.out.println(" x\t y");
        System.out.println("------------");
        for(int i = 0; i < x.length; i++){
            System.out.printf("%.1f\t%.1f\n", x[i], y[i]);
        }
        System.out.println(); // Espacio para separar
    }
    
}
