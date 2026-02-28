import java.util.Scanner;

// Clase base persona
abstract class Persona {

    protected String nombre;

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    // Metodo abstracto rol
    public abstract void mostrarRol();
}

// Usuario del sistema
class Usuario extends Persona {

    public Usuario(String nombre) {
        super(nombre);
    }

    @Override
    public void mostrarRol() {
        System.out.println("Rol: Usuario Biblioteca");
    }
}

// Clase libro sistema
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

    // Reducir stock libro
    public boolean prestarLibro() {
        if (stock > 0) {
            stock--;
            return true;
        }
        return false;
    }

    // Aumentar stock libro
    public void agregarStock() {
        stock++;
    }
}

// Categoria contiene libros
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

    // Mostrar libros disponibles
    public void mostrarLibros() {
        for (int i = 0; i < libros.length; i++) {
            System.out.println((i + 1) + ". "
                    + libros[i].getTitulo()
                    + " - Stock: "
                    + libros[i].getStock());
        }
    }
}

// Clase principal sistema
public class Biblioteca {

    private Categoria[] categorias;
    private Usuario usuarioActual;

    public Biblioteca() {

        categorias = new Categoria[]{
                new Categoria("Tecnologia", new Libro[]{
                        new Libro("Java Basico", 10),
                        new Libro("Python Facil", 10),
                        new Libro("POO desde Cero", 10)
                }),
                new Categoria("Ciencia", new Libro[]{
                        new Libro("Fisica Simple", 10),
                        new Libro("Quimica Basica", 10),
                        new Libro("Biologia General", 10)
                })
        };
    }

    // Registrar usuario sistema
    public void registrarUsuario(Scanner scanner) {
        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();
        usuarioActual = new Usuario(nombre);
        usuarioActual.mostrarRol();
    }

    // Mostrar categorias sistema
    public void mostrarCategorias() {
        for (int i = 0; i < categorias.length; i++) {
            System.out.println((i + 1) + ". "
                    + categorias[i].getNombre());
        }
    }

    // Validar numero ingresado
    private int validarNumero(Scanner scanner, int max) {
        int numero;
        while (true) {
            if (scanner.hasNextInt()) {
                numero = scanner.nextInt();
                if (numero > 0 && numero <= max) {
                    return numero - 1;
                }
            } else {
                scanner.next();
            }
            System.out.print("Opcion invalida. Intente: ");
        }
    }

    // Menu principal sistema
    public void menu() {

        Scanner scanner = new Scanner(System.in);
        int opcion;

        registrarUsuario(scanner);

        do {
            System.out.println("\n1.Ver categorias");
            System.out.println("2.Ver libros");
            System.out.println("3.Tomar libro");
            System.out.println("4.Agregar stock");
            System.out.println("5.Salir");
            System.out.print("Seleccione opcion: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Ingrese numero valido: ");
                scanner.next();
            }

            opcion = scanner.nextInt();

            switch (opcion) {

                case 1:
                    mostrarCategorias();
                    break;

                case 2:
                    mostrarCategorias();
                    System.out.print("Categoria: ");
                    int cat = validarNumero(scanner, categorias.length);
                    categorias[cat].mostrarLibros();
                    break;

                case 3:
                    mostrarCategorias();
                    System.out.print("Categoria: ");
                    cat = validarNumero(scanner, categorias.length);

                    categorias[cat].mostrarLibros();
                    System.out.print("Libro: ");
                    int lib = validarNumero(scanner,
                            categorias[cat].getLibros().length);

                    if (categorias[cat].getLibros()[lib].prestarLibro()) {
                        System.out.println("Prestamo exitoso.");
                    } else {
                        System.out.println("Sin stock disponible.");
                    }
                    break;

                case 4:
                    mostrarCategorias();
                    System.out.print("Categoria: ");
                    cat = validarNumero(scanner, categorias.length);

                    categorias[cat].mostrarLibros();
                    System.out.print("Libro: ");
                    lib = validarNumero(scanner,
                            categorias[cat].getLibros().length);

                    categorias[cat].getLibros()[lib].agregarStock();
                    System.out.println("Stock agregado.");
                    break;

                case 5:
                    System.out.println("Sistema finalizado.");
                    break;

                default:
                    System.out.println("Opcion invalida.");
            }

        } while (opcion != 5);
    }

    // Metodo principal programa
    public static void main(String[] args) {
        Biblioteca sistema = new Biblioteca();
        sistema.menu();
    }
}