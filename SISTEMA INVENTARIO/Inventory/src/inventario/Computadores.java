package inventario;

import java.time.LocalDate;
import java.util.Scanner;

public class Computadores extends Equipamentos {
    protected static final int MAX_COMPUTADORES = 10;  // Limite de computadores
    protected static Computadores[] computadores = new Computadores[MAX_COMPUTADORES];  // Array para armazenar computadores
    protected static int totalComputadores = 0;  // Contador de computadores adicionados

    protected String tipoComputador;  // Ex: Desktop, Notebook
    protected String processador;
    protected int memoriaRAM;  // em GB
    protected int armazenamento;  // em GB

    public Computadores() {
        super();
    }

    public Computadores(int quantidade, String nome, LocalDate dataInventario, String numeroInventario, String tipoComputador, String processador, int memoriaRAM, int armazenamento) {
        super(quantidade, nome, dataInventario, numeroInventario);
        this.tipoComputador = tipoComputador;
        this.processador = processador;
        this.memoriaRAM = memoriaRAM;
        this.armazenamento = armazenamento;
    }

    // Método de aquisição
    public static void aquisicao() {
        if (totalComputadores >= MAX_COMPUTADORES) {
            System.out.println("Capacidade máxima de computadores atingida.");
            return;
        }
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do computador: ");
        String nome = scanner.nextLine();

        System.out.print("Digite a quantidade: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();  // Consumir a nova linha

        System.out.print("Digite a data do inventário (YYYY-MM-DD): ");
        LocalDate dataInventario = LocalDate.parse(scanner.nextLine());

        System.out.print("Digite o número do inventário: ");
        String numeroInventario = scanner.nextLine();

        System.out.print("Digite o tipo de computador (Desktop, Notebook): ");
        String tipoComputador = scanner.nextLine();

        System.out.print("Digite o processador (Ex: Intel i5, Ryzen 5): ");
        String processador = scanner.nextLine();

        System.out.print("Digite a quantidade de memória RAM (em GB): ");
        int memoriaRAM = scanner.nextInt();
        scanner.nextLine();  // Consumir nova linha

        System.out.print("Digite a capacidade de armazenamento (em GB): ");
        int armazenamento = scanner.nextInt();
        scanner.nextLine();  // Consumir nova linha

        computadores[totalComputadores] = new Computadores(quantidade, nome, dataInventario, numeroInventario, tipoComputador, processador, memoriaRAM, armazenamento);
        totalComputadores++;
        System.out.println("Computador adicionado com sucesso.");
    }

    // Método de alteração
    public static void alteracao() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número do inventário do computador a ser alterado: ");
        String numeroInventario = scanner.nextLine();

        for (int i = 0; i < totalComputadores; i++) {
            if (computadores[i] != null && computadores[i].numeroInventario.equals(numeroInventario)) {
                System.out.print("Alterar nome (atual: " + computadores[i].nome + "): ");
                computadores[i].nome = scanner.nextLine();

                System.out.print("Alterar quantidade (atual: " + computadores[i].quantidade + "): ");
                computadores[i].quantidade = scanner.nextInt();
                scanner.nextLine();  // Consumir nova linha

                System.out.print("Alterar data de inventário (atual: " + computadores[i].dataInventario + "): ");
                computadores[i].dataInventario = LocalDate.parse(scanner.nextLine());

                System.out.print("Alterar tipo de computador (atual: " + computadores[i].tipoComputador + "): ");
                computadores[i].tipoComputador = scanner.nextLine();

                System.out.print("Alterar processador (atual: " + computadores[i].processador + "): ");
                computadores[i].processador = scanner.nextLine();

                System.out.print("Alterar memória RAM (atual: " + computadores[i].memoriaRAM + " GB): ");
                computadores[i].memoriaRAM = scanner.nextInt();
                scanner.nextLine();  // Consumir nova linha

                System.out.print("Alterar capacidade de armazenamento (atual: " + computadores[i].armazenamento + " GB): ");
                computadores[i].armazenamento = scanner.nextInt();
                scanner.nextLine();  // Consumir nova linha

                System.out.println("Computador alterado com sucesso.");
                return;
            }
        }
        System.out.println("Computador não encontrado.");
    }

    // Método de exibição
    public static void exibicao() {
        if (totalComputadores == 0) {
            System.out.println("Nenhum computador registrado.");
            return;
        }
        for (int i = 0; i < totalComputadores; i++) {
            if (computadores[i] != null) {
                System.out.println("Computador #" + (i + 1));
                System.out.println("Nome: " + computadores[i].nome);
                System.out.println("Quantidade: " + computadores[i].quantidade);
                System.out.println("Data de Inventário: " + computadores[i].dataInventario);
                System.out.println("Número de Inventário: " + computadores[i].numeroInventario);
                System.out.println("Tipo de Computador: " + computadores[i].tipoComputador);
                System.out.println("Processador: " + computadores[i].processador);
                System.out.println("Memória RAM: " + computadores[i].memoriaRAM + " GB");
                System.out.println("Armazenamento: " + computadores[i].armazenamento + " GB");
                System.out.println();
            }
        }
    }

    // Método de exclusão
    public static void exclusao() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número do inventário do computador a ser excluído: ");
        String numeroInventario = scanner.nextLine();

        for (int i = 0; i < totalComputadores; i++) {
            if (computadores[i] != null && computadores[i].numeroInventario.equals(numeroInventario)) {
                for (int j = i; j < totalComputadores - 1; j++) {
                    computadores[j] = computadores[j + 1];  // Desloca os elementos
                }
                computadores[totalComputadores - 1] = null;  // Remove o último
                totalComputadores--;
                System.out.println("Computador excluído com sucesso.");
                return;
            }
        }
        System.out.println("Computador não encontrado.");
    }
}