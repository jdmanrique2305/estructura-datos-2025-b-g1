public class Ejercicio3_Temperaturas {
    public static void main(String[] args) {
       String datos = "23.5,25.0,22.8,21.4,24.1,26.3,20.0";
       String[] partes = datos.split(",");
       double[] temperaturas = new double[partes.length];

       for (int i = 0; i < partes.length; i++) {
           temperaturas[i] = Double.parseDouble(partes[i]);
       }

       double suma = 0;
       double max = temperaturas[0];
       double min = temperaturas[0];

       for (double temp : temperaturas) {
           suma += temp;
           if (temp > max) max = temp;
           if (temp < min) min = temp;
       }

       double promedio = suma / temperaturas.length;

       double sumaVar=0;
       for (double temp : temperaturas) {
           sumaVar += Math.pow(temp - promedio, 2);
       }
       double varianza = sumaVar / temperaturas.length;
       double desviacionEstandar = Math.sqrt(varianza);

       System.out.println("Temperaturas: "+ datos);
       System.out.println("minimo: " + min);
       System.out.println("Máxima: " + max);
       System.out.println("Promedio: " + promedio);
       System.out.println("Desviación Estándar: " + desviacionEstandar);
    }
}
