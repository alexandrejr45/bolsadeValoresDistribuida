public class Usuario {

    private String nome;
    private double lance;
    private double saldo;
    private String status;
    private int idade;


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

    public void SetSaldo(Double saldo){
      this.saldo = saldo;
    }

    public Double getSaldo(){
      return this.saldo;
    }


}
