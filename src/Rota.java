package src;

import java.util.Locale;

public class Rota {
    private final Cidade origem;
    private final Cidade destino;

    public Rota(Cidade origem, Cidade destino) {
        if (origem == null || destino == null) {
            throw new IllegalArgumentException("Rota precisa de origem e destino");
        }
        if (origem == destino) {
            throw new IllegalArgumentException("Origem e destino não podem ser iguais");
        }
        this.origem = origem;
        this.destino = destino;
    }

    public Cidade getOrigem() {
        return origem;
    }

    public Cidade getDestino() {
        return destino;
    }

    public String getCodigo() {
        return String.format(Locale.ROOT, "%02d%02d", origem.getCodigo(), destino.getCodigo());
    }

    public static boolean validarCodigo(String codigo) {
        try {
            deCodigo(codigo);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public static Rota deCodigo(String codigo) {
        if (codigo == null || !codigo.matches("[0-9]{4}")) {
            throw new IllegalArgumentException("Código de rota inválido: " + codigo);
        }
        Cidade origem = Cidade.deCodigo(Integer.parseInt(codigo.substring(0, 2)));
        Cidade destino = Cidade.deCodigo(Integer.parseInt(codigo.substring(2)));
        return new Rota(origem, destino);
    }
}
