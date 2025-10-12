public class PruebaTamaño {

    public void ejecutar() {
        System.out.println("PRUEBA DE TAMAÑO Y REDIMENSIONAMIENTO");
        
        HashTable<String, Integer> tabla = new HashTable<>(8);
        System.out.println("Capacidad inicial: " + tabla.getCapacity());
        System.out.println("Tamaño inicial: " + tabla.size());
        System.out.println("¿Está vacía? " + tabla.isEmpty());
        
        System.out.println("\nInsertando elementos...");
        int elementosAInsertar = 20;
        
        for (int i = 1; i <= elementosAInsertar; i++) {
            String clave = "clave" + i;
            tabla.put(clave, i * 10);
            
            if (i % 5 == 0) {
                System.out.println("Después de insertar " + i + " elementos:");
                System.out.println(" - Tamaño: " + tabla.size());
                System.out.println(" - Capacidad: " + tabla.getCapacity());
                System.out.println(" - Factor de carga: " + 
                    String.format("%.2f", (double) tabla.size() / tabla.getCapacity()));
            }
        }
        
        System.out.println("\nESTADO FINAL");
        System.out.println("Tamaño final: " + tabla.size());
        System.out.println("Capacidad final: " + tabla.getCapacity());
        System.out.println("¿Está vacía? " + tabla.isEmpty());
        
        System.out.println("\nVERIFICACIÓN DE ELEMENTOS");
        int elementosEncontrados = 0;
        for (int i = 1; i <= elementosAInsertar; i++) {
            if (tabla.containsKey("clave" + i)) {
                elementosEncontrados++;
            }
        }
        System.out.println("Elementos insertados: " + elementosAInsertar);
        System.out.println("Elementos encontrados: " + elementosEncontrados);
        System.out.println("Verificación exitosa: " + (elementosAInsertar == elementosEncontrados));
        
        System.out.println("\nPRUEBA DE ELIMINACIÓN");
        int elementosAEliminar = 5;
        for (int i = 1; i <= elementosAEliminar; i++) {
            tabla.remove("clave" + i);
        }
        System.out.println("Después de eliminar " + elementosAEliminar + " elementos:");
        System.out.println(" - Tamaño: " + tabla.size());
        System.out.println(" - ¿Está vacía? " + tabla.isEmpty());
    }

    public static void main(String[] args) {
        new PruebaTamaño().ejecutar();
    }
}