public class Rectangulo {
    private double base;
    private double altura;
    private String color;

    public Rectangulo(double base, double altura, String color) {
        this.base = base;
        this.altura = altura;
        this.color = color;
    }

    public double calcularArea() {
        return base * altura;
    }

    public double calcularPerimetro() {
        return 2 * (base + altura);
    }

    public void mostrarInformacion() {
        System.out.println("Rectángulo -> base: " + base + ", altura: " + altura +
                ", color: " + color +
                ", área: " + calcularArea() +
                ", perímetro: " + calcularPerimetro());
    }
}
