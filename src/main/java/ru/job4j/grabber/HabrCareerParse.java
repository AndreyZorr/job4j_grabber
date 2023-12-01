package ru.job4j.grabber;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class HabrCareerParse implements Parse {
    private static final String SOURCE_LINK = "https://career.habr.com";
    private static int id = 0;
    private final DateTimeParser dateTimeParser;

    public HabrCareerParse(DateTimeParser dateTimeParser) {
        this.dateTimeParser = dateTimeParser;
    }

    private String retrieveDescription(String link) throws IOException {
        Connection connection = Jsoup.connect(link);
        Document document = connection.get();
        Element element = document.select(".page-section").first();
        return element.text();
    }

    @Override
    public List<Post> list(String link) {
        List<Post> postList = new ArrayList<>();
        Connection connection;
        HabrCareerParse hcp = new HabrCareerParse(new HabrCareerDateTimeParser());
        for (int i = 1; i <= 5; i++) {
            connection = Jsoup.connect(link + i);
            try {
                Document document = connection.get();
                Elements rows = document.select(".vacancy-card__inner");
                rows.forEach(row -> postList.add(hcp.post(row)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return postList;
    }

    private Post post(Element element) {
        HabrCareerParse hcp = new HabrCareerParse(new HabrCareerDateTimeParser());
        Element titleElement = element.select(".vacancy-card__title").first();
        Element linkElement = titleElement.child(0);
        Element dateElement = element.select(".vacancy-card__date").first();
        Element date = dateElement.child(0);
        LocalDateTime localDateTime = hcp.dateTimeParser.parse(date.attr("datetime"));
        String vacancyName = titleElement.text();
        String link = String.format("%s%s", SOURCE_LINK, linkElement.attr("href"));
        String description;
        try {
            description = hcp.retrieveDescription(link);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new Post(id, vacancyName, link, description, localDateTime);
    }
}
