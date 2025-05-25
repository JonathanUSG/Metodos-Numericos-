# 📊 Métodos de 1 Paso

Esta carpeta contiene información teórica, fórmulas y código en Java para el método de **Runge-Kutta**, un método numérico de un solo paso utilizado para resolver ecuaciones diferenciales ordinarias (EDOs).

---

## 📚 Información Teórica

### 🔹 Runge-Kutta

El método de **Runge-Kutta** es un enfoque numérico para resolver EDOs de la forma:

$$
\frac{dy}{dt} = f(t, y), \quad y(t_0) = y_0
$$

El método más común, **Runge-Kutta de orden 4 (RK4)**, aproxima la solución evaluando la función $f(t, y)$ en cuatro puntos intermedios dentro de un intervalo $h$ (tamaño del paso). Es conocido por su alta precisión y estabilidad.

#### Fórmulas

Para un paso de $t_i$ a $t_{i+1} = t_i + h$, la solución $y_{i+1}$ se calcula como:

$$
y_{i+1} = y_i + \frac{h}{6} (k_1 + 2k_2 + 2k_3 + k_4)
$$

Donde los términos $k_1$, $k_2$, $k_3$ y $k_4$ son:

$$
k_1 = f(t_i, y_i)
$$

$$
k_2 = f\left(t_i + \frac{h}{2}, y_i + \frac{h}{2}k_1\right)
$$

$$
k_3 = f\left(t_i + \frac{h}{2}, y_i + \frac{h}{2}k_2\right)
$$

$$
k_4 = f(t_i + h, y_i + hk_3)
$$

✅ **Ventajas**:
- Alta precisión (error de orden $O(h^5)$ por paso).
- Estable para una amplia gama de problemas.
- No requiere puntos previos adicionales.

⚠️ **Limitaciones**:
- Computacionalmente más costoso que métodos más simples como Euler.
- Requiere evaluar la función $f(t, y)$ cuatro veces por paso.

---

## 📂 Contenido de la Carpeta

Esta carpeta incluye:

- 📄 Código en Java para implementar el método **Runge-Kutta de orden 4** para resolver EDOs.

---

## 📝 Recomendaciones

- 📌 Ajuste el tamaño del paso $h$ para equilibrar precisión y costo computacional.
- ✅ Verifique la estabilidad del método para EDOs rígidas.
- 📊 Compare los resultados con soluciones analíticas cuando estén disponibles.
- ⚠️ Evite tamaños de paso grandes en problemas no lineales para minimizar errores.
