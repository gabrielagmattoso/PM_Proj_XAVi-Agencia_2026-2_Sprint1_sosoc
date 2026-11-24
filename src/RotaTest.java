package src;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class RotaTest {

    @Test
    void construtorGuardaOrigemEDestino() {
        Rota rota = new Rota(ECidade.BELO_HORIZONTE, ECidade.FORTALEZA);
        assertSame(ECidade.FORTALEZA, rota.getDestino());
    }

    @Test
    void construtorRejeitaCidadesNulasOuIguais() {
        assertThrows(IllegalArgumentException.class, () -> new Rota(null, ECidade.FORTALEZA));
        assertThrows(IllegalArgumentException.class, () -> new Rota(ECidade.BELO_HORIZONTE, null));
        assertThrows(IllegalArgumentException.class,
                () -> new Rota(ECidade.RECIFE, ECidade.RECIFE));
    }

    @Test
    void codigoRepresentaOsCodigosDeOrigemEDestino() {
        Rota rota = new Rota(ECidade.BELO_HORIZONTE, ECidade.FORTALEZA);
        assertEquals("1321", rota.getCodigo());
    }

    @Test
    void deCodigoReconstruiRota() {
        Rota rota = Rota.deCodigo("1350");
        assertSame(ECidade.BELO_HORIZONTE, rota.getOrigem());
        assertSame(ECidade.RECIFE, rota.getDestino());
        assertEquals("1350", rota.getCodigo());
    }

    @Test
    void deCodigoRejeitaCodigoInvalido() {
        assertThrows(IllegalArgumentException.class, () -> Rota.deCodigo(null));
        assertThrows(IllegalArgumentException.class, () -> Rota.deCodigo("ABC"));
        assertThrows(IllegalArgumentException.class, () -> Rota.deCodigo("9999"));
        assertThrows(IllegalArgumentException.class, () -> Rota.deCodigo("1313"));
    }

    @Test
    void validarCodigoIndicaSeCodigoPodeSerDecodificado() {
        assertTrue(Rota.validarCodigo("1350"));
        assertFalse(Rota.validarCodigo(null));
        assertFalse(Rota.validarCodigo("13A0"));
        assertFalse(Rota.validarCodigo("9999"));
    }
}