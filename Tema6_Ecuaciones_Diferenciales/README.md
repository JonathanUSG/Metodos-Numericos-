# 📘 Tema 6: Solución de Ecuaciones Diferenciales

Este tema aborda métodos numéricos para **resolver ecuaciones diferenciales ordinarias** (EDOs), que modelan fenómenos en ciencia e ingeniería. Los métodos implementados aproximan soluciones numéricas en dominios discretos.

---

## 📂 Contenido

### 📁 Metodos_1_Paso/
Método numérico que utiliza un solo punto previo para calcular la solución:

- **Runge-Kutta**

### 📁 Metodos_Pasos_Multiples/
Método que emplea múltiples puntos previos para mejorar la precisión:

- **Adams-Bashforth**

### 📁 Metodos_Sistemas_Ecuaciones/
Método para resolver sistemas de ecuaciones diferenciales:

- **Euler**

---

## 📌 Definiciones de los Métodos

### 🔹 Runge-Kutta
Método de un paso que aproxima la solución de una EDO evaluando la derivada en múltiples puntos intermedios dentro de un intervalo. Es preciso y ampliamente utilizado, especialmente en su variante de orden 4.

### 🔹 Adams-Bashforth
Método de pasos múltiples que usa valores previos de la solución y la derivada para predecir el siguiente punto. Es eficiente para problemas donde se dispone de datos iniciales.

### 🔹 Euler
Método simple para sistemas de EDOs que aproxima la solución usando la derivada en el punto actual. Aunque menos preciso, es útil para sistemas y como base para otros métodos.

---

## 📊 Comparación General

| Característica       | Métodos de 1 Paso       | Métodos de Pasos Múltiples | Métodos para Sistemas |
|----------------------|-------------------------|----------------------------|-----------------------|
| **Objetivo**         | Aproximar solución en un paso | Usar puntos previos para mayor precisión | Resolver sistemas de EDOs |
| **Puntos requeridos**| 1 punto                 | Múltiples puntos           | 1 punto por ecuación  |
| **Complejidad**      | Moderada                | Alta                       | Baja a moderada       |
| **Ejemplo**          | Runge-Kutta             | Adams-Bashforth            | Euler                 |

---

## 🎯 Objetivo del Tema

El objetivo de este tema es que el estudiante:

- Comprenda los fundamentos de los métodos numéricos para EDOs.
- Implemente los métodos Runge-Kutta, Adams-Bashforth y Euler en Java.
- Evalúe la precisión y estabilidad de cada método según el problema.
- Aplique los métodos a problemas prácticos en ciencia e ingeniería.

---

## ✅ Recomendaciones

- Verificar la estabilidad numérica al elegir el tamaño del paso.
- Comparar resultados con soluciones analíticas cuando sea posible.
- Considerar el costo computacional de los métodos de pasos múltiples.
- Usar el método de Euler para sistemas simples o como punto de partida.

---

## ✏️ Notación

- $y(t)$: Solución de la EDO
- $h$: Tamaño del paso
- $t_i, y_i$: Puntos discretos en la solución
