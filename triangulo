import java.util.Scanner;

class Triangulo {
    private double lado1;
    private double lado2;
    private double lado3;

    public Triangulo(double lado1, double lado2, double lado3) {
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
    }

    public double getLado1() {
        return lado1;
    }

    public void setLado1(double lado1) {
        this.lado1 = lado1;
    }

    public double getLado2() {
        return lado2;
    }

    public void setLado2(double lado2) {
        this.lado2 = lado2;
    }

    public double getLado3() {
        return lado3;
    }

    public void setLado3(double lado3) {
        this.lado3 = lado3;
    }

    public String verificarTipo() {
        double[] lados = {lado1, lado2, lado3};
        int distintos = (lado1 != lado2 ? 1 : 0) + (lado1 != lado3 && lado2 != lado3 ? 1 : 0);
        
        if (distintos == 0) {
            return "Equilátero";
        } else if (distintos == 1) {
            return "Isósceles";
        } else {
            return "Escaleno";
        }
    }

    public double calcularPerimetro() {
        return lado1 + lado2 + lado3;
    }

    public double calcularArea() {
        double semiPerimetro = calcularPerimetro() / 2;
        return Math.sqrt(semiPerimetro * (semiPerimetro - lado1) * (semiPerimetro - lado2) * (semiPerimetro - lado3));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Digite o comprimento do lado 1: ");
        double lado1 = scanner.nextDouble();

        System.out.println("Digite o comprimento do lado 2: ");
        double lado2 = scanner.nextDouble();

        System.out.println("Digite o comprimento do lado 3: ");
        double lado3 = scanner.nextDouble();

        Triangulo triangulo = new Triangulo(lado1, lado2, lado3);
        
        System.out.println("Tipo de triângulo: " + triangulo.verificarTipo());
        System.out.println("Perímetro do triângulo: " + triangulo.calcularPerimetro());
        System.out.println("Área do triângulo: " + triangulo.calcularArea());

        scanner.close();
    }
}
