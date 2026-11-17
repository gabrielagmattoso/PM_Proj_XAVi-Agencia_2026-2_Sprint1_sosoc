import java.util.List;
import java.util.ArrayList;
public class Cliente { 
    private int registro;
    private String nome;
    private String sobrenome;
    private List<Bilhete> bilhetes;
    private static int proximoregistro = 1;

    public Cliente(String nome , String sobrenome ){
        this.registro = proximoregistro++ ;
        this.nome = nome ;
        this.sobrenome = sobrenome;
        this.bilhetes = new ArrayList<>();
    }

    public int  getId (){
        return id;
    }

    public String getNome (){
        return nome;
    }

    public String getSobrenome (){
        return sobrenome;
    }

    public void adicionarBilhete (Bilhete bilhete){
        bilhetes.add(bilhete);
    }

    public List<Bilhete> getBilhetes(){
        return bilhetes ;
    }

    public Double totalGasto (){ 
        return this.bilhetes[bilhetes.size() - 1].precoVenda();

    }

}
