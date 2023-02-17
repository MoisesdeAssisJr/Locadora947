package services;

import exceptions.ImpossivelRebobinarVHSJaRebobinado;
import exceptions.ProdutoIndisponivelParaAluguelException;
import exceptions.ProdutoNaoFoiAlugadoException;
import model.Cliente;
import model.Locadora;
import model.VHS;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class ClienteServiceImplTest {

    static ClienteServiceImpl clienteService;
    static Cliente cliente;
    static Locadora locadora947;
    static VHS titanic;

    @BeforeEach
    void beforeEach() {

        clienteService = new ClienteServiceImpl();
        cliente = new Cliente();
        locadora947 = new Locadora();
        titanic = new VHS(1,"Titanic");

//        @ExtendWith(MockitoExtension.class)
//        @Mock
//        VHS titanic = new VHS(1,"Titanic");
//
//        @InjectMocks
    }

    @Test
    public void deveIniciarComOStatusNaoAlugado() {
        Assertions.assertFalse(titanic.isAlugado);
    }

    @Test
    public void deveIniciarComOStatusNaoDanificado() {
        Assertions.assertFalse(titanic.isDanificado);
    }

    @Test
    public void deveIniciarComOStatusRebobinado() {
        Assertions.assertTrue(titanic.isRebobinado);
    }

    @Test
    public void deveAlterarCorretamenteOStatusParaAlugadoQuandoAlugar() {
        // When
        clienteService.alugar(titanic);

        // Then
        Assertions.assertTrue(titanic.isAlugado);
    }

    @Test
    public void deveAlterarCorretamenteOStatusParaNaoAlugadoQuandoDevolver() {
        // Given
        clienteService.alugar(titanic);

        // When
        clienteService.devolver(cliente, titanic, 2);

        // Then
        Assertions.assertFalse(titanic.isAlugado);
    }

    @Test
    public void deveSomarCorretamenteOPrecoDoAluguelConformeOsDiasDeAluguelQuandoDevolver() {
        // Given
        clienteService.alugar(titanic);

        // When
        clienteService.devolver(cliente, titanic, 2);

        // Then
        Assertions.assertEquals(0, cliente.getValorDevidoPorAluguel().compareTo(titanic.getPrecoAluguel().multiply(BigDecimal.valueOf(2))));
    }

    @Test
    public void deveAlterarCorretamenteOStatusDeRebobinadoQuandoOClienteRebobinar() {
        // Given
        clienteService.alugar(titanic);
        titanic.setRebobinado(false);

        // When
        clienteService.rebobinar(titanic);

        // Then
        Assertions.assertTrue(titanic.getRebobinado());
    }

    @Test
    public void deveLancarExceptionAoTentarAlugarProdutoIndisponvelParaAluguel() throws ProdutoIndisponivelParaAluguelException {
        // Given
        titanic.setAlugado(true);

        // Then
        Assertions.assertThrows(ProdutoIndisponivelParaAluguelException.class, () -> clienteService.alugar(titanic));
    }

    @Test
    public void deveLancarExceptionAoTentarDevolverProdutoQueNaoFoiAlugado() throws ProdutoNaoFoiAlugadoException {
        // Given
        titanic.setAlugado(false);

        // Then
        Assertions.assertThrows(ProdutoNaoFoiAlugadoException.class, () -> clienteService.devolver(cliente, titanic, 2));
    }

    @Test
    public void deveLancarExceptionAoTentarRebobinarVHSJaRebobinado() throws ImpossivelRebobinarVHSJaRebobinado {
        // Given
        titanic.setRebobinado(true);

        // Then
        Assertions.assertThrows(ImpossivelRebobinarVHSJaRebobinado.class, () -> clienteService.rebobinar(titanic));
    }

    @Test
    public void deveSomarCorretamenteOsPrecosDoAluguelEDasMultasQuandoDevolver() {
        // Given
        clienteService.alugar(titanic);
        titanic.setDanificado(true);
        titanic.setRebobinado(false);

        // When
        clienteService.devolver(cliente, titanic, 2);

        // Then
        Assertions.assertEquals(0, cliente.getValorDevidoPorAluguel().add(cliente.getMultaDevidaPorDanificar().add(cliente.getMultaDevidaPorNaoRebobinar())).compareTo(titanic.getPrecoAluguel().multiply(BigDecimal.valueOf(2))));
    }

    @Test
    public void deveZerarOValorDevidoPorAluguelQuandoPagar() {
        // Given
        clienteService.alugar(titanic);
        clienteService.devolver(cliente, titanic, 2);

        // When
        clienteService.pagar(cliente, locadora947);

        // Then
        Assertions.assertEquals(0, cliente.getValorDevidoPorAluguel().compareTo(BigDecimal.ZERO));
    }

    @Test
    public void deveZerarOValorDevidoPorMultaPorDanificarQuandoPagar() {
        // Given
        clienteService.alugar(titanic);
        titanic.setDanificado(true);
        clienteService.devolver(cliente, titanic, 2);
        cliente.setMultaDevidaPorDanificar(BigDecimal.valueOf(25.00));

        // When
        clienteService.pagar(cliente, locadora947);

        // Then
        Assertions.assertEquals(0, cliente.getMultaDevidaPorDanificar().compareTo(BigDecimal.ZERO));
    }

    @Test
    public void deveZerarOValorDevidoPorMultaPorNaoRebobinarQuandoPagar() {
        // Given
        clienteService.alugar(titanic);
        titanic.setRebobinado(false);
        clienteService.devolver(cliente, titanic, 2);
        cliente.setMultaDevidaPorNaoRebobinar(BigDecimal.valueOf(5.00));

        // When
        clienteService.pagar(cliente, locadora947);

        // Then
        Assertions.assertEquals(0, cliente.getMultaDevidaPorDanificar().compareTo(BigDecimal.ZERO));
    }
}
