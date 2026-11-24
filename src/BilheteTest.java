package src;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class BilheteTest {

    Cliente cliente = new Cliente("Ana", "Silva");
    ECidade A = ECidade.BELO_HORIZONTE;
    ECidade B = ECidade.RECIFE;
    ECidade C = ECidade.JOAO_PESSOA;
    ECidade D = ECidade.NATAL;
    LocalDate hoje = LocalDate.of(2026, 11, 23);

    private Rota criarRota(ECidade origem, ECidade destino) {
        return new Rota(origem, destino);
    }

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
        Rota r1 = criarRota(A, B);
        Rota r2 = criarRota(B, C);

        Bilhete b = new Bilhete(cliente);
        b.adicionarVoo(new Voo(r1, hoje, 100));
        b.adicionarVoo(new Voo(r2, hoje, 200));
        assertEquals(A, b.getOrigem());
        assertEquals(C, b.getDestino());
    }

    @Test
    void consecutivosDiaSeguinte() {
        Rota r1 = criarRota(A, B);
        Rota r2 = criarRota(B, C);

        Voo v1 = new Voo(r1, hoje, 100);
        Voo v2 = new Voo(r2, hoje.plusDays(1), 100);
        assertEquals(true, Bilhete.voosConsecutivos(v1, v2));
    }

    @Test
    void naoConsecutivosDoisDiasDepois() {
        Rota r1 = criarRota(A, B);
        Rota r2 = criarRota(B, C);

        Voo v1 = new Voo(r1, hoje, 100);
        Voo v2 = new Voo(r2, hoje.plusDays(2), 100);
        assertEquals(false, Bilhete.voosConsecutivos(v1, v2));
    }

    @Test
    void naoConsecutivosOrigemDiferenteDoDestino() {
        Rota r1 = criarRota(A, B);
        Rota r2 = criarRota(C, A);

        Voo v1 = new Voo(r1, hoje, 100);
        Voo v2 = new Voo(r2, hoje, 100);
        assertEquals(false, Bilhete.voosConsecutivos(v1, v2));
    }

    @Test
    void adicionarVooSemVagaRetornaFalse() {
        Rota r1 = criarRota(A, B);
        Voo lotado = new Voo(r1, hoje, 100);
        for (int i = 0; i < 150; i++) {
            lotado.reservarVaga();
        }

        Bilhete b = new Bilhete(cliente);
        assertEquals(false, b.adicionarVoo(lotado));
        assertEquals(0, b.getVoos().size());
    }

    @Test
    void adicionarVooNaoConsecutivoRetornaFalse() {
        Rota r1 = criarRota(A, B);
        Rota r2 = criarRota(C, D);

        Bilhete b = new Bilhete(cliente);
        b.adicionarVoo(new Voo(r1, hoje, 100));
        assertEquals(false, b.adicionarVoo(new Voo(r2, hoje, 100)));
        assertEquals(1, b.getVoos().size());
    }
}