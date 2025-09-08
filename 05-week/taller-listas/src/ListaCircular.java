public class ListaCircular {
    private NodoCircular cabeza;
    private NodoCircular cola;

    public ListaCircular() {
        cabeza = null;
        cola = null;
    }

    // Insertar al final
    public void insertarFinal(int valor) {
        NodoCircular nuevo = new NodoCircular(valor);
        if (cabeza == null) {
            cabeza = nuevo;
            cola = nuevo;
            cola.siguiente = cabeza; // se apunta a sí mismo
        } else {
            cola.siguiente = nuevo;
            nuevo.siguiente = cabeza;
            cola = nuevo;
        }
    }

    // Insertar en una posición específica
    public void insertarPosicion(int valor, int pos) {
        NodoCircular nuevo = new NodoCircular(valor);

        // Caso 1: lista vacía
        if (cabeza == null) {
            cabeza = nuevo;
            cola = nuevo;
            cola.siguiente = cabeza;
            return;
        }

        // Caso 2: insertar al inicio
        if (pos <= 0) {
            nuevo.siguiente = cabeza;
            cabeza = nuevo;
            cola.siguiente = cabeza;
            return;
        }

        NodoCircular temp = cabeza;
        int contador = 0;

        // Avanzar hasta el nodo anterior
        while (contador < pos - 1 && temp.siguiente != cabeza) {
            temp = temp.siguiente;
            contador++;
        }

        nuevo.siguiente = temp.siguiente;
        temp.siguiente = nuevo;

        // Si insertamos después de la cola, actualizar cola
        if (temp == cola) {
            cola = nuevo;
        }
    }

    // Eliminar en una posición específica
    public void eliminarPosicion(int pos) {
        if (cabeza == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        // Caso 1: eliminar la cabeza
        if (pos == 0) {
            System.out.println("Eliminado: " + cabeza.dato);
            if (cabeza == cola) { // solo un nodo
                cabeza = cola = null;
            } else {
                cabeza = cabeza.siguiente;
                cola.siguiente = cabeza;
            }
            return;
        }

        NodoCircular temp = cabeza;
        int contador = 0;

        // Avanzar hasta el nodo anterior
        while (contador < pos - 1 && temp.siguiente != cabeza) {
            temp = temp.siguiente;
            contador++;
        }

        // Si la posición es inválida
        if (temp.siguiente == cabeza) {
            System.out.println("Posición inválida.");
            return;
        }

        System.out.println("Eliminado: " + temp.siguiente.dato);
        if (temp.siguiente == cola) {
            cola = temp;
        }
        temp.siguiente = temp.siguiente.siguiente;
    }

    // Mostrar lista
    public void mostrarLista() {
        if (cabeza == null) {
            System.out.println("La lista está vacía.");
            return;
        }
        NodoCircular temp = cabeza;
        do {
            System.out.print(temp.dato + " -> ");
            temp = temp.siguiente;
        } while (temp != cabeza);
        System.out.println("(regresa a " + cabeza.dato + ")");
    }
}
