# Métodos Directos para Sistemas de Ecuaciones Lineales

Los **métodos directos** permiten obtener una solución numérica precisa en un número finito de pasos, siempre que el sistema de ecuaciones esté bien condicionado. Son especialmente útiles para sistemas pequeños a medianos.

---

## 1. Eliminación Gaussiana

### Descripción

Transforma la matriz aumentada del sistema en una matriz triangular superior. Luego, aplica **sustitución hacia atrás** para obtener las soluciones.

### Ventajas

* Procedimiento sistemático y sencillo.
* No requiere iteraciones.

### Desventajas

* Sensible a errores de redondeo si no se usa pivoteo.
* Ineficiente para sistemas grandes.

### Código

```java
package Tema3_SistemasEcuaciones.Metodos_Directos;
import java.util.*;

public class EliminacionGaussiana {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el número de ecuaciones (n): ");
        int n = scanner.nextInt();
        
        double [][] matriz = new double[n][n];
        double [] soluciones = new double[n];
        double [] x = new double[n];
        
        System.out.println("Ingrese la matriz aumentada (coeficientes y términos independientes):");
        for (int i = 0; i < n; i++) {
            System.out.println("Ecuación " + (i + 1) + ":");
            for (int j = 0; j < n; j++) {
                System.out.printf("Coeficiente [%d][%d]: ", i + 1, j + 1);
                matriz[i][j] = scanner.nextDouble();
            }
            System.out.printf("Término independiente [%d]: ", i + 1);
            soluciones[i] = scanner.nextDouble();
        }

        System.out.println("\nMatriz Aumentada Ingresada");
        mostrarMatriz(matriz, soluciones, n);

        for (int j = 0; j < n; j++) {
            for (int i = j + 1; i < n; i++) {
                double factor = matriz[i][j] / matriz[j][j];
                for (int k = 0; k < n; k++) {
                    matriz[i][k] -= factor * matriz[j][k];
                }
                soluciones[i] -= factor * soluciones[j];
                System.out.printf("\nEliminando elemento [%d][%d] con factor %.3f:\n", i + 1, j + 1, factor);
                mostrarMatriz(matriz, soluciones, n);
            }
        }

        System.out.println("\nResolviendo por sustitución hacia atrás");
        for (int i = n - 1; i >= 0; i--) {
            double suma = 0;
            for (int j = i + 1; j < n; j++) {
                suma += matriz[i][j] * x[j];
            }
            x[i] = (soluciones[i] - suma) / matriz[i][i];
            System.out.printf("x[%d] = %.3f\n", i, x[i]);
        }

        System.out.println("\nSolución Final:");
        for (int i = 0; i < n; i++) {
            System.out.printf("x[%d] = %.3f\n", i, x[i]);
        }

        scanner.close();
    }

    public static void mostrarMatriz(double [][] matriz, double [] soluciones, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("|");
            for (int j = 0; j < n; j++) {
                System.out.printf("%8.3f ", matriz[i][j]);
            }
            System.out.printf("| %8.3f |\n", soluciones[i]);
        }
        System.out.println();
    }
}
```

---

## 2. Método de Gauss-Jordan

### Descripción

Es una extensión de la eliminación gaussiana que convierte la matriz en una matriz identidad. Las soluciones se leen directamente del vector de términos independientes.

### Ventajas

* No requiere sustitución hacia atrás.
* Muy útil para encontrar la inversa de una matriz.

### Desventajas

* Mayor cantidad de operaciones comparado con la Eliminación Gaussiana.

### Código

```java
package Tema3_SistemasEcuaciones.Metodos_Directos;
import java.util.*;

public class GaussJordan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el número de ecuaciones (n): ");
        int n = scanner.nextInt();

        double [][] matriz = new double[n][n];
        double [] soluciones = new double[n];
        double [] x = new double[n];

        System.out.println("Ingrese la matriz aumentada (coeficientes y términos independientes):");
        for (int i = 0; i < n; i++) {
            System.out.println("Ecuación " + (i + 1) + ": ");
            for (int j = 0; j < n; j++) {
                System.out.printf("Coeficiente [%d][%d]: ", i + 1, j + 1);
                matriz[i][j] = scanner.nextDouble();
            }
            System.out.printf("Término independiente [%d]: ", i + 1);
            soluciones[i] = scanner.nextDouble();
        }

        System.out.println("\nMatriz aumentada ingresada:");
        mostrarMatriz(matriz, soluciones, n);

        for (int i = 0; i < n; i++) {
            double pivote = matriz[i][i];
            System.out.printf("Normalizando fila %d dividiendo por %.3f\n", i + 1, pivote);
            for (int j = 0; j < n; j++) {
                matriz[i][j] /= pivote;
            }
            soluciones[i] /= pivote;
            mostrarMatriz(matriz, soluciones, n);

            for (int k = 0; k < n; k++) {
                if (k != i) {
                    double factor = matriz[k][i];
                    System.out.printf("Eliminando elemento [%d][%d] con factor %.3f\n", k + 1, i + 1, factor);
                    for (int j = 0; j < n; j++) {
                        matriz[k][j] -= factor * matriz[i][j];
                    }
                    soluciones[k] -= factor * soluciones[i];
                    mostrarMatriz(matriz, soluciones, n);
                }
            }
        }

        System.out.println("Solución final:");
        for (int i = 0; i < n; i++) {
            x[i] = soluciones[i];
            System.out.printf("x[%d] = %.3f\n", i, x[i]);
        }

        scanner.close();
    }

    public static void mostrarMatriz(double [][] matriz, double [] soluciones, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("| ");
            for (int j = 0; j < n; j++) {
                System.out.printf("%8.3f ", matriz[i][j]);
            }
            System.out.printf("| %8.3f |\n", soluciones[i]);
        }
        System.out.println();
    }
}
```

---

## 🧪 Aplicación

Estos métodos son ideales cuando se necesita una solución exacta en sistemas que:

* Tienen un número manejable de ecuaciones (pequeños o medianos).
* No requieren cálculos repetitivos con distintas condiciones iniciales.
* Son parte de un curso o aplicación académica donde se requiere comprender el proceso paso a paso.

---
