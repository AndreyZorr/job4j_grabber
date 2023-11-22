package ru.job4j.grabber.utils;

import java.time.LocalDateTime;
import java.util.Objects;

public class Post {
    private int id;
    private String title;
    private String link;
    private String description;
    private LocalDateTime created;

    public Post(int id, String title, String link, String description, LocalDateTime created) {
        this.id = id;
        this.title = title;
        this.link = link;
        this.description = description;
        this.created = created;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Post post)) {
            return false;
        }
        return id == post.id && Objects.equals(description, post.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description);
    }

    @Override
    public String toString() {
        return "Post{"
                + "id=" + id
                + ", description='" + description + '\''
                + '}';
    }
}
