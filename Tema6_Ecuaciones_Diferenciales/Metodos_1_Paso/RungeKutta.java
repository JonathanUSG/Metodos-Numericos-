import java.util.Scanner;

public class RungeKutta{
    // Método para evaluar la función f(x,y) que el usuario ingresa
    public static double evaluarFuncion(String funcion, double x, double y) {
        // Convertimos la función a minúsculas y quitamos espacios
        funcion = funcion.toLowerCase().replace(" ", "");
        
        // Reemplazamos funciones matemáticas con sus valores calculados
        funcion = funcion.replaceAll("sin\\(x\\)", Double.toString(Math.sin(x)));
        funcion = funcion.replaceAll("cos\\(x\\)", Double.toString(Math.cos(x)));
        funcion = funcion.replaceAll("exp\\(x\\)", Double.toString(Math.exp(x)));
        funcion = funcion.replaceAll("log\\(x\\)", Double.toString(Math.log(x)));
        
        // Lo mismo pero para la variable y
        funcion = funcion.replaceAll("sin\\(y\\)", Double.toString(Math.sin(y)));
        funcion = funcion.replaceAll("cos\\(y\\)", Double.toString(Math.cos(y)));
        funcion = funcion.replaceAll("exp\\(y\\)", Double.toString(Math.exp(y)));
        funcion = funcion.replaceAll("log\\(y\\)", Double.toString(Math.log(y)));
        
        // Sustituimos x e y por sus valores numéricos
        funcion = funcion.replaceAll("x", Double.toString(x));
        funcion = funcion.replaceAll("y", Double.toString(y));
        
        // Evaluamos la expresión resultante
        return evaluarExpresionSimple(funcion);
    }
    // Método para evaluar expresiones con sumas y restas
    public static double evaluarExpresionSimple(String expr) {
        double resultado = 0;
        // Cambiamos dobles negativos por suma para evitar errores
        expr = expr.replaceAll("--", "+");

        // Separamos la expresión en partes según los signos + o -
        String[] sumandos = expr.split("(?=[+-])");

        // Sumamos o restamos cada parte
        for (String sumando : sumandos) {
            resultado += evaluarProducto(sumando);
        }
        return resultado;
    }

    // Método para evaluar productos y divisiones dentro de un sumando
    public static double evaluarProducto(String expr) {
        String[] factores;
        double resultado = 1;

        // Si hay división, la procesamos con prioridad
        if (expr.contains("/")) {
            factores = expr.split("/");
            // Evaluamos el primer factor
            resultado = evaluarFactor(factores[0]);
            // Dividimos por los factores siguientes
            for (int i = 1; i < factores.length; i++) {
                resultado /= evaluarFactor(factores[i]);
            }
        } else if (expr.contains("*")) {
            // Si hay multiplicación, procesamos cada factor
            factores = expr.split("\\*");
            for (String f : factores) {
                resultado *= evaluarFactor(f);
            }
        } else {
            // Si no hay * ni /, evaluamos directamente
            resultado = evaluarFactor(expr);
        }
        return resultado;
    }
    // Método para evaluar un factor (número o expresión simple)
    public static double evaluarFactor(String expr) {
        // Quitamos espacios al inicio y final
        expr = expr.trim();
        
        // Eliminamos paréntesis externos si los hay
        while (expr.startsWith("(") && expr.endsWith(")")) {
            expr = expr.substring(1, expr.length() - 1).trim();
        }
        
        // Quitamos signos + al inicio si son redundantes
        while (expr.startsWith("+")) {
            expr = expr.substring(1).trim();
        }
        
        // Si la expresión está vacía, devolvemos 0
        if (expr.isEmpty()) return 0;
        
        // Intentamos convertir la expresión a número
        try {
            return Double.parseDouble(expr);
        } catch (NumberFormatException e) {
            // Si falla, mostramos error y devolvemos 0
            System.out.println("Error al evaluar factor: " + expr);
            return 0;
        }
    }
}