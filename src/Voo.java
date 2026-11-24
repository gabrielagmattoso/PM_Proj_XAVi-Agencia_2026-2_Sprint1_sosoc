package src;
import java.time.LocalDate;

public class Voo {
    private final Rota rota;
    private final LocalDate data;
    private final double precoBase;
    private static final int CAPACIDADE = 150;
    private int passageiros = 0;


    public Voo(Rota rota, LocalDate data, double precoBase) {
        if (rota == null) {
            throw new IllegalArgumentException("Voo precisa de uma rota");
        }
        if (data == null) {
            throw new IllegalArgumentException("Voo precisa de uma data");
        }
        if (precoBase <= 0 ) {
            throw new IllegalArgumentException("O preço base deve ser maior que zero");
        }
        this.rota = rota;
        this.data = data;
        this.precoBase = precoBase;
    }

    public String getCodigo(){
        return rota.getCodigo();
    }

    public ECidade getOrigem(){
        return rota.getOrigem();    
    }

    public ECidade getDestino(){
        return rota.getDestino();
    }

    public LocalDate getData(){
        return data;
    }

    public double getPrecoBase(){
        return precoBase;
    }

    public boolean temVaga(){

        if (passageiros >= CAPACIDADE) {
            return false;
        } 
        else {
            return true;
        }
    }

    public void reservarVaga(){

        if (temVaga()){
            passageiros += 1;
        }
        else {
            throw new IllegalArgumentException("Não é possível reservar vaga");
        }
    }
}