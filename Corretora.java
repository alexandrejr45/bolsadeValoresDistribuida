import java.io.*;
import java.util.*;
import java.rmi.*;

public class Corretora implements Serializable {
  private static Corretora corretora;

  private Corretora() {
  };

  private static ArrayList<Usuario> lista = new ArrayList<Usuario>();
  private static ArrayList<Lance> lances = new ArrayList<Lance>();

  public static Corretora getInstancia() {
    if (Corretora.corretora == null) {
      Corretora.corretora = new Corretora();
    }
    return corretora;
  }

  public static boolean adicionarCliente(Usuario cliente) {
    if (cliente != null) {
      lista.add(cliente);
    }

    return true;
  }

  public ArrayList<Usuario> retornaLista() {
    return lista;
  }

  public void mostraClientes(ArrayList<Usuario> clientes) {
    Usuario p;
    System.out.println("Numero de clientes cadastrados: " + clientes.size());
    for (int i = 0; i < clientes.size(); i++) {
      p = clientes.get(i);
      System.out.println("--------------------------------------------");
      System.out.println("Loops = ");
      System.out.println(p.getNome());

    }
  }

  public void mostraLances(ArrayList<Lance> lances) {
    Lance p;
    System.out.println("Numero de lances cadastrados: " + lances.size());
    for (int i = 0; i < lances.size(); i++) {
      p = lances.get(i);
      System.out.println("--------------------------------------------");
      System.out.println("Lance do Usuario = " + p.getUsuario().getNome());
      System.out.println("Valor do Lance = " + p.getValor());

    }
  }

  public boolean adicionarLance(Lance lance) {
    if (lance != null) {
      lances.add(lance);
      return true;
    } else {
      return false;
    }
  }

  public ArrayList<Lance> retornaLances() {
    return lances;
  }

  public ArrayList<Lance> retornaLancesSaldo(Usuario usuario) {
    ArrayList<Lance> listaFinal = new ArrayList<Lance>();
    ArrayList<Lance> lances = retornaLances();
    ArrayList<Usuario> listaUsuarios = retornaLista();
    ArrayList<Usuario> listaFinal2 = new ArrayList<Usuario>();
    Usuario myUser = null;

    Lance p;
    Usuario u;

    for (int j = 0; j < listaUsuarios.size(); j++) {

      u = listaUsuarios.get(j);

      if (u.getHash() != usuario.getHash()) {
        listaFinal2.add(u);
      } else {
        myUser = u;
      }

    }

    for (int i = 0; i < lances.size(); i++) {

      p = lances.get(i);

      if (p.getUsuario() != myUser) {
        if (p.getValor() <= usuario.getSaldo()) {
          listaFinal.add(p);
        }

      }

    }

    return listaFinal;

  }

}
