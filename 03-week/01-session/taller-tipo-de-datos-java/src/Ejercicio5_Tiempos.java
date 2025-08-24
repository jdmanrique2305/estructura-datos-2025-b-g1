public class Ejercicio5_Tiempos {

    private static int aSegundos(String t) {
        String[] partes = t.split(":");
        int h = Integer.parseInt(partes[0]);
        int m = Integer.parseInt(partes[1]);
        int s = Integer.parseInt(partes[2]);
        return h * 3600 + m * 60 + s;
    }
    private static String aHHMMSS(int segs) {
        int h = segs / 3600;
        int m = (segs % 3600) / 60;
        int s = segs % 60;
        return String.format("%02d:%02d:%02d", h, m, s);
    }

    public static void main(String[] args) {
        String[] tiempos = {"00:05:33", "00:12:17", "00:03:50"};

        int[] segs = new int[tiempos.length];
        int total = 0;
        for (int i = 0; i < tiempos.length; i++) {
            segs[i] = aSegundos(tiempos[i]);
            total += segs[i];
        }

        System.out.println("Tiempo total: " + aHHMMSS(total));

        int promedio = total / tiempos.length;
        System.out.println("Promedio: " + aHHMMSS(promedio));

        int max = segs[0], idxMax = 0;
        for (int i = 1; i < segs.length; i++) {
            if (segs[i] > max) {
                max = segs[i];
                idxMax = i;
            }
        }
        System.out.println("Tramo más largo: " + aHHMMSS(max) + " (índice " + idxMax + ")");

        System.out.println("Porcentajes:");
        for (int i = 0; i < segs.length; i++) {
            double p = (total == 0) ? 0 : (segs[i] * 100.0) / total;
            System.out.printf("  Tramo %d: %.2f%%\n", i, p);
        }
    }
}
