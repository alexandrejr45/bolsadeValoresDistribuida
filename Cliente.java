public class Cliente {

    private String nome;
    private double lance;
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


}
