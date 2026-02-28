import java.util.Scanner;

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

class Usuario extends Persona {

    public Usuario(String nombre) {
        super(nombre);
    }

    @Override
    public void mostrarRol() {
        System.out.println("Rol: Usuario de Biblioteca");
    }
}

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

public class Biblioteca {

    private String nombre;
    private Categoria[] categorias;
    private Persona usuarioActual;

    public Biblioteca(String nombre) {
        this.nombre = nombre;

        categorias = new Categoria[]{
                new Categoria("Tecnología", new Libro[]{
                        new Libro("Java Básico", 10),
                        new Libro("Python Fácil", 10),
                        new Libro("POO desde Cero", 10)
                }),
                new Categoria("Ciencia", new Libro[]{
                        new Libro("Física Simple", 10),
                        new Libro("Química Básica", 10),
                        new Libro("Biología General", 10)
                }),
                new Categoria("Historia", new Libro[]{
                        new Libro("Historia de México", 10),
                        new Libro("Historia Universal", 10),
                        new Libro("Imperios Antiguos", 10)
                })
        };
    }

    public void registrarUsuario(Scanner scanner) {
        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.next();
        usuarioActual = new Usuario(nombre);

        System.out.println("Bienvenido " + usuarioActual.getNombre());
        usuarioActual.mostrarRol();
    }

    public void mostrarCategorias() {
        for (int i = 0; i < categorias.length; i++) {
            System.out.println((i + 1) + ". " + categorias[i].getNombre());
        }
    }

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

    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca("Biblioteca Central");
        biblioteca.menu();

    }
}