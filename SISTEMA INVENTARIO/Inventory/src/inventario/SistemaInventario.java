package inventario;
import java.util.Scanner;

//Exceção personalizada para login inválido
class InvalidLoginException extends Exception {
 public InvalidLoginException(String message) {
     super(message);
 }
}

public class SistemaInventario {
 // Credenciais armazenadas para simulação
 private static final String USERNAME = "admin";
 private static final String PASSWORD = "12345";

 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
     boolean loggedIn = false; // Status de login

     // Tenta realizar o login até obter sucesso
     while (!loggedIn) {
         try {
             // Solicita o login
             System.out.println("===== Sistema de Inventário =====");
             System.out.print("Digite o nome de usuário: ");
             String inputUsername = scanner.nextLine();

             System.out.print("Digite a senha: ");
             String inputPassword = scanner.nextLine();

             // Verifica o login
             loggedIn = realizarLogin(inputUsername, inputPassword);

             if (loggedIn) {
                 System.out.println("Login realizado com sucesso!");
                 // Chama o menu principal do sistema após o login
                 exibirMenuPrincipal(scanner);
             }

         } catch (InvalidLoginException e) {
             System.out.println("Erro: " + e.getMessage());
         } catch (Exception e) {
             System.out.println("Ocorreu um erro inesperado. Tente novamente.");
         }
     }

     scanner.close();
 }

 // Método que realiza o login e lança exceção se as credenciais forem inválidas
 public static boolean realizarLogin(String username, String password) throws InvalidLoginException {
     if (username.equals(USERNAME) && password.equals(PASSWORD)) {
         return true;
     } else {
         throw new InvalidLoginException("Nome de usuário ou senha incorretos.");
     }
 }

 // Exibe o menu principal do sistema de inventário
 public static void exibirMenuPrincipal(Scanner scanner) {
     boolean continuar = true;

     while (continuar) {
         System.out.println("\n===== Menu Principal =====");
         System.out.println("1. Aquisição");
         System.out.println("2. Movimentação");
         System.out.println("3. Envio para reparo");
         System.out.println("4. Descarte para doação");
         System.out.println("5. Arquivamento de documentos");
         System.out.println("6. Pesquisa");
         System.out.println("7. Sair");

         System.out.print("Escolha uma opção: ");
         try {
             int opcao = Integer.parseInt(scanner.nextLine());

             switch (opcao) {
                 case 1:
                     System.out.println("Opção de Aquisição selecionada.");
                     // Implementar lógica de Aquisição
                     break;
                 case 2:
                     System.out.println("Opção de Movimentação selecionada.");
                     // Implementar lógica de Movimentação
                     break;
                 case 3:
                     System.out.println("Opção de Envio para reparo selecionada.");
                     // Implementar lógica de Envio para Reparo
                     break;
                 case 4:
                     System.out.println("Opção de Descarte para doação selecionada.");
                     // Implementar lógica de Descarte para Doação
                     break;
                 case 5:
                     System.out.println("Opção de Arquivamento de documentos selecionada.");
                     // Implementar lógica de Arquivamento de documentos
                     break;
                 case 6:
                     System.out.println("Opção de Pesquisa selecionada.");
                     // Implementar lógica de Pesquisa
                     break;
                 case 7:
                     System.out.println("Saindo do sistema...");
                     continuar = false;
                     break;
                 default:
                     System.out.println("Opção inválida. Tente novamente.");
                     break;
             }

         } catch (NumberFormatException e) {
             System.out.println("Erro: Entrada inválida. Por favor, insira um número.");
         }
     }
 }
}