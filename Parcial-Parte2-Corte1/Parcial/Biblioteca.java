import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;


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


class NodoPrestamo {
    Prestamo dato;
    NodoPrestamo sig;

    NodoPrestamo(Prestamo dato) {
        this.dato = dato;
        this.sig = null;
    }
}


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


class NodoHistorial {
    Operacion dato;
    NodoHistorial sig, ant;

    NodoHistorial(Operacion dato) {
        this.dato = dato;
        this.sig = null;
        this.ant = null;
    }
}


public class Biblioteca {
 
    static final int MAX_LIBROS = 100;
    static final int NUM_SUCURSALES = 3;

    static Libro[] catalogo = new Libro[MAX_LIBROS];
    static int[][] disponibilidad = new int[MAX_LIBROS][NUM_SUCURSALES];
    static int numLibros = 0;

   
    static NodoPrestamo prestamosActivos = null;  
    static NodoHistorial historial = null;        

    static Scanner sc = new Scanner(System.in);


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

        libro.stock--;
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
               
                for (int i = 0; i < numLibros; i++) {
                    if (catalogo[i] != null && catalogo[i].codigo == codigo) {
                        catalogo[i].stock++;
                        break;
                    }
                }
           
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
