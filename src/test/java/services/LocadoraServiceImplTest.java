package services;

import exceptions.ImpossivelRebobinarVHSJaRebobinado;
import model.Cliente;
import model.VHS;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

public class LocadoraServiceImplTest {
    static LocadoraServiceImpl locadoraService;
    static Cliente cliente;
    static VHS titanic;

    @BeforeEach
    void beforeEach() {
        locadoraService = new LocadoraServiceImpl();
        cliente = new Cliente();
        titanic = new VHS(1,"Titanic");
    }

    @Test
    public void deveAlterarCorretamenteOStatusDeRebobinadoQuandoOClienteRebobinar() {
        // Given
        titanic.setRebobinado(false);

        // When
        locadoraService.rebobinar(titanic);

        // Then
        Assertions.assertTrue(titanic.getRebobinado());
    }

    @Test
    public void deveLancarExceptionAoTentarRebobinarVHSJaRebobinado() throws ImpossivelRebobinarVHSJaRebobinado {
        // Given
        titanic.setRebobinado(true);

        // Then
        Assertions.assertThrows(ImpossivelRebobinarVHSJaRebobinado.class, () -> locadoraService.rebobinar(titanic));
    }

    @Test
    public void deveRebobinarCorretamenteQuandoCobrarMultaPorNaoRebobinar()  {
        // Given
        titanic.setRebobinado(false);

        // When
        locadoraService.aplicarMultaPorNaoRebobinar(cliente, titanic);

        // Then
        Assertions.assertTrue(titanic.getRebobinado());
    }

    @Test
    public void deveAplicarCorretamenteAMultaPorNaoRebobinar()  {
        // Given
        titanic.setRebobinado(false);

        // When
        locadoraService.aplicarMultaPorNaoRebobinar(cliente, titanic);

        // Then
        Assertions.assertEquals(0, cliente.getMultaDevidaPorNaoRebobinar().compareTo(titanic.getPrecoAluguel().multiply(BigDecimal.valueOf(0.5))));
    }

    @Test
    public void deveAplicarCorretamenteAMultaPorDanificar()  {
        // Given
        titanic.setDanificado(true);

        // When
        locadoraService.aplicarMultaPorDanificar(cliente, titanic);

        // Then
        Assertions.assertEquals(0, cliente.getMultaDevidaPorDanificar().compareTo(titanic.getPrecoAluguel().multiply(BigDecimal.valueOf(10))));
    }

    @Test
    public void deveCobrarCorretamentePelosDiasDeAluguel()  {
        // When
        locadoraService.cobrarDoClienteDiasDeAluguel(cliente, titanic, 2);

        // Then
        Assertions.assertEquals(BigDecimal.valueOf(10.0), cliente.getValorDevidoPorAluguel());
    }
}
