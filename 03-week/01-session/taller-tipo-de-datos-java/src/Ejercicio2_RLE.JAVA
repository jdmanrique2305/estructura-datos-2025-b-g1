public class Ejercicio2_RLE
 public static void main(String[] args) {
    String input = "aaabbccccd";

    String compressed = compress(input);
    double ratio = (input.isEmpty()) ? 0 : (double) compressed.length() / input.length();
    
        System.out.println("Original: " + input);
        System.out.println("Comprimido: " + compressed);
        System.out.println("Ratio: " + ratio);

}    