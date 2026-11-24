package src;
import java.util.List;
import java.util.ArrayList;
public class Cliente { 
    private int registro;
    private String nome;
    private String sobrenome;
    private List<Bilhete> bilhetes;
    private static int proximoRegistro = 1;

    public Cliente(String nome , String sobrenome ){
        this.registro = proximoRegistro++ ;
        this.nome = nome ;
        this.sobrenome = sobrenome;
        this.bilhetes = new ArrayList<>();
    }

    public int  getRegistro (){
        return registro;
    }

    public String getNome (){
        return nome;
    }

    public String getSobrenome (){
        return sobrenome;
    }

    public void registrarBilhete (Bilhete bilhete){
        bilhetes.add(bilhete);
    }

    public List<Bilhete> getBilhetes(){
        return bilhetes ;
    }

    public double totalGasto() {
        if (bilhetes.isEmpty()) {
            throw new IllegalStateException("O cliente não possui bilhetes cadastrados.");
        }
        double total = 0;
        for (Bilhete b : bilhetes) {
            total += b.precoVenda();
        }
        return total;
    }

}
