package model.principalgamecard;

import java.util.Arrays;

public class PrincipalGamesCard {

    private String name;
    private double newPrice;
    private double oldPrice;
    private String description;
    private String[] genres;
    private String urlImg;

    public PrincipalGamesCard(String name, double newPrice, double oldPrice, String description, String[] genres, String urlImg) {
        this.name = name;
        this.newPrice = newPrice;
        this.oldPrice = oldPrice;
        this.description = description;
        this.genres = genres;
        this.urlImg = urlImg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(double newPrice) {
        this.newPrice = newPrice;
    }

    public double getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(double oldPrice) {
        this.oldPrice = oldPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getGenres() {
        return genres;
    }

    public void setGenres(String[] genres) {
        this.genres = genres;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    @Override
    public String toString() {
        return "PrincipalGamesCard{" +
                "name='" + name + '\'' +
                ", newPrice=" + newPrice +
                ", oldPrice=" + oldPrice +
                ", description='" + description + '\'' +
                ", genres=" + Arrays.toString(genres) +
                '}';
    }
}
