import java.util.Scanner;

public class DiccionarioSimple {
    private HashTable<String, String> diccionario;

    public DiccionarioSimple() {
        diccionario = new HashTable<>();
    }

    public void ejecutar() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nDICCIONARIO USUARIO");
            System.out.println("1. Agregar usuario");
            System.out.println("2. Consultar usuario");
            System.out.println("3. Eliminar usuario");
            System.out.println("4. Mostrar todos");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            
            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    agregarUsuario(scanner);
                    break;
                case 2:
                    consultarUsuario(scanner);
                    break;
                case 3:
                    eliminarUsuario(scanner);
                    break;
                case 4:
                    mostrarTodos();
                    break;
                case 5:
                    System.out.println("Saliendo");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        } while (opcion != 5);
        
        scanner.close();
    }

    private void agregarUsuario(Scanner scanner) {
        System.out.print("Ingrese nombre de usuario: ");
        String usuario = scanner.nextLine();
        System.out.print("Ingrese rol: ");
        String rol = scanner.nextLine();
        
        String resultado = diccionario.put(usuario, rol);
        if (resultado == null) {
            System.out.println("Usuario agregado correctamente");
        } else {
            System.out.println("Usuario actualizado. Rol anterior: " + resultado);
        }
    }

    private void consultarUsuario(Scanner scanner) {
        System.out.print("Ingrese nombre de usuario a consultar: ");
        String usuario = scanner.nextLine();
        
        String rol = diccionario.get(usuario);
        if (rol != null) {
            System.out.println("Usuario: " + usuario + " → Rol: " + rol);
        } else {
            System.out.println("Usuario no encontrado");
        }
    }

    private void eliminarUsuario(Scanner scanner) {
        System.out.print("Ingrese nombre de usuario a eliminar: ");
        String usuario = scanner.nextLine();
        
        String rolEliminado = diccionario.remove(usuario);
        if (rolEliminado != null) {
            System.out.println("Usuario eliminado. Rol: " + rolEliminado);
        } else {
            System.out.println("Usuario no encontrado");
        }
    }

    private void mostrarTodos() {
        System.out.println("Total de usuarios: " + diccionario.size());
        System.out.println("Funcionalidad de mostrar todos requiere implementación adicional");
    }

    public static void main(String[] args) {
        new DiccionarioSimple().ejecutar();
    }
}