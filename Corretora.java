import java.io.*;
import java.util.*;
import java.rmi.*;


public class Corretora implements Serializable{
    private static Corretora corretora;
    private Corretora(){};

    private static ArrayList<Usuario> lista = new ArrayList<Usuario>();
    private static ArrayList<Lance> lances = new ArrayList<Lance>();

    public static Corretora getInstancia(){
      if (Corretora.corretora == null) {
            Corretora.corretora = new Corretora();
        }
        return corretora;
    }

    public static boolean adicionarCliente(Usuario cliente){
        if(cliente != null){
          lista.add(cliente);
        }

        return true;
    }

    public ArrayList retornaLista(){
      return this.lista;
    }

    public void mostraClientes(ArrayList clientes){
      Usuario p;
      System.out.println ("Numero de clientes cadastrados: " + clientes.size());
      for (int i=0; i < clientes.size(); i++) {
        p = (Usuario) clientes.get(i);
        System.out.println ("--------------------------------------------");
        System.out.println ("Loops = ");
        System.out.println (p.getNome());

      }
    }

    public void mostraLances(ArrayList lances){
      Lance p;
      System.out.println ("Numero de lances cadastrados: " + lances.size());
      for (int i=0; i < lances.size(); i++) {
        p = (Lance) lances.get(i);
        System.out.println ("--------------------------------------------");
        System.out.println ("Lance do Usuario = " + p.getUsuario().getNome());
        System.out.println ("Valor do Lance = " + p.getValor());

      }
    }

    public static boolean adicionarLance(Lance lance){
      if(lance != null){
        lances.add(lance);
        return true;
      }else{
        return false;
      }
    }

    public ArrayList<Lance> retornaLances(){
      return this.lances;
    }

    public ArrayList<Lance> retornaLancesSaldo(Usuario usuario){
      ArrayList<Lance> listaFinal = new ArrayList<Lance>();
      ArrayList<Lance> lances = retornaLances();
      Lance p;


      for(int i = 0; i < lances.size(); i++){
         p = (Lance) lances.get(i);
        if(p.getValor() <= usuario.getSaldo()){
          listaFinal.add(p);
        }
      }

      return listaFinal;

    }



}
