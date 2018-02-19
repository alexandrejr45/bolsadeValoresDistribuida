import java.lang.*;
import java.io.*;
import java.util.*;
import java.lang.String;
import javax.swing.*;
import java.rmi.*;

public interface Interface extends Remote{
    public boolean registraCliente(Usuario cliente)
    throws java.rmi.RemoteException;

    public ArrayList retornaClientes()
    throws java.rmi.RemoteException;

    public ArrayList registrarLance()
    throws java.rmi.RemoteException;

}
