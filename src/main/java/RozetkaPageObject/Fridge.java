package RozetkaPageObject;

import java.util.Objects;

public class Fridge {
    private String title;
    private String price;

    public Fridge(String title, String price) {
        this.title = title;
        this.price = price;
    }

    public Fridge() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fridge fridge = (Fridge) o;
        return Objects.equals(title, fridge.title) && Objects.equals(price, fridge.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, price);
    }

    @Override
    public String toString() {
        return "Fridge{" +
                "title='" + title + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
