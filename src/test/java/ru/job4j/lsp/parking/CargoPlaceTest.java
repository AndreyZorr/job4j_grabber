package ru.job4j.lsp.parking;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CargoPlaceTest {

    @Test
    void whenSizeMore1ThenFalse() {
        CargoPlace cargoPlace = new CargoPlace();
        Parking parking = new Parking();
        boolean place = parking.getSize(cargoPlace);
        assertThat(place).isFalse();
    }

}