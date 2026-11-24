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

    public Double totalGasto (){ 
          if (this.bilhetes.isEmpty()) {
            throw new IllegalStateException("O cliente não possui bilhetes cadastrados.");
        }
        return this.bilhetes.get(bilhetes.size() - 1).precoVenda();

    }

}
