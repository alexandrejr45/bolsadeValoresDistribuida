import java.lang.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.rmi.*;
import java.rmi.server.RemoteObject;

public class Menu {
    public Menu() throws RemoteException {
        super();
    };

    private static Usuario usuarioBackup = null;
    private static Interface principal;
    private static Corretora core = Corretora.getInstancia();

    public static void setUsuarioBackup(Usuario usuario) {
        usuarioBackup = usuario;
    }

    public static Usuario getUsuarioBackup() {
        return usuarioBackup;

    }

    public static Interface lookup(String objeto) throws Exception {

        Interface inter = (Interface) Naming.lookup("rmi:///" + objeto);

        return inter;
    }

    public static void menu() {
        System.out.println("\tBolsa de Valores");
        System.out.println("0. Fim");
        System.out.println("1. Cadastro do Cliente");
        System.out.println("2. Alterar Cadastro");
        System.out.println("3. Lista de Lances");
        System.out.println("4. Compra");
        System.out.println("5. Venda");
        System.out.println("6. Limpar a Tela");
        System.out.println("Opcao:");
    }

    public static void cadastra() throws Exception {
        System.out.println("----- Cadastro de Cliente -----");

        Scanner valor = new Scanner(System.in);
        String[] args = null;
        Usuario user = new Usuario();

        System.out.println("Qual o seu nome? ");
        user.setNome(valor.nextLine());

        System.out.println("Qual o seu saldo atual? ");
        user.setSaldo(valor.nextDouble());

        user.geraHash();

        if (principal == null) {
            principal = lookup("cadastro");
        }

        System.out.println("Procurando objeto cadastro no servidor...");
        System.out.println("Cadastrando Usuário " + user.getNome());

        boolean resposta = principal.registraCliente(user);

        usuarioBackup = user;

        main(args);

    }

    public static void altera() throws Exception{
        System.out.println("----- Alteração de Cadastro -----");
        Scanner valor = new Scanner(System.in);
        String[] args = null;
        String resposta = null;


        if (usuarioBackup == null) {
            System.out.println("É preciso ter um cadastro para acessar essa opção");
        } else {
            System.out.println("Nome " + usuarioBackup.getNome());
            System.out.println("Saldo " + usuarioBackup.getSaldo());

            System.out.println("Digite sim para alterar seu nome");
            resposta = valor.next();

            if(resposta.equals("sim") || resposta.equals("Sim")){
                System.out.println("Digite um novo nome ");
                usuarioBackup.setNome(valor.next());

                System.out.println("Seu novo nome é " + usuarioBackup.getNome());

                main(args);

            }else{
                main(args);
            }
        }
    }

    public static void lista() throws NotBoundException, RemoteException {
        System.out.println("----- Lista de Lances -----");
        if (usuarioBackup == null) {
            System.out.println("Faça seu cadastro para acessar a lista de lances");
        } else {
            ArrayList<Lance> lances = principal.retornaLancesUsuario(usuarioBackup);
            core.mostraLances(lances);

        }

    }

    public static void compra() throws NotBoundException, RemoteException, Exception {
        System.out.println("----- Lances para comprar -----");

        Scanner valor = new Scanner(System.in);
        double valorLance = 0;
        int indiceLance = 0;
        String[] args = null;

        if (usuarioBackup == null) {
            System.out.println("Faça seu cadastro para comprar um lance");
        } else {

            System.out.println("Qual o valor do seu lance? ");
            valorLance = valor.nextDouble();

            Lance lance = new Lance(usuarioBackup, valorLance);
            boolean resposta = principal.registrarLance(lance);

            ArrayList<Lance> lances = principal.retornaLancesUsuario(usuarioBackup);
            core.mostraLances(lances);

            System.out.println("Qual lance você deseja comprar? ");
            indiceLance = valor.nextInt();

            boolean respostaCompra = principal.comprarLance(usuarioBackup, lance, indiceLance);

            if (respostaCompra == true) {
                System.out.println("Lance comprado com sucesso");
            } else {
                System.out.println("Erro ao comprar Lance");
            }

            main(args);

        }

    }

    public static void venda() {
        System.out.println("Você entrou no método Consulta.");
    }

    public static void limpar() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) throws Exception {
        int opcao;
        Scanner entrada = new Scanner(System.in);

        try {
            do {
                menu();
                opcao = entrada.nextInt();

                switch (opcao) {

                case 0:
                    System.out.println("Saindo...");
                    break;
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
                case 6:
                    limpar();
                    break;
                default:
                    System.out.println("Opção inválida.");
                }

            } while (opcao != 0);
        } catch (InputMismatchException e) {
            System.out.println("Erro: Digite somente números");
            main(args);

        } catch (NotBoundException e) {
            System.out.println("Erro no servidor");
            System.out.println("Procurando objeto no outro servidor");

        } catch (ConnectException e) {
            System.out.println("Servidor fora do ar");
            System.out.println("Buscando outro");
            principal = (Interface) Naming.lookup("rmi:///cadastro");
            main(args);

        } catch (NullPointerException e) {
            System.out.println("Lista vazia");
            main(args);
        }

    }
}
