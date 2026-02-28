# PROYECTO FINAL  
## Sistema de Gestión de Biblioteca en Java  

---

## 📌 Descripción

El presente proyecto consiste en el desarrollo de un sistema de gestión de biblioteca utilizando el lenguaje Java y aplicando los principios de la Programación Orientada a Objetos.

El sistema permite:

- Registrar un usuario.
- Visualizar categorías.
- Mostrar libros disponibles.
- Realizar préstamos.
- Agregar stock.

El programa funciona mediante un menú interactivo en consola.

---

## 🧱 Estructura del Sistema

### 🔹 Clase Persona (Abstracta)

- Contiene el atributo `nombre`.
- Declara el método abstracto `mostrarRol()`.
- Permite aplicar herencia y abstracción.

| Parámetro | Tipo   | Descripción |
|-----------|--------|------------|
| nombre    | String | Nombre de la persona |

---

### 🔹 Clase Usuario

- Hereda de `Persona`.
- Implementa el método `mostrarRol()`.

| Parámetro | Tipo   | Descripción |
|-----------|--------|------------|
| nombre    | String | Nombre del usuario |

---

### 🔹 Clase Libro

- Representa un libro del sistema.
- Controla el stock disponible.

| Parámetro | Tipo   | Descripción |
|-----------|--------|------------|
| titulo    | String | Nombre del libro |
| stock     | int    | Cantidad disponible |

**Métodos:**

- `prestarLibro()` → Reduce el stock si hay disponibilidad.
- `agregarStock()` → Incrementa el stock.

---

### 🔹 Clase Categoria

- Agrupa libros por categoría.
- Utiliza un arreglo de objetos `Libro`.

| Parámetro | Tipo     | Descripción |
|-----------|----------|------------|
| nombre    | String   | Nombre de la categoría |
| libros    | Libro[]  | Arreglo de libros |

---

### 🔹 Clase Biblioteca (Principal)

- Controla el funcionamiento del sistema.
- Contiene el menú principal.
- Gestiona préstamos y stock.

| Parámetro      | Tipo         | Descripción |
|---------------|-------------|------------|
| categorias    | Categoria[] | Arreglo de categorías |
| usuarioActual | Usuario     | Usuario registrado |

---

## 🔐 Validación de Datos

Se implementó un método llamado `validarNumero(Scanner scanner, int max)`, el cual permite verificar que el usuario ingrese un número válido y dentro del rango permitido.

Este método evita:

- Ingresar letras en lugar de números.
- Seleccionar opciones fuera del límite establecido.
- Errores en la ejecución del programa.

---

## 🧠 Conceptos Aplicados

- Programación Orientada a Objetos  
- Herencia  
- Abstracción  
- Encapsulamiento  
- Polimorfismo  
- Estructuras de control (`if`, `switch`, `do-while`)  

---

## ✅ Conclusión

El sistema cumple correctamente con los requisitos solicitados, demostrando el uso adecuado de la Programación Orientada a Objetos en Java y el manejo de validación de datos para garantizar su correcto funcionamiento.

---
