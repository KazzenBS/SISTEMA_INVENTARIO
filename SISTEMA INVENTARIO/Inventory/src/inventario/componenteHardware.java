package inventario;

import java.time.LocalDate;
import java.util.Scanner;

public class componenteHardware extends Equipamentos {
    protected static final int MAX_COMPONENTES = 10;  // Limite de componentes de hardware
    protected static componenteHardware[] componentes = new componenteHardware[MAX_COMPONENTES];  // Array para armazenar componentes
    protected static int totalComponentes = 0;  // Contador de componentes adicionados
	protected static Object numeroInventario;
	protected static String nome;
	protected static int quantidade;
	protected static LocalDate dataInventario;

    protected String tipoComponente;
    protected String fabricante;

    public componenteHardware() {
        super();
    }

    public componenteHardware(int quantidade, String nome, LocalDate dataInventario, String numeroInventario, String tipoComponente, String fabricante) {
        super(quantidade, nome, dataInventario, numeroInventario);
        this.tipoComponente = tipoComponente;
        this.fabricante = fabricante;
    }

    // Método de aquisição
    public static void aquisicao() {
        if (totalComponentes >= MAX_COMPONENTES) {
            System.out.println("Capacidade máxima de componentes atingida.");
            return;
        }
        try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Digite o nome do componente: ");
			String nome = scanner.nextLine();

			System.out.print("Digite a quantidade: ");
			int quantidade = scanner.nextInt();
			scanner.nextLine();  // Consumir a nova linha

			System.out.print("Digite a data do inventário (YYYY-MM-DD): ");
			LocalDate dataInventario = LocalDate.parse(scanner.nextLine());

			System.out.print("Digite o número do inventário: ");
			String numeroInventario = scanner.nextLine();

			System.out.print("Digite o tipo de componente: ");
			String tipoComponente = scanner.nextLine();

			System.out.print("Digite o fabricante: ");
			String fabricante = scanner.nextLine();

			componentes[totalComponentes] = new componenteHardware(quantidade, nome, dataInventario, numeroInventario, tipoComponente, fabricante);
		}

        totalComponentes++;
        System.out.println("Componente de hardware adicionado com sucesso.");
    }

    // Método de alteração
    public static void alteracao() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número do inventário do componente a ser alterado: ");
        String numeroInventario = scanner.nextLine();

        for (int i = 0; i < totalComponentes; i++) {
            if (componentes[i] != null && componentes[i].numeroInventario.equals(numeroInventario)) {
                System.out.print("Alterar nome (atual: " + componentes[i].nome + "): ");
                componentes[i].nome = scanner.nextLine();

                System.out.print("Alterar quantidade (atual: " + componentes[i].quantidade + "): ");
                componenteHardware.quantidade = scanner.nextInt();
                scanner.nextLine();  // Consumir nova linha

                System.out.print("Alterar data de inventário (atual: " + componentes[i].dataInventario + "): ");
                componentes[i].dataInventario = LocalDate.parse(scanner.nextLine());

                System.out.print("Alterar tipo de componente (atual: " + componentes[i].tipoComponente + "): ");
                componentes[i].tipoComponente = scanner.nextLine();

                System.out.print("Alterar fabricante (atual: " + componentes[i].fabricante + "): ");
                componentes[i].fabricante = scanner.nextLine();

                System.out.println("Componente alterado com sucesso.");
                return;
            }
        }
        System.out.println("Componente não encontrado.");
    }

    // Método de exibição
    public static void exibicao() {
        if (totalComponentes == 0) {
            System.out.println("Nenhum componente registrado.");
            return;
        }
        for (int i = 0; i < totalComponentes; i++) {
            if (componentes[i] != null) {
                System.out.println("Componente #" + (i + 1));
                System.out.println("Nome: " + componentes[i].nome);
                System.out.println("Quantidade: " + componentes[i].quantidade);
                System.out.println("Data de Inventário: " + componentes[i].dataInventario);
                System.out.println("Número de Inventário: " + componentes[i].numeroInventario);
                System.out.println("Tipo de Componente: " + componentes[i].tipoComponente);
                System.out.println("Fabricante: " + componentes[i].fabricante);
                System.out.println();
            }
        }
    }

    // Método de exclusão
    public static void exclusao() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número do inventário do componente a ser excluído: ");
        String numeroInventario = scanner.nextLine();

        for (int i = 0; i < totalComponentes; i++) {
            if (componentes[i] != null && componentes[i].numeroInventario.equals(numeroInventario)) {
                for (int j = i; j < totalComponentes - 1; j++) {
                    componentes[j] = componentes[j + 1];  // Desloca os elementos
                }
                componentes[totalComponentes - 1] = null;  // Remove o último
                totalComponentes--;
                System.out.println("Componente excluído com sucesso.");
                return;
            }
        }
        System.out.println("Componente não encontrado.");
    }
}