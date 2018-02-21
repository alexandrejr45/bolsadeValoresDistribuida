  import java.io.*;
  import java.util.*;
  import java.rmi.*;


  public class Usuario implements Serializable {

    private String nome;
    private double lance;
    private double saldo;
    private String status;
    private int idade;
    private Random gerador = new Random();


    public void setStatus(String status){
        this.status = status;
    }

    public String getStatus(){
        return this.status;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    public void setLance(Double lance){
      this.lance = lance;
    }

    public Double getLance(){
      return this.lance;
    }

    public void setSaldo(Double saldo){
      this.saldo = saldo;
    }

    public Double getSaldo(){
      return this.saldo;
    }

    public int geraHash(){
      g = this.gerador;
      
      int valor = g.nextInt();

      return valor;

    }


  }
