public class Colisiones {
    
    static class ClaveColision {
        private String valor;
        private int hashForzado;

        public ClaveColision(String valor, int hashForzado) {
            this.valor = valor;
            this.hashForzado = hashForzado;
        }

       
        public int hashCode() {
            return hashForzado;

        }

        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            ClaveColision that = (ClaveColision) obj;
            return valor.equals(that.valor);
        }

        public String toString() {
            return valor + "(hash=" + hashForzado + ")";
        }
    }

    public void ejecutar() {
        System.out.println("PRUEBA DE COLISIONES CONTROLADAS");

        HashTable<ClaveColision, String> tabla = new HashTable<>(4);
        
        ClaveColision clave1 = new ClaveColision("clave1", 1);
        ClaveColision clave2 = new ClaveColision("clave2", 1);
        ClaveColision clave3 = new ClaveColision("clave3", 2);
        ClaveColision clave4 = new ClaveColision("clave4", 1);

        System.out.println("Capacidad de la tabla: " + tabla.getCapacity());
        
        System.out.println("\nInsertando elementos...");
        tabla.put(clave1, "valor1");
        System.out.println("Insertada: " + clave1 + " -> valor1");
        
        tabla.put(clave2, "valor2");
        System.out.println("Insertada: " + clave2 + " -> valor2 (COLISIÓN con clave1)");
        
        tabla.put(clave3, "valor3");
        System.out.println("Insertada: " + clave3 + " -> valor3");
        
        tabla.put(clave4, "valor4");
        System.out.println("Insertada: " + clave4 + " -> valor4 (COLISIÓN con clave1 y clave2)");
        
        System.out.println("\nESTADO DE LA TABLA ");
        tabla.display();
        
        System.out.println("\nPRUEBAS DE BÚSQUEDA");
        System.out.println("Buscando clave1: " + tabla.get(clave1));
        System.out.println("Buscando clave2: " + tabla.get(clave2));
        System.out.println("Buscando clave3: " + tabla.get(clave3));
        System.out.println("Buscando clave4: " + tabla.get(clave4));
        
        System.out.println("\nELIMINACIÓN EN CADENA DE COLISIONES");
        System.out.println("Eliminando clave2: " + tabla.remove(clave2));
        System.out.println("Estado después de eliminar clave2:");
        tabla.display();
        
        System.out.println("\nTamaño final de la tabla: " + tabla.size());
    }

    public static void main(String[] args) {
        new Colisiones().ejecutar();
    }
}