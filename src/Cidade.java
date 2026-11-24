package src;
public enum Cidade {
    BELO_HORIZONTE(13),
    FORTALEZA(21),
    RECIFE(50),
    JOAO_PESSOA(34),
    SAO_LUIS(42),
    NATAL(68);

    private final int codigo;

    Cidade(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public static Cidade deCodigo(int codigo) {
        for (Cidade c : values()) {
            if (c.codigo == codigo) {
                return c;
            }
        }
        throw new IllegalArgumentException("Código de cidade inválido: " + codigo);
    }
}