package job4j.utils;

import org.junit.jupiter.api.Test;
import ru.job4j.grabber.utils.HabrCareerDateTimeParser;

import java.time.LocalDateTime;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class HabrCareerDateTimeParserTest {
    @Test
    void parseDateTimeTest() {
        HabrCareerDateTimeParser parser = new HabrCareerDateTimeParser();
        String string = "2023-11-20T12:30:20+03:00";
        LocalDateTime exp = LocalDateTime.of(2023, 11, 20, 12, 30, 20);
        LocalDateTime rsl = parser.parse(string);
        assertThat(exp).isEqualTo(rsl);
    }
}
