import java.util.Scanner;

class Funcionario {
    private String nome;
    private int departamento;
    private double horasTrabalhadas;
    private static final double valorHoraAdministrativo = 22.00;
    private static final double valorHoraProducao = 12.00;
    private static final double insalubridadePercentual = 0.15;
    private static final double bonificacao20 = 0.03;
    private static final double bonificacao30 = 0.05;
    private static final double bonificacao40 = 0.10;
    private static final double inssPercentual = 0.07;
    private static final double impostoRendaPercentual = 0.12;
    private static final double planoSaude = 20.00;

    public Funcionario(String nome, int departamento, double horasTrabalhadas) {
        this.nome = nome;
        this.departamento = departamento;
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public double calcularSalarioBase() {
        if (departamento == 1) {
            return horasTrabalhadas * valorHoraAdministrativo;
        } else {
            return horasTrabalhadas * valorHoraProducao;
        }
    }

    public double calcularHoraExtra() {
        double horasAdicionais = Math.max(0, horasTrabalhadas - 160);
        return horasAdicionais * 2 * (departamento == 1 ? valorHoraAdministrativo : valorHoraProducao);
    }

    public double calcularInsalubridade() {
        if (departamento == 2) {
            return calcularSalarioBase() * insalubridadePercentual;
        }
        return 0;
    }

    public double calcularBonificacao() {
        double salarioBase = calcularSalarioBase();
        if (departamento == 1) {
            if (horasTrabalhadas >= 160) {
                return salarioBase * bonificacao40;
            } else if (horasTrabalhadas >= 120) {
                return salarioBase * bonificacao30;
            } else if (horasTrabalhadas >= 80) {
                return salarioBase * bonificacao20;
            }
        }
        return 0;
    }

    public double calcularINSS() {
        double salarioBase = calcularSalarioBase();
        double horaExtra = calcularHoraExtra();
        double insalubridade = calcularInsalubridade();
        double bonificacao = calcularBonificacao();
        return (salarioBase + horaExtra + insalubridade + bonificacao) * inssPercentual;
    }

    public double calcularImpostoRenda() {
        double salarioBase = calcularSalarioBase();
        double horaExtra = calcularHoraExtra();
        double insalubridade = calcularInsalubridade();
        double bonificacao = calcularBonificacao();
        return (salarioBase + horaExtra + insalubridade + bonificacao) * impostoRendaPercentual;
    }

    public double calcularSalarioLiquido() {
        double salarioBase = calcularSalarioBase();
        double horaExtra = calcularHoraExtra();
        double insalubridade = calcularInsalubridade();
        double bonificacao = calcularBonificacao();
        double inss = calcularINSS();
        double impostoRenda = calcularImpostoRenda();
        return salarioBase + horaExtra + insalubridade + bonificacao - inss - impostoRenda - planoSaude;
    }

    public String getNome() {
        return nome;
    }

    public double getPlanoSaude() {
        return planoSaude;
    }
}

public class FolhaDePagamento {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Funcionario[] funcionarios = new Funcionario[5];

        for (int i = 0; i < 5; i++) {
            System.out.println("Informe o nome do funcionário " + (i+1) + ":");
            String nome = scanner.nextLine();

            System.out.println("Informe o departamento do funcionário " + (i+1) + " (1 para Administrativo, 2 para Produção):");
            int departamento = scanner.nextInt();

            System.out.println("Informe a quantidade de horas trabalhadas pelo funcionário " + (i+1) + ":");
            double horasTrabalhadas = scanner.nextDouble();
            scanner.nextLine(); // Limpar o buffer do scanner

            funcionarios[i] = new Funcionario(nome, departamento, horasTrabalhadas);
        }

        System.out.println("\nFolha de Pagamento:\n");
        System.out.printf("%-5s %-15s %-12s %-10s %-14s %-12s %-8s %-8s %-14s %-15s\n", "Ordem", "Nome", "Salário base", "Hora Extra", "Insalubridade", "Bonificação", "INSS", "IR", "Plano Saúde", "Salário Líquido");

        for (int i = 0; i < 5; i++) {
            Funcionario funcionario = funcionarios[i];
            System.out.printf("%-5d %-15s %-12.2f %-10.2f %-14.2f %-12.2f %-8.2f %-8.2f %-14.2f %-15.2f\n",
                    i + 1,
                    funcionario.getNome(),
                    funcionario.calcularSalarioBase(),
                    funcionario.calcularHoraExtra(),
                    funcionario.calcularInsalubridade(),
                    funcionario.calcularBonificacao(),
                    funcionario.calcularINSS(),
                    funcionario.calcularImpostoRenda(),
                    funcionario.getPlanoSaude(),
                    funcionario.calcularSalarioLiquido());
        }

        scanner.close();
    }
}
