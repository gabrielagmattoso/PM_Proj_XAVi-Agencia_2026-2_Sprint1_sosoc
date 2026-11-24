package src;

import java.util.Locale;

public class Rota {
    private final ECidade origem;
    private final ECidade destino;

    public Rota(ECidade origem, ECidade destino) {
        if (origem == null || destino == null) {
            throw new IllegalArgumentException("Rota precisa de origem e destino");
        }
        if (origem == destino) {
            throw new IllegalArgumentException("Origem e destino não podem ser iguais");
        }
        this.origem = origem;
        this.destino = destino;
    }

    public ECidade getOrigem() {
        return origem;
    }

    public ECidade getDestino() {
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
        ECidade origem = ECidade.deCodigo(Integer.parseInt(codigo.substring(0, 2)));
        ECidade destino = ECidade.deCodigo(Integer.parseInt(codigo.substring(2)));
        return new Rota(origem, destino);
    }
}
