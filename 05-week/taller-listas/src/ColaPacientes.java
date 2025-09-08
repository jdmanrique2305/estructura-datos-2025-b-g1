public class ColaPacientes {
    private Paciente frente; // primero en la cola
    private Paciente fin;    // último en la cola

    public ColaPacientes() {
        frente = null;
        fin = null;
    }

    // Ingresar paciente (al final de la cola)
    public void ingresarPaciente(String nombre) {
        Paciente nuevo = new Paciente(nombre);
        if (frente == null) {
            frente = fin = nuevo;
        } else {
            fin.siguiente = nuevo;
            fin = nuevo;
        }
        System.out.println("Paciente ingresado: " + nombre);
    }

    // Atender paciente (eliminar al inicio)
    public void atenderPaciente() {
        if (frente == null) {
            System.out.println("No hay pacientes en espera.");
            return;
        }
        System.out.println("Atendiendo paciente: " + frente.nombre);
        frente = frente.siguiente;
        if (frente == null) {
            fin = null; // cola quedó vacía
        }
    }

    // Mostrar lista de espera
    public void mostrarCola() {
        if (frente == null) {
            System.out.println("La sala de espera está vacía.");
            return;
        }
        Paciente temp = frente;
        System.out.print("Lista de espera: ");
        while (temp != null) {
            System.out.print(temp.nombre + " -> ");
            temp = temp.siguiente;
        }
        System.out.println("FIN");
    }
}
