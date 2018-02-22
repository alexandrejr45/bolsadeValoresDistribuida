import java.util.*;

public class Menu {

    public static void menu() {
        System.out.println("\tBolsa de Valores");
        System.out.println("0. Fim");
        System.out.println("1. Cadastro do Cliente");
        System.out.println("2. Alterar Cadastro");
        System.out.println("3. Lista de Lances");
        System.out.println("4. Compra");
        System.out.println("5. Venda");
        System.out.println("Opcao:");
    }

    public static void cadastra() {
        System.out.println("Você entrou no método Inclui.");
    }

    public static void altera() {
        System.out.println("Você entrou no método Altera.");
    }

    public static void lista() {
        System.out.println("Você entrou no método Exclui.");
    }

    public static void compra() {
        System.out.println("Você entrou no método Consulta.");
    }

    public static void venda() {
        System.out.println("Você entrou no método Consulta.");
    }

    public static void main(String[] args) {
        int opcao;
        Scanner entrada = new Scanner(System.in);

        try {
            do {
                menu();
                opcao = entrada.nextInt();

                switch (opcao) {
                case 1:
                    cadastra();
                    break;

                case 2:
                    altera();
                    break;

                case 3:
                    lista();
                    break;

                case 4:
                    compra();
                    break;
                case 5:
                    venda();
                    break;
                default:
                    System.out.println("Opção inválida.");
                }

            } while (opcao != 0);
        } catch (InputMismatchException e) {
            System.out.println("Erro: Digite somente números");
            main(args);

        }

    }
}
