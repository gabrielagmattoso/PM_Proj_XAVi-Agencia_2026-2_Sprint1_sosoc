package src;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class RotaTest {

    @Test
    void construtorGuardaOrigemEDestino() {
        Rota rota = new Rota(Cidade.BELO_HORIZONTE, Cidade.FORTALEZA);
        assertSame(Cidade.BELO_HORIZONTE, rota.getOrigem());
        assertSame(Cidade.FORTALEZA, rota.getDestino());
    }

    @Test
    void construtorRejeitaCidadesNulasOuIguais() {
        assertThrows(IllegalArgumentException.class, () -> new Rota(null, Cidade.FORTALEZA));
        assertThrows(IllegalArgumentException.class, () -> new Rota(Cidade.BELO_HORIZONTE, null));
        assertThrows(IllegalArgumentException.class,
                () -> new Rota(Cidade.RECIFE, Cidade.RECIFE));
    }

    @Test
    void codigoRepresentaOsCodigosDeOrigemEDestino() {
        Rota rota = new Rota(Cidade.BELO_HORIZONTE, Cidade.FORTALEZA);
        assertEquals("1321", rota.getCodigo());
    }

    @Test
    void deCodigoReconstruiRota() {
        Rota rota = Rota.deCodigo("1350");
        assertSame(Cidade.BELO_HORIZONTE, rota.getOrigem());
        assertSame(Cidade.RECIFE, rota.getDestino());
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