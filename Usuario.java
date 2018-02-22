import java.io.*;
import java.util.*;
import java.rmi.*;

public class Usuario implements Serializable {

  private String nome;
  private double saldo;
  private String status;
  private Random gerador = new Random();
  private int hash;

  public void setStatus(String status) {
    this.status = status;
  }
  
  public String getStatus() {
    return this.status;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getNome() {
    return this.nome;
  }

  public void setSaldo(Double saldo) {
    this.saldo = saldo;
  }

  public Double getSaldo() {
    return this.saldo;
  }

  public void geraHash() {
    Random g;

    g = this.gerador;

    int valor = g.nextInt();
    this.hash = valor;

  }

  public int getHash() {

    return this.hash;
  }

  @Override
  public int hashCode() {
    //deve ser o mesmo resultado para um mesmo objeto, não pode ser aleatório
    return this.hash;
  }

  @Override
  public boolean equals(Object obj) {
    //se nao forem objetos da mesma classe sao objetos diferentes
    if (!(obj instanceof Usuario))
      return false;

    //se forem o mesmo objeto, retorna true
    if (obj == this)
      return true;

    // aqui o cast é seguro por causa do teste feito acima
    Usuario usuario = (Usuario) obj;

    //aqui você compara a seu gosto, o ideal é comparar atributo por atributo
    return this.hash == usuario.getHash() && this.nome.equals(usuario.getNome());
  }

}
