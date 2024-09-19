package inventario;

import java.time.LocalDate;
import java.util.Scanner;

public class Documento {
	protected static final int MAX_DOCUMENTOS = 10;  // Limite de documentos
	protected static Documento[] documentos = new Documento[MAX_DOCUMENTOS];  // Array para armazenar documentos
	protected static int totalDocumentos = 0;  // Contador de documentos adicionados

    protected LocalDate dataCriacao;
    protected String autor;
    protected String classificacao;
    protected String localizacao;

    // Construtores
    public Documento() {
    }

    public Documento(LocalDate dataCriacao, String autor, String classificacao, String localizacao) {
        this.dataCriacao = dataCriacao;
        this.autor = autor;
        this.classificacao = classificacao;
        this.localizacao = localizacao;
    }

    // Métodos getter e setter
    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getClassificacao() {
        return classificacao;
    }
    
    public String getLocalizacao() {
        return localizacao;
    }
    
    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    // Método de aquisição
    public static void aquisicao() {
        if (totalDocumentos >= MAX_DOCUMENTOS) {
            System.out.println("Capacidade máxima de documentos atingida.");
            return;
        }
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a data de criação (YYYY-MM-DD): ");
        LocalDate dataCriacao = LocalDate.parse(scanner.nextLine());

        System.out.print("Digite o autor do documento: ");
        String autor = scanner.nextLine();

        System.out.print("Digite a classificação do documento: ");
        String classificacao = scanner.nextLine();
        
        System.out.print("Digite a localização do documento: ");
        String localizacao = scanner.nextLine();

        documentos[totalDocumentos] = new Documento(dataCriacao, autor, classificacao, localizacao);
        totalDocumentos++;
        System.out.println("Documento adicionado com sucesso.");
    }

    // Método de alteração
    public static void alteracao() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o índice do documento a ser alterado (0 a " + (totalDocumentos - 1) + "): ");
        int indice = scanner.nextInt();
        scanner.nextLine();  // Consumir a nova linha

        if (indice < 0 || indice >= totalDocumentos) {
            System.out.println("Índice inválido.");
            return;
        }

        System.out.print("Alterar data de criação (atual: " + documentos[indice].getDataCriacao() + "): ");
        documentos[indice].setDataCriacao(LocalDate.parse(scanner.nextLine()));

        System.out.print("Alterar autor (atual: " + documentos[indice].getAutor() + "): ");
        documentos[indice].setAutor(scanner.nextLine());

        System.out.print("Alterar classificação (atual: " + documentos[indice].getClassificacao() + "): ");
        documentos[indice].setClassificacao(scanner.nextLine());
        
        System.out.print("Alterar localizacao (atual: " + documentos[indice].getLocalizacao() + "): ");
        documentos[indice].setLocalizacao(scanner.nextLine());

        System.out.println("Documento alterado com sucesso.");
    }

    // Método de exibição
    public static void exibicao() {
        if (totalDocumentos == 0) {
            System.out.println("Nenhum documento registrado.");
            return;
        }
        for (int i = 0; i < totalDocumentos; i++) {
            System.out.println("Documento #" + (i + 1));
            System.out.println("Data de Criação: " + documentos[i].getDataCriacao());
            System.out.println("Autor: " + documentos[i].getAutor());
            System.out.println("Classificação: " + documentos[i].getClassificacao());
            System.out.println("Localizacao: " + documentos[i].getLocalizacao());
            System.out.println();
        }
    }

    // Método de exclusão
    public static void exclusao() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o índice do documento a ser excluído (0 a " + (totalDocumentos - 1) + "): ");
        int indice = scanner.nextInt();

        if (indice < 0 || indice >= totalDocumentos) {
            System.out.println("Índice inválido.");
            return;
        }

        for (int i = indice; i < totalDocumentos - 1; i++) {
            documentos[i] = documentos[i + 1];
        }
        documentos[totalDocumentos - 1] = null;  // Limpar a última posição
        totalDocumentos--;
        System.out.println("Documento excluído com sucesso.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu de Documentos:");
            System.out.println("1. Adicionar Documento");
            System.out.println("2. Alterar Documento");
            System.out.println("3. Exibir Documentos");
            System.out.println("4. Excluir Documento");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();  // Consumir a nova linha

            switch (opcao) {
                case 1:
                    aquisicao();
                    break;
                case 2:
                    alteracao();
                    break;
                case 3:
                    exibicao();
                    break;
                case 4:
                    exclusao();
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