package Tema5_Interpolacion.Metodos_Analisis_Datos;

public class RegresionLineal {
    public static void main(String[] args) {
        // Datos de Ejemplo
        double [] x = {1, 2, 3, 4, 5};
        double [] y = {2, 3, 5, 4, 6};

        // Imprimimos los datos originales como tabla para visualizarlos mejor
        mostrarDatos(x, y);

        // Paso 1: calculamos la pendiente e intersección de la recta de regresión
        double[] coeficientes = calcularRegresionLineal(x, y);
        double pendiente = coeficientes[0];
        double interseccion = coeficientes[1];

        // Mostramos la ecuación que representa la regresión lineal
        System.out.printf("Ecuación ajustada: y = %.4fx + %.4f\n\n", pendiente, interseccion);

        // Paso 2: calculamos los errores para evaluar qué tan buena es la predicción
        calcularErrores(x, y, pendiente, interseccion);
    }

    // Método para mostrar los valores de entrada x e y como una tabla
    public static void mostrarDatos(double []x, double []y){
        System.out.println(" x\t y");
        System.out.println("------------");
        for(int i = 0; i < x.length; i++){
            System.out.printf("%.1f\t%.1f\n", x[i], y[i]);
        }
        System.out.println(); // Línea en blanco para separar visualmente
    }

    // Aquí se hace todo el cálculo de la regresión lineal usando las fórmulas clásicas
    public static double[] calcularRegresionLineal(double[] x, double[] y){
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
        return Math.abs(real - estimado); // Solo diferencia en valor, sin signo
    }

    // Método para calcular el error porcentual con base en el valor real
    public static double calcularErrorPorcentual(double valorReal, double errorAbsoluto){
        return (errorAbsoluto / valorReal) * 100; // Se convierte a porcentaje
    }

    // Este método recorre todos los puntos, estima los valores, calcula errores y muestra todo
    public static void calcularErrores(double []x, double []y, double pendiente, double interseccion){
        int n = x.length;
        double sumaErroresPorcentuales = 0;

        // Encabezado de la tabla de resultados
        System.out.println(" x\t y real\t y estimado\t Error abs\t Error %");
         System.out.println("-----------------------------------------------------");

         for(int i = 0; i < n; i++){
            // Calculamos el valor que estimaría la recta
            double yEstimado = pendiente * x[i] + interseccion;

            // Calculamos errores con los métodos auxiliares
            double errorAbsoluto = calcularErrorAbsoluto(y[i], yEstimado);
            double errorPorcentual = calcularErrorPorcentual(y[i], errorAbsoluto);

            // Acumulamos para luego sacar el promedio
            sumaErroresPorcentuales += errorPorcentual;

            // Imprimimos cada fila con los valores y errores
            System.out.printf("%.1f\t %.1f\t   %.2f\t\t %.2f\t\t %.2f%%\n",
                    x[i], y[i], yEstimado, errorAbsoluto, errorPorcentual);
         }

         // Promedio del error porcentual al final
         double promedioError = sumaErroresPorcentuales / n;
         System.out.printf("\nError Porcentual promedio: %.2f%%\n", promedioError);
    }

}
