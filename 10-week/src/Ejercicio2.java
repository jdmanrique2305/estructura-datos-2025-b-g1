public class Ejercicio2 {
    public static void main(String[] args) {
        HashTable<String, Integer> contador = new HashTable<>();
        String texto = "java es divertido y java es poderoso";

        for (String palabra : texto.split(" ")) {
            Integer actual = contador.get(palabra);
            if (actual == null) actual = 0;
            contador.put(palabra, actual + 1);
        }

        contador.printTable();
    }
}
