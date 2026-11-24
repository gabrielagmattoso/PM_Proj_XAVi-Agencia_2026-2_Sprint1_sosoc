package src;
import java.util.ArrayList;
import java.time.LocalDate;

public class Bilhete {
    private String codigo;
    private Cliente cliente;
    private ArrayList<Voo> voos;
    private static int proximoCodigo = 1;

    public Bilhete(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("Bilhete precisa de cliente");
        }
        this.cliente = cliente;
        this.voos = new ArrayList<>();
        this.codigo = "BIL" + String.format("%05d", proximoCodigo++);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getCodigo() {
        return codigo;
    }

    public ArrayList<Voo> getVoos() {
        return voos;
    }

    public Cidade getOrigem() {
        if (voos.isEmpty()) {
            throw new IllegalArgumentException("Bilhete sem voos");
        }
        Voo primeiroVoo = voos.get(0);
        Cidade origem = primeiroVoo.getOrigem();
        return origem;
    }

    public Cidade getDestino() {
        if (voos.isEmpty()) {
            throw new IllegalStateException("Bilhete sem voos");
        }
        Voo ultimoVoo = voos.get(voos.size() - 1);
        Cidade destino = ultimoVoo.getDestino();
        return destino;
    }

    public static boolean voosConsecutivos(Voo anterior, Voo novo) {
        if (anterior == null || novo == null) {
            return false;
        }
        LocalDate dia = anterior.getData();
        boolean dataValida = !novo.getData().isBefore(dia)
                          && !novo.getData().isAfter(dia.plusDays(1));
        return novo.getOrigem() == anterior.getDestino() && dataValida;
    }

    public boolean adicionarVoo(Voo v) {
        if (v == null || !v.temVaga()) {
            return false;
        }
        if (!voos.isEmpty() && !voosConsecutivos(voos.get(voos.size() - 1), v)) {
            return false;
        }
        voos.add(v);
        return true;
    }

    public boolean temVagas() {
        if (voos.isEmpty()) {
            return false;
        }
        for (Voo v : voos) {
            if (!v.temVaga()) {
                return false;
            }
        }
        return true;
    }

    public double precoVenda() {
        if (voos.isEmpty()) {
            return 0;
        }
        double soma = 0;
        double maior = 0;
        double segundo = 0;
        for (Voo v : voos) {
            double preco = v.getPrecoBase();
            soma += preco;
            if (preco > maior) {
                segundo = maior;
                maior = preco;
            } else if (preco > segundo) {
                segundo = preco;
            }
        }
        if (voos.size() == 1) {
            return soma;
        }
        return 0.6 * maior + 0.4 * segundo + 0.1 * (soma - maior - segundo);
    }
}
