package src;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class RotaTest {

    private final Rota rota = new Rota("R001");

    @Test
    void construtorDeveAceitarCodigoComQuatroCaracteres() {
        assertEquals("R001", rota.getCodigo());
    }

    @Test
    void construtorDeveRejeitarCodigoCurtoELongo() {
        assertThrows(IllegalArgumentException.class, () -> new Rota("ABC"));
        assertThrows(IllegalArgumentException.class, () -> new Rota("ABCDE"));
    }

    @Test
    void origemEDestinoDevemSerGuardados() {
        rota.DefinirOrigem(Cidade.BELO_HORIZONTE);
        rota.DefinirDestino(Cidade.SAO_PAULO);
        assertSame(Cidade.BELO_HORIZONTE, rota.getOrigem());
        assertSame(Cidade.SAO_PAULO, rota.getDestino());
    }

    @Test
    void naoDeveDefinirOrigemDuasVezes() {
        rota.DefinirOrigem(Cidade.BELO_HORIZONTE);
        assertThrows(IllegalArgumentException.class, () -> rota.DefinirOrigem(Cidade.RECIFE));
    }

    @Test
    void naoDeveDefinirDestinoDuasVezes() {
        rota.DefinirDestino(Cidade.SAO_PAULO);
        assertThrows(IllegalArgumentException.class, () -> rota.DefinirDestino(Cidade.RECIFE));
    }

    @Test
    void origemNaoPodeSerIgualAoDestino() {
        rota.DefinirDestino(Cidade.RECIFE);
        assertThrows(IllegalArgumentException.class, () -> rota.DefinirOrigem(Cidade.RECIFE));
    }

    @Test
    void destinoNaoPodeSerIgualAOrigem() {
        rota.DefinirOrigem(Cidade.RECIFE);
        assertThrows(IllegalArgumentException.class, () -> rota.DefinirDestino(Cidade.RECIFE));
    }

    @Test
    void minutosDevemAceitarSessentaEUm() {
        rota.DefinirMinutosRota(61);
        assertEquals(61, rota.getMinutosRota());
    }

    @Test
    void minutosDevemRejeitarSessentaENegativo() {
        assertThrows(IllegalArgumentException.class, () -> rota.DefinirMinutosRota(60));
        assertThrows(IllegalArgumentException.class, () -> rota.DefinirMinutosRota(-10));
    }

    @Test
    void gettersDevemLancarExcecaoQuandoNaoDefinidos() {
        assertThrows(IllegalArgumentException.class, () -> rota.getOrigem());
        assertThrows(IllegalArgumentException.class, () -> rota.getDestino());
        assertThrows(IllegalArgumentException.class, () -> rota.getMinutosRota());
    }

    @Test
    void resetarDeveLimparEPermitirRedefinir() {
        rota.DefinirOrigem(Cidade.BELO_HORIZONTE);
        rota.DefinirDestino(Cidade.SAO_PAULO);
        rota.DefinirMinutosRota(150);
        rota.ResetarRota();
        assertThrows(IllegalArgumentException.class, () -> rota.getOrigem());
        assertDoesNotThrow(() -> rota.DefinirOrigem(Cidade.SAO_PAULO));
        assertEquals("R001", rota.getCodigo());
    }
}
