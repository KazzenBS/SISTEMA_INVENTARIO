package inventario;

import java.time.LocalDate;
import java.util.Scanner;

public class Material_informatica extends Material {
    protected static final int MAX_MATERIAIS_INFORMATICA = 10;  // Limite de materiais de informática
    protected static Material_informatica[] materiaisInformatica = new Material_informatica[MAX_MATERIAIS_INFORMATICA];  // Array para armazenar materiais de informática
    protected static int totalMateriaisInformatica = 0;  // Contador de materiais de informática adicionados

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

    public Material_informatica() {
        super();
    }

    public Material_informatica(String nome, int quantidade, LocalDate dataInventario, String numeroInventario, String tipoMaterial, String unidadeMedida, int quantidadeMin, int quantidadeMax) {
        super(nome, quantidade, dataInventario, numeroInventario, tipoMaterial, unidadeMedida);
        this.quantidadeMin = quantidadeMin;
        this.quantidadeMax = quantidadeMax;
    }

    // Método de aquisição
    public static void aquisicao() {
        if (totalMateriaisInformatica >= MAX_MATERIAIS_INFORMATICA) {
            System.out.println("Capacidade máxima de materiais de informática atingida.");
            return;
        }
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do material de informática: ");
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

        materiaisInformatica[totalMateriaisInformatica] = new Material_informatica(nome, quantidade, dataInventario, numeroInventario, tipoMaterial, unidadeMedida, quantidadeMin, quantidadeMax);
        totalMateriaisInformatica++;
        System.out.println("Material de informática adicionado com sucesso.");
    }

    // Método de alteração
    public static void alteracao() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número do inventário do material de informática a ser alterado: ");
        String numeroInventario = scanner.nextLine();

        for (int i = 0; i < totalMateriaisInformatica; i++) {
            if (materiaisInformatica[i] != null && materiaisInformatica[i].getNumeroInventario().equals(numeroInventario)) {
                System.out.print("Alterar nome (atual: " + materiaisInformatica[i].getNome() + "): ");
                materiaisInformatica[i].setNome(scanner.nextLine());

                System.out.print("Alterar quantidade (atual: " + materiaisInformatica[i].getQuantidade() + "): ");
                materiaisInformatica[i].setQuantidade(scanner.nextInt());
                scanner.nextLine();  // Consumir nova linha

                System.out.print("Alterar data de inventário (atual: " + materiaisInformatica[i].getDataInventario() + "): ");
                materiaisInformatica[i].setDataInventario(LocalDate.parse(scanner.nextLine()));

                System.out.print("Alterar tipo de material (atual: " + materiaisInformatica[i].getTipoMaterial() + "): ");
                materiaisInformatica[i].setTipoMaterial(scanner.nextLine());

                System.out.print("Alterar unidade de medida (atual: " + materiaisInformatica[i].getUnidadeMedida() + "): ");
                materiaisInformatica[i].setUnidadeMedida(scanner.nextLine());

                System.out.print("Alterar quantidade mínima para reabastecimento (atual: " + materiaisInformatica[i].quantidadeMin + "): ");
                materiaisInformatica[i].quantidadeMin = scanner.nextInt();
                scanner.nextLine();  // Consumir nova linha

                System.out.print("Alterar quantidade máxima permitida (atual: " + materiaisInformatica[i].quantidadeMax + "): ");
                materiaisInformatica[i].quantidadeMax = scanner.nextInt();
                scanner.nextLine();  // Consumir nova linha

                System.out.println("Material de informática alterado com sucesso.");
                return;
            }
        }
        System.out.println("Material de informática não encontrado.");
    }

    protected Object getNumeroInventario() {
		// TODO Auto-generated method stub
		return null;
	}

	// Método de exibição
    public static void exibicao() {
        if (totalMateriaisInformatica == 0) {
            System.out.println("Nenhum material de informática registrado.");
            return;
        }
        for (int i = 0; i < totalMateriaisInformatica; i++) {
            if (materiaisInformatica[i] != null) {
                System.out.println("Material de Informática #" + (i + 1));
                System.out.println("Nome: " + materiaisInformatica[i].getNome());
                System.out.println("Quantidade: " + materiaisInformatica[i].getQuantidade());
                System.out.println("Data de Inventário: " + materiaisInformatica[i].getDataInventario());
                System.out.println("Número de Inventário: " + materiaisInformatica[i].getNumeroInventario());
                System.out.println("Tipo de Material: " + materiaisInformatica[i].getTipoMaterial());
                System.out.println("Unidade de Medida: " + materiaisInformatica[i].getUnidadeMedida());
                System.out.println("Quantidade Mínima: " + materiaisInformatica[i].quantidadeMin);
                System.out.println("Quantidade Máxima: " + materiaisInformatica[i].quantidadeMax);
                System.out.println();
            }
        }
    }

    // Método de exclusão
    public static void exclusao() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número do inventário do material de informática a ser excluído: ");
        String numeroInventario = scanner.nextLine();

        for (int i = 0; i < totalMateriaisInformatica; i++) {
            if (materiaisInformatica[i] != null && materiaisInformatica[i].getNumeroInventario().equals(numeroInventario)) {
                for (int j = i; j < totalMateriaisInformatica - 1; j++) {
                    materiaisInformatica[j] = materiaisInformatica[j + 1];  // Desloca os elementos
                }
                materiaisInformatica[totalMateriaisInformatica - 1] = null;  // Remove o último
                totalMateriaisInformatica--;
                System.out.println("Material de informática excluído com sucesso.");
                return;
            }
        }
        System.out.println("Material de informática não encontrado.");
    }

 
}