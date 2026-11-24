import src.*;

public class Agencia{

    public void mostrarMenu(){

    }

    public void loopPrincipal(){

    }

    public void cadastrarCliente(){

    }

    public void gerarRotas(){

    }

    public String cadastrarVoos(Voo voo){  
        return ("Voo para" + voo.getDestino() 
                + "na data" + voo.getData() 
                + "pelo valor de" + voo.getPrecoBase());
    }

    public void procurarVoos(){

    }

    public void criarBilhete(){

    }

    public void comprarBilhete(Cliente cliente, Bilhete bilhete){
        cliente.registrarBilhete(bilhete);
        cliente.totalGasto();
    }

    public static void main(String[] args){

    }
}