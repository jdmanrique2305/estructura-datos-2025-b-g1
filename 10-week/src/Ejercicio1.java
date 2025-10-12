import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        HashTable<String, String> usuarios = new HashTable<>();
        int opcion;

        try (Scanner sc = new Scanner(System.in)) {
            do {
                System.out.println("\n Diccionario Usuario");
                System.out.println("1. Agregar usuario");
                System.out.println("2. Consultar rol");
                System.out.println("3. Eliminar usuario");
                System.out.println("4. Mostrar tabla");
                System.out.println("0. Salir");
                System.out.print("Opción: ");
                opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.print("Usuario: ");
                        String user = sc.nextLine();
                        System.out.print("Rol: ");
                        String rol = sc.nextLine();
                        usuarios.put(user, rol);
                        System.out.println("Usuario agregado.");
                        break;
                    case 2:
                        System.out.print("Usuario: ");
                        user = sc.nextLine();
                        String valor = usuarios.get(user);
                        System.out.println(valor != null ? "Rol: " + valor : "No existe ese usuario.");
                        break;
                    case 3:
                        System.out.print("Usuario: ");
                        user = sc.nextLine();
                        usuarios.remove(user);
                        System.out.println("Usuario eliminado si existía.");
                        break;
                    case 4:
                        usuarios.printTable();
                        break;
                }
            } while (opcion != 0);
        }
    }
}
