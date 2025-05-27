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
}