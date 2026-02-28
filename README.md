# 📚 Proyecto Final  
## Sistema de Gestión de Biblioteca en Java

---

# 1️⃣ Introducción

El presente proyecto consiste en el desarrollo de un sistema de gestión de biblioteca utilizando el paradigma de Programación Orientada a Objetos (POO) en Java.  

Se aplicaron los siguientes conceptos:

- Abstracción  
- Encapsulamiento  
- Herencia  
- Polimorfismo  
- Uso de arreglos  
- Estructuras de control (if, switch, do-while)  

El sistema permite registrar un usuario, visualizar categorías, consultar libros, prestar libros y agregar stock.

---

# 2️⃣ Clase Persona (Abstracción)

La clase `Persona` es una clase abstracta porque representa un concepto general. No se crean objetos directamente de ella, sino que sirve como base para otras clases.

Se aplica:

- **Encapsulamiento** → atributo privado `nombre`
- **Abstracción** → método abstracto `mostrarRol()`

## Código

```java
abstract class Persona {

    private String nombre;

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public abstract void mostrarRol();
}
```

### Explicación de métodos

- **Constructor Persona(String nombre)**  
  Inicializa el nombre de la persona.

- **getNombre()**  
  Permite acceder al atributo privado mediante un método público.

- **mostrarRol()**  
  Método abstracto que obliga a las clases hijas a definir su comportamiento.

---

# 3️⃣ Clase Usuario (Herencia y Polimorfismo)

La clase `Usuario` hereda de `Persona`.

Se aplica:

- **Herencia** con `extends`
- **Polimorfismo** al sobrescribir el método `mostrarRol()`

## Código

```java
class Usuario extends Persona {

    public Usuario(String nombre) {
        super(nombre);
    }

    @Override
    public void mostrarRol() {
        System.out.println("Rol: Usuario de Biblioteca");
    }
}
```

### Explicación de métodos

- **Constructor Usuario(String nombre)**  
  Llama al constructor de la clase padre usando `super(nombre)`.

- **mostrarRol()**  
  Sobrescribe el método abstracto y define el rol específico del usuario.

---

# 4️⃣ Clase Libro (Encapsulamiento y Control de Estado)

La clase `Libro` representa un libro dentro del sistema.

Contiene:

- Título
- Cantidad disponible (stock)

Se aplica encapsulamiento con atributos privados.

## Código

```java
class Libro {

    private String titulo;
    private int stock;

    public Libro(String titulo, int stock) {
        this.titulo = titulo;
        this.stock = stock;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getStock() {
        return stock;
    }

    public void prestarLibro() {
        if (stock > 0) {
            stock--;
            System.out.println("Libro prestado correctamente.");
        } else {
            System.out.println("No hay ejemplares disponibles.");
        }
    }

    public void agregarStock() {
        stock++;
        System.out.println("Stock agregado correctamente.");
    }
}
```

### Explicación de métodos

- **Constructor Libro(String titulo, int stock)**  
  Inicializa el título y la cantidad disponible.

- **getTitulo() / getStock()**  
  Permiten consultar los valores privados.

- **prestarLibro()**  
  Verifica si hay ejemplares disponibles.  
  Si el stock es mayor que 0, lo reduce en 1.

- **agregarStock()**  
  Incrementa el stock cuando se agrega un nuevo ejemplar.

---

# 5️⃣ Clase Categoria (Uso de Arreglos)

La clase `Categoria` organiza los libros por temática.

Utiliza un arreglo `Libro[]` para almacenar múltiples libros.

## Código

```java
class Categoria {

    private String nombre;
    private Libro[] libros;

    public Categoria(String nombre, Libro[] libros) {
        this.nombre = nombre;
        this.libros = libros;
    }

    public String getNombre() {
        return nombre;
    }

    public Libro[] getLibros() {
        return libros;
    }

    public void mostrarLibros() {
        for (int i = 0; i < libros.length; i++) {
            System.out.println((i + 1) + ". " +
                    libros[i].getTitulo() +
                    " - Disponibles: " +
                    libros[i].getStock());
        }
    }
}
```

### Explicación de métodos

- **Constructor Categoria(...)**  
  Inicializa el nombre y el arreglo de libros.

- **mostrarLibros()**  
  Utiliza un ciclo `for` para recorrer el arreglo y mostrar cada libro.

---

# 6️⃣ Clase Biblioteca (Lógica Principal del Sistema)

La clase `Biblioteca` controla todo el sistema.

Se utilizan:

- Arreglos para categorías
- Scanner para entrada de datos
- do-while para el menú
- switch para opciones

## Código principal del menú

```java
public void menu() {

    Scanner scanner = new Scanner(System.in);
    int opcion;

    registrarUsuario(scanner);

    do {
        System.out.println("\n=== SISTEMA DE BIBLIOTECA ===");
        System.out.println("1. Ver categorías");
        System.out.println("2. Ver libros por categoría");
        System.out.println("3. Tomar libro");
        System.out.println("4. Agregar libro");
        System.out.println("5. Salir");
        System.out.print("Seleccione opción: ");

        opcion = scanner.nextInt();

        switch (opcion) {

            case 1 -> mostrarCategorias();

            case 2 -> {
                mostrarCategorias();
                System.out.print("Seleccione categoría: ");
                int cat = scanner.nextInt() - 1;
                categorias[cat].mostrarLibros();
            }

            case 3 -> {
                mostrarCategorias();
                System.out.print("Seleccione categoría: ");
                int cat = scanner.nextInt() - 1;

                categorias[cat].mostrarLibros();
                System.out.print("Seleccione libro: ");
                int lib = scanner.nextInt() - 1;

                categorias[cat].getLibros()[lib].prestarLibro();
            }

            case 4 -> {
                mostrarCategorias();
                System.out.print("Seleccione categoría: ");
                int cat = scanner.nextInt() - 1;

                categorias[cat].mostrarLibros();
                System.out.print("Seleccione libro: ");
                int lib = scanner.nextInt() - 1;

                categorias[cat].getLibros()[lib].agregarStock();
            }

            case 5 -> System.out.println("Gracias por usar el sistema.");

            default -> System.out.println("Opción inválida");
        }

    } while (opcion != 5);
}
```

### Explicación del menú

- El ciclo `do-while` mantiene el sistema activo hasta que el usuario elige salir.
- El `switch` controla las opciones.
- Se accede a los arreglos usando índices.
- Se invocan métodos de otras clases para mantener organización y modularidad.

---

# 🎓 Conclusión Personal

El desarrollo de este sistema me permitió aplicar de manera práctica los principios de la Programación Orientada a Objetos. Comprendí mejor cómo estructurar clases, distribuir responsabilidades y utilizar herencia y polimorfismo correctamente.

Uno de los principales retos fue organizar la lógica del menú y la interacción entre clases. Como mejora futura, el sistema podría ampliarse agregando una clase `Prestamo`, validaciones más robustas y estructuras de datos dinámicas.

En conclusión, este proyecto fortaleció mi comprensión de la POO y me permitió construir un sistema funcional a partir de un diseño estructurado.
