package ru.job4j.lsp.parking;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PassengerPlaceTest {

    @Test
    void whenSizeEquals1ThenPassengerFalse() {
        PassengerPlace passengerPlace = new PassengerPlace();
        Parking parking = new Parking();
        boolean place = parking.getSize(passengerPlace);
        assertThat(place).isFalse();

    }

}