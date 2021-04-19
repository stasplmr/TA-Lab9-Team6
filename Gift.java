package com.company;

public class Gift {

    private int quality;
    private int price;

    public Gift(int quality, int price) {
        if (quality >= 1 & quality <= 10) {
            this.quality = quality;
        } else {
            throw new IllegalArgumentException("1 ≤ Quality ≤ 10");
        }
        if (price >= 1 & price <= 10000) {
            this.price = price;
        } else {
            throw new IllegalArgumentException("1 ≤ Price ≤ 10000");
        }
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Gift {" + "quality=" + quality + ", price=" + price + "}";
    }
}
