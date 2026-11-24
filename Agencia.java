import src.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Agencia{
    private final List<Rota> rotas;

    public Agencia(){
        rotas = new ArrayList<>();
    }

    public void mostrarMenu(){
        System.out.println("-- Agencia de Viagens --");
        System.out.println("1 - Cadastrar cliente");
        System.out.println("2 - Gerar rotas");
        System.out.println("3 - Cadastrar voo");
        System.out.println("4 - Procurar voos");
        System.out.println("5 - Criar bilhete");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opcao: ");
    }

    public void loopPrincipal(){

    }

    public void cadastrarCliente(){

    }

    public void gerarRotas(){
        System.out.println("\nRotas disponiveis:");

        for (ECidade origem : ECidade.values()) {
            for (ECidade destino : ECidade.values()) {
                if (origem != destino) {
                    Rota rota = new Rota(origem, destino);
                    rotas.add(rota);
                    System.out.println(
                            rota.getCodigo() + " - "
                            + origem + " -> " + destino
                    );
                }
            }
        }
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