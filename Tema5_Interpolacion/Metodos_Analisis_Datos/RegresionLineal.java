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

    // Método para calcular la Regresión Lineal
    public static double[] calcularRegresionLineal(double[] x, double[] y){
        int n = x.length;
        double sumaX = 0, sumaY = 0, sumaXY = 0, sumaX2 = 0;

        for(int i = 0; i < n; i++){
            sumaX += x[i];
            sumaY += y[i];
            sumaXY += x[i] * y[i];
            sumaX2 += x[i] * x[i];

        }
        double pendiente = (n * sumaXY - sumaX * sumaY) / (n * sumaX2 - sumaX * sumaX);
        double interseccion = (sumaY - pendiente * sumaX) / n;
        
        return new double[]{pendiente, interseccion};
    }

    

}
