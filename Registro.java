import java.lang.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.*;
import java.rmi.registry.Registry;

public class Registro {
    private static Registro reg;
    private static Registry criacao;
    private static Registry resposta;
    
    private Registro() {};

    public static Registro getInstancia() {
        if (Registro.reg == null) {
          Registro.reg = new Registro();
        }
        return reg;
      }

    public static Registry criaRegistro(int porta) throws RemoteException{
        criacao = LocateRegistry.createRegistry(porta);

        return criacao;

    }

    public static Registry getRegistro(int porta) throws RemoteException{
        resposta = LocateRegistry.getRegistry(porta);
        
        return resposta;
    }

}