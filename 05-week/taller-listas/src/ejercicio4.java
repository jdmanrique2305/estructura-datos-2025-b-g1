public class ejercicio4 {
    public static void main(String[] args) {
        ListaDoble lista = new ListaDoble();

        lista.insertarFinal(10);
        lista.insertarFinal(20);
        lista.insertarFinal(30);
        lista.insertarInicio(5);

        System.out.println("Lista hacia adelante:");
        lista.mostrarAdelante();

        System.out.println("Lista hacia atrás:");
        lista.mostrarAtras();

        lista.eliminarInicio();
        lista.eliminarFinal();

        System.out.println("\nLista después de eliminaciones:");
        lista.mostrarAdelante();
    }
}

