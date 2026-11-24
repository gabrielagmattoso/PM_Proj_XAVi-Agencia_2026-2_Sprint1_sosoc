import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClienteTest {

    private Cliente cliente;

    @BeforeEach
    public void setUp() {
        cliente = new Cliente("João", "Silva");
    }

    @Test
    public void deveInicializarClienteComDadosCorretosEListaVazia() {
        assertEquals("João", cliente.getNome());
        assertEquals("Silva", cliente.getSobrenome());
        assertNotNull(cliente.getBilhetes());
        assertTrue(cliente.getBilhetes().isEmpty());
    }

    @Test
    public void deveGerarRegistrosSequenciaisParaNovosClientes() {
        Cliente cliente1 = new Cliente("Maria", "Oliveira");
        Cliente cliente2 = new Cliente("Carlos", "Santos");

        assertEquals(cliente1.getId() + 1, cliente2.getId());
    }

    @Test
    public void deveLancarExcecaoAoCalcularTotalGastoComListaVazia() {
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            cliente.totalGasto();
        });

        assertEquals("O cliente não possui bilhetes cadastrados.", exception.getMessage());
    }

    @Test
    public void deveAdicionarBilhetesERetornarPrecoDoUltimoBilhete() {
        Bilhete primeiroBilhete = new Bilhete(cliente);
        Bilhete ultimoBilhete = new Bilhete(cliente);

        cliente.registrarBilhete(primeiroBilhete);
        cliente.registrarBilhete(ultimoBilhete);

        assertEquals(2, cliente.getBilhetes().size());
        assertTrue(cliente.getBilhetes().contains(primeiroBilhete));
        assertTrue(cliente.getBilhetes().contains(ultimoBilhete));
        assertEquals(ultimoBilhete.precoVenda(), cliente.totalGasto(), 0.001);
    }
}
