package services;

import model.VHS;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReservaPorTelefoneTest {

    @Test
    public void deveIniciarRetornandoFalsoOMetodoDeStatusDeReserva(){
        // Given
        ReservasPorTelefone reservasPorTelefone = new ReservasPorTelefone();
        VHS titanic = new VHS();

        // When
        reservasPorTelefone.reservaDeFilmeAtivada(titanic);

        // Then
        Assertions.assertFalse(reservasPorTelefone.reservaDeFilmeAtivada(titanic));
    }


}
