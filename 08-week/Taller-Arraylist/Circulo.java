public class Circulo {
    private double radio;
    private String color;

    public Circulo(double radio, String color) {
        this.radio = radio;
        this.color = color;
    }

    public double calcularArea() {
        return Math.PI * radio * radio;
    }

    public double calcularPerimetro() {
        return 2 * Math.PI * radio;
    }

    public void mostrarInformacion() {
        System.out.println("Círculo -> radio: " + radio + ", color: " + color +
                ", área: " + calcularArea() +
                ", perímetro: " + calcularPerimetro());
    }
}
