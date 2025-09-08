import java.util.Scanner;

public class ejercicio6 {
    public static void main(String[] args) {
        ColaPacientes cola = new ColaPacientes();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Consultorio Médico ---");
            System.out.println("1. Ingresar paciente");
            System.out.println("2. Atender paciente");
            System.out.println("3. Mostrar lista de espera");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del paciente: ");
                    String nombre = sc.nextLine();
                    cola.ingresarPaciente(nombre);
                    break;
                case 2:
                    cola.atenderPaciente();
                    break;
                case 3:
                    cola.mostrarCola();
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);

        sc.close();
    }
}
