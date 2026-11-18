import java.time.LocalDate;

public class Voo {
    private Rota rota; 
    private LocalDate data;
    private double precoBase;
    private static final int CAPACIDADE = 150;
    private int passageiros = 0;


    public Voo (Rota rota, LocalDate data, double precoBase) {
        this.rota = rota;
        this.data = data;
        this.precoBase = precoBase;
    }

    public String getCodigo(){
        return rota.getCodigo();
    }

    public Cidade getOrigem(){
        return rota.getOrigem();    
    }

    public Cidade getDestino(){
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
            IO.print("Não é possível reservar vagas");
        }
    }
}