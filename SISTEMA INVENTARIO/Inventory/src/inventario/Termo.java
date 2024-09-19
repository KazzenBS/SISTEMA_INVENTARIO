package inventario;

import java.time.LocalDate;
import java.util.Scanner;

public class Contrato extends Documento {
    protected String partesEnvolvidas;
    protected LocalDate dataAssinatura;
    protected LocalDate dataValidade;
    protected String sistemaEnvolvido;

    

    public Contrato(LocalDate dataCriacao, String autor, String classificacao, String partesEnvolvidas, LocalDate dataAssinatura, LocalDate dataValidade, String sistemaEnvolvido) {
        super(dataCriacao, autor, classificacao);
        this.partesEnvolvidas = partesEnvolvidas;
        this.dataAssinatura = dataAssinatura;
        this.dataValidade = dataValidade;
        this.sistemaEnvolvido = sistemaEnvolvido;
    }

    // Método de Aquisição (input de dados)
    public static Contrato aquisicao() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a data de criação (YYYY-MM-DD): ");
        LocalDate dataCriacao = LocalDate.parse(scanner.nextLine());

        System.out.print("Digite o autor: ");
        String autor = scanner.nextLine();

        System.out.print("Digite a classificação: ");
        String classificacao = scanner.nextLine();

        System.out.print("Digite as partes envolvidas: ");
        String partesEnvolvidas = scanner.nextLine();

        System.out.print("Digite a data de assinatura (YYYY-MM-DD): ");
        LocalDate dataAssinatura = LocalDate.parse(scanner.nextLine());

        System.out.print("Digite a data de validade (YYYY-MM-DD): ");
        LocalDate dataValidade = LocalDate.parse(scanner.nextLine());
        
        System.out.print("Digite o sistema envolvido: ");
        String sistemaEnvolvido = scanner.nextLine();

        return new Contrato(dataCriacao, autor, classificacao, partesEnvolvidas, dataAssinatura, dataValidade, sistemaEnvolvido);
    }

    // Método de Alteração (modificação de atributos)
    public void alteracao() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o novo autor (atual: " + this.autor + "): ");
        this.autor = scanner.nextLine();

        System.out.print("Digite a nova classificação (atual: " + this.classificacao + "): ");
        this.classificacao = scanner.nextLine();

        System.out.print("Digite as novas partes envolvidas (atual: " + this.partesEnvolvidas + "): ");
        this.partesEnvolvidas = scanner.nextLine();

        System.out.print("Digite a nova data de assinatura (atual: " + this.dataAssinatura + " - YYYY-MM-DD): ");
        this.dataAssinatura = LocalDate.parse(scanner.nextLine());

        System.out.print("Digite a nova data de validade (atual: " + this.dataValidade + " - YYYY-MM-DD): ");
        this.dataValidade = LocalDate.parse(scanner.nextLine());
        
        System.out.print("Digite o novo Sistema Envolvido (atual: " + this.sistemaEnvolvido + "): ");
        this.sistemaEnvolvido = scanner.nextLine();
        
        
    }

    // Método de Exibição (mostra os dados)
    @Override
    public void exibicao() {
        super.exibicao();
        System.out.println("Partes Envolvidas: " + partesEnvolvidas);
        System.out.println("Data de Assinatura: " + dataAssinatura);
        System.out.println("Data de Validade: " + dataValidade);
        System.out.println("Sistema Envolvido: " + sistemaEnvolvido);

    }

    // Método de Exclusão (deleta o conteúdo do contrato)
    public void exclusao() {
        this.dataCriacao = null;
        this.autor = null;
        this.classificacao = null;
        this.partesEnvolvidas = null;
        this.dataAssinatura = null;
        this.dataValidade = null;
        this.sistemaEnvolvido = null;
        System.out.println("Contrato excluído.");
    }

    // Programa principal
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Contrato contrato = null;

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Aquisição de Contrato");
            System.out.println("2. Alteração de Contrato");
            System.out.println("3. Exibição de Contrato");
            System.out.println("4. Exclusão de Contrato");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    contrato = Contrato.aquisicao();
                    break;
                case 2:
                    if (contrato != null) {
                        contrato.alteracao();
                    } else {
                        System.out.println("Nenhum contrato disponível para alteração.");
                    }
                    break;
                case 3:
                    if (contrato != null) {
                        contrato.exibicao();
                    } else {
                        System.out.println("Nenhum contrato disponível para exibição.");
                    }
                    break;
                case 4:
                    if (contrato != null) {
                        contrato.exclusao();
                        contrato = null;
                    } else {
                        System.out.println("Nenhum contrato disponível para exclusão.");
                    }
                    break;
                case 5:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}