package inventario;

import java.time.LocalDate;
import java.util.Scanner;

public class Material_escritorio extends Material {
    protected static final int MAX_MATERIAIS_ESCRITORIO = 10;  // Limite de materiais de escritório
    protected static Material_escritorio[] materiaisEscritorio = new Material_escritorio[MAX_MATERIAIS_ESCRITORIO];  // Array para armazenar materiais de escritório
    protected static int totalMateriaisEscritorio = 0;  // Contador de materiais de escritório adicionados

    protected int quantidadeMin;  // Quantidade mínima para reabastecimento
    protected int quantidadeMax;  // Quantidade máxima permitida
    
    // Métodos getter e setter para quantidadeMin e quantidadeMax
    public int getQuantidadeMin() {
        return quantidadeMin;
    }

    public void setQuantidadeMin(int quantidadeMin) {
        this.quantidadeMin = quantidadeMin;
    }

    public int getQuantidadeMax() {
        return quantidadeMax;
    }

    public void setQuantidadeMax(int quantidadeMax) {
        this.quantidadeMax = quantidadeMax;
    }

    public Material_escritorio() {
        super();
    }

    public Material_escritorio(String nome, int quantidade, LocalDate dataInventario, String numeroInventario, String tipoMaterial, String unidadeMedida, int quantidadeMin, int quantidadeMax) {
        super(nome, quantidade, dataInventario, numeroInventario, tipoMaterial, unidadeMedida);
        this.quantidadeMin = quantidadeMin;
        this.quantidadeMax = quantidadeMax;
    }

    // Método de aquisição
    public static void aquisicao() {
        if (totalMateriaisEscritorio >= MAX_MATERIAIS_ESCRITORIO) {
            System.out.println("Capacidade máxima de materiais de escritório atingida.");
            return;
        }
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do material de escritório: ");
        String nome = scanner.nextLine();

        System.out.print("Digite a quantidade: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();  // Consumir a nova linha

        System.out.print("Digite a data do inventário (YYYY-MM-DD): ");
        LocalDate dataInventario = LocalDate.parse(scanner.nextLine());

        System.out.print("Digite o número do inventário: ");
        String numeroInventario = scanner.nextLine();

        System.out.print("Digite o tipo de material: ");
        String tipoMaterial = scanner.nextLine();

        System.out.print("Digite a unidade de medida: ");
        String unidadeMedida = scanner.nextLine();

        System.out.print("Digite a quantidade mínima para reabastecimento: ");
        int quantidadeMin = scanner.nextInt();
        scanner.nextLine();  // Consumir a nova linha

        System.out.print("Digite a quantidade máxima permitida: ");
        int quantidadeMax = scanner.nextInt();
        scanner.nextLine();  // Consumir a nova linha

        materiaisEscritorio[totalMateriaisEscritorio] = new Material_escritorio(nome, quantidade, dataInventario, numeroInventario, tipoMaterial, unidadeMedida, quantidadeMin, quantidadeMax);
        totalMateriaisEscritorio++;
        System.out.println("Material de escritório adicionado com sucesso.");
    }

    // Método de alteração
    public static void alteracao() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número do inventário do material de escritório a ser alterado: ");
        String numeroInventario = scanner.nextLine();

        for (int i = 0; i < totalMateriaisEscritorio; i++) {
            if (materiaisEscritorio[i] != null && materiaisEscritorio[i].getNumeroInventario().equals(numeroInventario)) {
                System.out.print("Alterar nome (atual: " + materiaisEscritorio[i].getNome() + "): ");
                materiaisEscritorio[i].setNome(scanner.nextLine());

                System.out.print("Alterar quantidade (atual: " + materiaisEscritorio[i].getQuantidade() + "): ");
                materiaisEscritorio[i].setQuantidade(scanner.nextInt());
                scanner.nextLine();  // Consumir nova linha

                System.out.print("Alterar data de inventário (atual: " + materiaisEscritorio[i].getDataInventario() + "): ");
                materiaisEscritorio[i].setDataInventario(LocalDate.parse(scanner.nextLine()));

                System.out.print("Alterar tipo de material (atual: " + materiaisEscritorio[i].getTipoMaterial() + "): ");
                materiaisEscritorio[i].setTipoMaterial(scanner.nextLine());

                System.out.print("Alterar unidade de medida (atual: " + materiaisEscritorio[i].getUnidadeMedida() + "): ");
                materiaisEscritorio[i].setUnidadeMedida(scanner.nextLine());

                System.out.print("Alterar quantidade mínima para reabastecimento (atual: " + materiaisEscritorio[i].quantidadeMin + "): ");
                materiaisEscritorio[i].quantidadeMin = scanner.nextInt();
                scanner.nextLine();  // Consumir nova linha

                System.out.print("Alterar quantidade máxima permitida (atual: " + materiaisEscritorio[i].quantidadeMax + "): ");
                materiaisEscritorio[i].quantidadeMax = scanner.nextInt();
                scanner.nextLine();  // Consumir nova linha

                System.out.println("Material de escritório alterado com sucesso.");
                return;
            }
        }
        System.out.println("Material de escritório não encontrado.");
    }

    // Método de exibição
    public static void exibicao() {
        if (totalMateriaisEscritorio == 0) {
            System.out.println("Nenhum material de escritório registrado.");
            return;
        }
        for (int i = 0; i < totalMateriaisEscritorio; i++) {
            if (materiaisEscritorio[i] != null) {
                System.out.println("Material de Escritório #" + (i + 1));
                System.out.println("Nome: " + materiaisEscritorio[i].getNome());
                System.out.println("Quantidade: " + materiaisEscritorio[i].getQuantidade());
                System.out.println("Data de Inventário: " + materiaisEscritorio[i].getDataInventario());
                System.out.println("Número de Inventário: " + materiaisEscritorio[i].getNumeroInventario());
                System.out.println("Tipo de Material: " + materiaisEscritorio[i].getTipoMaterial());
                System.out.println("Unidade de Medida: " + materiaisEscritorio[i].getUnidadeMedida());
                System.out.println("Quantidade Mínima: " + materiaisEscritorio[i].quantidadeMin);
                System.out.println("Quantidade Máxima: " + materiaisEscritorio[i].quantidadeMax);
                System.out.println();
            }
        }
    }

    // Método de exclusão
    public static void exclusao() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número do inventário do material de escritório a ser excluído: ");
        String numeroInventario = scanner.nextLine();

        for (int i = 0; i < totalMateriaisEscritorio; i++) {
            if (materiaisEscritorio[i] != null && materiaisEscritorio[i].getNumeroInventario().equals(numeroInventario)) {
                for (int j = i; j < totalMateriaisEscritorio - 1; j++) {
                    materiaisEscritorio[j] = materiaisEscritorio[j + 1];  // Desloca os elementos
                }
                materiaisEscritorio[totalMateriaisEscritorio - 1] = null;  // Remove o último
                totalMateriaisEscritorio--;
                System.out.println("Material de escritório excluído com sucesso.");
                return;
            }
        }
        System.out.println("Material de escritório não encontrado.");
    }

   
}
