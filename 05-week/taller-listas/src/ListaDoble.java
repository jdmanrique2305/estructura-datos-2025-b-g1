public class ListaDoble {
    private NodoDoble cabeza;
    private NodoDoble cola;

    public ListaDoble() {
        cabeza = null;
        cola = null;
    }

    public void insertarInicio(int valor) {
        NodoDoble nuevo = new NodoDoble(valor);
        if (cabeza == null) {
            cabeza = cola = nuevo;
        } else {
            nuevo.siguiente = cabeza;
            cabeza.anterior = nuevo;
            cabeza = nuevo;
        }
    }

    public void insertarFinal(int valor) {
        NodoDoble nuevo = new NodoDoble(valor);
        if (cola == null) {
            cabeza = cola = nuevo;
        } else {
            cola.siguiente = nuevo;
            nuevo.anterior = cola;
            cola = nuevo;
        }
    }

    public void eliminarInicio() {
        if (cabeza == null) {
            System.out.println("La lista está vacía.");
            return;
        }
        System.out.println("Eliminado: " + cabeza.dato);
        if (cabeza == cola) {
            cabeza = cola = null;
        } else {
            cabeza = cabeza.siguiente;
            cabeza.anterior = null;
        }
    }

    public void eliminarFinal() {
        if (cola == null) {
            System.out.println("La lista está vacía.");
            return;
        }
        System.out.println("Eliminado: " + cola.dato);
        if (cabeza == cola) {
            cabeza = cola = null;
        } else {
            cola = cola.anterior;
            cola.siguiente = null;
        }
    }

    public void mostrarAdelante() {
        NodoDoble temp = cabeza;
        while (temp != null) {
            System.out.print(temp.dato + " <-> ");
            temp = temp.siguiente;
        }
        System.out.println("null");
    }

    public void mostrarAtras() {
        NodoDoble temp = cola;
        while (temp != null) {
            System.out.print(temp.dato + " <-> ");
            temp = temp.anterior;
        }
        System.out.println("null");
    }
}
