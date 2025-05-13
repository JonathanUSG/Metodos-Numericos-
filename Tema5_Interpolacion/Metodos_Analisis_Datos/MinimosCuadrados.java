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

    // Aquí se hace todo el cálculo 
    public static double[] calcularMinimosCuadrados(double []x, double []y){
        int n = x.length;
        double sumaX = 0, sumaY = 0, sumaXY = 0, sumaX2 = 0;

        // Sumamos lo necesario: x, y, x*y y x^2
        for(int i = 0; i < n; i++){
            sumaX += x[i];
            sumaY += y[i];
            sumaXY += x[i] * y[i];
            sumaX2 += x[i] * x[i];
        }

        // Fórmulas para calcular la pendiente (m) y la intersección (b)
        double pendiente = (n * sumaXY - sumaX * sumaY) / (n * sumaX2 - sumaX * sumaX);
        double interseccion = (sumaY - pendiente * sumaX) / n;

        // Devolvemos ambos en un arreglo
        return new double[]{pendiente, interseccion};
    }

    // Método para calcular el error absoluto entre el valor real y el estimado
    public static double calcularErrorAbsoluto(double real, double estimado){
        return Math.abs(real - estimado);  // Solo diferencia en valor, sin signo
    }

    // Método para calcular el error porcentual con base en el valor real
    public static double calcularErrorPorcentual(double real, double errorAbsoluto){
        return (errorAbsoluto / real) * 100; // Se convierte a porcentaje
    }

}
