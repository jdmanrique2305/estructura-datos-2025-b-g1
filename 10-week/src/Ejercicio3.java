public class Ejercicio3 {
    public static void main(String[] args) {
        HashTable<Integer, String> tabla = new HashTable<>();

        // Forzamos colisiones con números que producen mismo índice
        tabla.put(10, "A");
        tabla.put(20, "B");
        tabla.put(30, "C");

        tabla.printTable();
    }
}
