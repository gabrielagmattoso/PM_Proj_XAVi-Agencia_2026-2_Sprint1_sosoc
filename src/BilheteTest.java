import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BilheteTest {

    private Cliente cliente = new Cliente("Ana", "Silva");
    private Bilhete bilhete = new Bilhete(cliente);

    @Test
    void construtorSemClienteLancaExcecao() {
        assertThrows(IllegalArgumentException.class, () -> new Bilhete(null));
    }

    @Test
    void construtorGuardaCliente() {
        assertSame(cliente, bilhete.getCliente());
    }

    @Test
    void bilheteNovoNaoTemVoos() {
        assertTrue(bilhete.getVoos().isEmpty());
    }

    @Test
    void codigoTemFormatoBIL() {
        assertTrue(bilhete.getCodigo().matches("BIL\\d{5}"));
    }

    @Test
    void origemSemVoosLancaExcecao() {
        assertThrows(IllegalArgumentException.class, () -> bilhete.getOrigem());
    }

    @Test
    void destinoSemVoosLancaExcecao() {
        assertThrows(IllegalStateException.class, () -> bilhete.getDestino());
    }

    @Test
    void adicionarVooNuloRetornaFalse() {
        assertFalse(bilhete.adicionarVoo(null));
    }

    @Test
    void voosConsecutivosComNuloRetornaFalse() {
        assertFalse(Bilhete.voosConsecutivos(null, null));
    }

    @Test
    void temVagasSemVoosRetornaFalse() {
        assertFalse(bilhete.temVagas());
    }

    @Test
    void precoVendaSemVoosEhZero() {
        assertEquals(0.0, bilhete.precoVenda(), 0.001);
    }
}