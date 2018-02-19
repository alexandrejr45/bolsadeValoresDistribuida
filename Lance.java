import java.io.*;
import java.util.*;
import java.rmi.*;

public class Lance implements Serializable{
    private Double valor;
    private Usuario usuario;

    public Lance(Usuario usuario, Double valor){
      if(valor <= usuario.getSaldo()){
        this.usuario = usuario;
        this.valor = valor;
      }else{
        throw new RuntimeException("Saldo insuficiente");
      }
    }

    public void setValor(Double valor){
        this.valor = valor;
    }

    public Double getValor(){
        return this.valor;
    }

    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }

    public Usuario getUsuario(){
        return this.usuario;
    }



}
