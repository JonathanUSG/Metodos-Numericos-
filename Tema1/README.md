# Tema 1 - Error Absoluto y Relativo

## 📌 Introducción

En el análisis numérico, el error es una parte fundamental para evaluar la precisión de los resultados. Dado que en muchos casos no se obtiene el valor exacto, sino una aproximación, es importante medir **cuánto se desvía un resultado aproximado del valor real o exacto**.

Los dos tipos más comunes de error son:

- **Error Absoluto**
- **Error Relativo**

---

## Error Absoluto

### Definición

El **error absoluto** mide la diferencia directa entre el valor real y el valor aproximado.

### Fórmula

\|valor real - valor aproximado\|

### Características

- Tiene las **mismas unidades** que la magnitud que se está midiendo.
- Representa la **magnitud total** del error.
- Puede ser útil cuando se conoce el valor exacto o se necesita una referencia directa.

### Ejemplo

Si el valor real de una cantidad es 5.00 y el valor aproximado es 4.83, entonces:

Error absoluto = |5.00 - 4.83| = 0.17

---

## Error Relativo

### Definición

El **error relativo** proporciona una idea del error en proporción al tamaño del valor real. Es especialmente útil para comparar errores en diferentes magnitudes.

### Fórmula

\|valor real - valor aproximado\| / valor real

### Características

- **No tiene unidades**, ya que es una razón.
- Se puede expresar como número decimal o como porcentaje.
- Permite una **comparación proporcional** del error.

### Ejemplo

Continuando con el caso anterior:

Error relativo = |5.00 - 4.83| / 5.00 = 0.17 / 5.00 = 0.034 = 3.4%

---

## Comparación

| Aspecto             | Error Absoluto                      | Error Relativo                                  |
|---------------------|--------------------------------------|-------------------------------------------------|
| Fórmula             | \|valor real - valor aproximado\|   | \|valor real - valor aproximado\| / valor real |
| Unidades            | Mismas que la medida                | No tiene unidades                              |
| Uso principal       | Magnitud del error                  | Proporcionalidad del error                     |
| Afectado por escala | Sí                                  | No                                              |

---

## Conclusiones

- Ambos errores son fundamentales en el análisis numérico.
- El error absoluto indica qué tan lejos está un valor aproximado del real.
- El error relativo permite entender el error en relación con la magnitud del número.
- Siempre es importante especificar qué tipo de error se está reportando.

---

## Recursos adicionales

- [Khan Academy - Errores de medición](https://es.khanacademy.org/)
- [Documentación sobre análisis numérico](https://es.wikipedia.org/wiki/An%C3%A1lisis_num%C3%A9rico)

---

> 📌 **Nota:** Para cálculos más precisos, es importante considerar el contexto del problema, las unidades utilizadas y la sensibilidad de los instrumentos de medición.
