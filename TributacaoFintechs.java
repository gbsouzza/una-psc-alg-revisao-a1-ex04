public class TributacaoFintechs {

    public static double calcularImposto(double faturamento, double aliquota) {
        return (faturamento * aliquota) / 100;
    }

    public static double calcularImpostoComAlivio(double faturamento, double aliquota, double valorAlivio) {
        double impostoCalculado = (faturamento * aliquota) / 100;
        return impostoCalculado - valorAlivio;
    }

    public static double calcularDiferencaImposto(double impostoAntigo, double impostoNovo) {
        return Math.abs(impostoNovo - impostoAntigo);
    }

    public static void exibirDialogo(String mensagem) {
        System.out.println(mensagem);
    }

    public static void main(String[] args) {
        double faturamentoAnual = 8000000.00;

        exibirDialogo("--- Análise de Tributação de Fintechs ---");

        double aliquotaAntiga = 15.0;
        double impostoAntigo = calcularImposto(faturamentoAnual, aliquotaAntiga);

        double aliquotaProposta = 18.0;
        double alivioProposto = 50000.00;
        double impostoProposto = calcularImpostoComAlivio(faturamentoAnual, aliquotaProposta, alivioProposto);

        double diferenca = calcularDiferencaImposto(impostoAntigo, impostoProposto);

        System.out.printf("\nFaturamento Anual: R$ %,.2f\n", faturamentoAnual);
        System.out.println("----------------------------------------");
        System.out.println("Cenário 1 (Regra Antiga):");
        System.out.printf("-- Alíquota: %.1f%%\n", aliquotaAntiga);
        System.out.printf("-- Imposto Devido: R$ %,.2f\n", impostoAntigo);
        System.out.println("----------------------------------------");
        System.out.println("Cenário 2 (Regra Proposta):");
        System.out.printf("-- Alíquota: %.1f%%\n", aliquotaProposta);
        System.out.printf("-- Alívio Fiscal: R$ %,.2f\n", alivioProposto);
        System.out.printf("-- Imposto Devido: R$ %,.2f\n", impostoProposto);
        System.out.println("----------------------------------------");
        System.out.printf("\nDiferença de Imposto: R$ %,.2f\n\n", diferenca);

        System.out.print("Parecer da Análise: ");
        if (impostoProposto > impostoAntigo) {
            exibirDialogo("NEGATIVO: Proposta aumenta o fardo tributário.");
        } else if (impostoProposto < impostoAntigo) {
            exibirDialogo("POSITIVO: Proposta reduz o fardo tributário.");
        } else {
            exibirDialogo("NEUTRO: Proposta mantém o mesmo fardo tributário.");
        }
    }
}