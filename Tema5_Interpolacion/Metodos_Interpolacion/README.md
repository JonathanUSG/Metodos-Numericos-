# 📂 Métodos de Interpolación

Esta carpeta contiene **información teórica** y **código en Java** para los métodos de interpolación:  
**Interpolación Lineal** e **Interpolación Polinómica**.  
Estos métodos permiten estimar valores de una función en puntos intermedios a partir de **datos discretos**.

---

## 📘 Información Teórica

### 🔹 Interpolación Lineal

La interpolación lineal conecta dos puntos consecutivos $(x_i, y_i)$ y $(x_{i+1}, y_{i+1})$ con una **recta**.  
La fórmula para estimar $f(x)$ en un punto $x$ entre $x_i$ y $x_{i+1}$ es:

$$
P(x) = a_0 + a_1 x + a_2 x^2 + \dots + a_n x^n
$$


**✅ Ventajas:**
- Simple.
- Rápida.
- Adecuada para datos con comportamiento lineal.

**⚠️ Limitaciones:**
- No captura curvaturas.
- No representa comportamientos complejos.

---

### 🔹 Interpolación Polinómica

Construye un **polinomio de grado $n$** que pasa por $n+1$ puntos.  
Métodos comunes incluyen el **polinomio de Lagrange** y el de **Newton**.  
La forma general es:

$$
P(x) = a_0 + a_1 x + a_2 x^2 + \dots + a_n x^n
$$

**✅ Ventajas:**
- Precisa para datos con patrones no lineales.

**⚠️ Limitaciones:**
- Polinomios de alto grado pueden generar oscilaciones (**fenómeno de Runge**)

---

## 📁 Contenido de la Carpeta

Esta carpeta incluye:

- ✅ **Código en Java** para implementar la **Interpolación Lineal**.
- ✅ **Código en Java** para implementar la **Interpolación Polinómica** (usando **Lagrange**).

---

## 🧠 Recomendaciones

- Verifique que los puntos de datos sean **suficientes** para el grado del polinomio.
- **Visualice los resultados** para detectar oscilaciones en la interpolación polinómica.
- Use:
  - ✅ **Interpolación Lineal** para datos simples.
  - ✅ **Interpolación Polinómica** para datos más complejos.
