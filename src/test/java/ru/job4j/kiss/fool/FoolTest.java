package ru.job4j.kiss.fool;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class FoolTest {

    @Test
    void when15Is3and5ThenTrue() {
        assertThat(Fool.in3and5(15)).isTrue();
    }

    @Test
    void when9and3TheTrue() {
        assertThat(Fool.and3(9)).isTrue();
    }

    @Test
    void when10and5TheTrue() {
        assertThat(Fool.and5(10)).isTrue();
    }

    @Test
    void when5Is3and5ThenFalse() {
        assertThat(Fool.in3and5(5)).isFalse();
    }

    @Test
    void when25and3TheFalse() {
        assertThat(Fool.and3(25)).isFalse();
    }

    @Test
    void when12and5TheTrue() {
        assertThat(Fool.and5(12)).isFalse();
    }
}