import java.util.Scanner;

public class Biblioteca {

    // Nombre de la biblioteca
    String libraryName = "Biblioteca Central";

    // Nombre del usuario que accede al sistema
    String username;

    // Categorías disponibles en la biblioteca
    String[] categories = {"Tecnología", "Ciencia", "Historia"};

    // Libros disponibles por cada categoría
    String[][] books = {
        {"Java Básico", "Python Fácil", "POO desde Cero"},
        {"Física Simple", "Química Básica", "Biología General"},
        {"Historia de México", "Historia Universal", "Imperios Antiguos"}
    };

    // Cantidad disponible de cada libro
    int[][] bookStock = {
        {10, 10, 10},
        {10, 10, 10},
        {10, 10, 10}
    };

    void registerUsername(Scanner scanner) {
        System.out.print("Ingrese su nombre de usuario: ");
        username = scanner.next();
        System.out.println("Hola " + username + ", bienvenido a la biblioteca.");
    }

    void showCategories() {
        System.out.println("Categorías disponibles:");
        for (int i = 0; i < categories.length; i++) {
            System.out.println((i + 1) + ". " + categories[i]);
        }
    }

    void showBooksByCategory(int categoryIndex) {
        System.out.println("Libros disponibles:");
        for (int i = 0; i < books[categoryIndex].length; i++) {
            System.out.println(
                (i + 1) + ". " + books[categoryIndex][i] +
                " - Disponibles: " + bookStock[categoryIndex][i]
            );
        }
    }

    void takeBook(Scanner scanner) {
        showCategories();
        System.out.print("Seleccione una categoría: ");
        int cat = scanner.nextInt() - 1;

        showBooksByCategory(cat);
        System.out.print("Seleccione un libro: ");
        int book = scanner.nextInt() - 1;

        if (bookStock[cat][book] > 0) {
            bookStock[cat][book]--;
            System.out.println("Has tomado el libro correctamente.");
        } else {
            System.out.println("No hay ejemplares disponibles.");
        }
    }

    void addBook(Scanner scanner) {
        showCategories();
        System.out.print("Seleccione una categoría: ");
        int cat = scanner.nextInt() - 1;

        showBooksByCategory(cat);
        System.out.print("Seleccione el libro al que desea agregar stock: ");
        int book = scanner.nextInt() - 1;

        bookStock[cat][book]++;
        System.out.println("Libro agregado correctamente.");
    }

    void menu() {
        Scanner scanner = new Scanner(System.in);
        int option;

        registerUsername(scanner);

        do {
            System.out.println("\n=== BOOK MANAGEMENT ===");
            System.out.println("1. Ver categorías");
            System.out.println("2. Ver libros por categoría");
            System.out.println("3. Tomar un libro");
            System.out.println("4. Agregar un libro");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            option = scanner.nextInt();

            switch (option) {
                case 1 -> showCategories();
                case 2 -> {
                    showCategories();
                    System.out.print("Seleccione una categoría: ");
                    int cat = scanner.nextInt() - 1;
                    showBooksByCategory(cat);
                }
                case 3 -> takeBook(scanner);
                case 4 -> addBook(scanner);
                case 5 -> System.out.println("Gracias por usar la biblioteca.");
                default -> System.out.println("Opción no válida");
            }
        } while (option != 5);
    }

    public static void main(String[] args) {
        new Biblioteca().menu();
    }
}
