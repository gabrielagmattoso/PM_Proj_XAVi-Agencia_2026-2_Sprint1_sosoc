import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class BilheteTest {


    Cliente cliente = new Cliente("Ana");
    Cidade A = new Cidade("A");
    Cidade B = new Cidade("B");
    Cidade C = new Cidade("C");
    Cidade D = new Cidade("D");
    LocalDate hoje = LocalDate.of(2026, 11, 23);

    @Test
    void construtorSemClienteLancaExcecao() {
        assertThrows(IllegalArgumentException.class, () -> new Bilhete(null));
    }

    @Test
    void origemSemVoosLancaExcecao() {
        Bilhete b = new Bilhete(cliente);
        assertThrows(IllegalArgumentException.class, () -> b.getOrigem());
    }

    @Test
    void destinoSemVoosLancaExcecao() {
        Bilhete b = new Bilhete(cliente);
        assertThrows(IllegalStateException.class, () -> b.getDestino());
    }

    @Test
    void origemEDestinoComDoisVoos() {
        Bilhete b = new Bilhete(cliente);
        b.adicionarVoo(new Voo(A, B, hoje, 100, 10));
        b.adicionarVoo(new Voo(B, C, hoje, 200, 10));
        assertEquals(A, b.getOrigem());
        assertEquals(C, b.getDestino());
    }

    @Test
    void consecutivosDiaSeguinte() {
        Voo v1 = new Voo(A, B, hoje, 100, 10);
        Voo v2 = new Voo(B, C, hoje.plusDays(1), 100, 10);
        assertEquals(true, Bilhete.voosConsecutivos(v1, v2));
    }

    @Test
    void naoConsecutivosDoisDiasDepois() {
        Voo v1 = new Voo(A, B, hoje, 100, 10);
        Voo v2 = new Voo(B, C, hoje.plusDays(2), 100, 10);
        assertEquals(false, Bilhete.voosConsecutivos(v1, v2));
    }

    @Test
    void naoConsecutivosOrigemDiferenteDoDestino() {
        Voo v1 = new Voo(A, B, hoje, 100, 10);
        Voo v2 = new Voo(C, A, hoje, 100, 10);
        assertEquals(false, Bilhete.voosConsecutivos(v1, v2));
    }

    @Test
    void adicionarVooSemVagaRetornaFalse() {
        Bilhete b = new Bilhete(cliente);
        assertEquals(false, b.adicionarVoo(new Voo(A, B, hoje, 100, 0)));
        assertEquals(0, b.getVoos().size());
    }

    @Test
    void adicionarVooNaoConsecutivoRetornaFalse() {
        Bilhete b = new
