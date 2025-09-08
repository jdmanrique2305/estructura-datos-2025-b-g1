public class ListaSimple {
    private Nodo cabeza;

    public ListaSimple() {
        cabeza = null;
    }

    // Insertar al inicio
    public void insertarInicio(int valor) {
        Nodo nuevo = new Nodo(valor);
        nuevo.siguiente = cabeza;
        cabeza = nuevo;
    }

    // Insertar al final
    public void insertarFinal(int valor) {
        Nodo nuevo = new Nodo(valor);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo temp = cabeza;
            while (temp.siguiente != null) {
                temp = temp.siguiente;
            }
            temp.siguiente = nuevo;
        }
    }

    // 🔹 Insertar en una posición específica (PASO 1)
    public void insertarPosicion(int valor, int pos) {
        Nodo nuevo = new Nodo(valor);

        // Caso 1: al inicio
        if (pos <= 0 || cabeza == null) {
            nuevo.siguiente = cabeza;
            cabeza = nuevo;
            return;
        }

        Nodo temp = cabeza;
        int contador = 0;

        // Moverse hasta la posición anterior
        while (temp != null && contador < pos - 1) {
            temp = temp.siguiente;
            contador++;
        }

        // Caso 2: si la posición es mayor que el tamaño → insertar al final
        if (temp == null) {
            System.out.println("Posición fuera de rango, se inserta al final.");
            insertarFinal(valor);
            return;
        }

        // Caso 3: insertar en medio
        nuevo.siguiente = temp.siguiente;
        temp.siguiente = nuevo;
    }

    // Mostrar lista
    public void mostrarLista() {
        Nodo temp = cabeza;
        if (temp == null) {
            System.out.println("La lista está vacía.");
            return;
        }
        while (temp != null) {
            System.out.print(temp.dato + " -> ");
            temp = temp.siguiente;
        }
        System.out.println("null");
    }


public void eliminarPosicion(int pos) {
    if (cabeza == null) {
        System.out.println("La lista está vacía, no se puede eliminar.");
        return;
    }

    // Caso 1: eliminar la cabeza
    if (pos == 0) {
        System.out.println("Eliminado: " + cabeza.dato);
        cabeza = cabeza.siguiente;
        return;
    }

    Nodo temp = cabeza;
    int contador = 0;

    // Avanzar hasta el nodo anterior al que queremos eliminar
    while (temp != null && contador < pos - 1) {
        temp = temp.siguiente;
        contador++;
    }

    // Caso 2: la posición no existe
    if (temp == null || temp.siguiente == null) {
        System.out.println("Posición inválida, no se pudo eliminar.");
        return;
    }

    // Caso 3: eliminar en medio o al final
    System.out.println("Eliminado: " + temp.siguiente.dato);
    temp.siguiente = temp.siguiente.siguiente;
}

}