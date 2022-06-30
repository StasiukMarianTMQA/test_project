package PageObject;

public class Book {
    private String name;
    private String date;
    private String cover;

    public Book() {
    }

    public Book(String name, String author, String cover) {
        this.name = name;
        this.date = author;
        this.cover = cover;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", cover='" + cover + '\'' +
                '}';
    }
}

