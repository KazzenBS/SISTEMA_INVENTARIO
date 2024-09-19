package inventario;

import java.time.LocalDate;
import java.util.Scanner;

public class Material {
    protected static final int MAX_MATERIAIS = 10;  // Limite de materiais
    protected static Material[] materiais = new Material[MAX_MATERIAIS];  // Array para armazenar materiais
    protected static int totalMateriais = 0;  // Contador de materiais adicionados

    protected String nome;
    protected int quantidade;
    protected LocalDate dataInventario;
    protected String numeroInventario;
    protected String tipoMaterial;
    protected String unidadeMedida;
    protected String localizacao;

    public Material() {
    }

    public Material(String nome, int quantidade, LocalDate dataInventario, String numeroInventario, String tipoMaterial, String unidadeMedida) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.dataInventario = dataInventario;
        this.numeroInventario = numeroInventario;
        this.tipoMaterial = tipoMaterial;
        this.unidadeMedida = unidadeMedida;
    }
    
    
 // Métodos getter e setter
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDate getDataInventario() {
        return dataInventario;
    }

    public void setDataInventario(LocalDate dataInventario) {
        this.dataInventario = dataInventario;
    }

    public String getNumeroInventario() {
        return numeroInventario;
    }

    public void setNumeroInventario(String numeroInventario) {
        this.numeroInventario = numeroInventario;
    }

    public String getTipoMaterial() {
        return tipoMaterial;
    }

    public void setTipoMaterial(String tipoMaterial) {
        this.tipoMaterial = tipoMaterial;
    }

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    // Método de aquisição
    public static void aquisicao() {
        if (totalMateriais >= MAX_MATERIAIS) {
            System.out.println("Capacidade máxima de materiais atingida.");
            return;
        }
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do material: ");
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

        materiais[totalMateriais] = new Material(nome, quantidade, dataInventario, numeroInventario, tipoMaterial, unidadeMedida);
        totalMateriais++;
        System.out.println("Material adicionado com sucesso.");
    }

    // Método de alteração
    public static void alteracao() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número do inventário do material a ser alterado: ");
        String numeroInventario = scanner.nextLine();

        for (int i = 0; i < totalMateriais; i++) {
            if (materiais[i] != null && materiais[i].numeroInventario.equals(numeroInventario)) {
                System.out.print("Alterar nome (atual: " + materiais[i].nome + "): ");
                materiais[i].nome = scanner.nextLine();

                System.out.print("Alterar quantidade (atual: " + materiais[i].quantidade + "): ");
                materiais[i].quantidade = scanner.nextInt();
                scanner.nextLine();  // Consumir nova linha

                System.out.print("Alterar data de inventário (atual: " + materiais[i].dataInventario + "): ");
                materiais[i].dataInventario = LocalDate.parse(scanner.nextLine());

                System.out.print("Alterar tipo de material (atual: " + materiais[i].tipoMaterial + "): ");
                materiais[i].tipoMaterial = scanner.nextLine();

                System.out.print("Alterar unidade de medida (atual: " + materiais[i].unidadeMedida + "): ");
                materiais[i].unidadeMedida = scanner.nextLine();

                System.out.println("Material alterado com sucesso.");
                return;
            }
        }
        System.out.println("Material não encontrado.");
    }

    // Método de exibição
    public static void exibicao() {
        if (totalMateriais == 0) {
            System.out.println("Nenhum material registrado.");
            return;
        }
        for (int i = 0; i < totalMateriais; i++) {
            if (materiais[i] != null) {
                System.out.println("Material #" + (i + 1));
                System.out.println("Nome: " + materiais[i].nome);
                System.out.println("Quantidade: " + materiais[i].quantidade);
                System.out.println("Data de Inventário: " + materiais[i].dataInventario);
                System.out.println("Número de Inventário: " + materiais[i].numeroInventario);
                System.out.println("Tipo de Material: " + materiais[i].tipoMaterial);
                System.out.println("Unidade de Medida: " + materiais[i].unidadeMedida);
                System.out.println();
            }
        }
    }

    // Método de exclusão
    public static void exclusao() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número do inventário do material a ser excluído: ");
        String numeroInventario = scanner.nextLine();

        for (int i = 0; i < totalMateriais; i++) {
            if (materiais[i] != null && materiais[i].numeroInventario.equals(numeroInventario)) {
                for (int j = i; j < totalMateriais - 1; j++) {
                    materiais[j] = materiais[j + 1];  // Desloca os elementos
                }
                materiais[totalMateriais - 1] = null;  // Remove o último
                totalMateriais--;
                System.out.println("Material excluído com sucesso.");
                return;
            }
        }
        System.out.println("Material não encontrado.");
    }

  
}
