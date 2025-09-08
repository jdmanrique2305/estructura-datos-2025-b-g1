public class ejercicio3 {
    public static void main(String[] args) {
        ListaSimple lista = new ListaSimple();

        // Insertamos elementos
        lista.insertarFinal(10);
        lista.insertarFinal(20);
        lista.insertarFinal(30);
        lista.insertarFinal(40);
        lista.insertarFinal(50);

        System.out.println("Lista inicial:");
        lista.mostrarLista();  // 10 -> 20 -> 30 -> 40 -> 50 -> null

        // Eliminar en diferentes posiciones
        lista.eliminarPosicion(0);  // Elimina el primero (10)
        lista.eliminarPosicion(2);  // Elimina el que está en la posición 2 (40)
        lista.eliminarPosicion(10); // Posición inválida

        System.out.println("\nLista después de eliminaciones:");
        lista.mostrarLista();  // 20 -> 30 -> 50 -> null
    }
}
