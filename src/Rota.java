package src;
public class Rota {
    private String codigoRota;

    private long minutosRota = 0;
    private Cidade origem;
    private Cidade destino;

    public Rota(String codigoRota) {
        if (codigoRota.length() < 4 || codigoRota.length() > 4) {
            throw new IllegalArgumentException("Código rota inválido");
        } 
        this.codigoRota = codigoRota;
    }

    public String DefinirOrigem(Cidade origem) {
        if (this.origem != null) {
            throw new IllegalArgumentException("Essa rota ja possui uma origem");
        }

        if (this.destino != null && origem == this.destino) {
            throw new IllegalArgumentException("A origem e o destino de uma rota não podem ser os mesmos");
        }

        this.origem = origem;
        return (origem + " foi definida como a origem com sucesso");
    }

    public String DefinirDestino(Cidade destino) {
        if (this.destino != null) {
            throw new IllegalArgumentException("Essa rota ja possui um destino");
        }

        if (this.origem != null && destino == this.origem) {
            throw new IllegalArgumentException("O destino e a origem de uma rota não podem ser os mesmos");
        }

        this.destino = destino;
        return (destino + " foi definida como o destino com sucesso");
    }

    public String DefinirMinutosRota(long minutosRota) {
        if (minutosRota <= 60) {
            throw new IllegalArgumentException("Tempo inválido, muito curto para ser verdadeiro");
        }

        this.minutosRota = minutosRota;
        return ("O tempo total da rota foi definido como " + minutosRota);
    }

    public void ResetarRota() {
        this.origem = null;
        this.destino = null;
        this.minutosRota = 0;
    }

    public String getCodigo() {
        return codigoRota;
    }

    public Cidade getOrigem() {
        if (this.origem == null) {
            throw new IllegalArgumentException("Essa rota ainda não possui uma origem");
        }

        return origem;
    }

    public Cidade getDestino() {
        if (this.destino == null) {
            throw new IllegalArgumentException("Essa rota ainda não possui um destino");
        }

        return destino;
    }

    public long getMinutosRota() {
        if (minutosRota == 0) {
            throw new IllegalArgumentException("Essa rota ainda não possui um tempo de duração definido");
        }

        return minutosRota;
    }
}
