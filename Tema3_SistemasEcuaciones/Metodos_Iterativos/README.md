# Métodos Iterativos para Sistemas de Ecuaciones Lineales

Estos métodos se utilizan para resolver sistemas de ecuaciones lineales grandes de forma aproximada mediante iteraciones sucesivas. Funcionan mejor si el sistema es **diagonalmente dominante**.

---

## 1. Método de Gauss-Seidel

### Descripción

Usa los valores más recientes disponibles para cada variable dentro de una misma iteración.

### Ventajas

* Convergencia más rápida que Jacobi en muchos casos.

### Desventajas

* Puede no converger si la matriz no es diagonalmente dominante.

### Código

```java
package Tema3_SistemasEcuaciones.Metodos_Iterativos;
import java.util.*;
public class GaussSeidel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el número de ecuaciones (n): ");
        int n = scanner.nextInt();

        double[][] matriz = new double[n][n];
        double[] soluciones = new double[n];
        double[] x = new double[n];
        double[] anterior = new double[n];

        System.out.println("Ingrese la matriz aumentada (coeficientes y términos independientes):");
        for (int i = 0; i < n; i++) {
            System.out.println("Ecuación " + (i + 1) + ":");
            for (int j = 0; j < n; j++) {
                System.out.printf("Coeficiente [%d][%d]: ", i + 1, j + 1);
                matriz[i][j] = scanner.nextDouble();
            }
            System.out.printf("Término Independiente [%d]: ", i + 1);
            soluciones[i] = scanner.nextDouble();
        }

        System.out.print("Ingrese la tolerancia adecuada (de preferencia 0.000001): ");
        double tolerancia = scanner.nextDouble();
        System.out.print("Ingrese el número máximo de Iteraciones (Por ejemplo, 100): ");
        int maxIteraciones = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            x[i] = 0;
            anterior[i] = 0;
        }

        System.out.println("\nIniciando Iteraciones de Gauss - Seidel");
        int iteracion = 0;
        while (iteracion < maxIteraciones) {
            for (int i = 0; i < n; i++) {
                anterior[i] = x[i];
            }

            for (int i = 0; i < n; i++) {
                double suma = soluciones[i];
                for (int j = 0; j < n; j++) {
                    if (j != i) suma -= matriz[i][j] * x[j];
                }
                x[i] = suma / matriz[i][i];
            }

            boolean convergencia = true;
            for (int j = 0; j < n; j++) {
                if (Math.abs(x[j] - anterior[j]) > tolerancia) {
                    convergencia = false;
                    break;
                }
            }

            System.out.printf("Iteración %d:\n", iteracion + 1);
            for (int j = 0; j < n; j++) {
                System.out.printf("x[%d] = %.3f\n", j, x[j]);
            }

            if (convergencia) {
                System.out.println("\nConvergencia alcanzada");
                break;
            }
            iteracion++;
        }

        if (iteracion >= maxIteraciones) {
            System.out.println("\nNo se alcanzó convergencia dentro del número máximo de iteraciones");
        }

        System.out.println("Solución Final:");
        for (int j = 0; j < n; j++) {
            System.out.printf("x[%d] = %.3f\n", j, x[j]);
        }
        scanner.close();
    }
}
```

---

## 2. Método de Jacobi

### Descripción

Calcula todos los valores nuevos usando solo los valores anteriores, manteniéndolos sin actualizar hasta terminar cada iteración.

### Ventajas

* Fácil de paralelizar.

### Desventajas

* Generalmente más lento que Gauss-Seidel.
* Puede no converger si la matriz no es diagonalmente dominante.

### Código

```java
package Tema3_SistemasEcuaciones.Metodos_Iterativos;
import java.util.*;
public class Jacobi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el número de ecuaciones (n): ");
        int n = scanner.nextInt();

        double[][] matriz = new double[n][n];
        double[] soluciones = new double[n];
        double[] x = new double[n];
        double[] anterior = new double[n];

        System.out.println("Ingrese la matriz aumentada (coeficientes y términos independientes):");
        for (int i = 0; i < n; i++) {
            System.out.println("Ecuación " + (i + 1) + ":");
            for (int j = 0; j < n; j++) {
                System.out.printf("Coeficiente [%d][%d]: ", i + 1, j + 1);
                matriz[i][j] = scanner.nextDouble();
            }
            System.out.printf("Término Independiente [%d]: ", i + 1);
            soluciones[i] = scanner.nextDouble();
        }

        for (int i = 0; i < n; i++) {
            if (Math.abs(matriz[i][i]) < 1e-10) {
                System.out.println("Error: El elemento diagonal matriz [" + i + "][" + (i + 1) + "] es cero o muy pequeño");
                scanner.close();
                return;
            }
        }

        System.out.print("Ingrese la tolerancia deseada (Por ejemplo: 0.00001): ");
        double tolerancia = scanner.nextDouble();
        System.out.print("Ingrese el número máximo de iteraciones (Por ejemplo: 100): ");
        int maxIteraciones = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            x[i] = 0;
            anterior[i] = 0;
        }

        System.out.println("\nIniciando iteraciones de Jacobi....");
        int iteracion = 0;
        while (iteracion < maxIteraciones) {
            iteracion++;

            for (int i = 0; i < n; i++) {
                double suma = soluciones[i];
                for (int j = 0; j < n; j++) {
                    if (j != i) suma -= matriz[i][j] * anterior[j];
                }
                x[i] = suma / matriz[i][i];
            }

            double maxDiferencia = 0;
            for (int i = 0; i < n; i++) {
                maxDiferencia = Math.max(maxDiferencia, Math.abs(x[i] - anterior[i]));
            }

            System.out.printf("Iteración %d (Diferencia Máxima: %.3f):\n", iteracion, maxDiferencia);
            for (int i = 0; i < n; i++) {
                System.out.printf("x[%d] = %.3f\n", i, x[i]);
            }

            boolean convergencia = true;
            for (int i = 0; i < n; i++) {
                if (Math.abs(x[i] - anterior[i]) > tolerancia) {
                    convergencia = false;
                    break;
                }
            }

            if (convergencia) {
                System.out.println("\nConvergencia alcanzada en la iteración " + iteracion + "!");
                break;
            }

            for (int i = 0; i < n; i++) {
                anterior[i] = x[i];
            }
        }

        if (iteracion >= maxIteraciones) {
            System.out.println("\nAdvertencia: No se alcanzó convergencia dentro del número de iteraciones establecidas");
        }

        System.out.println("\nSolución Final:");
        for (int i = 0; i < n; i++) {
            System.out.printf("x[%d] = %.3f\n", i, x[i]);
        }
        scanner.close();
    }
}
```
---
