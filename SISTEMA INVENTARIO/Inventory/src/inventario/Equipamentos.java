package inventario;
import java.time.LocalDate;
import java.util.Scanner;

public class Equipamentos {
    protected static final int MAX_EQUIPAMENTOS = 10;  // Limite de equipamentos
    protected static Equipamentos[] equipamentos = new Equipamentos[MAX_EQUIPAMENTOS];  // Array para armazenar equipamentos
    protected static int totalEquipamentos = 0;  // Contador de equipamentos adicionados

    protected int quantidade;
    protected String nome;
    protected LocalDate dataInventario;
    protected String numeroInventario;
    protected String localizacao;

    public Equipamentos() {}

    public Equipamentos(int quantidade, String nome, LocalDate dataInventario, String numeroInventario, String localizacao) {
        this.quantidade = quantidade;
        this.nome = nome;
        this.dataInventario = dataInventario;
        this.numeroInventario = numeroInventario;
        this.localizacao = localizacao;
    }

    // Método de aquisição
    public static void aquisicao() {
        if (totalEquipamentos >= MAX_EQUIPAMENTOS) {
            System.out.println("Capacidade máxima de equipamentos atingida.");
            return;
        }
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do equipamento: ");
        String nome = scanner.nextLine();

        System.out.print("Digite a quantidade: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();  // Consumir nova linha

        System.out.print("Digite a data do inventário (YYYY-MM-DD): ");
        LocalDate dataInventario = LocalDate.parse(scanner.nextLine());

        System.out.print("Digite o número do inventário: ");
        String numeroInventario = scanner.nextLine();
        
        System.out.print("Digite a localizacao do equipamento: ");
        String localizacao = scanner.nextLine();

        equipamentos[totalEquipamentos] = new Equipamentos(quantidade, nome, dataInventario, numeroInventario, localizacao);
        totalEquipamentos++;
        System.out.println("Equipamento adicionado com sucesso.");
    }

    // Método de alteração
    public static void alteracao() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número do inventário do equipamento a ser alterado: ");
        String numeroInventario = scanner.nextLine();

        for (int i = 0; i < totalEquipamentos; i++) {
            if (equipamentos[i] != null && equipamentos[i].numeroInventario.equals(numeroInventario)) {
                System.out.print("Alterar nome (atual: " + equipamentos[i].nome + "): ");
                equipamentos[i].nome = scanner.nextLine();

                System.out.print("Alterar quantidade (atual: " + equipamentos[i].quantidade + "): ");
                equipamentos[i].quantidade = scanner.nextInt();
                scanner.nextLine();  // Consumir nova linha

                System.out.print("Alterar data de inventário (atual: " + equipamentos[i].dataInventario + "): ");
                equipamentos[i].dataInventario = LocalDate.parse(scanner.nextLine());
                
                System.out.print("Alterar localização (atual: " + equipamentos[i].localizacao + "): ");
                equipamentos[i].localizacao = scanner.nextLine();

                System.out.println("Equipamento alterado com sucesso.");
                return;
            }
        }
        System.out.println("Equipamento não encontrado.");
    }

    // Método de exibição
    public static void exibicao() {
        if (totalEquipamentos == 0) {
            System.out.println("Nenhum equipamento registrado.");
            return;
        }
        for (int i = 0; i < totalEquipamentos; i++) {
            if (equipamentos[i] != null) {
                System.out.println("Equipamento #" + (i + 1));
                System.out.println("Nome: " + equipamentos[i].nome);
                System.out.println("Quantidade: " + equipamentos[i].quantidade);
                System.out.println("Data de Inventário: " + equipamentos[i].dataInventario);
                System.out.println("Número de Inventário: " + equipamentos[i].numeroInventario);
                System.out.println("Localização: " + equipamentos[i].localizacao);
                System.out.println();
            }
        }
    }

    // Método de exclusão
    public static void exclusao() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número do inventário do equipamento a ser excluído: ");
        String numeroInventario = scanner.nextLine();

        for (int i = 0; i < totalEquipamentos; i++) {
            if (equipamentos[i] != null && equipamentos[i].numeroInventario.equals(numeroInventario)) {
                for (int j = i; j < totalEquipamentos - 1; j++) {
                    equipamentos[j] = equipamentos[j + 1];  
                }
                equipamentos[totalEquipamentos - 1] = null; 
                totalEquipamentos--;
                System.out.println("Equipamento excluído com sucesso.");
                return;
            }
        }
        System.out.println("Equipamento não encontrado.");
    }
}