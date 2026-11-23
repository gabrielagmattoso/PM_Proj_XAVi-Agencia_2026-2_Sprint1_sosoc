import java.util.ArrayList;
import java.time.LocalDate;

class Bilhete {
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
