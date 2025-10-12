import java.util.Scanner;

public class ContadorDePalabras {
    private HashTable<String, Integer> contador;

    public ContadorDePalabras() {
        contador = new HashTable<>();
    }

    public void contarDePalabras(String texto) {
        if (texto == null || texto.trim().isEmpty()) {
            System.out.println("Texto vacío");
            return;
        }

        String[] palabras = texto.toLowerCase()
                                .replaceAll("[^a-zA-Záéíóúüñ\\s]", "")
                                .split("\\s+");

        for (String palabra : palabras) {
            if (!palabra.isEmpty()) {
                Integer count = contador.get(palabra);
                if (count == null) {
                    contador.put(palabra, 1);
                } else {
                    contador.put(palabra, count + 1);
                }
            }
        }
    }

    public void mostrarConteo() {
        System.out.println("\n=== CONTEO DE PALABRAS ===");
        System.out.println("Total de palabras únicas: " + contador.size());
        
        // Nota: Para mostrar todas las palabras necesitaríamos un método iterator
        System.out.println("Para mostrar el conteo completo se requiere implementación adicional");
    }

    public void buscarPalabra(String palabra) {
        Integer count = contador.get(palabra.toLowerCase());
        if (count != null) {
            System.out.println("Palabra: '" + palabra + "' → Ocurrencias: " + count);
        } else {
            System.out.println("Palabra '" + palabra + "' no encontrada");
        }
    }

    public void ejecutar() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== CONTADOR DE PALABRAS ===");
        System.out.println("Ingrese el texto a analizar:");
        String texto = scanner.nextLine();
        
        contarDePalabras(texto);
        mostrarConteo();
        
        System.out.println("\n--- Búsqueda individual ---");
        System.out.print("Ingrese palabra a buscar (o 'salir' para terminar): ");
        String palabra = scanner.nextLine();
        
        while (!palabra.equalsIgnoreCase("salir")) {
            buscarPalabra(palabra);
            System.out.print("Ingrese otra palabra (o 'salir'): ");
            palabra = scanner.nextLine();
        }
        
        scanner.close();
    }

    public static void main(String[] args) {
        new ContadorDePalabras().ejecutar();
    }
}

