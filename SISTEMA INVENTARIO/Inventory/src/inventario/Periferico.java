package inventario;

import java.time.LocalDate;
import java.util.Scanner;

public class Periferico extends Equipamentos {
    protected static final int MAX_PERIFERICOS = 10;  // Limite de periféricos
    protected static Periferico[] perifericos = new Periferico[MAX_PERIFERICOS];  // Array para armazenar periféricos
    protected static int totalPerifericos = 0;  // Contador de periféricos adicionados

    protected String tipoPeriferico;

    public Periferico() {
        super();
    }

    public Periferico(int quantidade, String nome, LocalDate dataInventario, String numeroInventario, String tipoPeriferico) {
        super(quantidade, nome, dataInventario, numeroInventario);
        this.tipoPeriferico = tipoPeriferico;
    }

    // Método de aquisição
    public static void aquisicao() {
        if (totalPerifericos >= MAX_PERIFERICOS) {
            System.out.println("Capacidade máxima de periféricos atingida.");
            return;
        }
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do periférico: ");
        String nome = scanner.nextLine();

        System.out.print("Digite a quantidade: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();  // Consumir a nova linha

        System.out.print("Digite a data do inventário (YYYY-MM-DD): ");
        LocalDate dataInventario = LocalDate.parse(scanner.nextLine());

        System.out.print("Digite o número do inventário: ");
        String numeroInventario = scanner.nextLine();

        System.out.print("Digite o tipo do periférico: ");
        String tipoPeriferico = scanner.nextLine();

        perifericos[totalPerifericos] = new Periferico(quantidade, nome, dataInventario, numeroInventario, tipoPeriferico);
        totalPerifericos++;
        System.out.println("Periférico adicionado com sucesso.");
    }

    // Método de alteração
    public static void alteracao() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número do inventário do periférico a ser alterado: ");
        String numeroInventario = scanner.nextLine();

        for (int i = 0; i < totalPerifericos; i++) {
            if (perifericos[i] != null && perifericos[i].numeroInventario.equals(numeroInventario)) {
                System.out.print("Alterar nome (atual: " + perifericos[i].nome + "): ");
                perifericos[i].nome = scanner.nextLine();

                System.out.print("Alterar quantidade (atual: " + perifericos[i].quantidade + "): ");
                perifericos[i].quantidade = scanner.nextInt();
                scanner.nextLine();  // Consumir nova linha

                System.out.print("Alterar data de inventário (atual: " + perifericos[i].dataInventario + "): ");
                perifericos[i].dataInventario = LocalDate.parse(scanner.nextLine());

                System.out.print("Alterar tipo do periférico (atual: " + perifericos[i].tipoPeriferico + "): ");
                perifericos[i].tipoPeriferico = scanner.nextLine();

                System.out.println("Periférico alterado com sucesso.");
                return;
            }
        }
        System.out.println("Periférico não encontrado.");
    }

    // Método de exibição
    public static void exibicao() {
        if (totalPerifericos == 0) {
            System.out.println("Nenhum periférico registrado.");
            return;
        }
        for (int i = 0; i < totalPerifericos; i++) {
            if (perifericos[i] != null) {
                System.out.println("Periférico #" + (i + 1));
                System.out.println("Nome: " + perifericos[i].nome);
                System.out.println("Quantidade: " + perifericos[i].quantidade);
                System.out.println("Data de Inventário: " + perifericos[i].dataInventario);
                System.out.println("Número de Inventário: " + perifericos[i].numeroInventario);
                System.out.println("Tipo de Periférico: " + perifericos[i].tipoPeriferico);
                System.out.println();
            }
        }
    }

    // Método de exclusão
    public static void exclusao() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número do inventário do periférico a ser excluído: ");
        String numeroInventario = scanner.nextLine();

        for (int i = 0; i < totalPerifericos; i++) {
            if (perifericos[i] != null && perifericos[i].numeroInventario.equals(numeroInventario)) {
                for (int j = i; j < totalPerifericos - 1; j++) {
                    perifericos[j] = perifericos[j + 1];  // Desloca os elementos
                }
                perifericos[totalPerifericos - 1] = null;  // Remove o último
                totalPerifericos--;
                System.out.println("Periférico excluído com sucesso.");
                return;
            }
        }
        System.out.println("Periférico não encontrado.");
    }
}