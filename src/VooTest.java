package src;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

public class VooTest{

    private static final LocalDate DATA = LocalDate.of(2026, 12, 1);
    private static final double PRECO = 500.0;
    private static final int CAPACIDADE = 150;

    private Rota criarRota(){
        return new Rota(ECidade.BELO_HORIZONTE, ECidade.RECIFE);
    }

    private Voo criarVoo(){
        return new Voo(criarRota(), DATA, PRECO);
    }

    private void reservar(Voo voo, int vezes) {
    for (int i = 0; i < vezes; i++) {
        voo.reservarVaga();
    }
}

    @Test
    void construtorRejeitaRotaNula() {
        assertThrows(IllegalArgumentException.class,
                () -> new Voo(null, DATA, PRECO));
    }

    @Test
    void construtorRejeitaDataNula() {
        assertThrows(IllegalArgumentException.class,
                () -> new Voo(criarRota(), null, PRECO));
    }

    @Test
    void construtorRejeitaPrecoBaseInvalido() {
        assertThrows(IllegalArgumentException.class,
                () -> new Voo(criarRota(), DATA, 0));
        assertThrows(IllegalArgumentException.class,
                () -> new Voo(criarRota(), DATA, -1));
        assertThrows(IllegalArgumentException.class,
                () -> new Voo(criarRota(), DATA, Double.NaN));
    }

    @Test void vooNovoTemVaga() {
        Voo voo = criarVoo();
        assertTrue(voo.temVaga());
    }

    @Test
    void com149ReservasAindaTemVaga() {
        Voo voo = criarVoo();
        reservar(voo, CAPACIDADE - 1);
        assertTrue(voo.temVaga());
    }
    
    @Test
    void com150ReservasNaoTemVaga() {
        Voo voo = criarVoo();
        reservar(voo, CAPACIDADE);
        assertFalse(voo.temVaga());
    }

    @Test
    void reservaEmVooComVagaMantemVaga() {
        Voo voo = criarVoo();
        voo.reservarVaga();
        assertTrue(voo.temVaga());
    }

    @Test
    void reservaEmVooLotadoLancaExcecao() {
        Voo voo = criarVoo();
        reservar(voo, CAPACIDADE);
        assertThrows(IllegalArgumentException.class, () -> voo.reservarVaga());
        assertFalse(voo.temVaga());
    }

    @Test
    void getDataDevolveDataDoConstrutor() {
        Voo voo = criarVoo();
        assertEquals(DATA, voo.getData());
    }

     @Test
    void getPrecoBaseDevolvePrecoDoConstrutor() {
        Voo voo = criarVoo();
        assertEquals(PRECO, voo.getPrecoBase(), 0.001); // 0.001 = tolerância do double
    }

    @Test
    void getOrigemEGetDestinoDevolvemCidadesDaRota() {
        Voo voo = criarVoo();
        assertEquals(ECidade.BELO_HORIZONTE, voo.getOrigem());
        assertEquals(ECidade.RECIFE, voo.getDestino());
    }

    @Test
    void getCodigoDevolveCodigoDaRota() {
        Voo voo = criarVoo();
        assertEquals("1350", voo.getCodigo());
    }

}