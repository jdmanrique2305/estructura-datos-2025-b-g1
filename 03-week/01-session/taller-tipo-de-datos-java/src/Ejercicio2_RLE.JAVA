public class Ejercicio2_RLE {
    public static void main(String[] args) {
        String input = "aaaaabbccccd";

    String compressed = compress(input);
    double ratio = (input.isEmpty()) ? 0 : (double) compressed.length() / input.length();
    
        System.out.println("Original: " + input);
        System.out.println("Comprimido: " + compressed);
        System.out.println("Ratio: " + ratio);


    }  

    public static String compress(String s) {
        if (s.isEmpty()) return "";

        StringBuilder sb = new StringBuilder();
        int count = 1;

        for (int i = 1; i <= s.length(); i++) {
            if (i < s.length() && s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } 
            else {
                sb.append(s.charAt(i - 1)).append(count);
                count = 1;
            }
        }
        return sb.toString();
    }
}