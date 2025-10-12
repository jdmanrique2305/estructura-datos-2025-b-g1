// Importamos las clases necesarias del paquete java.util
// ArrayList: para manejar listas dinámicas de productos
// Scanner: para leer datos que ingresa el usuario por consola
import java.util.ArrayList;
import java.util.Scanner;

public class TallerEstructuraDatos {

    public static void main(String[] args) {

        // Creamos un objeto Scanner para leer la entrada del usuario
        Scanner sc = new Scanner(System.in);

        // Declaramos un ArrayList para almacenar los nombres de los productos
        // Un ArrayList permite agregar o eliminar elementos dinámicamente
        ArrayList<String> productos = new ArrayList<>();

        // Declaramos un vector (array) con categorías fijas de productos
        // Su tamaño no cambia, a diferencia del ArrayList
        String[] categorias = {"Tecnología", "Hogar", "Aseo", "Bebidas", "Snacks"};

        // Variable que almacenará la opción que el usuario elija del menú
        int opcion;

        // Ciclo principal del programa: se repite hasta que el usuario elija la opción 0 (salir)
        do {
            // Mostramos el menú principal
            System.out.println("\n--- MENÚ DE TECHMARKET ---");
            System.out.println("1. Agregar producto");
            System.out.println("2. Listar productos");
            System.out.println("3. Eliminar producto");
            System.out.println("4. Mostrar categorías");
            System.out.println("0. Salir");

            // Solicitamos la opción al usuario
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();   // Leemos el número que ingresa el usuario
            sc.nextLine();           // Limpiamos el buffer del Scanner

            // Estructura switch para ejecutar una acción según la opción elegida
            switch (opcion) {

                // Opción 1: Agregar un producto al ArrayList
                case 1 -> {
                    System.out.print("Ingrese el nombre del producto: ");
                    String p = sc.nextLine(); // Leemos el nombre del producto

                    // Validamos que el nombre no esté vacío
                    if (!p.isEmpty()) {
                        productos.add(p); // Agregamos el producto a la lista
                        System.out.println(" Producto agregado correctamente.");
                    } else {
                        // Si el usuario no ingresó nada, mostramos advertencia
                        System.out.println(" El nombre no puede estar vacío.");
                    }
                }

                // Opción 2: Mostrar la lista de productos guardados
                case 2 -> {
                    System.out.println("\n Productos registrados:");

                    // Verificamos si la lista está vacía
                    if (productos.isEmpty()) {
                        System.out.println("No hay productos registrados.");
                    } else {
                        // Recorremos el ArrayList usando un ciclo for-each
                        for (String prod : productos) {
                            System.out.println("- " + prod);
                        }
                    }
                }

                // Opción 3: Eliminar un producto existente
                case 3 -> {
                    System.out.print("Ingrese el nombre del producto a eliminar: ");
                    String eliminar = sc.nextLine(); // Leemos el nombre a eliminar

                    // Intentamos eliminarlo del ArrayList
                    // El método remove() devuelve true si lo encuentra y elimina
                    if (productos.remove(eliminar)) {
                        System.out.println(" Producto eliminado con éxito.");
                    } else {
                        // Si no existe el producto, informamos al usuario
                        System.out.println(" El producto no existe en la lista.");
                    }
                }

                // Opción 4: Mostrar las categorías predefinidas del vector
                case 4 -> {
                    System.out.println("\n Categorías disponibles:");

                    // Recorremos el vector usando un ciclo for-each
                    for (String cat : categorias) {
                        System.out.println("* " + cat);
                    }
                }

                // Opción 0: Salir del programa
                case 0 -> {
                    System.out.println(" Saliendo del sistema...");
                }

                // Si el usuario ingresa una opción que no está en el menú
                default -> {
                    System.out.println(" Opción no válida, intente de nuevo.");
                }
            }

            // El ciclo se repite mientras la opción sea diferente de 0
        } while (opcion != 0);

        // Cerramos el objeto Scanner para liberar recursos
        sc.close();
    }
}
