import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

// Clase Libro
// Representa cada libro del catálogo.
// Se usa dentro de un array fijo porque el catálogo
// tiene tamaño limitado y el acceso por índice es directo.

class Libro {
    int codigo;
    String titulo;
    String autor;
    int stock;
    boolean activo;

    Libro(int codigo, String titulo, String autor, int stock) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.stock = stock;
        this.activo = true;
    }
}

// Clase Prestamo
// Se usa en una lista enlazada simple porque las inserciones
// y eliminaciones de préstamos activos son frecuentes.

class Prestamo {
    int codigoLibro;
    String usuario;
    LocalDate fecha;
    boolean devuelto;

    Prestamo(int codigoLibro, String usuario) {
        this.codigoLibro = codigoLibro;
        this.usuario = usuario;
        this.fecha = LocalDate.now();
        this.devuelto = false;
    }
}

// Nodo de lista simple
// Estructura dinámica para la lista de préstamos activos.
// Complejidad de inserción: O(1) si agrego al inicio.

class NodoPrestamo {
    Prestamo dato;
    NodoPrestamo sig;

    NodoPrestamo(Prestamo dato) {
        this.dato = dato;
        this.sig = null;
    }
}

// Clase Operacion
// Cada acción (ALTA, BAJA, PRESTAMO, DEVOLUCION) se guarda en el historial.

class Operacion {
    String tipo; 
    LocalDateTime fechaHora;
    String detalle;

    Operacion(String tipo, String detalle) {
        this.tipo = tipo;
        this.fechaHora = LocalDateTime.now();
        this.detalle = detalle;
    }
}

// Nodo de lista doble
// Estructura dinámica para historial de operaciones.
// Permite recorrer hacia adelante y hacia atrás.
// Inserción: O(1).

class NodoHistorial {
    Operacion dato;
    NodoHistorial sig, ant;

    NodoHistorial(Operacion dato) {
        this.dato = dato;
        this.sig = null;
        this.ant = null;
    }
}

// Clase principal
// Integra arrays, listas enlazadas y programación estructurada.
// Menú principal con while + switch.

public class Biblioteca {
 
    static final int MAX_LIBROS = 100;  // tamaño fijo de catálogo
    static final int NUM_SUCURSALES = 3;  // matriz disponibilidad

    static Libro[] catalogo = new Libro[MAX_LIBROS]; // array 1D
    static int[][] disponibilidad = new int[MAX_LIBROS][NUM_SUCURSALES];  // matriz 2D
    static int numLibros = 0;

    // Listas dinámicas

    static NodoPrestamo prestamosActivos = null;   // lista simple
    static NodoHistorial historial = null;        // lista doble

    static Scanner sc = new Scanner(System.in);

 // Métodos de catálogo (array)

 // Alta de libro: inserción en array si hay espacio.

    static void cargarLibro() {
        if (numLibros >= MAX_LIBROS) { 
            System.out.println("No hay espacio para más libros.");
            return;
        }
        System.out.print("Código: ");
        int codigo = sc.nextInt(); sc.nextLine();
        System.out.print("Título: ");
        String titulo = sc.nextLine();
        System.out.print("Autor: ");
        String autor = sc.nextLine();
        System.out.print("Stock: ");
        int stock = sc.nextInt();

        catalogo[numLibros] = new Libro(codigo, titulo, autor, stock);
        numLibros++;

        agregarHistorial("ALTA", "Libro " + titulo + " agregado");
    }

     // Baja lógica: no se elimina físicamente, solo se marca inactivo.

    static void eliminarLibro() {
        System.out.print("Código a eliminar: ");
        int codigo = sc.nextInt();
        for (int i = 0; i < numLibros; i++) {
            if (catalogo[i] != null && catalogo[i].codigo == codigo && catalogo[i].activo) {
                catalogo[i].activo = false; // baja lógica
                agregarHistorial("BAJA", "Libro código " + codigo + " dado de baja");
                System.out.println("Libro eliminado.");
                return;
            }
        }
        System.out.println("Libro no encontrado.");
    }

  // Búsqueda lineal por título

    static void buscarLibroPorTitulo() {
        System.out.print("Título: ");
        sc.nextLine();
        String titulo = sc.nextLine();
        for (int i = 0; i < numLibros; i++) {
            if (catalogo[i] != null && catalogo[i].titulo.equalsIgnoreCase(titulo) && catalogo[i].activo) {
                System.out.println("Encontrado: " + catalogo[i].titulo + " (Stock: " + catalogo[i].stock + ")");
                return;
            }
        }
        System.out.println("No encontrado.");
    }

   // Métodos de préstamos 

    static void prestarLibro() {
        System.out.print("Usuario: ");
        sc.nextLine();
        String usuario = sc.nextLine();
        System.out.print("Código libro: ");
        int codigo = sc.nextInt();

        Libro libro = null;
        for (int i = 0; i < numLibros; i++) {
            if (catalogo[i] != null && catalogo[i].codigo == codigo && catalogo[i].activo) {
                libro = catalogo[i];
                break;
            }
        }
        if (libro == null) {
            System.out.println("Libro no encontrado.");
            return;
        }
        if (libro.stock <= 0) {
            System.out.println("No hay stock disponible.");
            return;
        }

        libro.stock--; // actualizar stock
        Prestamo p = new Prestamo(codigo, usuario);
        NodoPrestamo nuevo = new NodoPrestamo(p);
        nuevo.sig = prestamosActivos;
        prestamosActivos = nuevo;

        agregarHistorial("PRESTAMO", "Usuario " + usuario + " prestó libro " + codigo);
        System.out.println("Préstamo realizado.");
    }

    static void devolverLibro() {
        System.out.print("Código libro a devolver: ");
        int codigo = sc.nextInt();
        NodoPrestamo actual = prestamosActivos, anterior = null;

        while (actual != null) {
            if (actual.dato.codigoLibro == codigo && !actual.dato.devuelto) {
                actual.dato.devuelto = true;

                // devolver libro al catálogo
                for (int i = 0; i < numLibros; i++) {
                    if (catalogo[i] != null && catalogo[i].codigo == codigo) {
                        catalogo[i].stock++;
                        break;
                    }
                }
           
                // quitar nodo de la lista

                if (anterior == null) prestamosActivos = actual.sig;
                else anterior.sig = actual.sig;

                agregarHistorial("DEVOLUCION", "Libro " + codigo + " devuelto");
                System.out.println("Devolución registrada.");
                return;
            }
            anterior = actual;
            actual = actual.sig;
        }
        System.out.println("Préstamo no encontrado.");
    }

    static void listarPrestamos() {
        NodoPrestamo actual = prestamosActivos;
        while (actual != null) {
            if (!actual.dato.devuelto) {
                System.out.println("Usuario: " + actual.dato.usuario + ", Libro: " + actual.dato.codigoLibro);
            }
            actual = actual.sig;
        }
    }

    // Métodos de historial

    static void agregarHistorial(String tipo, String detalle) {
        Operacion op = new Operacion(tipo, detalle);
        NodoHistorial nuevo = new NodoHistorial(op);

        if (historial == null) {
            historial = nuevo;
        } else {
            historial.sig = nuevo;
            nuevo.ant = historial;
            historial = nuevo;
        }
    }

    static void listarHistorialAdelante() {
        NodoHistorial actual = historial;
        if (actual == null) {
            System.out.println("Historial vacío.");
            return;
        }
        while (actual.ant != null) actual = actual.ant;  
        while (actual != null) {
            System.out.println(actual.dato.tipo + " - " + actual.dato.detalle + " (" + actual.dato.fechaHora + ")");
            actual = actual.sig;
        }
    }


    static void listarHistorialAtras() {
        NodoHistorial actual = historial;
        if (actual == null) {
            System.out.println("Historial vacío.");
            return;
        }
        while (actual != null) {
            System.out.println(actual.dato.tipo + " - " + actual.dato.detalle + " (" + actual.dato.fechaHora + ")");
            actual = actual.ant;
        }
    }

             // Menú principal
             // Usa while + switch → programación estructurada.
    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== Biblioteca =====");
            System.out.println("1. Alta libro");
            System.out.println("2. Baja libro");
            System.out.println("3. Buscar libro por título");
            System.out.println("4. Prestar libro");
            System.out.println("5. Devolver libro");
            System.out.println("6. Listar préstamos");
            System.out.println("7. Ver historial adelante");
            System.out.println("8. Ver historial atrás");
            System.out.println("9. Salir");
            System.out.print("Opción: ");

            int opcion = sc.nextInt();
            switch (opcion) {
                case 1 -> cargarLibro();
                case 2 -> eliminarLibro();
                case 3 -> buscarLibroPorTitulo();
                case 4 -> prestarLibro();
                case 5 -> devolverLibro();
                case 6 -> listarPrestamos();
                case 7 -> listarHistorialAdelante();
                case 8 -> listarHistorialAtras();
                case 9 -> System.exit(0);
                default -> System.out.println("Opción inválida");
            }
        }
    }
}
