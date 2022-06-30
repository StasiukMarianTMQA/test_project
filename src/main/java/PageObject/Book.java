package PageObject;

import java.util.Objects;

public class Book {
    private String name;
    private String cover;

    public Book() {
    }

    public Book(String name, String cover) {
        this.name = name;
        this.cover = cover;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(name, book.name) && Objects.equals(cover, book.cover);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cover);
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", cover='" + cover + '\'' +
                '}';
    }
}

