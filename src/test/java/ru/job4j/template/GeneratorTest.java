package ru.job4j.template;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class GeneratorTextTest {

    @Test
    public void whenKeyFromDoesNotExistInArgs() {
        GeneratorText generatorText = new GeneratorText();
        Map<String, String> map = new HashMap<>();
        map.put("name", "Petr Arsentev");
        map.put("subject ", "you");
        String template = "I am a ${name}, Who are ${subject}?";
        String expected = "I am a Petr Arsentev, Who are you? ";
        assertThat(generatorText.produce(template, map)).isEqualTo(expected);

    }
}