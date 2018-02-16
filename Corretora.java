import java.util.*;

public class Corretora{
    private static Corretora Corretora;

    private Corretora(){}

    private static ArrayList<Cliente> clientes = new ArrayList<>();

        public static void setClientes(Cliente cliente){
             clientes.add(cliente);
        }

    public static void main(String args[]){
        Scanner valor = new Scanner(System.in);

        Cliente cliente = new Cliente();

        System.out.println("Qual seu nome? ");
        cliente.setNome(valor.next());

        System.out.println("Você deseja comprar ou vender? ");
        cliente.setStatus(valor.next());

        System.out.println("Qual o seu lance? ");
        cliente.setLance(valor.nextDouble());

        Corretora.setClientes(cliente);


    }


}
