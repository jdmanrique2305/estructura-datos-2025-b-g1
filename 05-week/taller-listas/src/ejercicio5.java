public class ejercicio5 {
    public static void main(String[] args) {
        ListaCircular lista = new ListaCircular();

        lista.insertarFinal(10);
        lista.insertarFinal(20);
        lista.insertarFinal(30);
        lista.insertarFinal(40);

        System.out.println("Lista inicial:");
        lista.mostrarLista(); // 10 -> 20 -> 30 -> 40 -> (regresa a 10)

        lista.insertarPosicion(5, 0);   // al inicio
        lista.insertarPosicion(25, 3);  // en medio
        lista.insertarPosicion(50, 10); // más allá del tamaño, se inserta al final

        System.out.println("\nDespués de inserciones:");
        lista.mostrarLista();

        lista.eliminarPosicion(0); // eliminar cabeza
        lista.eliminarPosicion(2); // eliminar en medio
        lista.eliminarPosicion(10); // posición inválida

        System.out.println("\nDespués de eliminaciones:");
        lista.mostrarLista();
    }
}
