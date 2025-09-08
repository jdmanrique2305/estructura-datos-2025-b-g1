public class Ejercicio2 {
    public static void main(String[] args) {
        ListaSimple lista = new ListaSimple();

        lista.insertarFinal(10);
        lista.insertarFinal(20);
        lista.insertarFinal(30);
        lista.insertarFinal(40);

        System.out.println("Lista inicial:");
        lista.mostrarLista(); // 10 -> 20 -> 30 -> 40 -> null

        // Insertar en posición específica
        lista.insertarPosicion(15, 1); // después de 10
        lista.insertarPosicion(25, 3); // después de 20 y 15
        lista.insertarPosicion(5, 0);  // al inicio
        lista.insertarPosicion(50, 10); // fuera de rango, se pone al final

        System.out.println("\nLista después de inserciones:");
        lista.mostrarLista();
        // Esperado: 5 -> 10 -> 15 -> 20 -> 25 -> 30 -> 40 -> 50 -> null
    }
}
