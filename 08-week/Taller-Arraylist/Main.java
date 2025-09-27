import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Object> figuras = new ArrayList<>();

        // Agregar al menos dos objetos de cada clase
        figuras.add(new Circulo(4, "Verde"));
       

        figuras.add(new Rectangulo(6, 9, "Rojo"));
       

        figuras.add(new Triangulo(3, 4, 5, "Naranja"));
        

        // Recorrer e imprimir información
        for (Object f : figuras) {
            if (f instanceof Circulo) {
                ((Circulo) f).mostrarInformacion();
            } else if (f instanceof Rectangulo) {
                ((Rectangulo) f).mostrarInformacion();
            } else if (f instanceof Triangulo) {
                ((Triangulo) f).mostrarInformacion();
            }
        }
    }
}
