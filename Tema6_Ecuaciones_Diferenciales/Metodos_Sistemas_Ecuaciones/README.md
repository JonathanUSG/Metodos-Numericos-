# 📊 Métodos para Sistemas de Ecuaciones

Esta carpeta contiene información teórica, fórmulas y código en Java para el método de **Euler**, un método numérico simple utilizado para resolver sistemas de ecuaciones diferenciales ordinarias (EDOs).

---

## 📚 Información Teórica

### 🔹 Euler

El método de **Euler** es un método numérico de un paso para resolver sistemas de EDOs de la form:

$$
\frac{d\mathbf{y}}{dt} = \mathbf{f}(t, \mathbf{y}), \quad \mathbf{y}(t_0) = \mathbf{y}_0
$$

Donde $\mathbf{y}$ es un vector de variables dependientes y $\mathbf{f}$ es un vector de funciones. El método aproxima la solución usando la derivada en el punto actual.

#### Fórmulas

Para un paso de $t_i$ a $t_{i+1} = t_i + h$, la solución $\mathbf{y}_{i+1}$ se calcula como:

$$
\mathbf{y}_{i+1} = \mathbf{y}_i + h \cdot \mathbf{f}(t_i, \mathbf{y}_i)
$$

✅ **Ventajas**:
- Simple de implementar y entender.
- Adecuado para sistemas de EDOs con comportamiento suave.

⚠️ **Limitaciones**:
- Baja precisión (error de orden $O(h^2)$ por paso).
- Puede ser inestable para tamaños de paso grandes o EDOs rígidas.

---

## 📂 Contenido de la Carpeta

Esta carpeta incluye:

- 📄 Código en Java para implementar el método **Euler** para resolver sistemas de EDOs.

---

## 📝 Recomendaciones

- 📌 Use tamaños de paso pequeños para mejorar la precisión.
- ✅ Valide los resultados con métodos más precisos (como Runge-Kutta) para sistemas complejos.
- 📊 Verifique la estabilidad del método en sistemas rígidos.
- ⚠️ Evite su uso en problemas con soluciones que crecen rápidamente.
