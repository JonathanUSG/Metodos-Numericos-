# 📊 Análisis de Datos

Esta carpeta contiene información teórica y código en Java para los métodos de análisis de datos: **Correlación**, **Regresión** y **Mínimos Cuadrados**. Estos métodos se utilizan para modelar relaciones y tendencias en conjuntos de datos.

---

## 📚 Información Teórica

### 🔗 Correlación

La correlación mide la relación lineal entre dos variables. El **coeficiente de correlación de Pearson** $r$ se calcula como:

$$
r = \frac{\sum (x_i - \bar{x})(y_i - \bar{y})}{\sqrt{\sum (x_i - \bar{x})^2 \sum (y_i - \bar{y})^2}}
$$

✅ **Ventajas**:
- Indica la fuerza y dirección de la relación.

⚠️ **Limitaciones**:
- Solo mide relaciones lineales.

---

### 📈 Regresión

La regresión ajusta una función (lineal o no lineal) para modelar la relación entre variables. Para **regresión lineal simple**, la ecuación es:

$$
y = a + bx
$$

Donde $a$ es la **intersección** y $b$ es la **pendiente**.

✅ **Ventajas**:
- Predice valores basándose en tendencias.

⚠️ **Limitaciones**:
- Sensible a valores atípicos.

---

### ➕ Mínimos Cuadrados

El método de mínimos cuadrados ajusta una función **minimizando la suma de los cuadrados de los errores**:

$$
S = \sum (y_i - f(x_i))^2
$$

✅ **Ventajas**:
- Proporciona el mejor ajuste para datos ruidosos.

⚠️ **Limitaciones**:
- Puede ser computacionalmente costoso para modelos complejos.

---

## 📂 Contenido de la Carpeta

Esta carpeta incluye:

- 📄 Código en Java para calcular el **coeficiente de correlación**.
- 📄 Código en Java para implementar **regresión** (lineal).
- 📄 Código en Java para el método de **mínimos cuadrados**.


---

## 📝 Recomendaciones

- 📊 Verifique la distribución de los datos antes de aplicar regresión.
- 📌 Use correlación para decidir si la regresión lineal es adecuada.
- ✅ Valide los modelos comparando los resultados con datos reales.
