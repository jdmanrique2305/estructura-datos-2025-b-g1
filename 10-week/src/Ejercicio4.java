public class Ejercicio4 {
    public static void main(String[] args) {
        HashTable<String, Integer> tabla = new HashTable<>();

        tabla.put("uno", 1);
        tabla.put("dos", 2);
        tabla.put("tres", 3);
        tabla.put("cuatro", 4);

        System.out.println("Tamaño actual: " + tabla.size());
        System.out.println("¿Está vacía? " + tabla.isEmpty());
        tabla.printTable();
    }
}
