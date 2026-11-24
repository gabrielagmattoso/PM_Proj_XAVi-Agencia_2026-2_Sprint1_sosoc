package src;

import java.util.ArrayList;
import java.util.List;

public class Cliente implements IRelatorio {
    private static int proximoRegistro = 1;

    private final int registro;
    private String nome;
    private String sobrenome;
    private List<Bilhete> bilhetes;

    public Cliente(String nome, String sobrenome) {
        this.registro = proximoRegistro++;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.bilhetes = new ArrayList<>();
    }

    public int getRegistro() {
        return registro;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public List<Bilhete> getBilhetes() {
        return bilhetes;
    }

    public void registrarBilhete(Bilhete bilhete) {
        bilhetes.add(bilhete);
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

    @Override
    public String gerarRelatorio() {
        String texto = "Cliente: " + nome + " " + sobrenome + " (registro " + registro + ")\n";

        if (bilhetes.isEmpty()) {
            return texto + "Nenhum bilhete comprado.";
        }

        for (Bilhete b : bilhetes) {
            texto += b.getCodigo() + ": " + b.getOrigem() + " -> " + b.getDestino()
                    + " - R$ " + b.precoVenda() + "\n";
        }
        return texto + "Total gasto: R$ " + totalGasto();
    }
}